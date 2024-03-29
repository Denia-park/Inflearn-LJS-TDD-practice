package com.example.productorderservice.product.adapter;

import com.example.productorderservice.product.application.port.ProductPort;
import com.example.productorderservice.product.domian.Product;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {
    final private ProductRepository productRepository;

    ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(final long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
