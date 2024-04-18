package com.techelevator;

public class SavingsAccount extends BankAccount {

    private int minBalanceServiceCharge;
    private int serviceChargeAmount;

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
        this.minBalanceServiceCharge = 150;
        this.serviceChargeAmount = 2;
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
        this.minBalanceServiceCharge = 150;
        this.serviceChargeAmount = 2;
    }

    @Override
    public int withdraw(int amountToWithdraw){
        int currentBalance = super.getBalance();

        int newBalance = currentBalance - amountToWithdraw;

        if (newBalance < minBalanceServiceCharge) {
            amountToWithdraw += serviceChargeAmount;
            newBalance = currentBalance - amountToWithdraw;
        }

        if (newBalance >= 0) {
            super.withdraw(amountToWithdraw);
        }

        return super.getBalance();
    }
}
