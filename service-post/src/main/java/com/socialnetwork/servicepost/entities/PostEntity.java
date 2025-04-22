package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(name = "url", length = 255)
    private String url;

    @ManyToOne
    @JoinColumn(name = "privacy_type_id", referencedColumnName = "privacy_type_id", nullable = true)
    private PrivacyTypeEntity privacyType;

    @ManyToOne
    @JoinColumn(name = "url_type_id", referencedColumnName = "url_type_id", nullable = true)
    private UrlTypeEntity urlType;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "likes", nullable = false)
    private Integer likes = 0;

    @Transient
    private List<CommentEntity> listComments = new ArrayList<>();

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PrivacyTypeEntity getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(PrivacyTypeEntity privacyType) {
        this.privacyType = privacyType;
    }

    public UrlTypeEntity getUrlType() {
        return urlType;
    }

    public void setUrlType(UrlTypeEntity urlType) {
        this.urlType = urlType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<CommentEntity> getListComments() {
        return listComments;
    }

    public void setListComments(List<CommentEntity> listComments) {
        this.listComments = listComments;
    }
}


