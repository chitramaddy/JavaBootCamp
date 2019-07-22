package com.company.ChitraMadhanU1Capstone.service;

import com.company.ChitraMadhanU1Capstone.dao.*;
import com.company.ChitraMadhanU1Capstone.dto.*;
import com.company.ChitraMadhanU1Capstone.exception.InputValidationException;
import com.company.ChitraMadhanU1Capstone.viewModel.ConsoleViewModel;
import com.company.ChitraMadhanU1Capstone.viewModel.GameViewModel;
import com.company.ChitraMadhanU1Capstone.viewModel.InvoiceViewModel;
import com.company.ChitraMadhanU1Capstone.viewModel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameStoreService {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TShirtDao tShirtDao;

    @Autowired
    public GameStoreService(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao,
                            ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TShirtDao tShirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tShirtDao = tShirtDao;
    }

    //Console view model CRUD methods, find console by manufacturer

    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);
        consoleViewModel.setGameId(console.getGameId());

        return consoleViewModel;
    }

    public ConsoleViewModel findConsole(int id) {
        Console console = consoleDao.getConsole(id);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public ConsoleViewModel updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setGameId(consoleViewModel.getGameId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleDao.updateConsole(console);

        return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findConsoleByManufacturer(String manufacturer) {

        List<Console> consoles = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> consoleViewModels = new ArrayList<ConsoleViewModel>();

        for (Console console : consoles) {
            consoleViewModels.add(buildConsoleViewModel(console));
        }
        return consoleViewModels;
    }

    public void removeConsole(int id) {

        consoleDao.deleteConsole(id);

    }

    //TShirt View Model CRUD methods, find by color, find by size

    public TShirtViewModel saveTshirt(TShirtViewModel tShirtViewModel) {

        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirtViewModel.settShirtId(tShirt.gettShirtId());

        return tShirtViewModel;
    }

    public TShirtViewModel findTshirt(int id) {
        TShirt tShirt = tShirtDao.getTShirt(id);
        if (tShirt == null)
            return null;
        else
            return buildTshirtViewModel(tShirt);
    }

    public TShirtViewModel updateTshirt(TShirtViewModel tShirtViewModel) {

        TShirt tShirt = new TShirt();
        tShirt.settShirtId(tShirtViewModel.gettShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirt = tShirtDao.updateTShirt(tShirt);

        return buildTshirtViewModel(tShirt);
    }

    public void removeTShirt(int id) {

        tShirtDao.deleteTShirt(id);
    }


    public List<TShirtViewModel> findTShirtByColor(String color) {

        List<TShirt> tShirtList = tShirtDao.getTShirtByColor(color);
        List<TShirtViewModel> tShirtViewModels = new ArrayList<TShirtViewModel>();

        for (TShirt tShirt : tShirtList) {
            tShirtViewModels.add(buildTshirtViewModel(tShirt));
        }
        return tShirtViewModels;
    }

    public List<TShirtViewModel> findTShirtBySize(String size) {
        List<TShirt> tShirtList = tShirtDao.getTShirtBySize(size);
        List<TShirtViewModel> tShirtViewModels = new ArrayList<TShirtViewModel>();

        for (TShirt tShirt : tShirtList) {
            tShirtViewModels.add(buildTshirtViewModel(tShirt));
        }
        return tShirtViewModels;
    }


    //Game view model CRUD methods, find game by studio, find game by esrb, find game by title

    public GameViewModel saveGame(GameViewModel gameViewModel) {

        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        game = gameDao.addGame(game);

        gameViewModel.setGameId(game.getGameId());

        return gameViewModel;
    }

    public GameViewModel findGame(int id) {
        Game game = gameDao.getGame(id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public GameViewModel updateGame(GameViewModel gameViewModel) {

        Game game = new Game();
        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        gameDao.updateGame(game);

        return buildGameViewModel(game);
    }

    public List<GameViewModel> findGameByStudio(String studio) {

        List<Game> gameList = gameDao.getGamesByStudio(studio);
        List<GameViewModel> gameViewModels = new ArrayList<GameViewModel>();

        for (Game game : gameList) {
            gameViewModels.add(buildGameViewModel(game));
        }
        return gameViewModels;
    }

    public void removeGame(int id) {
        gameDao.deleteGame(id);
    }

    public List<GameViewModel> findGameByEsrbRating(String esrb) {

        List<Game> gameList = gameDao.getGamesByEsrbRating(esrb);
        List<GameViewModel> gameViewModels = new ArrayList<GameViewModel>();

        for (Game game : gameList) {
            gameViewModels.add(buildGameViewModel(game));
        }
        return gameViewModels;
    }

    public List<GameViewModel> findGameByTitle(String title) {
        List<Game> gameList = gameDao.getGamesByTitle(title);
        List<GameViewModel> gameViewModels = new ArrayList<GameViewModel>();

        for (Game game : gameList) {
            gameViewModels.add(buildGameViewModel(game));
        }
        return gameViewModels;
    }

    //Invoice view model methods

    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) throws InputValidationException{

        String errors = inputValidation(invoiceViewModel);

        if(!errors.equals("none")){
            throw new InputValidationException(errors);
        }


        Invoice invoice = new Invoice();

        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZipCode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());

        //Find Unit Price
        BigDecimal unitPrice = findUnitPrice(invoiceViewModel.getItemType(), invoiceViewModel.getItemId());
        invoice.setUnitPrice(unitPrice);

        //Find Sub Total
        BigDecimal subTotal = invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity()));
        invoice.setSubTotal(subTotal);

        //find salestax
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate("NJ");
        BigDecimal taxRate = salesTaxRate.getRate();
        invoice.setTax(taxRate);

        //find processingfee
        BigDecimal processingFee = findProcessingFee(invoice.getQuantity(), invoice.getItemType());
        invoice.setProcessingFee(processingFee);

        //find total
        BigDecimal total = subTotal.add(subTotal.multiply(invoice.getTax()).setScale(2, RoundingMode.HALF_UP));

        total = total.add(processingFee).setScale(2, RoundingMode.HALF_UP);
        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);

        calculateStock(invoice, invoice.getItemId());

        return buildInvoiceViewModel(invoice);
    }

    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if (invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    public List<Invoice> findAllInvoices() {

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        return invoiceList;

    }

    //view model build methods

    private ConsoleViewModel buildConsoleViewModel(Console console) {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setGameId(console.getGameId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }

    private GameViewModel buildGameViewModel(Game game) {

        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }

    private TShirtViewModel buildTshirtViewModel(TShirt tShirt) {

        TShirtViewModel tShirtViewModel = new TShirtViewModel();

        tShirtViewModel.settShirtId(tShirt.gettShirtId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());

        return tShirtViewModel;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();

        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipCode(invoice.getZipCode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setSubTotal(invoice.getSubTotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

    //check State validity
    Boolean validStateCode(String state){
        SalesTaxRate salesTaxRate= salesTaxRateDao.getSalesTaxRate(state);
         if (salesTaxRate == null) return false;
         else return true;

    }

    Boolean isItemValid(String itemType) {
        switch (itemType.toLowerCase()) {
            case "game":
            case "games":
                return true;

            case "t_shirt":
            case "t_shirts":
                return true;

            case "console":
            case "consoles":
                return true;

            default:
                return false;
        }
    }

    //Find the matching itemtype and itemId. Get the unit price;
    private BigDecimal findUnitPrice(String itemType, int itemId) {

        BigDecimal unitPrice = new BigDecimal("0.00");

        switch (itemType.toLowerCase()) {
            case "game":
            case "games":
                Game game = gameDao.getGame(itemId);
                if (game == null)
//                    throw new Exception();
                    return null;
                else unitPrice = game.getPrice();
                break;

            case "t_shirt":
            case "t_shirts":
                TShirt tShirt = tShirtDao.getTShirt(itemId);
                if (tShirt == null) return null;
                else unitPrice = tShirt.getPrice();
                break;

            case "console":
            case "consoles":
                Console console = consoleDao.getConsole(itemId);
                if (console == null) return null;
                else unitPrice = console.getPrice();
                unitPrice = console.getPrice();
                break;
            default:
                System.out.println("Item not found");
        }
        return unitPrice;
    }

    private BigDecimal findProcessingFee(int quantity, String productType) {
        ProcessingFee processingFee = processingFeeDao.getProcessingFee(productType);

        if (processingFee == null) {
            return null;
        } else {
            BigDecimal fee = processingFee.getFee().setScale(2, RoundingMode.HALF_UP);
            if (quantity > 10) {
                fee = fee.add(new BigDecimal("15.49").setScale(2, RoundingMode.HALF_UP));
            }
            return fee;
        }
    }

    private Integer checkAvailability(int itemId, String productType) {

        int stock = 0;

        switch (productType) {
            case "game":
            case "games":
                Game game = gameDao.getGame(itemId);
                if (game == null)
                    return null;
                else stock = game.getQuantity();
                break;
            case "tshirt":
            case "tshirts":
                TShirt tShirt = tShirtDao.getTShirt(itemId);
                if (tShirt == null)
                    return null;
                else stock = tShirt.getQuantity();
                break;
            case "console":
            case "consoles":
                Console console = consoleDao.getConsole(itemId);
                if (console == null)
                    return null;
                else stock = console.getQuantity();
                break;
            default:
                stock = 0;
        }
        return stock;
    }

    //calculate stock after order is executed.
    public void calculateStock(Invoice invoice, int itemId){

        int orderQuantity = invoice.getQuantity();
        int stock = checkAvailability(invoice.getItemId(), invoice.getItemType());

        stock = stock-orderQuantity;
        updateInventory(invoice.getItemType(), invoice.getItemId(), stock);
    }

    //update the database with current stock
    public void updateInventory(String productType, int itemId, int quantity){

        switch (productType) {
            case "game":
            case "games":
                Game game = gameDao.getGame(itemId);
                game.setQuantity(quantity);
                gameDao.updateGame(game);
                break;
            case "tshirt":
            case "tshirts":
                TShirt tShirt = tShirtDao.getTShirt(itemId);
                tShirt.setQuantity(quantity);
                tShirtDao.updateTShirt(tShirt);
                break;
            case "console":
            case "consoles":
                Console console = consoleDao.getConsole(itemId);
                console.setQuantity(quantity);
                consoleDao.updateConsole(console);
                break;
                default:
                    return;
                   }

    }

    public String inputValidation(InvoiceViewModel invoiceViewModel) throws InputValidationException{
        String error = "none";

        Boolean checkState = validStateCode(invoiceViewModel.getState());
        Boolean itemValid = isItemValid(invoiceViewModel.getItemType());
        int stockInHand = checkAvailability(invoiceViewModel.getItemId(), invoiceViewModel.getItemType());

        if (checkState == false) {
            error = "Invalid state code.";
        } else if (!itemValid) {
            error = "Invalid product type.";
        } else if (invoiceViewModel.getQuantity() > stockInHand) {
            error = "Insufficient stock.";
        }
        return error;
    }

}

