package com.aloha_coupon.domains.book.application;

import com.aloha_coupon.domains.book.application.dto.BookRegisterRequest;
import com.aloha_coupon.domains.book.domain.BookEntity;
import com.aloha_coupon.domains.book.domain.BookRepository;
import com.aloha_coupon.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookRegisterService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;

  public ResponseEntity bookRegister(String userToken, BookRegisterRequest bookRegisterRequest) {

    bookRepository.save(
        BookEntity.builder()
            .userToken(userToken)
            .contents(bookRegisterRequest.getDesc())
            .name(bookRegisterRequest.getName())
            .build());

    return ResponseEntity.ok().build();
  }
}
