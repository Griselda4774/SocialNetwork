package com.socialnetwork.servicechat.repositories;

import com.socialnetwork.servicechat.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByConversation_Id(Long conversationId);

    List<MessageEntity> findByConversation_IdOrderByTimestampDesc(Long conversationId);

    Page<MessageEntity> findByConversation_Id(Long conversationId, Pageable pageable);
}

