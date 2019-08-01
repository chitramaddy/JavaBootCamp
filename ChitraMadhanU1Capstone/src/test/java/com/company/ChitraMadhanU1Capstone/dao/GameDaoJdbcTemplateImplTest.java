package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Game;
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
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    private GameDao gameDao;


    @Before
    public void setUp() throws Exception {
        System.out.println("Here I am");

        List<Game> gameList = gameDao.getAllGames();

        gameList.stream()
                .forEach(game -> gameDao.deleteGame(game.getGameId()));
    }

    @Test
    public void addGetDeleteGame() {

        Game game = new Game();
        game.setTitle("Elmo's World");
        game.setEsrbRating("EVERYONE");
        game.setDescription("This is a great game");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(9);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game1, game);

         gameDao.deleteGame(game.getGameId());
         game1 = gameDao.getGame(game.getGameId());
         assertNull(game1);

    }


    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setTitle("Elmo's World");
        game.setEsrbRating("EVERYONE");
        game.setDescription("This is a great game");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(9);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("River City Girls");
        game.setEsrbRating("EVERYONE 10+");
        game.setDescription("This is an action game.");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Way Forward");
        game.setQuantity(3);

        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGames();
        assertEquals(2, gameList.size());
    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Elmo World");
        game.setEsrbRating("EVERYONE");
        game.setDescription("This is a an Elmo game.");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(9);

        game = gameDao.addGame(game);

        game.setTitle("Elmo's World");
        game.setEsrbRating("MATURE");
        game.setDescription("This is a collection of \"point-and-click\" mini-games in which players can interact with Elmo and learn " +
                "about his favorite things. Players participate in basic sorting, matching, and music activities while Elmo narrates and assists.");
        game.setPrice(new BigDecimal("12.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(19);

        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game, game1);
    }

    @Test
    public void getGamesByStudio() {

        Game game = new Game();
        game.setTitle("Elmo's World");
        game.setEsrbRating("EVERYONE");
        game.setDescription("This is a great game");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(2);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("EVERYONE 10+");
        game.setDescription("This is a puzzle-adventure game");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Microsoft");
        game.setQuantity(1);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Gears of War 4");
        game.setEsrbRating("MATURE");
        game.setDescription("This is a third-person shooter game.");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Microsoft");
        game.setQuantity(3);

        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getGamesByStudio("Microsoft");
        assertEquals(2, gameList.size());

        List<Game> gameList1 = gameDao.getGamesByStudio("Avanquest Software");
        assertEquals(1, gameList1.size());
    }

    @Test
    public void getGamesByTitle() {

        Game game = new Game();
        game.setTitle("Elmo's World");
        game.setEsrbRating("EVERYONE");
        game.setDescription("This is a collection of \"point-and-click\" mini-games in which players can interact with Elmo and learn " +
                "about his favorite things. Players participate in basic sorting, matching, and music activities while Elmo narrates and assists.");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(9);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("EVERYONE 10+");
        game.setDescription("This is a puzzle-adventure game in which players mine pixelated landscapes to harvest stylized cube-like materials. ");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Microsoft");
        game.setQuantity(10);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Minecraft: Story Mode - Season Two");
        game.setEsrbRating("EVERYONE 10+");
        game.setDescription("This is an adventure game, set in the Minecraft universe, in which players assume the role of Jessie and her friends on a quest to save their home.");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Tell Tale Games");
        game.setQuantity(1);

        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getGamesByTitle("Minecraft");
        assertEquals(1, gameList.size());
    }

    @Test
    public void getGamesByEsrbRating() {

        Game game = new Game();
        game.setTitle("Elmo's World");
        game.setEsrbRating("EVERYONE");
        game.setDescription("This is a collection of \"point-and-click\" mini-games in which players can interact with Elmo and learn " +
                "about his favorite things. Players participate in basic sorting, matching, and music activities while Elmo narrates and assists.");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Avanquest Software");
        game.setQuantity(9);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("EVERYONE 10+");
        game.setDescription("This is a puzzle-adventure game in which players mine pixelated landscapes to harvest stylized cube-like materials. ");
        game.setPrice(new BigDecimal("15.99"));
        game.setStudio("Microsoft");
        game.setQuantity(10);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Minecraft: Story Mode - Season Two");
        game.setEsrbRating("EVERYONE 10+");
        game.setDescription("This is an adventure game, set in the Minecraft universe, in which players assume the role of Jessie and her friends on a quest to save their home.");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Tell Tale Games");
        game.setQuantity(1);

        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getGamesByEsrbRating("EVERYONE 10+");
        assertEquals(2, gameList.size());
    }
}