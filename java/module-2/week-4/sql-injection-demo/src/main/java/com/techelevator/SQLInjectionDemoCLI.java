package com.techelevator;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

import java.util.List;
import java.util.Scanner;

public class SQLInjectionDemoCLI {

    private final Scanner userInput = new Scanner(System.in);

    private final StateDao stateDao;
    private final ParkDao parkDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/SqlInjectionDemo");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        SQLInjectionDemoCLI application = new SQLInjectionDemoCLI(dataSource);
        application.run();
    }

    public SQLInjectionDemoCLI(DataSource dataSource) {
        stateDao = new JdbcStateDao(dataSource);
        parkDao = new JdbcParkDao(dataSource);
    }

    private void run() {
        displayBanner();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = promptForInt("Please select an option: ");
            if (selection == 1) {
                String stateAbbr = promptForString("Please enter a state abbreviation: ");
                State state = stateDao.getStateByAbbreviation(stateAbbr);
                displayState(state);
            } else if (selection == 2) {
                String stateAbbr = promptForString("Please enter a state abbreviation: ");
                try {
                    State state = stateDao.getStateByAbbreviationConcatenation(stateAbbr);
                    displayState(state);
                } catch (Exception ignored) {
                    // bad idea to just ignore exceptions, this is solely for demo purposes
                }
            } else if (selection == 3) {
                String stateName = promptForString("Please enter a search string: ");
                if (stateName.isEmpty()) {
                    displayError("You must enter a search term");
                } else {
                    List<State> states = stateDao.getStatesByName(stateName);
                    displayStates(states);
                }
            } else if (selection == 4) {
                int parkCount = parkDao.getParkCount();
                System.out.format("\nThere are %d parks\n\n", parkCount);
            } else if (selection == 5) {
                running = false;
            } else {
                displayError("Invalid option selected.");
            }
        }
    }

    private void displayState(State state) {
        System.out.println("---");
        if (state != null) {
            System.out.println("State name: " + state.getStateName() + " (" + state.getStateAbbreviation() + ")");
        } else {
            System.out.println("State is null");
        }
        System.out.println("---");
    }

    private void displayStates(List<State> states) {
        System.out.println("---");
        for (State state : states) {
            System.out.println("State name: " + state.getStateName() + " (" + state.getStateAbbreviation() + ")");
        }
        System.out.println("---");
    }

    private void displayBanner() {
        System.out.println("-----------------------------------------");
        System.out.println("|      SQL Injection Demonstration      |");
        System.out.println("-----------------------------------------");
    }

    private void displayMenu() {
        System.out.println("1. Get State By Abbreviation (parameter)");
        System.out.println("2. Get State By Abbreviation (string concatenation)");
        System.out.println("3. Get States By Name (string concatenation)");
        System.out.println("4. Get Park Count");
        System.out.println("5. Exit");
    }

    private void displayError(String message) {
        System.out.println();
        System.out.println("***" + message + "***");
        System.out.println();
    }

    private int promptForInt(String prompt) {
        return (int) promptForDouble(prompt);
    }

    private double promptForDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return Double.parseDouble(response);
            } catch (NumberFormatException e) {
                if (response.isBlank()) {
                    return -1; //Assumes negative numbers are never valid entries.
                } else {
                    displayError("Numbers only, please.");
                }
            }
        }
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return userInput.nextLine();
    }
}
