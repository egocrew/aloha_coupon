package com.tickettaca.domains.book.application;

import com.tickettaca.domains.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookDeleteService {

  private final BookRepository bookRepository;

  @Transactional
  public void deleteBook(String userToken, Long bookId) {
    bookRepository.deleteBookEntityByIdAndUserToken(bookId, userToken);
  }
}
