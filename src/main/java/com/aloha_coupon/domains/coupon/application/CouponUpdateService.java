package com.aloha_coupon.domains.coupon.application;

import com.aloha_coupon.commons.firebase.FCMService;
import com.aloha_coupon.domains.coupon.application.dto.CouponUpdateRequest;
import com.aloha_coupon.domains.coupon.domain.CouponEntity;
import com.aloha_coupon.domains.coupon.domain.CouponRepository;
import com.aloha_coupon.domains.coupon.domain.CouponStatus;
import com.aloha_coupon.domains.user.domain.UserEntity;
import com.aloha_coupon.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CouponUpdateService {
  private final CouponRepository couponRepository;
  private final UserRepository userRepository;
  private final FCMService fcmService;

  @Transactional
  public ResponseEntity updateCoupon(Long userId, CouponUpdateRequest couponUpdateRequest)
      throws IOException {
    CouponEntity couponEntity =
        couponRepository
            .findByIdAndUserEntity_Id(couponUpdateRequest.getCouponId(), userId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid userIndex"));
    UserEntity lover = userRepository.findByLover(couponEntity.getUserToken(), userId);
    UserEntity user =
        userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(""));

    couponEntity.update(CouponStatus.AFTER_USE);
    fcmService.sendMessageTo(
        lover.getPushToken(),
        user.getName() + "이(가) 쿠폰을 사용하셨습니다. \uD83D\uDE03",
        couponEntity.getBookEntity().getName());

    return ResponseEntity.ok().build();
  }
}
