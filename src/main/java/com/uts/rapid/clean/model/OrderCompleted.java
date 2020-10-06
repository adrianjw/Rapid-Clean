package com.uts.rapid.clean.model;

import java.util.Date;

public class OrderCompleted {

    private String _id;
    private String order_id;
    private Date startTime;
    private Date endTime;
    private double workedHours;
    private String cleaner_id;

    public OrderCompleted(String _id, String order_id, Date startTime,
            Date endTime, double workedHours, String cleaner_id) {
        this._id = _id;
        this.order_id = order_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workedHours = workedHours;
        this.cleaner_id = cleaner_id;
    }

    public String getCleaner_id() {
        return cleaner_id;
    }

    public void setCleaner_id(String cleaner_id) {
        this.cleaner_id = cleaner_id;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }
}
