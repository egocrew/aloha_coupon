package com.tickettaca.domains.user.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tickettaca.domains.user.application.dto.UserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserSupportRepository {
  private final JPAQueryFactory queryFactory;
  private QUserEntity userEntity = QUserEntity.userEntity;

  public List<UserListResponse> coupleList(String userToken) {
    return queryFactory
        .select(
            Projections.constructor(
                UserListResponse.class, userEntity.id.as("seq"), userEntity.name, userEntity.userToken.as("token")))
        .from(userEntity)
        .where(userEntity.userToken.eq(userToken))
        .fetch();
  }
}
