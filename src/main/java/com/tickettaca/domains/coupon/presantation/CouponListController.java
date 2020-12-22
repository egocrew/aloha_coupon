package com.tickettaca.domains.coupon.presantation;

import com.tickettaca.domains.coupon.application.CouponListService;
import com.tickettaca.domains.coupon.application.dto.CouponHistoryResponse;
import com.tickettaca.domains.coupon.application.dto.CouponListResponse;
import com.tickettaca.domains.coupon.domain.CouponRepository;
import com.tickettaca.domains.coupon.domain.CouponStatus;
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
  @GetMapping("/coupon/{userToken}")
  public List<CouponListResponse> couponList(@PathVariable String userToken) {
    return couponListService.couponList(userToken);
  }
  // 쿠폰 사용내역
  @GetMapping("/coupon/{userToken}/history/{couponStatus}")
  public List<CouponHistoryResponse> couponHistory(
      @PathVariable String userToken, @PathVariable CouponStatus couponStatus) {
    return couponListService.couponHistory(userToken,couponStatus);
  }
}
