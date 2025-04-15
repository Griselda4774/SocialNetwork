package com.socialnetwork.servicechat.service;

import com.socialnetwork.servicechat.repositories.ConversationRepository;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    // Add methods as needed
}

