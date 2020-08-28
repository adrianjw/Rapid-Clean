/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model;

public class OrderAccepted {
    private String _id;
    private String cleaner_id;
    private String order_id;

    public OrderAccepted(String _id, String cleaner_id, String order_id) {
        this._id = _id;
        this.cleaner_id = cleaner_id;
        this.order_id = order_id;
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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    
    
    
}
