package com.company.ChitraMadhanU1Capstone.dao;

import com.company.ChitraMadhanU1Capstone.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_CONSOLE =
            "insert into console (model, manufacturer, memory_amount, processor, price, quantity) values(?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CONSOLE =
            "select * from console where game_id = ?";

    private static final String SELECT_ALL_CONSOLES =
            "select * from console";

    private static final String UPDATE_CONSOLE =
            "update console set model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? where game_id = ?";

    private static final String DELETE_CONSOLE =
            "delete from console where game_id = ?";

    private static final String SELECT_CONSOLE_BY_MANUFACTURER =
             "select * from console where manufacturer = ?";

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Console addConsole(Console console) {

        jdbcTemplate.update(INSERT_CONSOLE,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());

        int gameId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        console.setGameId(gameId);

        return console;
    }

    @Override
    public Console getConsole(int id) {
    try{
        return jdbcTemplate.queryForObject(SELECT_CONSOLE, this::mapRowToConsole, id);
    }catch (EmptyResultDataAccessException e){
        return null;
    }
}

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES, this::mapRowToConsole);
    }

    @Override
    public Console updateConsole(Console console) {
         jdbcTemplate.update(
                 UPDATE_CONSOLE,
                 console.getModel(),
                 console.getManufacturer(),
                 console.getMemoryAmount(),
                 console.getProcessor(),
                 console.getPrice(),
                 console.getQuantity(),
                 console.getGameId());

         return console;
    }

    @Override
    public void deleteConsole(int id) {

        jdbcTemplate.update(DELETE_CONSOLE, id);

    }

    @Override
    public List<Console> getConsoleByManufacturer(String manufacturer) {

        return jdbcTemplate.query(SELECT_CONSOLE_BY_MANUFACTURER, this::mapRowToConsole, manufacturer);
    }

    private Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException{

        Console console = new Console();
        console.setGameId(rs.getInt("game_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemoryAmount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }

}
