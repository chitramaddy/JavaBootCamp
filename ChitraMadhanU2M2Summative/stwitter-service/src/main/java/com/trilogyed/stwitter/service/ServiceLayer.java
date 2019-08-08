package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.dto.Comment;
import com.trilogyed.stwitter.dto.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    public static final String EXCHANGE = "comment-exchange";


    public static final String ROUTING_KEY = "comment.create.#";

    @Autowired
    private final PostServiceClient postServiceClient;

    @Autowired
    private final CommentServiceClient commentServiceClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ServiceLayer(PostServiceClient postServiceClient, CommentServiceClient commentServiceClient,
                        RabbitTemplate rabbitTemplate){
        this.postServiceClient = postServiceClient;
        this.commentServiceClient = commentServiceClient;
        this.rabbitTemplate = rabbitTemplate;
    }

//Comments are recieved from the front end. Sent to the comment-queue-consumer.



    @Transactional
    public PostViewModel savePost(PostViewModel postViewModel) {

        // Create post object from the view model
        Post post = new Post();
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());

        //add the post to the database and generate id.
        post = postServiceClient.createPost(post);
        postViewModel.setPostId(post.getPostId());
        return postViewModel;
    }

    public PostViewModel findPost(int id) {

        // Get the album object first
        Post post = postServiceClient.getPost(id);
        System.out.println(post);

        return buildPostViewModel(post);

    }

    public List<PostViewModel> findPostsByUser(String posterName) {

        // Get the posts by the poster
        List<Post> posts = postServiceClient.getPostByUser(posterName);
        List<PostViewModel> postViewModels = new ArrayList<>();

        //build post view model that includes comments for each of the post by poster
        posts.stream().forEach(post -> {
            PostViewModel postViewModel = buildPostViewModel(post);
            postViewModels.add(postViewModel);
        });

        return postViewModels;

    }
    @Transactional
    public Comment saveComment(Comment comment){

        //Create a new comment object
        Comment comment1 = new Comment();
        comment1.setCreateDate(comment.getCreateDate());
        comment1.setCommenterName(comment.getCommenterName());
        comment1.setComment(comment.getComment());
        comment1.setPostId(comment.getPostId());

        //Send it to the comment queue
        {
            //send the comment to the queue
            System.out.println("Sending comments...");
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment1);
            System.out.println("comment Sent to Queue for Creation...");
        }

        //Add the comment to the database and get the id.
        comment1=commentServiceClient.saveComment(comment1);
        comment1.setCommentId(comment1.getCommentId());
        return comment1;

    }

    private PostViewModel buildPostViewModel(Post post){

        //Find the comments with the given postId.
        List<Comment> commentList = commentServiceClient.getCommentsByPostId(post.getPostId());
        System.out.println(commentList.size());
        List<String> commentContents = new ArrayList<>();

//        Find the comment strings from each comment object associated with the given postId.
        if(commentList.size() != 0) {
            commentList.stream().forEach(c -> {
                String commentContent = c.getComment();
                commentContents.add(commentContent);
            });
        }

        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostId(post.getPostId());
        postViewModel.setPostDate(post.getPostDate());
        postViewModel.setPosterName(post.getPosterName());
        postViewModel.setPost(post.getPost());
        postViewModel.setComments(commentContents);

        return postViewModel;
    }

//    private void simulateSlowService() {
////        try {
////            long time = 1000L;
////            Thread.sleep(time);
////        } catch (InterruptedException e) {
////            throw new IllegalStateException(e);
////        }
////    }



}
