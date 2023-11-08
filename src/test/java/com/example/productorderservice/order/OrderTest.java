package com.example.productorderservice.order;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.product.domian.DiscountPolicy;
import com.example.productorderservice.product.domian.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품1", 1000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        final int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(2000);
    }
}
