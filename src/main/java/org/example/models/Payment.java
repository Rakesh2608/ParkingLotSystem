package org.example.models;

import org.example.models.enums.PaymentMode;

public class Payment extends BaseModel{
    private PaymentMode paymentMode;
    private Bill bill;
    private PaymentMode paymentStatus;
    private int amount;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentMode getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentMode paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
