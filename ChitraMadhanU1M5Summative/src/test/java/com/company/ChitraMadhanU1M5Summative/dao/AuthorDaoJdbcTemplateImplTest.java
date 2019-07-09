package com.company.ChitraMadhanU1M5Summative.dao;

import com.company.ChitraMadhanU1M5Summative.model.Author;
import com.company.ChitraMadhanU1M5Summative.model.Book;
import com.company.ChitraMadhanU1M5Summative.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoJdbcTemplateImplTest {

    @Autowired
    protected AuthorDao authorDao;

    @Autowired
    protected BookDao bookDao;

    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception{

        // clean out the test db

        List<Book> bookList = bookDao.getAllBooks();

        bookList.stream()
                .forEach(book ->
                        bookDao.deleteBook(book.getAuthorId()));

        List<Author> authorList = authorDao.getAllAuthors();

        authorList.stream()
                .forEach(author ->
                        authorDao.deleteAuthor(author.getAuthorId()));

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        publisherList.stream()
                .forEach(publisher ->
                        publisherDao.deletePublisher(publisher.getPublisherId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();

        author.setFirstName("Khaled");
        author.setLastName("Hosseini");
        author.setStreet("4848 San Felipe Road, #150-221");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("95135");
        author.setPhone("408-904-7175");
        author.setEmail("info@khaledhosseinifoundation.org");

        author = authorDao.addAuthor(author);

        Author author1 = new Author();
        author1 = authorDao.getAuthorById(author.getAuthorId());

        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getAuthorId());

        author1 = authorDao.getAuthorById(author.getAuthorId());
        assertNull(author1);
    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Author author = new Author();
        author.setFirstName("Khaled");
        author.setLastName("Hosseini");
        author.setStreet("4848 San Felipe Road, #150-221");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("95135");
        author.setPhone("408-904-7175");
        author.setEmail("info@khaledhosseinifoundation.org");

        author = authorDao.addAuthor(author);

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void deleteWithRefIntegrityException() {

        Author author = new Author();
        author.setFirstName("Khaled");
        author.setLastName("Hosseini");
        author.setStreet("4848 San Felipe Road, #150-221");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("95135");
        author.setPhone("408-904-7175");
        author.setEmail("info@khaledhosseinifoundation.org");

        author = authorDao.addAuthor(author);

        authorDao.deleteAuthor(author.getAuthorId());

    }


    @Test
    public void getAllAuhtors() {

        Author author = new Author();

        author.setFirstName("Khaled");
        author.setLastName("Hosseini");
        author.setStreet("4848 San Felipe Road, #150-221");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("95135");
        author.setPhone("408-904-7175");
        author.setEmail("info@khaledhosseinifoundation.org");

        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("Ashlee");
        author.setLastName("Vance");
        author.setStreet("1100 New Road");
        author.setCity("New City");
        author.setState("CA");
        author.setPostalCode("95100");
        author.setPhone("971-235-7441");
        author.setEmail("info@ashleevance.com");


        author = authorDao.addAuthor(author);

        List<Author> aList = authorDao.getAllAuthors();

        assertEquals(aList.size(), 2);
    }

    @Test
    public void updateAuhtor() {

        Author author = new Author();

        author.setFirstName("Khaled");
        author.setLastName("Hosseini");
        author.setStreet("4848 San Felipe Road, #150-221");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("95135");
        author.setPhone("408-904-7175");
        author.setEmail("info@khaledhosseinifoundation.org");

        author = authorDao.addAuthor(author);

        author = authorDao.getAuthorById(author.getAuthorId());

        author.setPhone("111-222-3333");
        author.setEmail("contact@khaledhosseinifoundation.org");

        authorDao.updateAuthor(author);

        Author updatedAuthor = authorDao.getAuthorById(author.getAuthorId());
        assertEquals(updatedAuthor, author);

    }
}