package com.socialnetwork.servicepost.models;

import com.socialnetwork.servicepost.entities.CommentEntity;
import com.socialnetwork.servicepost.entities.PrivacyTypeEntity;
import com.socialnetwork.servicepost.entities.UrlTypeEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private Long id;
    private String content;
    private String url;
    private PrivacyTypeEntity privacyType;
    private UrlTypeEntity urlType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long authorId;
    private Long pageId;
    private Integer likes = 0;
    private List<Comment> listComments = new ArrayList<>();

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

    public List<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(List<Comment> listComments) {
        this.listComments = listComments;
    }
}
