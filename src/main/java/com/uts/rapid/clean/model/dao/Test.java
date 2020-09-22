package com.uts.rapid.clean.model.dao;

public class Test {

    public static void main(String[] args) {
        String firstName = "qwe";
        String lastName = "asd";
        String email = "qwe.asd@gmail.com";
        String password = "qweasdzxc123";
        String phone = "0412341234";
        
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createCustomer(firstName, lastName, email, password, phone);
    }
}
