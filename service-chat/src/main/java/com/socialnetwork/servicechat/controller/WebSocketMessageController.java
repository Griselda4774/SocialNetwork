package com.socialnetwork.servicechat.controller;

import com.socialnetwork.servicechat.entities.MessageEntity;
import com.socialnetwork.servicechat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketMessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleMessage(MessageEntity message) {
        MessageEntity saved = messageService.saveMessage(message);
        messagingTemplate.convertAndSend(
                "/topic/conversations/" + message.getConversation().getId(),
                saved
        );
    }
}
