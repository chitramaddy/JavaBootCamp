package com.company.ChitraMadhanU1M5Summative.dao;

import com.company.ChitraMadhanU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    Book addBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> findBooksByAuthor(int authorId);

}
