package com.uts.rapid.clean.model;

import java.io.Serializable;


public class Cleaner implements Serializable {
    
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int bankBsbNumber;
    private int bankAccountNumber;
    private String bankAccountHolderName;
    private String phoneNumber;

    public Cleaner(String _id, String firstName, String lastName, String email,
            String password, String phoneNumber, int bankBsbNumber,
            int bankAccountNumber, String bankAccountHolderName) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.bankBsbNumber = bankBsbNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public String getId() {
        return _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public int getBankBsbNumber() {
        return bankBsbNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setBankBsbNumber(int bankBsbNumber) {
        this.bankBsbNumber = bankBsbNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }
}
