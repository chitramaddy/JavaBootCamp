package com.company.ChitraMadhanU2M3Summative.dao;

import com.company.ChitraMadhanU2M3Summative.dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int Id);

    List<Invoice> getAllInvoices();

    Invoice updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

}
