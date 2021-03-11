package com.aloha_coupon.domains.coupon.domain;

public enum CouponStatus {
    BEFORE_USE("BEFOREUSER"),
    AFTER_USE("AFTERUSE");
    String status;

    CouponStatus(String status) {
        this.status = status;
    }
}
