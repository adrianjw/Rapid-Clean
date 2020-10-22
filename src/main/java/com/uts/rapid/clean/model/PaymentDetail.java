/*
 * THIS IS FOR RELEASE 2
 */
package com.uts.rapid.clean.model;

import java.io.Serializable;

/**
 *
 * @author Bryan Guntoro
 */
public class PaymentDetail implements Serializable {

    private String _id;
    private String cardNumber;
    private String expiryDate;
    private int cvc;
    private String cardholderName;
    private String customer_id;

    public PaymentDetail(String _id, String customer_id, String cardNumber, String expiryDate,
            int cvc, String cardholderName) {
        this._id = _id;
        this.customer_id = customer_id;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
        this.cardholderName = cardholderName;
        
    }

    public static void main(String[] Args) {
        //PaymentDetail paymentDets = new PaymentDetail("1", "5218009488121234", "12/12", 122, "Bryan Guntoro", "12");
        //paymentDets.getLastFourDigits();
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
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

    public String getLastFourDigits() {
        String ssn = String.valueOf(cardNumber);
        int ssnLength = ssn.length();
        if (ssnLength > 4) {
            ssn = ssn.substring(ssnLength - 4);
            //System.out.println("ssn is: "+ssn);
        } else {
            //System.out.println("ssn is: "+cardNumber);
        }
        return ssn;
    }
}
