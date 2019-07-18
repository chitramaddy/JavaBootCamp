package com.company.ChitraMadhanU1Capstone.controller;

import com.company.ChitraMadhanU1Capstone.dto.Console;
import com.company.ChitraMadhanU1Capstone.exception.NotFoundException;
import com.company.ChitraMadhanU1Capstone.service.GameStoreService;
import com.company.ChitraMadhanU1Capstone.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {

    @Autowired
    GameStoreService gameStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        return gameStoreService.saveConsole(consoleViewModel);
    }

    @GetMapping("/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("gameId") int gameId) {
        ConsoleViewModel consoleViewModel = gameStoreService.findConsole(gameId);
        if (consoleViewModel == null)
            throw new NotFoundException("Console could not be retrieved for id " + gameId);
        return consoleViewModel;
    }

    @DeleteMapping("/{gameId}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("gameId") int gameId) {
        gameStoreService.removeConsole(gameId);
    }

    @PutMapping("/{gameId}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("gameId") int gameId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getGameId() == 0)
            consoleViewModel.setGameId(gameId);
        if (gameId != consoleViewModel.getGameId()) {
            throw new IllegalArgumentException("Console ID on path must match the ID in the Console object");
        }
        gameStoreService.updateConsole(consoleViewModel);
    }

    @GetMapping("/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> consoleViewModel = gameStoreService.findConsoleByManufacturer(manufacturer);
        if (consoleViewModel == null)
            throw new NotFoundException("No console found by " + manufacturer);
        return consoleViewModel;
    }

}
