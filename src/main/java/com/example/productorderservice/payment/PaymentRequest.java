package com.example.productorderservice.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "orderId must not be null");
        Assert.hasText(cardNumber, "cardNumber must not be null");
    }
}
