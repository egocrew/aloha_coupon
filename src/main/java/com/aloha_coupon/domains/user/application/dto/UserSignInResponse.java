package com.aloha_coupon.domains.user.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserSignInResponse {
    private Long seq;
}
