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
        int newBalance = super.getBalance() - amountToWithdraw;
        if (newBalance >= overdraftLimit) {
            super.withdraw(amountToWithdraw);
            if (super.getBalance() < 0) {
                super.withdraw(overdraftFee);
            }
        }
        return super.getBalance();
    }
}
