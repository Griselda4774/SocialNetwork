package com.socialnetwork.servicechat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "message_type")
public class MessageTypeEntity {

    @Id
    @Column(name = "message_type_id")
    private Byte messageTypeId;

    @Column(name = "name_en", length = 20, nullable = false)
    private String nameEn;

    @Column(name = "name_vn", columnDefinition = "NVARCHAR(20)", nullable = false)
    private String nameVn;

    // Getters and Setters

    public Byte getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Byte messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public String getNameVn() {
        return nameVn;
    }

    public void setNameVn(String nameVn) {
        this.nameVn = nameVn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
