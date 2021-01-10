package com.tickettaca.domains.user.application.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserInfoRequest {
    private String name;
    private LocalDate birthDay;
    private LocalDate startDate;
    private String profileImg;
}
