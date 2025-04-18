package com.socialnetwork.servicechat.controller;

import com.socialnetwork.servicechat.entities.MessageEntity;
import com.socialnetwork.servicechat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages") // Base path
public class MessageRestController {

    @Autowired
    private MessageService messageService;

//    @GetMapping("/conversation/{conversationId}")
//    public List<MessageEntity> getMessagesByConversation(@PathVariable("conversationId") Long conversationId) {
//        return messageService.getALLMessagesByConversationId(conversationId);
//    }

    @GetMapping("/conversation/{conversationId}")
    public List<MessageEntity> getMessagesByConversation(
            @PathVariable("conversationId") Long conversationId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size) {
        return messageService.getLatestMessagesByConversationId(conversationId, page, size);
    }


//    // Endpoint: GET /api/messages/conversation/1
//    @GetMapping("/conversation/{conversationId}")
//    public List<MessageEntity> getMessagesByConversation(@PathVariable Long conversationId) {
//        return messageService.getMessagesByConversationId(conversationId);
//    }

    // Endpoint: POST /api/messages
    @PostMapping
    public MessageEntity sendMessage(@RequestBody MessageEntity message) {
        return messageService.saveMessage(message);
    }

}
