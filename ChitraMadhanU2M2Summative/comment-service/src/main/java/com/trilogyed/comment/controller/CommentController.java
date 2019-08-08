package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CacheConfig(cacheNames = {"comments"})
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @CachePut(key = "#result.getCommentId()")
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment saveComment(@RequestBody Comment comment) {
        comment = commentDao.addComment(comment);
        System.out.println(comment);
        return comment;
    }

    @Cacheable
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> findAllComments() {
        return commentDao.getAllComments();
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment findCommentById(@PathVariable int id) {
        return commentDao.getCommentById(id);
    }

    @CacheEvict(key = "#result.getCommentId()")
    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentsByPostId(@PathVariable ("postId") int id) {
        List<Comment> comments = commentDao.getCommentsByPostId(id);
        return comments;
    }

    @CacheEvict
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateComment(@RequestBody Comment comment, @PathVariable int id) {
       commentDao.updateComment(comment);
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        commentDao.deleteComment(id);
    }
}
