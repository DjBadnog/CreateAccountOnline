package com.example.abnn965.createaccountonline;

import java.io.Serializable;

/**
 * Created by ABNN965 on 8/8/2016.
 */
public class Account implements Serializable {
    private int id;
    private String accountNumber ;
    private String accountType;
    private double balance ;
    private String idNumber;

    public Account() {

    }

    public Account(String accountNumber, String accountType, Double balance, String idNumber) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.idNumber = idNumber;
    }

    public Account(int id, String accountNumber, String accountType, Double balance, String idNumber) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.idNumber = idNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
