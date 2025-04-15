package com.socialnetwork.servicechat.service;

import com.socialnetwork.servicechat.entities.MessageEntity;
import com.socialnetwork.servicechat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageEntity> getMessagesByConversationId(Long conversationId) {
        return messageRepository.findByConversationId(conversationId);
    }

    public MessageEntity saveMessage(MessageEntity message) {
        return messageRepository.save(message);
    }
}

