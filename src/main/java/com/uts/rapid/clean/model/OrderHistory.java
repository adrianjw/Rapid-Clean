/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model;

import java.util.Date;

/**
 *
 * @author trandamtrungthai
 */
public class OrderHistory {
    
    private String _id;
    private String cleaner_id;
    private String orderCompleted_id;
    private Date dateTime;

    public OrderHistory(String _id, String cleaner_id, String orderCompleted_id, Date dateTime) {
        this._id = _id;
        this.cleaner_id = cleaner_id;
        this.orderCompleted_id = orderCompleted_id;
        this.dateTime = dateTime;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCleaner_id() {
        return cleaner_id;
    }

    public void setCleaner_id(String cleaner_id) {
        this.cleaner_id = cleaner_id;
    }

    public String getOrderCompleted_id() {
        return orderCompleted_id;
    }

    public void setOrderCompleted_id(String orderCompleted_id) {
        this.orderCompleted_id = orderCompleted_id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
