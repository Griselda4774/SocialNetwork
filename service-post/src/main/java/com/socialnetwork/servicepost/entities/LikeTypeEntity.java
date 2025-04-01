package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "like_types")
public class LikeTypeEntity {
    @Id
    @Column(name = "like_type_id")
    private Byte id;

    @Column(name = "name_en", nullable = false, length = 20)
    private String nameEn;

    @Column(name = "name_vn", nullable = false, length = 20)
    private String nameVn;
}


