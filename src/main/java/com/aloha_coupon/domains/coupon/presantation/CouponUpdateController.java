package com.aloha_coupon.domains.coupon.presantation;

import com.aloha_coupon.domains.coupon.application.CouponUpdateService;
import com.aloha_coupon.domains.coupon.application.dto.CouponUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CouponUpdateController {

  private final CouponUpdateService couponUpdateService;

  // 쿠폰 사용
  @PutMapping("/coupon/{userId}")
  public ResponseEntity updateCoupon(
      @PathVariable Long userId, @RequestBody CouponUpdateRequest couponUpdateRequest)
      throws IOException {
    couponUpdateService.updateCoupon(userId, couponUpdateRequest);
    return ResponseEntity.ok().build();
  }
}
