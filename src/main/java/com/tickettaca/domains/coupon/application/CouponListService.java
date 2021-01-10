package com.tickettaca.domains.coupon.application;

import com.tickettaca.commons.firebase.FCMService;
import com.tickettaca.domains.coupon.application.dto.CouponHistoryResponse;
import com.tickettaca.domains.coupon.application.dto.CouponListResponse;
import com.tickettaca.domains.coupon.domain.CouponSupportRepository;
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
