package com.tickettaca.domains.book.presantation;

import com.tickettaca.domains.book.application.BookListService;
import com.tickettaca.domains.book.application.dto.BookListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookListController {

  private final BookListService bookListService;

  @GetMapping("/book/{token}")
  public ResponseEntity<List<BookListResponse>> bookList(@PathVariable String token) {
    return ResponseEntity.ok().body(bookListService.bookList(token));
  }
}
