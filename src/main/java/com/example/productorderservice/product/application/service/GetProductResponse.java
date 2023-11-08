package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.domian.DiscountPolicy;
import org.springframework.util.Assert;

record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    GetProductResponse {
        Assert.hasText(name, "상품명은 필수입니다");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다");

    }
}
