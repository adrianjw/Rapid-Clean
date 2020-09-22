/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model;

import java.security.Timestamp;

public class OrderCompleted {

    private String _id;
    private String order_id;
    private Timestamp startTime;
    private Timestamp endTime;
    private double workedHours;

    public OrderCompleted(String _id, String order_id, Timestamp startTime, Timestamp endTime, double workedHours) {
        this._id = _id;
        this.order_id = order_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workedHours = workedHours;
    }

    public String getId() {
        return _id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

}
