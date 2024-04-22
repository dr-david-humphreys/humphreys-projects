package com.techelevator.exceptions;

import java.util.Scanner;

public class BankingApp {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        BankAccount account;

        try {
            account = createBankAccount();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return; // Exit the program if the initial balance is invalid

        }

        //while (true) {
        while (true) {
            System.out.println("Choose an action: 1 - Deposit, 2 - Withdraw, 3 - Exit");
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                }else if(choice == 2){
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                }else if(choice == 3) {
                    System.out.println("Exiting.");
                    return;

                }else{
                    System.out.println("Invalid choice.");
                }

                //Can use a switch statement as well (another tool for logical branching)
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter amount to deposit: ");
//                        double depositAmount = scanner.nextDouble();
//                        account.deposit(depositAmount);
//                        break;
//                    case 2:
//                        System.out.print("Enter amount to withdraw: ");
//                        double withdrawAmount = scanner.nextDouble();
//                        account.withdraw(withdrawAmount);
//                        break;
//                    case 3:
//                        System.out.println("Exiting.");
//                        return;
//                    default:
//                        System.out.println("Invalid choice.");
//                }



            } catch (IllegalArgumentException | InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Current Balance: " + account.getBalance());
            }
        }
    }

    public static BankAccount createBankAccount(){
        System.out.print("Enter initial balance: ");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(name, accountNumber, balance);

        return bankAccount;
    }


}