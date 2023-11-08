package com.example.productorderservice.product.application.port;

import com.example.productorderservice.product.domian.Product;

public interface ProductPort {
    void save(final Product product);

    Product getProduct(long productId);
}
