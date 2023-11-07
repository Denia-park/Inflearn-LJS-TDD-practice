package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.util.Assert;

class Payment {
    private final Order order;
    private final String cardNumber;
    private Long id;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "order must not be null");
        Assert.hasText(cardNumber, "cardNumber must not be null");

        this.order = order;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
