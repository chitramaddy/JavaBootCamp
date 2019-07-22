package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    private InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
    }

    @Test
    public void addGetDeleteInvoice() {

        Invoice invoice = new Invoice();
                invoice.setName("Chitra");
                invoice.setStreet("New Road");
                invoice.setCity("Princeton");
                invoice.setState("NJ");
                invoice.setZipCode("08540");
                invoice.setItemType("t-Shirts");
                invoice.setItemId(1);
                invoice.setUnitPrice(new BigDecimal("12.99"));
                invoice.setQuantity(2);
                invoice.setSubTotal(new BigDecimal("25.98").setScale(2, RoundingMode.HALF_UP));
                invoice.setTax(new BigDecimal("1.299").setScale(2, RoundingMode.HALF_UP));
                invoice.setProcessingFee(new BigDecimal("1.98").setScale(2, RoundingMode.HALF_UP));
                invoice.setTotal(new BigDecimal("29.259").setScale(2,RoundingMode.HALF_UP));

                invoice = invoiceDao.addInvoice(invoice);

                Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
                assertEquals(invoice1, invoice);
    }

    @Test
    public void getAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setName("Chitra");
        invoice.setStreet("New Road");
        invoice.setCity("Princeton");
        invoice.setState("NJ");
        invoice.setZipCode("08540");
        invoice.setItemType("t-Shirts");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99").setScale(2,RoundingMode.HALF_UP));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("25.98").setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal("1.299").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("1.98").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("29.259").setScale(2,RoundingMode.HALF_UP));

        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Chitra");
        invoice.setStreet("New Road");
        invoice.setCity("Princeton");
        invoice.setState("NJ");
        invoice.setZipCode("08540");
        invoice.setItemType("consoles");
        invoice.setItemId(4);
        invoice.setUnitPrice(new BigDecimal("100.99").setScale(2,RoundingMode.HALF_UP));
        invoice.setQuantity(4);
        invoice.setSubTotal(new BigDecimal("403.96").setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal("16.1584").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("435.11").setScale(2,RoundingMode.HALF_UP));

        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        assertEquals(2, invoiceList.size());
    }

    @Test
    public void updateInvoices() {

        Invoice invoice = new Invoice();
        invoice.setName("Chitra");
        invoice.setStreet("New Road");
        invoice.setCity("Princeton");
        invoice.setState("NJ");
        invoice.setZipCode("08540");
        invoice.setItemType("t-Shirts");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99").setScale(2,RoundingMode.HALF_UP));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("25.98").setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal("1.299").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("1.98").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("29.259").setScale(2,RoundingMode.HALF_UP));

        invoiceDao.addInvoice(invoice);

        invoice.setName("New Customer");
        invoice.setStreet("Old Road");
        invoice.setCity("Princeton");
        invoice.setState("NJ");
        invoice.setZipCode("08540");
        invoice.setItemType("t-Shirts");
        invoice.setItemId(4);
        invoice.setUnitPrice(new BigDecimal("12.99").setScale(2,RoundingMode.HALF_UP));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("25.98").setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal("1.299").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("1.98").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("29.259").setScale(2,RoundingMode.HALF_UP));

        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice1, invoice);

    }
}