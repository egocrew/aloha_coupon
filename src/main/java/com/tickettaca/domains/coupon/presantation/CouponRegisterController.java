package com.tickettaca.domains.coupon.presantation;

import com.tickettaca.domains.coupon.application.CouponRegisterService;
import com.tickettaca.domains.coupon.application.dto.CouponRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CouponRegisterController {

  private final CouponRegisterService couponRegisterService;

  // 쿠폰 발급
  @PostMapping("/coupon/add/{userIndex}")
  public ResponseEntity register(
      @PathVariable Long userIndex, @RequestBody CouponRegisterRequest couponRegisterRequest) {
    couponRegisterService.register(userIndex, couponRegisterRequest);
    return ResponseEntity.ok().build();
  }
}
