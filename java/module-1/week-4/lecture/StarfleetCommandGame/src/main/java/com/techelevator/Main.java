package com.techelevator;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    private static int playerHealth = 100;
    private static int playerScore = 0;

    private static final String[] enemyShips = {"Borg Cube", "The Narada", "Klingon Bird of Prey", "Star Destroyer", "Lambda Class Imperial Ship"};
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        while (true) {
            System.out.println("===== Main Menu =====");
            System.out.println("1. Start Battle");
            System.out.println("2. View Stats");
            System.out.println("3. Repair Ship");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = readUserChoice();
            if (choice == 1) {
                startBattle();
            } else if (choice == 2) {
                viewStats();
            } else if (choice == 3) {
                repairShip();
            } else if (choice == 0) {
                exitGame();
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int readUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void startBattle() {
        System.out.println("===== Battle Start =====");
        String enemyShip = getRandomEnemyShip();
        System.out.println("An enemy " + enemyShip + " approaches!");

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Attack");
            System.out.println("2. Retreat");
            System.out.print("Choose an option: ");

            int choice = readUserChoice();
            if (choice == 1) {
                if (attackEnemy()) {
                    System.out.println("You destroyed the enemy " + enemyShip + "!");
                    playerScore += 10;
                } else {
                    System.out.println("Your attack failed!");
                }
            } else if (choice == 2) {
                System.out.println("You retreated from battle.");
                return;
            } else {
                System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private static boolean attackEnemy() {
        return random.nextBoolean();
    }

    private static void viewStats() {
        System.out.println("===== Player Stats =====");
        System.out.println("Health: " + playerHealth);
        System.out.println("Score: " + playerScore);
    }

    private static void repairShip() {
        playerHealth = 100;
        System.out.println("Your ship has been repaired. Health restored to 100.");
    }

    private static void exitGame() {
        System.out.println("===== Game Over =====");
        System.out.println("Final Score: " + playerScore);
        System.exit(0);
    }

    private static String getRandomEnemyShip() {
        int index = random.nextInt(enemyShips.length);
        return enemyShips[index];
    }
}