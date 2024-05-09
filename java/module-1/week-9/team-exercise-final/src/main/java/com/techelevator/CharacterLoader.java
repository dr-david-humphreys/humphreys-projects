package com.techelevator;

// CharacterLoader.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterLoader {
    public static List<Character> loadCharacters(String filePath) {
        List<Character> characters = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    continue; // Skip invalid lines
                }

                String type = parts[0].trim();
                String name = parts[1].trim();
                int health = Integer.parseInt(parts[2].trim());
                int attackPower = Integer.parseInt(parts[3].trim());

                Character character = switch (type.toLowerCase()) {
                    case "warrior" -> new Warrior(name, health, attackPower);
                    case "valkyrie" -> new Valkyrie(name, health, attackPower);
                    case "wizard" -> new Wizard(name, health, attackPower);
                    case "elf" -> new Elf(name, health, attackPower);
                    default -> null;
                };

                if (character != null) {
                    characters.add(character);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV file.");
        }
        return characters;
    }
}

