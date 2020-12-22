package com.tickettaca.domains.coupon.application;

import com.tickettaca.domains.book.domain.BookEntity;
import com.tickettaca.domains.book.domain.BookRepository;
import com.tickettaca.domains.coupon.application.dto.CouponRegisterRequest;
import com.tickettaca.domains.coupon.domain.CouponEntity;
import com.tickettaca.domains.coupon.domain.CouponRepository;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponRegisterService {
  private final CouponRepository couponRepository;
  private final BookRepository bookRepository;
  private final UserRepository userRepository;


  // 쿠폰 발급
  public void register(Long userIndex,CouponRegisterRequest couponRegisterRequest) {

    UserEntity userEntity =
        userRepository
            .findById(userIndex)
            .orElseThrow(() -> new IllegalArgumentException("Invalid User Id"));

    BookEntity bookEntity =
        bookRepository
            .findById(couponRegisterRequest.getBookId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid Shop Id"));

    couponRepository.save(
        CouponEntity.builder()
            .issueDate(couponRegisterRequest.getIssueDate())
            .expirationDate(couponRegisterRequest.getExpirationDate())
            .status(couponRegisterRequest.getStatus())
            .bookEntity(bookEntity)
            .userEntity(userEntity)
            .build());
  }
}
