package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoTemplateImpl implements SalesTaxRateDao{

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_SALES_TAX_RATE =
        "select * from Sales_Tax_Rate where state = ?";

    @Autowired
    public SalesTaxRateDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {

        try{
            return  jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE, this::mapToRowSaleTaxRate, state);

        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private SalesTaxRate mapToRowSaleTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate").setScale(2, RoundingMode.HALF_UP));

        return salesTaxRate;
    }

}
