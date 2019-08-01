package com.company.ChitraMadhanU1Capstone.controller;

import com.company.ChitraMadhanU1Capstone.exception.NotFoundException;
import com.company.ChitraMadhanU1Capstone.service.GameStoreService;
import com.company.ChitraMadhanU1Capstone.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {


    @Autowired
    GameStoreService gameStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody @Valid GameViewModel gameViewModel) {
        return gameStoreService.saveGame(gameViewModel);
    }

    @GetMapping("/game/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("gameId") int gameId) {
        GameViewModel gameViewModel = gameStoreService.findGame(gameId);
        if (gameViewModel == null)
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        return gameViewModel;
    }

    @DeleteMapping("/game/{gameId}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("gameId") int gameId) {
        gameStoreService.removeGame(gameId);
    }

    @PutMapping("/game/{gameId}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel updateGame(@PathVariable("gameId") int gameId, @RequestBody @Valid GameViewModel gameViewModel) {
        if (gameViewModel.getGameId() == 0)
            gameViewModel.setGameId(gameId);
        if (gameId != gameViewModel.getGameId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the Game object");
        }
        gameViewModel= gameStoreService.updateGame(gameViewModel);
        return gameViewModel;
    }

    @GetMapping("/esrb/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameWithEsrb(@PathVariable("esrb") String esrb) {
        List<GameViewModel> gameViewModel = gameStoreService.findGameByEsrbRating(esrb);
        if (gameViewModel.size() == 0)
            throw new NotFoundException("No games available with " + esrb + " rating.");
        return gameViewModel;
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByStudio(@PathVariable("studio") String studio) {
        List<GameViewModel> gameViewModel = gameStoreService.findGameByStudio(studio);
        if (gameViewModel.size() == 0)
            throw new NotFoundException("No games found for: " + studio + ".");
        return gameViewModel;
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameWithTitle(@PathVariable("title") String title) {
        List<GameViewModel> gameViewModel = gameStoreService.findGameByTitle(title);
        if (gameViewModel.size() == 0)
            throw new NotFoundException("No games found for: " + title + ".");
        return gameViewModel;
    }
}
