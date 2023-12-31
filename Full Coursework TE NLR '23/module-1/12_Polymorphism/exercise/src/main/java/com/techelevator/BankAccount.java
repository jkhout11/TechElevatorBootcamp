package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

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

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    @Override
    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        balance += amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;
    }

    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        if (balance - transferAmount >= 0) {
            withdraw(transferAmount);
            destinationAccount.deposit(transferAmount);
        }
        return balance;
    }
}
