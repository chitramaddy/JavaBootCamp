package com.company.ChitraMadhanU1M5Summative.dao;

import com.company.ChitraMadhanU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {

    Author addAuthor(Author author);

    Author getAuthorById(int id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int id);

}
