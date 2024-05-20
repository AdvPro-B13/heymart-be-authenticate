package com.heymart.authenticate.service;

import com.heymart.authenticate.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface CustomerService {
    public void addCoupon(String couponId);
    public void removeCouponFromAll(String couponId);
    public void removeCoupon(String couponId, String username);
}
