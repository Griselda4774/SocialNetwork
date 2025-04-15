package com.socialnetwork.servicechat.controller;

import com.socialnetwork.servicechat.entities.MessageEntity;
import com.socialnetwork.servicechat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;


    // Client gửi đến /app/chat.sendMessage
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload MessageEntity chatMessage) {
        MessageEntity savedMessage = messageService.saveMessage(chatMessage);
        // Gửi lại tới topic cụ thể của conversation
        messagingTemplate.convertAndSend("/topic/conversations/" + savedMessage.getConversation(), savedMessage);
    }
}


