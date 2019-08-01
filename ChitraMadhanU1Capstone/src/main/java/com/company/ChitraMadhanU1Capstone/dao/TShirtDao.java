package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Invoice;
import com.company.ChitraMadhanU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int Id);

    List<TShirt> getAllTShirts();

    TShirt updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);

    List<TShirt> getTShirtByColor(String color);

    List<TShirt> getTShirtBySize(String size);

}
