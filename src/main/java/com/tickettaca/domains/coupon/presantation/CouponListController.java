package com.tickettaca.domains.coupon.presantation;

import com.tickettaca.domains.coupon.application.CouponListService;
import com.tickettaca.domains.coupon.application.dto.CouponHistoryResponse;
import com.tickettaca.domains.coupon.application.dto.CouponListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponListController {

  private final CouponListService couponListService;

  // 쿠폰 리스트
  @GetMapping("/coupon/{token}")
  public List<CouponListResponse> couponList(@PathVariable String token) {
    return couponListService.couponList(token);
  }
  // 쿠폰 사용내역
  @GetMapping("/coupon/{token}/history")
  public List<CouponHistoryResponse> couponHistory(@PathVariable String token) {
    return couponListService.couponHistory(token);
  }
}
