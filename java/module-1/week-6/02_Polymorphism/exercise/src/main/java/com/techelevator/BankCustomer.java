package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;

    //Constructor
    public BankCustomer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    //Accounts getter and setter (methods)
    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[0]);
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // isVIP method
    public boolean isVip() {
        int totalBalance = 0;
        for (Accountable account : accounts) {
            if (account instanceof CreditCardAccount) {
                totalBalance += account.getBalance();
            } else {
                totalBalance += account.getBalance();
            }
        }
        return totalBalance >= 25000;
    }
}
