package com.socialnetwork.servicechat.repositories;

import com.socialnetwork.servicechat.entities.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<ConversationEntity, Long> {

    List<ConversationEntity> findByUser1IdOrUser2Id(Long user1Id, Long user2Id);

    ConversationEntity findByUser1IdAndUser2Id(Long user1Id, Long user2Id);
}
