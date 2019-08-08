package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_POST =
            "insert into post (post_date, poster_name, post) values (?, ?, ?)";

    private static final String SELECT_POST =
            "select * from post where post_id = ?";

    private static final String SELECT_POSTS_BY_USER =
            "select * from post where poster_name = ?";

    private static final String SELECT_ALL_POSTS =
            "select * from post";

    private static final String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";

    private static final String DELETE_POST =
            "delete from post where post_id = ?";


    @Override
    @Transactional
    public Post addPost(Post post) {

        jdbcTemplate.update(INSERT_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setPostId(id);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS, this::mapRowToPost);
    }

    @Override
    public List<Post> getPostsByUser(String posterName) {
        try {
            return jdbcTemplate.query(SELECT_POSTS_BY_USER, this::mapRowToPost, posterName);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Post getPostWithId(int id){
        try {
            return jdbcTemplate.queryForObject(SELECT_POST, this::mapRowToPost, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void updatePost(Post post) {

        jdbcTemplate.update(UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostId());
    }

    @Override
    public void deletePost(int id) {

        jdbcTemplate.update(DELETE_POST, id);

    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException{

        Post post = new Post();

        post.setPostId(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }

}
