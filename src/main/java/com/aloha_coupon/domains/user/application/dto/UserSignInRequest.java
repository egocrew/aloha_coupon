package com.aloha_coupon.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserSignInRequest {
  private String token;
  private String pushToken;
}
