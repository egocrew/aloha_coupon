package com.tickettaca.domains.user.presantation;

import com.tickettaca.domains.user.application.CoupleListService;
import com.tickettaca.domains.user.application.dto.UserListResponse;
import com.tickettaca.domains.user.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserListController {

  private final CoupleListService coupleListService;

  @GetMapping("/user/{userToken}")
  public ResponseEntity<List<UserListResponse>> userInfo(@PathVariable String userToken) {
    return ResponseEntity.ok().body(coupleListService.userInfo(userToken));
  }
}
