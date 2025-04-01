package com.socialnetwork.servicepost.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "privacy_types")
public class PrivacyTypeEntity {
    @Id
    @Column(name = "privacy_type_id")
    private Byte id;

    @Column(name = "name_en", nullable = false, length = 20)
    private String nameEn;

    @Column(name = "name_vn", nullable = false, length = 20)
    private String nameVn;
}
