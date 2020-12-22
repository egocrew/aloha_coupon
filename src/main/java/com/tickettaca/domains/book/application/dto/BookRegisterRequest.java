package com.tickettaca.domains.book.application.dto;

import lombok.Getter;

@Getter
public class BookRegisterRequest {
    private String name;
    private String contents;
    private Long userId;
}
