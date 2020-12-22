package com.tickettaca.domains.user.application.dto;


import com.tickettaca.domains.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResponse {
   private Long seq;
   private String name;
   private String token;
}
