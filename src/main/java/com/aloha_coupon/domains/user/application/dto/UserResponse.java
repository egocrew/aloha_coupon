package com.aloha_coupon.domains.user.application.dto;


import com.aloha_coupon.domains.user.domain.PremiumType;
import lombok.*;


@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
   private Long seq;
   private String name;
   private String token;
   private PremiumType premiumType;
}
