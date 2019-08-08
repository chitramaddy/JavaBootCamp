package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.dto.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name="comment-service")
public interface CommentServiceClient {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment saveComment(@RequestBody Comment comment);


    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public List<Comment> getCommentsByPostId(@PathVariable ("postId") int id);

}
