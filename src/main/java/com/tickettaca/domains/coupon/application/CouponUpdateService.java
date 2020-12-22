package com.tickettaca.domains.coupon.application;

import com.tickettaca.domains.book.domain.BookEntity;
import com.tickettaca.domains.book.domain.BookRepository;
import com.tickettaca.domains.coupon.application.dto.CouponUpdateRequest;
import com.tickettaca.domains.coupon.domain.CouponEntity;
import com.tickettaca.domains.coupon.domain.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CouponUpdateService {
  private final CouponRepository couponRepository;
  private final BookRepository bookRepository;

  @Transactional
  public ResponseEntity updateCoupon(Long userIndex, CouponUpdateRequest couponUpdateRequest) {
    CouponEntity couponEntity =
        couponRepository
            .findById(userIndex)
            .orElseThrow(() -> new IllegalArgumentException("Invalid userIndex"));

    couponEntity.update(
        couponUpdateRequest.getIssueDate(),
        couponUpdateRequest.getExpirationDate(),
        couponUpdateRequest.getCouponStatus());

    return ResponseEntity.ok().build();
  }
}
