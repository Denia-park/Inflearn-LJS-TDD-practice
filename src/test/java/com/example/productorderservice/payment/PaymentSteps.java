package com.example.productorderservice.payment;

import com.example.productorderservice.payment.application.service.PaymentRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class PaymentSteps {
    public static PaymentRequest 주문결제요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }

    static ExtractableResponse<Response> 주문결제요청(final PaymentRequest request) {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/payments")
                .then().log().all()
                .extract();
    }
}
