package com.aloha_coupon.domains.coupon.application;

import com.aloha_coupon.commons.firebase.FCMService;
import com.aloha_coupon.domains.book.domain.BookEntity;
import com.aloha_coupon.domains.book.domain.BookRepository;
import com.aloha_coupon.domains.coupon.application.dto.CouponRegisterRequest;
import com.aloha_coupon.domains.coupon.domain.CouponEntity;
import com.aloha_coupon.domains.coupon.domain.CouponRepository;
import com.aloha_coupon.domains.coupon.domain.CouponStatus;
import com.aloha_coupon.domains.user.domain.UserEntity;
import com.aloha_coupon.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class CouponRegisterService {
  private final CouponRepository couponRepository;
  private final BookRepository bookRepository;
  private final UserRepository userRepository;
  private final FCMService fcmService;

  // 쿠폰 발급
  public void register(Long userIndex, CouponRegisterRequest couponRegisterRequest)
      throws ExecutionException, InterruptedException, IOException {

    UserEntity userEntity =
        userRepository
            .findById(userIndex)
            .orElseThrow(() -> new IllegalArgumentException("Invalid User Id"));

    UserEntity loverEntity = userRepository.findByLover(userEntity.getUserToken(), userIndex);
    BookEntity bookEntity =
        bookRepository
            .findById(couponRegisterRequest.getBookId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid Shop Id"));

    couponRepository.save(
        CouponEntity.builder()
            .issueDate(LocalDate.now())
            .expirationDate(expirationDate())
            .status(CouponStatus.BEFORE_USE)
            .bookEntity(bookEntity)
            .userToken(userEntity.getUserToken())
            .userEntity(loverEntity) // own seq
            .build());

    fcmService.sendMessageTo(
        loverEntity.getPushToken(),
        userEntity.getName() + "이(가) 보내신 쿠폰이 도착했습니다 \uD83D\uDE0D",
        bookEntity.getName());
  }

  public LocalDate expirationDate() {
    LocalDate nowDate = LocalDate.now();
    LocalDate expiration = nowDate.plusMonths(1);
    return expiration;
  }
}
