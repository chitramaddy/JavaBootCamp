package com.trilogyed.CommentQueueConsumer.util.feign;

import com.trilogyed.CommentQueueConsumer.util.message.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment saveComment(@RequestBody Comment comment);


}
