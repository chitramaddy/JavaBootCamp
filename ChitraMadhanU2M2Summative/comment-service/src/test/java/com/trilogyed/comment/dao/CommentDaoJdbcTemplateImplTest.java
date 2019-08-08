package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoJdbcTemplateImplTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception{
        List<Comment> comments = commentDao.getAllComments();

        for(Comment comment: comments){
            commentDao.deleteComment(comment.getCommentId());
        }
    }

    @Test
    public void addGetDeleteComment() {

        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,19));
        comment.setCommenterName("AwesomePerson");
        comment.setComment("I liked the post!!!");
        comment = commentDao.addComment(comment);

        Comment comment1 = commentDao.getCommentById(comment.getCommentId());
        assertEquals(comment, comment1);

        commentDao.deleteComment(comment.getCommentId());
        comment1 = commentDao.getCommentById(comment.getCommentId());
        assertNull(comment1);
    }

    @Test
    public void getAllComments() {

        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,19));
        comment.setCommenterName("AwesomePerson");
        comment.setComment("I liked the post!!!");
        comment = commentDao.addComment(comment);

        comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,19));
        comment.setCommenterName("MeanPerson");
        comment.setComment("Worst post ever!!!");

        comment = commentDao.addComment(comment);

        List<Comment> comments = commentDao.getAllComments();
        assertEquals(2, comments.size());

    }

    @Test
    public void updateComment() {

        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,19));
        comment.setCommenterName("AwesomePerson");
        comment.setComment("I liked the post!!!");
        comment = commentDao.addComment(comment);

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,7,19));
        comment.setCommenterName("CoolPerson");
        comment.setComment("Cool post ever!!!");
        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getCommentById(comment.getCommentId());
        assertEquals(comment1, comment);

    }

}