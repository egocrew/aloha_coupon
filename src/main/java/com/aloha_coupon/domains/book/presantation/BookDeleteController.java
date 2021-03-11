package com.aloha_coupon.domains.book.presantation;

import com.aloha_coupon.domains.book.application.BookDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookDeleteController {

  private final BookDeleteService bookDeleteService;

  @PutMapping("/{token}/book/{bookId}")
  public void deleteBook(@PathVariable String token, @PathVariable Long bookId) {

    bookDeleteService.updateBook(token, bookId);
  }
}
