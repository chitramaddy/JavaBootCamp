package com.company.ChitraMadhanU1M5Summative.dao;

import com.company.ChitraMadhanU1M5Summative.model.Author;
import com.company.ChitraMadhanU1M5Summative.model.Book;
import com.company.ChitraMadhanU1M5Summative.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoJdbcTemplateImplTest {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception{

        // clean out the test db
        List<Author> authorList = authorDao.getAllAuthors();

        authorList.stream()
                .forEach(author ->
                        authorDao.deleteAuthor(author.getAuthorId()));

        List<Book> bookList = bookDao.getAllBooks();

        bookList.stream()
                .forEach(book ->
                        bookDao.deleteBook(book.getAuthorId()));

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        publisherList.stream()
                .forEach(publisher ->
                        publisherDao.deletePublisher(publisher.getPublisherId()));

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void addGetDeleteBook() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Riverhead Trade");
        publisher.setStreet("New Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("21021");
        publisher.setEmail("rh@riverHead.com");
        publisher.setPhone("999-999-9999");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();

        book.setIsbn("978-1594480003");
        book.setPublishDate(LocalDate.of(2004, 04, 27));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Kite Runner");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("18.95"));

        book = bookDao.addBook(book);

        Book book2 = bookDao.getBookById(book.getBookId());

        assertEquals(book, book2);

        bookDao.deleteBook(book.getBookId());

        book2 = bookDao.getBookById(book.getBookId());

        assertNull(book2);
    }

    @Test
    public void getAllBooks() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Riverhead Trade");
        publisher.setStreet("New Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("rh@riverHead.com");
        publisher.setPhone("212-207-7235");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();

        book.setIsbn("978-1594480003");
        book.setPublishDate(LocalDate.of(2004, 04, 27));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Kite Runner");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("18.95"));

        book = bookDao.addBook(book);

        author = new Author();
        author.setFirstName("Ashlee");
        author.setLastName("Vance");
        author.setStreet("1100 New Road");
        author.setCity("New City");
        author.setState("CA");
        author.setPostalCode("95100");
        author.setPhone("971-235-7441");
        author.setEmail("info@ashleevance.com");

        authorDao.addAuthor(author);

        publisher = new Publisher();

        //195 Broadway New York, NY .
        publisher.setName("Harper Collins Publishers");
        publisher.setStreet("195 Broadway");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("hc@hcp.com");
        publisher.setPhone("212-207-7000");

        publisher = publisherDao.addPublisher(publisher);

        book = new Book();

        book.setIsbn("9780062301239");
        book.setPublishDate(LocalDate.of(2015, 05, 19));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Elon Musk");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("29.99"));

        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();
        assertEquals(bookList.size(), 2);
    }

    @Test
    public void updateBook() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Riverhead Trade");
        publisher.setStreet("New Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setEmail("rh@riverHead.com");
        publisher.setPhone("212-207-7235");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();

        book.setIsbn("978-1594480003");
        book.setPublishDate(LocalDate.of(2004, 04, 27));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Kite Runner");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("18.95"));

        book = bookDao.addBook(book);

        book.setTitle("The Kite Runner (Hard Cover)");
        book.setPrice(new BigDecimal("32.15"));

        bookDao.updateBook(book);

        Book book2 = bookDao.getBookById(book.getBookId());
        assertEquals(book2, book);
    }

   @Test
    public void findBooksByAuthor() {

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

       Author author2 = new Author();
       author2.setFirstName("Ashlee");
       author2.setLastName("Vance");
       author2.setStreet("1100 New Road");
       author2.setCity("New City");
       author2.setState("CA");
       author2.setPostalCode("95100");
       author2.setPhone("971-235-7441");
       author2.setEmail("info@ashleevance.com");

       authorDao.addAuthor(author);

       Author author3 = new Author();
       author2.setFirstName("Cecelia");
       author2.setLastName("ahern");
       author2.setStreet("1100 Old Road");
       author2.setCity("Old City");
       author2.setState("CA");
       author2.setPostalCode("95100");
       author2.setPhone("971-836-7890");
       author2.setEmail("info@ca.com");

       authorDao.addAuthor(author);

       Publisher publisher = new Publisher();

       publisher.setName("Riverhead Trade");
       publisher.setStreet("New Street");
       publisher.setCity("New York City");
       publisher.setState("NY");
       publisher.setPostalCode("10007");
       publisher.setEmail("rh@riverHead.com");
       publisher.setPhone("212-207-7235");

       publisher = publisherDao.addPublisher(publisher);

       Publisher publisher2 = new Publisher();

       publisher2.setName("Harper Collins Publishers");
       publisher2.setStreet("195 Broadway");
       publisher2.setCity("New York City");
       publisher2.setState("NY");
       publisher2.setPostalCode("10007");
       publisher2.setEmail("hc@hcp.com");
       publisher2.setPhone("212-207-7000");

       publisher = publisherDao.addPublisher(publisher);

       Book book = new Book();

       book.setIsbn("978-1594480003");
       book.setPublishDate(LocalDate.of(2004, 04, 27));
       book.setAuthorId(author.getAuthorId());
       book.setTitle("The Kite Runner");
       book.setPublisherId(publisher.getPublisherId());
       book.setPrice(new BigDecimal("18.95"));

       book = bookDao.addBook(book);

       book = new Book();

       book.setIsbn("9780062301239");
       book.setPublishDate(LocalDate.of(2015, 05, 19));
       book.setAuthorId(author2.getAuthorId());
       book.setTitle("Elon Musk");
       book.setPublisherId(publisher2.getPublisherId());
       book.setPrice(new BigDecimal("29.99"));

       book = bookDao.addBook(book);

       book = new Book();

       book.setIsbn("9780762742394");
       book.setPublishDate(LocalDate.of(2007, 10, 1));
       book.setAuthorId(author2.getAuthorId());
       book.setTitle("Geek Silicon Valley");
       book.setPublisherId(publisher2.getPublisherId());
       book.setPrice(new BigDecimal("19.99"));

       book = bookDao.addBook(book);



       List<Book> bookList = bookDao.findBooksByAuthor(author2.getAuthorId());
       assertEquals("2", bookList.size());

       List<Book> bookList2 = bookDao.findBooksByAuthor(author.getAuthorId());
       assertEquals("1", bookList.size());

       List<Book> bookList3 = bookDao.findBooksByAuthor(author3.getAuthorId());
       assertEquals("0", bookList.size());
    }
}