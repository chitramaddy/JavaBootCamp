package com.trilogyed.post.model;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postId;
    private LocalDate postDate;
    private String posterName;
    private String post;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post1 = (Post) o;
        return getPostId() == post1.getPostId() &&
                Objects.equals(getPostDate(), post1.getPostDate()) &&
                Objects.equals(getPosterName(), post1.getPosterName()) &&
                Objects.equals(getPost(), post1.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPostDate(), getPosterName(), getPost());
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postId +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
