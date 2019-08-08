package com.trilogyed.stwitter.viewmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int postId;
    @NotEmpty(message = "Post cannot be empty")
    private String post;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotEmpty(message = "Post date cannot be empty")
    private LocalDate postDate;
    @NotEmpty(message = "Poster name cannot be empty")
    private String posterName;

    List<String> comments;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostViewModel)) return false;
        PostViewModel that = (PostViewModel) o;
        return getPostId() == that.getPostId() &&
                Objects.equals(getPost(), that.getPost()) &&
                Objects.equals(getPostDate(), that.getPostDate()) &&
                Objects.equals(getPosterName(), that.getPosterName()) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPost(), getPostDate(), getPosterName(), comments);
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "postId=" + postId +
                ", post='" + post + '\'' +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", comments=" + comments +
                '}';
    }
}
