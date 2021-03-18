package com.aloha_coupon.domains.user.application;

import com.aloha_coupon.domains.book.domain.BookRepository;
import com.aloha_coupon.domains.coupon.domain.CouponRepository;
import com.aloha_coupon.domains.user.domain.UserEntity;
import com.aloha_coupon.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserDeleteService {
  private final UserRepository userRepository;
  private final CouponRepository couponRepository;
  private final BookRepository bookRepository;

  @Transactional
  public ResponseEntity delete(Long userIndex) {
    UserEntity userEntity =
        userRepository
            .findById(userIndex)
            .orElseThrow(() -> new IllegalArgumentException("Invalid UserIndex"));

    UserEntity loverEntity = userRepository.findByLover(userEntity.getUserToken(), userIndex);

    couponRepository.deleteCouponEntityByUserToken(userEntity.getUserToken());
    bookRepository.deleteBookEntityByUserToken(userEntity.getUserToken());

    userRepository.delete(userEntity);

    if (loverEntity != null) {
      userRepository.delete(loverEntity);
    }
    return ResponseEntity.ok().build();
  }
}
