package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post);

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("postId") int id);

    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    public List<Post> getPostByUser(@PathVariable("poster_name") String posterName) ;

}
