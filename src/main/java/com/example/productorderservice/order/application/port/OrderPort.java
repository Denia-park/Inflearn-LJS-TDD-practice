package com.example.productorderservice.order.application.port;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.product.domian.Product;

public interface OrderPort {
    void save(final Order order);

    Product getProductById(final Long productId);
}
