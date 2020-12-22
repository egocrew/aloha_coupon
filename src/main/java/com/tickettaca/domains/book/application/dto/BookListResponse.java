package com.tickettaca.domains.book.application.dto;


import com.tickettaca.domains.book.domain.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BookListResponse {
   private String name;
   private String desc;
   private Long seq;

}
