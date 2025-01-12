package com.example.training.myApp4.api;


import com.example.training.myApp4.request.CounponDiscountRequest;
import com.example.training.myApp4.response.CouponDiscountResponse;
import com.example.training.myApp4.service.CouponServiceGrpc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon-service")
public class CouponAPI {

    private final CouponServiceGrpc couponServiceGrpc;

    public CouponAPI(CouponServiceGrpc couponServiceGrpc) {
        this.couponServiceGrpc = couponServiceGrpc;
    }

    @PostMapping("/coupon-discount")
    public ResponseEntity<CouponDiscountResponse> getCouponDiscount(@RequestBody CounponDiscountRequest request) {
        CouponDiscountResponse couponDiscount = couponServiceGrpc.getCouponDiscount(request.getCouponCode(), request.getOriginalPrice());
        return new ResponseEntity<>(couponDiscount, HttpStatus.OK);
    }
}
