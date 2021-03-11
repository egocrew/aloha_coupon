package com.aloha_coupon.domains.book.application;

import com.aloha_coupon.domains.book.application.dto.BookListResponse;
import com.aloha_coupon.domains.book.domain.BookRepository;
import com.aloha_coupon.domains.book.domain.BookSupportRepository;
import lombok.RequiredArgsConstructor;
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
