package com.aloha_coupon.domains.book.application.dto;

import lombok.Getter;

@Getter
public class BookRegisterRequest {
  private String name;
  private String desc;
  private Long seq;
}
