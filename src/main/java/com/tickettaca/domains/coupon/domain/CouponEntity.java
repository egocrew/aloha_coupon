package com.tickettaca.domains.coupon.domain;

import com.tickettaca.domains.BaseTimeEntity;
import com.tickettaca.domains.book.domain.BookEntity;
import com.tickettaca.domains.user.domain.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "coupon")
@Builder
@AllArgsConstructor
public class CouponEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "userId")
  private UserEntity userEntity;

  @ManyToOne
  @JoinColumn(name = "bookId")
  private BookEntity bookEntity;

  private String userToken;

  private LocalDate issueDate;
  private LocalDate expirationDate;
  private LocalDate useDate;

  @Enumerated(value = EnumType.STRING)
  private CouponStatus status;

  @Builder
  public CouponEntity(
      UserEntity userEntity,
      BookEntity bookEntity,
      String userToken,
      LocalDate issueDate,
      LocalDate expirationDate,
      CouponStatus status) {
    this.userEntity = userEntity;
    this.bookEntity = bookEntity;
    this.userToken = userToken;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
    this.status = status;
  }

  public void update(CouponStatus status) {
    this.useDate = LocalDate.now();
    this.status = status;
  }
}
