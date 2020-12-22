package com.tickettaca.domains.coupon.domain;

public enum CouponStatus {
    BEFORE_USE("BEFOREUSER"),
    AFTER_USE("AFTERUSE");
    String status;

    CouponStatus(String status) {
        this.status = status;
    }
}
