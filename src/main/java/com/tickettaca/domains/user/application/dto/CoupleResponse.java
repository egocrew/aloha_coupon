package com.tickettaca.domains.user.application.dto;

import com.tickettaca.domains.user.domain.PremiumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CoupleResponse {
  private Long seq;
  private String name;
  private String token;
  private Long partnerSeq;
  private String partnerName;
  private PremiumType premiumType;
}
