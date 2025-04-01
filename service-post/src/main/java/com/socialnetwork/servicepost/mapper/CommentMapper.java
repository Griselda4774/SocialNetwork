package com.socialnetwork.servicepost.mapper;

import com.socialnetwork.servicepost.entities.CommentEntity;
import com.socialnetwork.servicepost.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "post.id", target = "postId")
    Comment entityToModel(CommentEntity commentEntity);

    @Mapping(source = "postId", target = "post.id")
    @Mapping(target = "post", ignore = true)
    CommentEntity modelToEntity(Comment comment);
}
