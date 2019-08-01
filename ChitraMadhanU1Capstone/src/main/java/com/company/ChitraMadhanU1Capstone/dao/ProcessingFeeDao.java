package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.ProcessingFee;
import com.company.ChitraMadhanU1Capstone.dto.TShirt;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface ProcessingFeeDao {

    ProcessingFee getProcessingFee(String productType);

}
