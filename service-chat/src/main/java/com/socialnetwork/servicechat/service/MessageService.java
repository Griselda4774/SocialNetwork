package com.socialnetwork.servicechat.service;

import com.socialnetwork.servicechat.entities.MessageEntity;
import com.socialnetwork.servicechat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageEntity> getMessagesByConversationId(Long conversationId) {
        return messageRepository.findByConversation_Id(conversationId);
    }

    public MessageEntity saveMessage(MessageEntity message) {
        return messageRepository.save(message);
    }

//    public List<MessageEntity> getALLMessagesByConversationId(Long conversationId) {
//        return messageRepository.findByConversationIdOrderByTimestampDesc(conversationId);
//    }

    public List<MessageEntity> getLatestMessagesByConversationId(Long conversationId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "timestamp"));
        return messageRepository.findByConversation_Id(conversationId, pageable).getContent();
    }
}

