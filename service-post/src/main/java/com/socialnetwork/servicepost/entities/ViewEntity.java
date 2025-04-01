package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "views")
public class ViewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "view_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "story_id", referencedColumnName = "story_id", nullable = false)
    private StoryEntity story;

    @Column(name = "user_id")
    private Long userId;
}

