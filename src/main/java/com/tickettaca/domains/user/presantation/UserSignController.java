package com.tickettaca.domains.user.presantation;

import com.tickettaca.domains.user.application.UserSignInService;
import com.tickettaca.domains.user.application.dto.UserSignInRequest;
import com.tickettaca.domains.user.application.dto.UserSignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserSignController {

  private final UserSignInService userSignInService;

  @PostMapping
  public ResponseEntity<UserSignInResponse> signIn(UserSignInRequest userSignInRequest) {
    return ResponseEntity.ok()
        .body(
            userSignInService.signIn(
                userSignInRequest.getSocialToken(), userSignInRequest.getName()));
  }
}
