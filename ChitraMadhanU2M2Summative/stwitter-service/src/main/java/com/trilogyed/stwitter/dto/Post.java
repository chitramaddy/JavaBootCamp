package com.trilogyed.stwitter.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Post {
    private int postId;
    private String post;
    private LocalDate postDate;
    private String posterName;

    public Post(){

    }

    public Post(String post, LocalDate postDate, String posterName) {
        this.post = post;
        this.postDate = postDate;
        this.posterName = posterName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getPostId() == post.getPostId() &&
                Objects.equals(getPost(), post.getPost()) &&
                Objects.equals(getPostDate(), post.getPostDate()) &&
                Objects.equals(getPosterName(), post.getPosterName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPost(), getPostDate(), getPosterName());
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", post='" + post + '\'' +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                '}';
    }
}
