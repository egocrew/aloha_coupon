package com.tickettaca.domains.coupon.application.dto;

import com.tickettaca.domains.coupon.domain.CouponStatus;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CouponRegisterRequest {

    private LocalDate issueDate;
    private LocalDate expirationDate;
    private int count;
    private CouponStatus status;
    private Long bookId;
}
