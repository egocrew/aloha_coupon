package com.tickettaca.domains.book.application;

import com.tickettaca.domains.book.application.dto.BookListResponse;
import com.tickettaca.domains.book.domain.BookEntity;
import com.tickettaca.domains.book.domain.BookRepository;
import com.tickettaca.domains.book.domain.BookSupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookListService {
    private final BookRepository bookRepository;
    private final BookSupportRepository bookSupportRepository;

    public List<BookListResponse> bookList(String userToken){
//        List<BookEntity> bookEntityList = bookRepository.findAllByUserToken(userToken);
        return bookSupportRepository.list(userToken);

    }
}
