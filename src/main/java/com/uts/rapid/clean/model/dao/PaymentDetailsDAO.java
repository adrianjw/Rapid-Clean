package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.uts.rapid.clean.model.PaymentDetail;
import java.io.Serializable;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

public class PaymentDetailsDAO implements Serializable {

    private MongoCollection<Document> customerCollection;
    private MongoCollection<Document> paymentDetailCollection;

    // Build a connection with MongoDB Atlas
    public PaymentDetailsDAO(MongoDatabase database) {
        customerCollection = database.getCollection("Customer");
        paymentDetailCollection = database.getCollection("PaymentDetail");

    }

    // Create a Payment Detail
    public void createPaymentDetail(String customer_id, String cardNumber, String expiryDate, int cvc, String cardholderName) {
        Document document = new Document("customer_id", customer_id)
                .append("cardNumber", cardNumber)
                .append("expiryDate", expiryDate)
                .append("cvc", cvc)
                .append("cardholderName", cardholderName);
        paymentDetailCollection.insertOne(document);
    }

    // View all Payment Details
    public ArrayList<PaymentDetail> paymentList(String customer_id) {

        ArrayList<PaymentDetail> table = new ArrayList();
        ArrayList<Document> paymentDetailList = paymentDetailCollection.find(eq("customer_id", customer_id)).into(new ArrayList<>());

        for (Document paymentDets : paymentDetailList) {
            ObjectId objId = (ObjectId) paymentDets.get("_id");
            String paymentDetId = objId.toString();
            PaymentDetail paymentD = new PaymentDetail(paymentDetId, (String) paymentDets.get("customer_id"), (String) paymentDets.get("cardNumber"), (String) paymentDets.get("expiryDate"), (int) paymentDets.get("cvc"), (String) paymentDets.get("cardholderName"));
            table.add(paymentD);
        }

        if (!table.isEmpty()) {
            return table;
        } else {
            return null;
        }
    }

    // Delete Payment Detail
    public void deletePaymentDetail(String paymentDetail_id) {
        ObjectId _id = new ObjectId(paymentDetail_id);
        paymentDetailCollection.deleteOne(eq("_id", _id));
    }
    

}
