package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {

    @Autowired
    private ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {

        List<Console> consolesList = consoleDao.getAllConsoles();

        consolesList.stream()
                .forEach(console -> consoleDao.deleteConsole(console.getGameId()));
    }

    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setModel("Nintendo");
        console.setManufacturer("SomeBigManufacturer");
        console.setMemoryAmount("bigGB");
        console.setProcessor("speedyProcessor");
        console.setPrice(new BigDecimal("2.89"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getGameId());

        assertEquals(console, console1);

        consoleDao.deleteConsole(console.getGameId());

        console1 =consoleDao.getConsole(console.getGameId());

        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("Nintendo");
        console.setManufacturer("SomeBigManufacturer");
        console.setMemoryAmount("bigGB");
        console.setProcessor("speedyProcessor");
        console.setPrice(new BigDecimal("45.99"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Pico");
        console.setManufacturer("Sega");
        console.setMemoryAmount("bigGB");
        console.setProcessor("speedyProcessor");
        console.setPrice(new BigDecimal("99.89"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        List<Console> consoles = consoleDao.getAllConsoles();

        assertEquals(2, consoles.size());
    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("Nintendo");
        console.setManufacturer("SomeBigManufacturer");
        console.setMemoryAmount("bigGB");
        console.setProcessor("speedyProcessor");
        console.setPrice(new BigDecimal("45.99"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        console.setModel("Nintendo1");
        console.setManufacturer("SomeBigManufacturer1");
        console.setMemoryAmount("bigGB1");
        console.setProcessor("speedyProcessor1");
        console.setPrice(new BigDecimal("45.99"));
        console.setQuantity(1);

        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getGameId());

        assertEquals(console1, console);
    }

    @Test
    public void getConsoleByManufacturer() {

        Console console = new Console();
        console.setModel("Nintendo");
        console.setManufacturer("SomeBigManufacturer");
        console.setMemoryAmount("bigGB");
        console.setProcessor("speedyProcessor");
        console.setPrice(new BigDecimal("45.99"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("newNintendo");
        console.setManufacturer("SomeBigManufacturer");
        console.setMemoryAmount("smallGB");
        console.setProcessor("slowProcessor");
        console.setPrice(new BigDecimal("25.99"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Pico");
        console.setManufacturer("Sega");
        console.setMemoryAmount("bigGB");
        console.setProcessor("speedyProcessor");
        console.setPrice(new BigDecimal("99.89"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getConsoleByManufacturer("SomeBigManufacturer");
        assertEquals(2, consoleList.size());

        List<Console> consoleList1 = consoleDao.getConsoleByManufacturer("Sega");
        assertEquals(1, consoleList1.size());
    }
}