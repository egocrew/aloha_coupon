package com.aloha_coupon.domains.book.application;

import com.aloha_coupon.domains.book.domain.BookEntity;
import com.aloha_coupon.domains.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookDeleteService {

  private final BookRepository bookRepository;

  @Transactional
  public ResponseEntity updateBook(String userToken, Long bookId) {
    BookEntity bookEntity =
        bookRepository
            .findByIdAndUserToken(bookId, userToken)
            .orElseThrow(() -> new IllegalArgumentException("Invalid BookIndex OR UserToken"));
    bookEntity.updateStatus(false);
    return ResponseEntity.ok().build();
  }
}
