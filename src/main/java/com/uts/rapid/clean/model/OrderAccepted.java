package com.uts.rapid.clean.model;

import org.bson.types.ObjectId;

public class OrderAccepted {
    private String _id;
    private ObjectId cleaner_id;
    private ObjectId order_id;

    public OrderAccepted(String _id, ObjectId cleaner_id, ObjectId order_id) {
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

    public ObjectId getCleaner_id() {
        return cleaner_id;
    }

    public void setCleaner_id(ObjectId cleaner_id) {
        this.cleaner_id = cleaner_id;
    }

    public ObjectId getOrder_id() {
        return order_id;
    }

    public void setOrder_id(ObjectId order_id) {
        this.order_id = order_id;
    }

   
    
    
    
}
