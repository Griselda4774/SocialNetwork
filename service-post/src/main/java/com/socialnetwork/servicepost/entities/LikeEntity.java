package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "likes",
        uniqueConstraints = @UniqueConstraint(name = "UQ_Likes_Target_Type_User", columnNames = {"targetId", "userId", "typeId"}))
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "like_type_id", referencedColumnName = "like_type_id", nullable = true)
    private LikeTypeEntity likeType;
}


