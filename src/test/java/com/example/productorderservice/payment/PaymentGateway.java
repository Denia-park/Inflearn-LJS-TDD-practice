package com.example.productorderservice.payment;

interface PaymentGateway {
    void execute(int price, String cardNumber);
}
