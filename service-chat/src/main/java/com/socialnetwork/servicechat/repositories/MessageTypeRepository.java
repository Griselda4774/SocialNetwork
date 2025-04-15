package com.socialnetwork.servicechat.repositories;

import com.socialnetwork.servicechat.entities.MessageTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageTypeRepository extends JpaRepository<MessageTypeEntity, Long> {
}
