package com.uts.rapid.clean.model;

public class Customer {
    
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    public Customer(String _id, String firstName, String lastName,
            String email, String password, String phone) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
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
    
    public String getPhone() {
        return phone;
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
        this.phone = password;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
