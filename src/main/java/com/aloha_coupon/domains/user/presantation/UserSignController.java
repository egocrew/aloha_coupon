package com.aloha_coupon.domains.user.presantation;

import com.aloha_coupon.domains.user.application.UserSignInService;
import com.aloha_coupon.domains.user.application.dto.CoupleResponse;
import com.aloha_coupon.domains.user.application.dto.UserSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserSignController {

  private final UserSignInService userSignInService;

  @PostMapping("/user/signIn")
  public ResponseEntity<CoupleResponse> signIn(
      @RequestBody UserSignInRequest userSignInRequest) {
    System.out.println("SocialToken is : " + userSignInRequest.getToken());
    return ResponseEntity.ok().body(userSignInService.signIn(userSignInRequest));
  }
}
