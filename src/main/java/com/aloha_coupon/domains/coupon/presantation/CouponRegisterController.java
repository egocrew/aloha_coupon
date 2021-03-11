package com.aloha_coupon.domains.coupon.presantation;

import com.aloha_coupon.domains.coupon.application.CouponRegisterService;
import com.aloha_coupon.domains.coupon.application.dto.CouponRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class CouponRegisterController {

  private final CouponRegisterService couponRegisterService;

  // 쿠폰 발급
  @PostMapping("/coupon/add/{userId}")
  public ResponseEntity register(
      @PathVariable Long userId, @RequestBody CouponRegisterRequest couponRegisterRequest)
      throws ExecutionException, InterruptedException, IOException {
    couponRegisterService.register(userId, couponRegisterRequest);
    return ResponseEntity.ok().build();
  }
}
