package com.example.training.myApp4.service;

import com.example.training.myApp4.response.CouponDiscountResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.example.GrpcCouponServiceGrpc;
import net.devh.boot.grpc.example.GrpcCouponServiceRequest;
import net.devh.boot.grpc.example.GrpcCouponServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceGrpc {
    public CouponDiscountResponse getCouponDiscount(String couponCode, double originalPrice) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        GrpcCouponServiceGrpc.GrpcCouponServiceBlockingStub blockingStub = GrpcCouponServiceGrpc.newBlockingStub(channel);

        GrpcCouponServiceRequest request = GrpcCouponServiceRequest.newBuilder()
                .setCouponCode(couponCode)
                .setOriginalPrice(originalPrice)
                .build();

        GrpcCouponServiceResponse result = blockingStub.couponDiscount(request);

        CouponDiscountResponse response = new CouponDiscountResponse();
        response.setCouponCode(result.getCouponCode());
        response.setTotalPrice(result.getTotalPrice());
        response.setStatus(result.getStatus());
        return response;
    }
}
