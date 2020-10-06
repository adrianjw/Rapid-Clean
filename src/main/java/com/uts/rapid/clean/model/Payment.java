/*
 * This is for RELEASE 2
 */
package com.uts.rapid.clean.model;

/**
 *
 * @author Bryan Guntoro
 */
public class Payment {
    
    private String _id;
    private String orderCompleted_id;

    public Payment(String _id, String orderCompleted_id) {
        this._id = _id;
        this.orderCompleted_id = orderCompleted_id;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getOrderCompleted_id() {
        return orderCompleted_id;
    }

    public void setOrderCompleted_id(String orderCompleted_id) {
        this.orderCompleted_id = orderCompleted_id;
    }
}
