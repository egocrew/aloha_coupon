package com.aloha_coupon.domains.book.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.aloha_coupon.domains.book.application.dto.BookListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookSupportRepository {
  private final JPAQueryFactory queryFactory;
  private QBookEntity bookEntity = QBookEntity.bookEntity;

  public List<BookListResponse> list(String userToken) {
    return queryFactory
        .select(
            Projections.constructor(
                BookListResponse.class,
                bookEntity.name,
                bookEntity.contents.as("desc"),
                bookEntity.id.as("seq")))
            .from(bookEntity)
        .where(bookEntity.userToken.eq(userToken).and(bookEntity.status.eq(true)))
        .fetch();
  }
}
