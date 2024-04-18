package com.techelevator;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    // Constructors
    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Transfer funds method
    public int transferFunds(BankAccount destinationAccount, int transferAmount) {
        this.withdraw(transferAmount);

        destinationAccount.deposit(transferAmount);

        return this.getBalance();
    }

    // Getters and Setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Implementing Accountable
    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        if (amountToDeposit > 0) {
            balance = balance + amountToDeposit;
        }
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw > 0) {
            balance = balance - amountToWithdraw;
        }
        return balance;
    }

}
