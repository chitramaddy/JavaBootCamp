package com.trilogyed.stwitter.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

public class Comment {

    private int commentId;
    private int postId;
    private String commenterName;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate createDate;
    private String comment;

    public Comment(){

    }

    public Comment(int postId, String commenterName, LocalDate createDate, String comment) {
        this.postId = postId;
        this.commenterName = commenterName;
        this.createDate = createDate;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate commentDate) {
        this.createDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getCommentId() == comment.getCommentId() &&
                getPostId() == comment.getPostId() &&
                Objects.equals(getCommenterName(), comment.getCommenterName()) &&
                Objects.equals(getCreateDate(), comment.getCreateDate()) &&
                Objects.equals(getComment(), comment.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getPostId(), getCommenterName(), getCreateDate(), getComment());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commenterName='" + commenterName + '\'' +
                ", commentDate=" + createDate +
                ", comment='" + comment + '\'' +
                '}';
    }
}
