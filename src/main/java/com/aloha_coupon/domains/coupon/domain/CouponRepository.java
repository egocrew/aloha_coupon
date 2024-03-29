package com.aloha_coupon.domains.coupon.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
  List<CouponEntity> findAllByUserToken(String userToken);

  @Query("select c from CouponEntity c where c.userToken=:userToken and c.status=:status")
  List<CouponEntity> findHistory(String userToken, CouponStatus status);

  Optional<CouponEntity> findByIdAndUserEntity_Id(Long couponId, Long userIndex);

  void deleteCouponEntityByUserToken(String userToken);
}
