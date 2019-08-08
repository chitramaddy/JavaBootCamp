package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CacheConfig(cacheNames = {"posts"} )
public class PostController {

    @Autowired
    PostDao postDao;

    @CachePut(key = "#result.getPostId()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {

        post = postDao.addPost(post);
        System.out.println(post);
        return post;
    }

    @Cacheable
    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("postId") int id) {
        try {
            Post post = postDao.getPostWithId(id);
            System.out.println(post);
            return post;
        } catch (NullPointerException e) {
            throw new NullPointerException("Id not found");
        }
    }

    @CacheEvict(key = "#rsvp.getPostId()")
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        postDao.updatePost(post);

    }

    @CacheEvict
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);

    }

    @Cacheable
    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    public List<Post> getPostByUser(@PathVariable("poster_name") String posterName) {
        return postDao.getPostsByUser(posterName);
    }

}
