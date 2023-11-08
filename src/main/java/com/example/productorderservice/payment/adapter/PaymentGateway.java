package com.example.productorderservice.payment.adapter;

interface PaymentGateway {
    void execute(int price, String cardNumber);
}
