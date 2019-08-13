package com.company.ChitraMadhanU2M3Summative.dao;

import com.company.ChitraMadhanU2M3Summative.dto.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcesseingFeeDaoJdbcTemplateImplTest {

    @Autowired
    private ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getProcessingFee() {

        ProcessingFee processingFee = new ProcessingFee();

        processingFee = processingFeeDao.getProcessingFee("t_shirts");

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertEquals(processingFee1.getFee(), processingFee.getFee());

    }
}