package com.microservices.post.service;

import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;
import com.microservices.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post savedPost = postRepository.save(post);
        return mapToDto(savedPost);
    }


    @Override
    public PostDto findByPostId(String postId) {
        Post post = postRepository.findById(postId).get();
        return mapToDto(post);
    }

    Post mapToEntity(PostDto dto){
        Post entity = new Post();
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }
    PostDto mapToDto(Post entity){
        PostDto dto = new PostDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
