package com.socialmedia.socialmedia.post;


import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();
    Post createPost(Post post);
    Optional<Post> getPostById(Integer id);
}
