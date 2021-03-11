package com.aloha_coupon.domains.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoverResponse {
  private Long partnerSeq;
  private String partnerName;
}
