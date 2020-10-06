package com.uts.rapid.clean.model;

import java.util.Date;

public class Order {

    private String _id;
    private String customer_id;
    private String address_id;
    private String residentialType;
    private double hourlyRate;
    private String orderCategory;
    private String orderCategoryDesc;
    private Date dateTime;

    public Order(String _id, String customer_id, String address_id, String residentialType,
            double hourlyRate, String orderCategory, String orderCategoryDesc, Date dateTime) {
        this._id = _id;
        this.customer_id = customer_id;
        this.address_id = address_id;
        this.residentialType = residentialType;
        this.hourlyRate = hourlyRate;
        this.orderCategory = orderCategory;
        this.orderCategoryDesc = orderCategoryDesc;
        this.dateTime = dateTime;
    }
    
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getResidentialType() {
        return residentialType;
    }

    public void setResidentialType(String residentialType) {
        this.residentialType = residentialType;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(String orderCategory) {
        this.orderCategory = orderCategory;
    }

    public String getOrderCategoryDesc() {
        return orderCategoryDesc;
    }

    public void setOrderCategoryDesc(String orderCategoryDesc) {
        this.orderCategoryDesc = orderCategoryDesc;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
