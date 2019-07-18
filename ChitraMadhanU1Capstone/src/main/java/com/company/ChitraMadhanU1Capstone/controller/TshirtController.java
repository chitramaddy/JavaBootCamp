package com.company.ChitraMadhanU1Capstone.controller;

import com.company.ChitraMadhanU1Capstone.exception.NotFoundException;
import com.company.ChitraMadhanU1Capstone.service.GameStoreService;
import com.company.ChitraMadhanU1Capstone.viewModel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirt")
public class TshirtController {


    @Autowired
    GameStoreService gameStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel addTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel) {
        return gameStoreService.saveTshirt(tShirtViewModel);
    }

    @GetMapping("/{tshirtId}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTshirt(@PathVariable("tshirtId") int tshirtId) {
        TShirtViewModel tShirtViewModel = gameStoreService.findTshirt(tshirtId);
        if (tShirtViewModel == null)
            throw new NotFoundException("Tshirt could not be retrieved for id " + tshirtId);
        return tShirtViewModel;
    }

    @DeleteMapping("/{tshirtId}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable("tshirtId") int tshirtId) {
        gameStoreService.removeTShirt(tshirtId);
    }

    @PutMapping("/{tshirtId}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("tshirtId") int tshirtId, @RequestBody @Valid TShirtViewModel tShirtViewModel) {
        if (tShirtViewModel.gettShirtId() == 0)
            tShirtViewModel.settShirtId(tshirtId);
        if (tshirtId != tShirtViewModel.gettShirtId()) {
            throw new IllegalArgumentException("T-Shirt ID on path must match the ID in the T-Shirt object");
        }
        gameStoreService.updateTshirt(tShirtViewModel);
    }

    @GetMapping("/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTshirtWithColor(@PathVariable("color") String color) {
        List<TShirtViewModel> tShirtViewModels = gameStoreService.findTShirtByColor(color);
        if (tShirtViewModels == null)
            throw new NotFoundException("No " + color + "tshirts available.");
        return tShirtViewModels;
    }

    @GetMapping("/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTshirtWithSize(@PathVariable("size") String size) {
        List<TShirtViewModel> tShirtViewModels = gameStoreService.findTShirtBySize(size);
        if (tShirtViewModels == null)
            throw new NotFoundException("No " + size + "tshirts available.");
        return tShirtViewModels;
    }

}
