package com.aloha_coupon.domains.user.presantation;

import com.aloha_coupon.domains.user.application.CoupleListService;
import com.aloha_coupon.domains.user.application.dto.CoupleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserListController {

  private final CoupleListService coupleListService;

  @GetMapping("/user/{token}")
  public ResponseEntity<CoupleResponse> userInfo(@PathVariable String token) {
    return ResponseEntity.ok().body(coupleListService.userInfo(token));
  }
}
