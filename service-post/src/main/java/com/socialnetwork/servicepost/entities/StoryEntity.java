package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stories")
public class StoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_id")
    private Long id;

    @Column(name = "content", columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "url_type_id", referencedColumnName = "url_type_id", nullable = true)
    private UrlTypeEntity urlType;

    @ManyToOne
    @JoinColumn(name = "privacy_type_id", referencedColumnName = "privacy_type_id", nullable = true)
    private PrivacyTypeEntity privacyType;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "likes", nullable = false)
    private Integer likes = 0;

    @Column(name = "views", nullable = false)
    private Integer views = 0;
}


