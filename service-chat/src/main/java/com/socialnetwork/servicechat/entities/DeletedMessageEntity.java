package com.socialnetwork.servicechat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "deleted_messages")
public class DeletedMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false, foreignKey = @ForeignKey(name = "fk_deleted_messages_conversations"))
    private ConversationEntity conversation;

    @Column(name = "last_deleted_message_id")
    private Long lastDeletedMessageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ConversationEntity getConversation() {
        return conversation;
    }

    public void setConversation(ConversationEntity conversation) {
        this.conversation = conversation;
    }

    public Long getLastDeletedMessageId() {
        return lastDeletedMessageId;
    }

    public void setLastDeletedMessageId(Long lastDeletedMessageId) {
        this.lastDeletedMessageId = lastDeletedMessageId;
    }
}

