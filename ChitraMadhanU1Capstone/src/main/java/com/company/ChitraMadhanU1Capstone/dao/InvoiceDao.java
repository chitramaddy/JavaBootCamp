package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int Id);

    List<Invoice> getAllInvoices();

    Invoice updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

}
