package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import com.example.productorderservice.order.OrderRepository;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    PaymentAdapter(final PaymentGateway paymentGateway, final PaymentRepository paymentRepository, final OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("order not found"));
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void pay(final int price, final String cardNumber) {
        paymentGateway.execute(price, cardNumber);
    }
}