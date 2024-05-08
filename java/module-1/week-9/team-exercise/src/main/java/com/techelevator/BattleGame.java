package com.techelevator;

// BattleGame.java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleGame {
    private static final Random RANDOM = new Random();
    private static final String LOG_FILE = ""; //TODO: assign value for LOG_FILE

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> characters = CharacterLoader.loadCharacters(""); //TODO: assign value for .csv file

        if (characters.isEmpty()) {
            System.out.println("No characters available for battle.");
            return;
        }

        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            System.out.println("Welcome to the Gauntlet Character Battle!");
            System.out.println("Available Characters:");
            for (int i = 0; i < characters.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, characters.get(i).getName());
            }

            System.out.print("Select the first character for battle (1-" + characters.size() + "): ");
            int firstChoice = scanner.nextInt() - 1;

            System.out.print("Select the second character for battle (1-" + characters.size() + "): ");
            int secondChoice = scanner.nextInt() - 1;

            if (firstChoice < 0 || firstChoice >= characters.size() || secondChoice < 0 || secondChoice >= characters.size() || firstChoice == secondChoice) {
                System.out.println("Invalid selection.");
                return;
            }

            Character character1 = characters.get(firstChoice);
            Character character2 = characters.get(secondChoice);

            logWriter.printf("Battle between %s and %s:%n", character1.getName(), character2.getName());

            Character winner = battle(character1, character2, logWriter);

            System.out.printf("%s is the winner!%n", winner.getName());
            logWriter.printf("%s wins the battle!%n", winner.getName());
            logWriter.println();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    private static Character battle(Character character1, Character character2, PrintWriter logWriter) {
        System.out.printf("Starting battle between %s and %s!%n", character1.getName(), character2.getName());

        while (character1.getHealth() > 0 && character2.getHealth() > 0) {
            if (RANDOM.nextBoolean()) {
                character1.attack(character2);
            } else {
                character2.attack(character1);
            }

            logWriter.printf("%s: %d HP | %s: %d HP%n", character1.getName(), character1.getHealth(), character2.getName(), character2.getHealth());

            if (character1.getHealth() <= 0) {
                return character2;
            } else if (character2.getHealth() <= 0) {
                return character1;
            }
        }
        return character1;
    }
}

