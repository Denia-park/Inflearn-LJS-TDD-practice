package com.example.productorderservice.product;

class ProductAdapter implements ProductPort {
    final private ProductRepository productRepository;

    ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }
}
