package com.uts.rapid.clean.model;

import java.io.Serializable;

public class Address implements Serializable {
    
    private String _id;
    private String customer_id;
    private String streetAddress;
    private String suburb;
    private String state;
    private int postcode;

    public Address(String _id, String customer_id, String streetAddress,
            String suburb, String state, int postcode) {
        this._id = _id;
        this.customer_id = customer_id;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
    }

    public String getId() {
        return _id;
    }

    public String getCustomerId() {
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
    
    public String getFullAddress() {
        return (streetAddress + ", " + suburb + ", " + state + ", " + postcode);
    }
}
