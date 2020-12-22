package com.tickettaca.domains.book.presantation;

import com.tickettaca.domains.book.application.BookRegisterService;
import com.tickettaca.domains.book.application.dto.BookRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookRegisterController {
  private final BookRegisterService bookRegisterService;

  @PostMapping("/book/{userToken}")
  public ResponseEntity bookRegister(@PathVariable String userToken, @RequestBody BookRegisterRequest bookRegisterRequest) {
    return ResponseEntity.ok().body(bookRegisterService.bookRegister(userToken,bookRegisterRequest));
  }
}
