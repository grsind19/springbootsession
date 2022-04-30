package com.socialmedia.socialmedia.post;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PostController {
    @Autowired
    private PostServiceImp postServiceImp;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/posts")
    List<PostDto> getPosts(){
        List<Post> posts = postServiceImp.getPosts();
        return posts.stream()
                .map(this::covertEntityToDto)
                .collect(Collectors.toList());
    }

    private PostDto covertEntityToDto(Post post){
        PostDto postdto = modelMapper.map(post, PostDto.class);
        return postdto;
    }

    @PostMapping("/posts")
    PostDto createPost(@RequestBody PostDto postdto){
        Post post = modelMapper.map(postdto, Post.class);
        post = postServiceImp.createPost(post);

        postdto = modelMapper.map(post, PostDto.class);
        return postdto;
    }

    @GetMapping("/posts/{postId}")
    Optional<PostDto> getPostById(@PathVariable Integer postId){
        Optional<Post> post = postServiceImp.getPostById(postId);
        return modelMapper.map(post, Optional.class);
    }
}
