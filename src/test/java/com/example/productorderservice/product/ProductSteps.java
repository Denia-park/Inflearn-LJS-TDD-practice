package com.example.productorderservice.product;

import com.example.productorderservice.order.application.service.CreateOrderRequest;
import com.example.productorderservice.product.application.service.AddProductRequest;
import com.example.productorderservice.product.application.service.UpdateProductRequest;
import com.example.productorderservice.product.domian.DiscountPolicy;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class ProductSteps {
    public static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

    public static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    public static ExtractableResponse<Response> 상품조회요청(final Long productId) {
        return RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then().log().all()
                .extract();
    }

    public static UpdateProductRequest 상품수정요청_생성() {
        return new UpdateProductRequest("상품수정", 2000, DiscountPolicy.NONE);
    }

    static ExtractableResponse<Response> 상품수정요청(final Long productId) {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(상품수정요청_생성())
                .when()
                .patch("/products/{productId}", productId)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 상품주문요청(final CreateOrderRequest request) {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/orders")
                .then().log().all()
                .extract();
    }

    public static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}
