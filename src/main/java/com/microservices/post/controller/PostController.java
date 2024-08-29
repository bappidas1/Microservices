package com.microservices.post.controller;

import com.microservices.post.payload.PostDto;
import com.microservices.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    //http://localhost:8081/api/v1/post/{postId}
    @GetMapping("{postId}")
    public ResponseEntity<PostDto> getByPostId(@PathVariable String postId){
        PostDto byPostId = postService.findByPostId(postId);
        return new ResponseEntity<>(byPostId, HttpStatus.OK);
    }
}
