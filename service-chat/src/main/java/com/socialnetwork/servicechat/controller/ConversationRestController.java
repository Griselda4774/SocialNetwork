package com.socialnetwork.servicechat.controller;

import com.socialnetwork.servicechat.entities.ConversationEntity;
import com.socialnetwork.servicechat.repositories.ConversationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conversations")
@CrossOrigin(origins = "*") // Cho phép gọi từ frontend ở mọi origin
public class ConversationRestController {

    private final ConversationRepository conversationRepository;

    public ConversationRestController(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @GetMapping("/user/{userId}")
    public List<ConversationView> getConversationsByUser(@PathVariable("userId") Long userId) {
        List<ConversationEntity> conversations = conversationRepository.findByUser1IdOrUser2Id(userId, userId);
        List<ConversationView> result = new ArrayList<>();

        for (ConversationEntity conv : conversations) {
            Long partnerId = conv.getUser1Id().equals(userId) ? conv.getUser2Id() : conv.getUser1Id();
            String partnerName = "Người dùng #" + partnerId;
            result.add(new ConversationView(conv.getId(), partnerId, partnerName));
        }
        return result;
    }

    // DTO trả về dữ liệu
    public static class ConversationView {
        private Long id;
        private Long partnerId;
        private String partnerName;

        public ConversationView(Long id, Long partnerId, String partnerName) {
            this.id = id;
            this.partnerId = partnerId;
            this.partnerName = partnerName;
        }

        public Long getId() {
            return id;
        }

        public Long getPartnerId() {
            return partnerId;
        }

        public String getPartnerName() {
            return partnerName;
        }
    }
}
