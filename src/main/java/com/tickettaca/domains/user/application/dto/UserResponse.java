package com.tickettaca.domains.user.application.dto;


import lombok.*;


@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
   private Long seq;
   private String name;
   private String token;
}
