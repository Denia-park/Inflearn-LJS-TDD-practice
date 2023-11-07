package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;

interface OrderPort {
    void save(final Order order);

    Product getProductById(final Long productId);
}
