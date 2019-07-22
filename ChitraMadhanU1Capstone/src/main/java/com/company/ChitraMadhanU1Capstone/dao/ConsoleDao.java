package com.company.ChitraMadhanU1Capstone.dao;


import com.company.ChitraMadhanU1Capstone.dto.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int Id);

    List<Console> getAllConsoles();

    Console updateConsole(Console console);

    void deleteConsole(int id);

    List<Console> getConsoleByManufacturer(String manufacturer);
}