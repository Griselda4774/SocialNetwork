let stompClient = null;
let currentConversationId = null;
const authorId = 101; // ID người dùng hiện tại

function connectWebSocket() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, () => {
        console.log('Đã kết nối WebSocket');
    });
}

function loadConversations(userId) {
    // Thêm userId vào URL API
    fetch(`/conversations/user/${userId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Lỗi khi tải cuộc trò chuyện: ' + response.status);
            }
            return response.json();
        })
        .then(conversations => {
            const list = document.getElementById('conversationList');
            list.innerHTML = ''; // Xóa danh sách cuộc trò chuyện hiện tại

            // Kiểm tra nếu conversations có dữ liệu
            if (Array.isArray(conversations) && conversations.length > 0) {
                conversations.forEach(conv => {
                    const title = `Cuộc trò chuyện với ${conv.partnerName}`;
                    const li = document.createElement('li');
                    li.textContent = title;
                    li.onclick = () => selectConversation(conv.id, title); // Gọi hàm xử lý khi chọn cuộc trò chuyện
                    list.appendChild(li);
                });
            } else {
                // Thêm thông báo nếu không có cuộc trò chuyện nào
                const li = document.createElement('li');
                li.textContent = 'Không có cuộc trò chuyện nào';
                list.appendChild(li);
            }
        })
        .catch(err => {
            console.error("Lỗi khi tải danh sách cuộc trò chuyện:", err);
        });
}

function selectConversation(id, name) {
    currentConversationId = id;
    document.getElementById('chatTitle').textContent = name;
    loadMessages(id);
    if (stompClient) {
        stompClient.subscribe(`/topic/conversations/${id}`, message => {
            const msg = JSON.parse(message.body);
            displayMessage(msg);
        });
    }
}

function loadMessages(conversationId) {
    fetch(`/messages/conversation/${conversationId}`)
        .then(response => response.json())
        .then(messages => {
            const chatBox = document.getElementById('chatBox');
            chatBox.innerHTML = '';
            messages.forEach(displayMessage);
            chatBox.scrollTop = chatBox.scrollHeight;
        });
}

function displayMessage(msg) {
    const chatBox = document.getElementById('chatBox');
    const div = document.createElement('div');
    div.className = 'message' + (msg.authorId === authorId ? ' self' : '');
    div.innerHTML = `<strong>${msg.authorId}</strong>: ${msg.content}`;
    chatBox.appendChild(div);
    chatBox.scrollTop = chatBox.scrollHeight;
}

document.getElementById('chatForm').addEventListener('submit', event => {
    event.preventDefault();
    const contentInput = document.getElementById('content');
    const content = contentInput.value.trim();
    if (!content || !currentConversationId) return;
    const message = {
        content,
        conversationId: currentConversationId,
        authorId
    };
    fetch('/messages', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(message)
    }).then(response => {
        if (response.ok) {
            contentInput.value = '';
        }
    });
});

connectWebSocket();
loadConversations(101);
