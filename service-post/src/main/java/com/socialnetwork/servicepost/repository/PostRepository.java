package com.socialnetwork.servicepost.repository;

import com.socialnetwork.servicepost.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    void create(PostEntity post);
}
