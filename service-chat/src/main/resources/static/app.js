let stompClient = null;
let currentConversationId = null;
const authorId = 101; // ID người dùng hiện tại

function connectWebSocket() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, () => {
        console.log('✅ Kết nối WebSocket thành công');
    });
}

function loadConversations(userId) {
    fetch(`/conversations/user/${userId}`)
        .then(response => response.json())
        .then(conversations => {
            const list = document.getElementById('conversationList');
            list.innerHTML = '';
            if (Array.isArray(conversations) && conversations.length > 0) {
                conversations.forEach(conv => {
                    const title = `Cuộc trò chuyện với ${conv.partnerName}`;
                    const li = document.createElement('li');
                    li.textContent = title;
                    li.onclick = () => selectConversation(conv.id, title);
                    list.appendChild(li);
                });
            } else {
                const li = document.createElement('li');
                li.textContent = 'Không có cuộc trò chuyện nào';
                list.appendChild(li);
            }
        })
        .catch(err => console.error("Lỗi khi tải danh sách:", err));
}

function selectConversation(id, name) {
    currentConversationId = id;
    document.getElementById('chatTitle').textContent = name;

    const chatBox = document.getElementById('chatBox');
    chatBox.innerHTML = '';

    // Gọi API để load 20 tin nhắn gần nhất
    fetch(`/messages/conversation/${id}?page=0&size=20`)
        .then(response => response.json())
        .then(messages => {
            messages.reverse().forEach(displayMessage);
            chatBox.scrollTop = chatBox.scrollHeight;
        });

    // Đăng ký nhận tin nhắn mới qua WebSocket
    if (stompClient) {
        stompClient.subscribe(`/topic/conversations/${id}`, message => {
            const msg = JSON.parse(message.body);
            displayMessage(msg);
        });
    }
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
    if (!content || !currentConversationId || !stompClient) return;

    // ✅ Gửi đúng định dạng: conversation là object
    const message = {
        content,
        authorId,
        conversation: { id: currentConversationId }
    };

    stompClient.send("/app/chat", {}, JSON.stringify(message));
    contentInput.value = '';
});


connectWebSocket();
loadConversations(101);
