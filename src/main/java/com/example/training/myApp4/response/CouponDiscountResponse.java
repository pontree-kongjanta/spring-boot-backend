package com.example.training.myApp4.response;

import lombok.Data;

@Data
public class CouponDiscountResponse {
    private String couponCode;
    private double totalPrice;
    private String status;
}
