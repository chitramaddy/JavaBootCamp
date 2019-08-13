package com.company.ChitraMadhanU2M3Summative.dao;


import com.company.ChitraMadhanU2M3Summative.dto.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int Id);

    List<Console> getAllConsoles();

    Console updateConsole(Console console);

    void deleteConsole(int id);

    List<Console> getConsoleByManufacturer(String manufacturer);
}