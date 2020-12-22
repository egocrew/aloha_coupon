package com.tickettaca.domains.book.presantation;

import com.tickettaca.domains.book.application.BookListService;
import com.tickettaca.domains.book.application.dto.BookListResponse;
import com.tickettaca.domains.book.domain.BookEntity;
import com.tickettaca.domains.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookListController {

    private final BookListService bookListService;

    @GetMapping("/book/{userToken}")
    public ResponseEntity<List<BookListResponse>> bookList(@PathVariable String userToken){
        return ResponseEntity.ok().body(bookListService.bookList(userToken));
    }
}
