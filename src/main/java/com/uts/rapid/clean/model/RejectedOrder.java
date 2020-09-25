/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model;


public class RejectedOrder {
    private String _id;
    private String orderId;
    private String cleanerId;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId;
    }

    public RejectedOrder(String _id, String orderId, String cleanerId) {
        this._id = _id;
        this.orderId = orderId;
        this.cleanerId = cleanerId;
    }
}
