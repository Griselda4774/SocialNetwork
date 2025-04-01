package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
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
}


