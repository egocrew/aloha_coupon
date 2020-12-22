package com.tickettaca.domains.book.application;

import com.tickettaca.domains.book.application.dto.BookRegisterRequest;
import com.tickettaca.domains.book.domain.BookEntity;
import com.tickettaca.domains.book.domain.BookRepository;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookRegisterService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;

  public ResponseEntity bookRegister(String userToken, BookRegisterRequest bookRegisterRequest) {

    UserEntity userEntity =
        userRepository
            .findById(bookRegisterRequest.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid userID"));

    return ResponseEntity.ok()
        .body(
            bookRepository.save(
                BookEntity.builder()
                    .userToken(userToken)
                    .contents(bookRegisterRequest.getContents())
                    .name(bookRegisterRequest.getName())
                    .userEntity(userEntity)
                    .build()));
  }
}
