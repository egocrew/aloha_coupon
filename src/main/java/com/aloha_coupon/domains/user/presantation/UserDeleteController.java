package com.aloha_coupon.domains.user.presantation;

import com.aloha_coupon.domains.user.application.UserDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserDeleteController {
  private final UserDeleteService userDeleteService;

  @RequestMapping("/user/{userIndex}/account")
  public ResponseEntity deleteUser(@PathVariable Long userIndex) {
    return userDeleteService.delete(userIndex);
  }
}
