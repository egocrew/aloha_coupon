package com.aloha_coupon.domains.coupon.application;

import com.aloha_coupon.domains.coupon.application.dto.CouponHistoryResponse;
import com.aloha_coupon.domains.coupon.application.dto.CouponListResponse;
import com.aloha_coupon.domains.coupon.domain.CouponSupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponListService {

  private final CouponSupportRepository couponSupportRepository;

  public List<CouponListResponse> couponList(String userToken) {
    return couponSupportRepository.list(userToken);
  }

  public List<CouponHistoryResponse> couponHistory(String userToken) {
    return couponSupportRepository.history(userToken);
  }
}
