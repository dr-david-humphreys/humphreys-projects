package com.techelevator;

public class CheckingAccount  extends BankAccount {
    private int overdraftFee = 10;
    private int overdraftLimit = -100;

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Override

    @Override
    public int withdraw(int amountToWithdraw) {
        int currentBalance = super.getBalance();
        int newBalance = currentBalance - amountToWithdraw;

        if (newBalance < overdraftLimit) {
            return currentBalance;
        }

        if (newBalance < 0) {
            int totalWithdrawal = amountToWithdraw + overdraftFee;
            super.withdraw(totalWithdrawal);
        } else {
            super.withdraw(amountToWithdraw);
        }
        return super.getBalance();
    }
}
