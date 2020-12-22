package com.tickettaca.domains.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

    List<BookEntity> findAllByUserToken(String userToken);
}
