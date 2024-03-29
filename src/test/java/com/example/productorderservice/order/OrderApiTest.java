package com.example.productorderservice.order;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.order.application.service.OrderService;
import com.example.productorderservice.product.ProductSteps;
import com.example.productorderservice.product.application.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class OrderApiTest extends ApiTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final var request = OrderSteps.상품주문요청_생성();

        final var response = OrderSteps.상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
