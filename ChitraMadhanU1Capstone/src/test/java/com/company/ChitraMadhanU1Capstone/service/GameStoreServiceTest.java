package com.company.ChitraMadhanU1Capstone.service;

import com.company.ChitraMadhanU1Capstone.dao.*;
import com.company.ChitraMadhanU1Capstone.dto.*;
import com.company.ChitraMadhanU1Capstone.exception.InputValidationException;
import com.company.ChitraMadhanU1Capstone.viewModel.ConsoleViewModel;
import com.company.ChitraMadhanU1Capstone.viewModel.GameViewModel;
import com.company.ChitraMadhanU1Capstone.viewModel.InvoiceViewModel;
import com.company.ChitraMadhanU1Capstone.viewModel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class GameStoreServiceTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TShirtDao tShirtDao;
    GameStoreService gameStoreService;

    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTShirtDaoMock();
        setUpSalesTaxDaoMock();
        setUpProcessingFeeDaoMock();

        gameStoreService = new GameStoreService(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao, tShirtDao);
    }

    private void setUpConsoleDaoMock(){

        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setGameId(1);
        console.setModel("Peca");
        console.setManufacturer("Sega");
        console.setMemoryAmount("2GB");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("100.36").setScale(2, RoundingMode.HALF_UP));
        console.setQuantity(3);

        Console console1 = new Console();
        console1.setModel("Peca");
        console1.setManufacturer("Sega");
        console1.setMemoryAmount("2GB");
        console1.setProcessor("Processor");
        console1.setPrice(new BigDecimal("100.36").setScale(2, RoundingMode.HALF_UP));
        console1.setQuantity(3);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleList).when(consoleDao).getConsoleByManufacturer("Sega");
    }

    private void setUpGameDaoMock(){

        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("Everyone 10+");
        game.setDescription("This is an adventure game.");
        game.setPrice(new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP));
        game.setStudio("Microsoft");
        game.setQuantity(2);

        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("Everyone 10+");
        game1.setDescription("This is an adventure game.");
        game1.setPrice(new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP));
        game1.setStudio("Microsoft");
        game1.setQuantity(2);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getGamesByStudio("Microsoft");
        doReturn(gameList).when(gameDao).getGamesByEsrbRating("Everyone 10+");
        doReturn(gameList).when(gameDao).getGamesByTitle("Minecraft");
    }

    private void setUpTShirtDaoMock(){

        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);

        TShirt tShirt = new TShirt();

        tShirt.settShirtId(1);
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool T-Shirt");
        tShirt.setPrice(new BigDecimal("15.99").setScale(2, RoundingMode.HALF_UP));
        tShirt.setQuantity(1);

        TShirt tShirt1 = new TShirt();

        tShirt1.setSize("M");
        tShirt1.setColor("Red");
        tShirt1.setDescription("Cool T-Shirt");
        tShirt1.setPrice(new BigDecimal("15.99").setScale(2, RoundingMode.HALF_UP));
        tShirt1.setQuantity(1);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt1);
        doReturn(tShirt).when(tShirtDao).getTShirt(1);
        doReturn(tShirtList).when(tShirtDao).getAllTShirts();
        doReturn(tShirtList).when(tShirtDao).getTShirtByColor("Red");
        doReturn(tShirtList).when(tShirtDao).getTShirtBySize("M");
    }

    private void setUpInvoiceDaoMock(){

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Chitra");
        invoice.setStreet("New Road");
        invoice.setCity("Princeton");
        invoice.setState("NJ");
        invoice.setZipCode("08540");
        invoice.setItemType("consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("100.36"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("301.08"));
        invoice.setTax(new BigDecimal("0.05").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("331.12").setScale(2,RoundingMode.HALF_UP));

        Invoice invoice1 = new Invoice();

        invoice1.setName("Chitra");
        invoice1.setStreet("New Road");
        invoice1.setCity("Princeton");
        invoice1.setState("NJ");
        invoice1.setZipCode("08540");
        invoice1.setItemType("consoles");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal("100.36"));
        invoice1.setQuantity(3);
        invoice1.setSubTotal(new BigDecimal("301.08"));
        invoice1.setTax(new BigDecimal("0.05").setScale(2, RoundingMode.HALF_UP));
        invoice1.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.HALF_UP));
        invoice1.setTotal(new BigDecimal("331.12").setScale(2,RoundingMode.HALF_UP));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();

    }

    private void setUpSalesTaxDaoMock(){
        salesTaxRateDao = mock(SalesTaxRateDaoTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NJ");
        salesTaxRate.setRate(new BigDecimal("0.05").setScale(2,RoundingMode.HALF_UP));

        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
        salesTaxRate1.setState("NJ");
        salesTaxRate1.setRate(new BigDecimal("0.05").setScale(2,RoundingMode.HALF_UP));

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate(salesTaxRate1.getState());
    }

    private void setUpProcessingFeeDaoMock(){
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("consoles");
        processingFee.setFee(new BigDecimal("14.99").setScale(2, RoundingMode.HALF_UP));

        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProductType("consoles");
        processingFee1.setFee(new BigDecimal("14.99").setScale(2, RoundingMode.HALF_UP));

        doReturn(processingFee).when(processingFeeDao).getProcessingFee(processingFee.getProductType());
    }
    //console tests
    @Test
    public void saveFindConsole(){

        ConsoleViewModel console = new ConsoleViewModel();
        console.setGameId(1);
        console.setModel("Peca");
        console.setManufacturer("Sega");
        console.setMemoryAmount("2GB");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("100.36").setScale(2, RoundingMode.HALF_UP));
        console.setQuantity(3);

        console = gameStoreService.saveConsole(console);
        ConsoleViewModel fromService = gameStoreService.findConsole(console.getGameId());
        assertEquals(console, fromService);
    }

    @Test
    public void findConsoleByManufacturer(){
        ConsoleViewModel console = new ConsoleViewModel();
        console.setGameId(1);
        console.setModel("Peca");
        console.setManufacturer("Sega");
        console.setMemoryAmount("2GB");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("100.36").setScale(2, RoundingMode.HALF_UP));
        console.setQuantity(3);

        console = gameStoreService.saveConsole(console);
        List<ConsoleViewModel> fromService = gameStoreService.findConsoleByManufacturer("Sega");
        assertEquals(1, fromService.size());
    }

    //Game tests
    @Test
    public void saveFindGame(){

        GameViewModel game = new GameViewModel();
        game.setTitle("Minecraft");
        game.setEsrbRating("Everyone 10+");
        game.setDescription("This is an adventure game.");
        game.setPrice(new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP));
        game.setStudio("Microsoft");
        game.setQuantity(2);

        game = gameStoreService.saveGame(game);
        GameViewModel fromService = gameStoreService.findGame(game.getGameId());
        assertEquals(game, fromService);
    }

    @Test
    public void findGameByEsrbRating(){

        GameViewModel game = new GameViewModel();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("Everyone 10+");
        game.setDescription("This is an adventure game.");
        game.setPrice(new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP));
        game.setStudio("Microsoft");
        game.setQuantity(2);

        game = gameStoreService.saveGame(game);
        List<GameViewModel> fromService = gameStoreService.findGameByEsrbRating("Everyone 10+");
        assertEquals(1, fromService.size());

    }

    @Test
    public void findGameByTitle(){

        GameViewModel game = new GameViewModel();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("Everyone 10+");
        game.setDescription("This is an adventure game.");
        game.setPrice(new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP));
        game.setStudio("Microsoft");
        game.setQuantity(2);

        game = gameStoreService.saveGame(game);
        List<GameViewModel> fromService = gameStoreService.findGameByTitle("Minecraft");
        assertEquals(1, fromService.size());
    }

    @Test
    public void findGameByStudio(){

        GameViewModel game = new GameViewModel();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("Everyone 10+");
        game.setDescription("This is an adventure game.");
        game.setPrice(new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP));
        game.setStudio("Microsoft");
        game.setQuantity(2);

        game = gameStoreService.saveGame(game);
        List<GameViewModel> fromService = gameStoreService.findGameByStudio("Microsoft");
        assertEquals(1, fromService.size());

    }

    @Test
    public void saveFindTShirt(){
        TShirtViewModel tShirt = new TShirtViewModel();

        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool T-Shirt");
        tShirt.setPrice(new BigDecimal("15.99").setScale(2,RoundingMode.HALF_UP));
        tShirt.setQuantity(1);
        tShirt = gameStoreService.saveTshirt(tShirt);

        TShirtViewModel fromService = gameStoreService.findTshirt(tShirt.gettShirtId());
        assertEquals(fromService, tShirt);

    }

    @Test
    public void findTshirtByColor(){

        TShirtViewModel tShirt = new TShirtViewModel();

        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool T-Shirt");
        tShirt.setPrice(new BigDecimal("15.99").setScale(2,RoundingMode.HALF_UP));
        tShirt.setQuantity(1);
        tShirt = gameStoreService.saveTshirt(tShirt);

        List<TShirtViewModel> fromService = gameStoreService.findTShirtByColor("Red");
        assertEquals(1,fromService.size());

    }

    @Test
    public void findTshirtBySize(){

        TShirtViewModel tShirt = new TShirtViewModel();

        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Cool T-Shirt");
        tShirt.setPrice(new BigDecimal("15.99").setScale(2,RoundingMode.HALF_UP));
        tShirt.setQuantity(1);
        tShirt = gameStoreService.saveTshirt(tShirt);

        List<TShirtViewModel> fromService = gameStoreService.findTShirtBySize("M");
        assertEquals(1,fromService.size());

    }

    @Test
    public void findSaveInvoice() throws InputValidationException {
        InvoiceViewModel invoice = new InvoiceViewModel();

        invoice.setName("Chitra");
        invoice.setStreet("New Road");
        invoice.setCity("Princeton");
        invoice.setState("NJ");
        invoice.setZipCode("08540");
        invoice.setItemType("consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("100.36").setScale(2, RoundingMode.HALF_UP));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("301.08").setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal("0.05").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("330.56").setScale(2,RoundingMode.HALF_UP));
        invoice = gameStoreService.saveInvoice(invoice);

    }


}
