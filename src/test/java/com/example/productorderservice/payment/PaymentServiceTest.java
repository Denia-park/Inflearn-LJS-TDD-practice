package com.example.productorderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        final PaymentGateway paymentGateway = new ConsolePaymentGateway();
        final PaymentRepository paymentRepository = new PaymentRepository();
        final PaymentPort paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품결제() {
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }
}
