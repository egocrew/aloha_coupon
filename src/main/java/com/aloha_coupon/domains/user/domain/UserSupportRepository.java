package com.aloha_coupon.domains.user.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.aloha_coupon.domains.user.application.dto.LoverResponse;
import com.aloha_coupon.domains.user.application.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserSupportRepository {
  private final JPAQueryFactory queryFactory;
  private QUserEntity userEntity = QUserEntity.userEntity;

  public UserResponse coupleList(String socialToken) {
    return queryFactory
        .select(
            Projections.constructor(
                UserResponse.class,
                userEntity.id.as("seq"),
                userEntity.name.coalesce("").as("name"),
                userEntity.userToken.as("token"),
                userEntity.premium))
        .from(userEntity)
        .where(userEntity.socialToken.eq(socialToken))
        .fetchOne();
  }

  public LoverResponse findLover(String userToken, String socialToken) {
    return queryFactory
        .select(
            Projections.constructor(
                LoverResponse.class,
                userEntity.id.as("partnerSeq"),
                userEntity.name.as("partnerName")))
        .from(userEntity)
        .where(
            userEntity
                .userToken
                .eq(userToken)
                .and(userEntity.socialToken.notEqualsIgnoreCase(socialToken)))
        .fetchOne();
  }
}
