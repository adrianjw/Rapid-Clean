package com.uts.rapid.clean.model;

public class Address {
    
    private String id;
    private String customer_id;
    private String streetAddress;
    private String suburb;
    private String state;
    private int postcode;

    public Address(String id, String customer_id, String streetAddress,
            String suburb, String state, int postcode) {
        this.id = id;
        this.customer_id = customer_id;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
    }

    public String getId() {
        return id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
