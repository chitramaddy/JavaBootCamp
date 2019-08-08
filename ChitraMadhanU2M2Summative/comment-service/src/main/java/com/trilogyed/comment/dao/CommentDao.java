package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {

    Comment addComment(Comment comment);

    List<Comment> getAllComments();

    List<Comment> getCommentsByPostId(int postId);

    Comment getCommentById(int id);

    void updateComment(Comment comment);

    void deleteComment(int id);
}
