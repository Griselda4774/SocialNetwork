package com.socialnetwork.servicepost.mapper;

import com.socialnetwork.servicepost.entities.PostEntity;
import com.socialnetwork.servicepost.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostEntity modelToEntity(Post post);
    Post entityToModel(PostEntity model);
}
