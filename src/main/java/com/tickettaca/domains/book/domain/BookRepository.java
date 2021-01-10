package com.tickettaca.domains.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

  void deleteBookEntityByIdAndUserToken(Long bookId, String userToken);
}
