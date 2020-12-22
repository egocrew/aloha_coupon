package com.tickettaca.domains.coupon.application;

import com.tickettaca.domains.coupon.application.dto.CouponHistoryResponse;
import com.tickettaca.domains.coupon.application.dto.CouponListResponse;
import com.tickettaca.domains.coupon.domain.CouponEntity;
import com.tickettaca.domains.coupon.domain.CouponRepository;
import com.tickettaca.domains.coupon.domain.CouponStatus;
import com.tickettaca.domains.coupon.domain.CouponSupportRepository;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponListService {

  private final CouponRepository couponRepository;
  private final CouponSupportRepository couponSupportRepository;

  public List<CouponListResponse> couponList(String userToken) {
//    List<CouponEntity> couponEntityList =
//        couponRepository.findAllByUserToken(userToken);

    return couponSupportRepository.list(userToken);
  }

  public List<CouponHistoryResponse> couponHistory(String userToken, CouponStatus status){
//    List<CouponEntity> couponEntityList =
//            couponRepository.findHistory(userToken,status);
    return couponSupportRepository.history(status,userToken);

  }
}
