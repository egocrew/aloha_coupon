package com.tickettaca.domains.coupon.application.dto;

import com.tickettaca.domains.coupon.domain.CouponStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Getter
public class CouponHistoryResponse {
  private CouponStatus state;
  private String issueDate;
  private String deadLine;
  private String desc;
  private String name;
  private Long ownSeq;
  private Long seq;
  private String deadDay;
  private String dday;

  public CouponHistoryResponse(
      CouponStatus state,
      LocalDate issueDate,
      LocalDate deadLine,
      String desc,
      String name,
      Long ownSeq,
      Long seq) {
    this.issueDate = convertDate(issueDate);
    this.state = state;
    this.deadLine = convertDate(deadLine);
    this.desc = desc;
    this.name = name;
    this.ownSeq = ownSeq;
    this.seq = seq;
    this.deadDay = convertDate(LocalDate.now());
    this.dday = String.valueOf(ChronoUnit.DAYS.between(issueDate, LocalDate.now()));
  }

  public String convertDate(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    return date.format(formatter);
  }
}
