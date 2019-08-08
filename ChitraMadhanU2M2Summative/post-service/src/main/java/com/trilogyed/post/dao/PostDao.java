package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {

    Post addPost(Post post);

    List<Post> getAllPosts();

    List<Post> getPostsByUser(String posterName);

    Post getPostWithId(int id);

    void updatePost(Post post);

    void deletePost(int id);

}
