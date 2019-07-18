package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Console;
import com.company.ChitraMadhanU1Capstone.dto.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int Id);

    List<Game> getAllGames();

    Game updateGame(Game game);

    void deleteGame(int id);

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByTitle(String title);

    List<Game> getGamesByEsrbRating(String esrb);


}
