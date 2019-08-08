package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PostDaoJdbcTemplateImplTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        List<Post> posts = postDao.getAllPosts();

        for(Post post : posts){
            postDao.deletePost(post.getPostId());
        }
    }

    @Test
    public void addGetDeletePost() {

        Post post = new Post();

        post.setPostDate(LocalDate.of(2019, 8, 02));
        post.setPosterName("Chitra");
        post.setPost("Most interesting post");
        post = postDao.addPost(post);

        Post post1 = postDao.getPostWithId(post.getPostId());
        assertEquals(post1, post);

        postDao.deletePost(post.getPostId());
        post1 = postDao.getPostWithId(post.getPostId());
        assertNull(post1);
    }

    @Test
    public void getAllPosts() {

        Post post = new Post();

        post.setPostDate(LocalDate.of(2019, 8, 02));
        post.setPosterName("Chitra");
        post.setPost("Most interesting post");
        post = postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2019, 7, 22));
        post.setPosterName("Chitra");
        post.setPost("reminscing post");
        post = postDao.addPost(post);

        List<Post> posts = postDao.getAllPosts();
        assertEquals(2, posts.size());
    }

    @Test
    public void updatePost() {

        Post post = new Post();

        post.setPostDate(LocalDate.of(2019, 8, 02));
        post.setPosterName("Chitra");
        post.setPost("Most interesting post");
        post = postDao.addPost(post);

        post.setPostDate(LocalDate.of(2019, 8, 02));
        post.setPosterName("Chitra");
        post.setPost("Latest updated post");
        postDao.updatePost(post);

        Post post1 = postDao.getPostWithId(post.getPostId());
        assertEquals(post, post1);

    }

}