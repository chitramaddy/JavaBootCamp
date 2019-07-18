package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Invoice;
import com.company.ChitraMadhanU1Capstone.dto.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {

    SalesTaxRate getSalesTaxRate(String state);

}
