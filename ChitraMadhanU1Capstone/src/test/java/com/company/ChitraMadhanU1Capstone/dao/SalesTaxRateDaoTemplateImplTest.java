package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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