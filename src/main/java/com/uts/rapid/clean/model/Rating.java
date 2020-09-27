package com.uts.rapid.clean.model;

import java.util.Date;

public class Rating {
    private String id;
    private String customerId;
    private String orderCompletedId;
    private int rating;
    private String comment;
    private Date date;

    public Rating(String id, String customerId, String orderHistoryId, int rating, String comment, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.orderCompletedId = orderCompletedId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderCompletedId() {
        return orderCompletedId;
    }

    public void setOrderCompletedId(String orderHistoryId) {
        this.orderCompletedId = orderHistoryId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
