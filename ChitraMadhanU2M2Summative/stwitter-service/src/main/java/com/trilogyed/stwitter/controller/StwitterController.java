package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.dto.Comment;
import com.trilogyed.stwitter.dto.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CacheConfig(cacheNames = {"stwitter"})
@RestController
@RefreshScope
public class StwitterController {

    @Autowired
    ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    @CachePut(key = "#result.getPostId()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel postViewModel){
        return service.savePost(postViewModel);
    }

    @Cacheable
    @RequestMapping(value = "/posts/{post_id}", method = RequestMethod.GET)
    public PostViewModel getPost(@PathVariable("post_id") @Valid int id){
        return service.findPost(id);
    }

    @Cacheable
    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    public List<PostViewModel> getPostByUser(@PathVariable("poster_name") String posterName){
        return service.findPostsByUser(posterName);
    }

    @CachePut(key="#result.getCommentId")
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody @Valid Comment comment){
        return service.saveComment(comment);
    }
}
