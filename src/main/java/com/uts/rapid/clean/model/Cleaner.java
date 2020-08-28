/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model;


public class Cleaner {
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int bankBsb;
    private int bankAccountNumber;
    private String bankAccountHolderName;
    private String phone;

    public Cleaner(String _id, String firstName, String lastName, String email, String password, int bankBsb, int bankAccountNumber, String bankAccountHolderName, String phone) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bankBsb = bankBsb;
        this.bankAccountNumber = bankAccountNumber;
        this.bankAccountHolderName = bankAccountHolderName;
        this.phone = phone;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBankBsb() {
        return bankBsb;
    }

    public void setBankBsb(int bankBsb) {
        this.bankBsb = bankBsb;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
