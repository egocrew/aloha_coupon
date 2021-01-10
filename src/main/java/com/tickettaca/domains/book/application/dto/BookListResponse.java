package com.tickettaca.domains.book.application.dto;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class BookListResponse {
   private String name;
   private String desc;
   private Long seq;
}
