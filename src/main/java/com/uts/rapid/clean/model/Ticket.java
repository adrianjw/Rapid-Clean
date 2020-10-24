package com.uts.rapid.clean.model;

import java.util.Date;

public class Ticket {
    private String id;
    private String customerId;
    private String priority;
    private String status;
    private String subject;
    private String department;
    private String comment;
    private Date date;

    public Ticket(String id, String customerId, String priority, String status, String subject, String department, String comment, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.priority = priority;
        this.status = status;
        this.subject = subject;
        this.department = department;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
