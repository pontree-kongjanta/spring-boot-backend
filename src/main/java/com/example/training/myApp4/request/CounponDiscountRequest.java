package com.example.training.myApp4.request;

import lombok.Data;

@Data
public class CounponDiscountRequest {
    private String couponCode;
    private double originalPrice;

}
