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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoJdbcTemplateImplTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();

        publisher.setName("Riverhead Trade");
        publisher.setStreet("New Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("rh@riverHead.com");
        publisher.setPhone("212-207-7235");

        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1 = publisherDao.getPublisherById(publisher.getPublisherId());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getPublisherId());

        publisher1 = publisherDao.getPublisherById(publisher.getPublisherId());
        assertNull(publisher1);
    }

    @Test
    public void getAllPublishers() {

        Publisher publisher = new Publisher();

        publisher.setName("Riverhead Trade");
        publisher.setStreet("New Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("rh@riverHead.com");
        publisher.setPhone("212-207-7235");

        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();

        publisher.setName("Harper Collins Publishers");
        publisher.setStreet("195 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("hc@hcp.com");
        publisher.setPhone("212-207-7000");

        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> allPublishers = publisherDao.getAllPublishers();
        assertEquals(allPublishers.size(), 2);

    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();

        publisher.setName("Riverhead Trade");
        publisher.setStreet("New Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("rh@riverHead.com");
        publisher.setPhone("212-207-7235");

        publisher = publisherDao.addPublisher(publisher);

        publisher.setPhone("123-456-7890");
        publisherDao.updatePublisher(publisher);


        Publisher publisher1 = publisherDao.getPublisherById(publisher.getPublisherId());
        assertEquals(publisher, publisher1);
    }

}