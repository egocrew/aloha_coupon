package com.tickettaca.domains.book.presantation;

import com.tickettaca.domains.book.application.BookDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookDeleteController {

  private final BookDeleteService bookDeleteService;

  @DeleteMapping("/{token}/book/{bookId}")
  public void deleteBook(@PathVariable String token, @PathVariable Long bookId) {

    bookDeleteService.deleteBook(token, bookId);
  }
}
