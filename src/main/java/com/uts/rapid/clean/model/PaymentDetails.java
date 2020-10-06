/*
 * THIS IS FOR RELEASE 2
 */
package com.uts.rapid.clean.model;

/**
 *
 * @author Bryan Guntoro
 */
public class PaymentDetails {
    
    private String _id;
    private int cardNumber;
    private String expiryDate;
    private int cvc;
    private String cardholderName;
    private String customer_id;

    public PaymentDetails(String _id, int cardNumber, String expiryDate,
            int cvc, String cardholderName, String customer_id) {
        this._id = _id;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
        this.cardholderName = cardholderName;
        this.customer_id = customer_id;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
