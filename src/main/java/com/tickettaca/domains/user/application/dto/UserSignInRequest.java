package com.tickettaca.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserSignInRequest {
    private String socialToken;
    private String name;
}
