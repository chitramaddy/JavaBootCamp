package com.company.ChitraMadhanU1M5Summative.dao;

import com.company.ChitraMadhanU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisherById(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);
}
