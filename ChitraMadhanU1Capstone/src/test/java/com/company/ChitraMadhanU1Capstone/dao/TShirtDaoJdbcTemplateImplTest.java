package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateImplTest {

    @Autowired
    private TShirtDao tShirtDao;
    @Before
    public void setUp() throws Exception {

            List<TShirt> tShirtList = tShirtDao.getAllTShirts();

            tShirtList.stream()
                    .forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.gettShirtId()));
        }

    @Test
    public void addGetDeleteTShirt() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.gettShirtId());
        assertEquals(tShirt1, tShirt);


         tShirtDao.deleteTShirt(tShirt.gettShirtId());
         tShirt1 = tShirtDao.getTShirt(tShirt.gettShirtId());
         assertNull(tShirt1);

    }

    @Test
    public void getAllTShirts() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Yellow");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("17.99"));
        tShirt.setQuantity(3);

        tShirt = tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        assertEquals(2, tShirtList.size());
    }

    @Test
    public void updateTShirt() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt.setSize("M");
        tShirt.setColor("Blue");
        tShirt.setDescription("New Cool Game T-Shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(1);

        tShirtDao.updateTShirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.gettShirtId());
        assertEquals(tShirt1, tShirt);
    }

    @Test
    public void getTShirtByColor(){

        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Yellow");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("17.99"));
        tShirt.setQuantity(3);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("white");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Yellow");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("17.99"));
        tShirt.setQuantity(1);

        tShirt = tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getTShirtByColor("Yellow");
        assertEquals(2, tShirtList.size());

    }

    @Test
    public void getTShirtBySize(){

        TShirt tShirt = new TShirt();
        tShirt.setSize("m");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Yellow");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("17.99"));
        tShirt.setQuantity(3);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("white");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(2);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Yellow");
        tShirt.setDescription("Cool game t-shirt");
        tShirt.setPrice(new BigDecimal("17.99"));
        tShirt.setQuantity(1);

        tShirt = tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getTShirtBySize("m");
        assertEquals(2, tShirtList.size());

    }


}