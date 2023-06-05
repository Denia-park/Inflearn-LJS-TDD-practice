package com.example.productorderservice.product;

import org.springframework.util.Assert;

class Product {

    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;
    private Long id;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public Long getId() {
        return id;
    }

    public void assignId(final Long id) {
        this.id = id;
    }
}
