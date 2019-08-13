package com.company.ChitraMadhanU2M3Summative.dao;

import com.company.ChitraMadhanU2M3Summative.dto.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoTemplateImplTest {

    @Autowired
    private SalesTaxRateDao salesTaxRateDao;

    @Test
    public void getSalesTaxRate() {

        SalesTaxRate salesTaxRate = new SalesTaxRate();

        salesTaxRate = salesTaxRateDao.getSalesTaxRate("NJ");

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertEquals(salesTaxRate.getRate(), salesTaxRate1.getRate());
    }

}