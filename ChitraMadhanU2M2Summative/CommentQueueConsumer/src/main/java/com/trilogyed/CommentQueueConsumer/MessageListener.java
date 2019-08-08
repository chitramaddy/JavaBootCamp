package com.trilogyed.CommentQueueConsumer;


import com.trilogyed.CommentQueueConsumer.util.feign.CommentServiceClient;
import com.trilogyed.CommentQueueConsumer.util.message.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentServiceClient commentServiceClient;

    public MessageListener(){

    }

    public MessageListener(CommentServiceClient commentServiceClient) {
        this.commentServiceClient = commentServiceClient;
    }

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment comment) {
            System.out.println("Sending to comment Service to create "+comment.toString());
            commentServiceClient.saveComment(comment);
        }
    }

