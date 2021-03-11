package com.aloha_coupon.domains.book.presantation;

import com.aloha_coupon.domains.book.application.BookRegisterService;
import com.aloha_coupon.domains.book.application.dto.BookRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookRegisterController {
  private final BookRegisterService bookRegisterService;

  @PostMapping("/book/{token}")
  public ResponseEntity bookRegister(
      @PathVariable String token, @RequestBody BookRegisterRequest bookRegisterRequest) {
    bookRegisterService.bookRegister(token, bookRegisterRequest);
    return ResponseEntity.ok().build();
  }
}
