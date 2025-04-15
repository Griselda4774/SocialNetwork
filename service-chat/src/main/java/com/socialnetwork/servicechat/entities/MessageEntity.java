package com.socialnetwork.servicechat.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @ManyToOne
    @JoinColumn(name = "message_type_id", referencedColumnName = "message_type_id", nullable = true, foreignKey = @ForeignKey(name = "fk_posts_message_type"))
    private MessageTypeEntity messageType;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "author_id")
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_messages_conversations"))
    private ConversationEntity conversation;

    @Column(name = "is_revoke", columnDefinition = "BIT DEFAULT 0")
    private Boolean isRevoke = false;

    @Column(name = "is_seen", columnDefinition = "BIT DEFAULT 0")
    private Boolean isSeen = false;

    @Column(name = "timestamp", updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageTypeEntity getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEntity messageType) {
        this.messageType = messageType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public ConversationEntity getConversation() {
        return conversation;
    }

    public void setConversation(ConversationEntity conversation) {
        this.conversation = conversation;
    }

    public Boolean getRevoke() {
        return isRevoke;
    }

    public void setRevoke(Boolean revoke) {
        isRevoke = revoke;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
