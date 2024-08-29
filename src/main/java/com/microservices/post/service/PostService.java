package com.microservices.post.service;

import com.microservices.post.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto findByPostId(String postId);
}
