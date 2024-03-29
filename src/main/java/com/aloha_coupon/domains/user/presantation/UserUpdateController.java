package com.aloha_coupon.domains.user.presantation;

import com.aloha_coupon.domains.user.application.CoupleUpdateService;
import com.aloha_coupon.domains.user.application.dto.CoupleUpdateRequest;
import com.aloha_coupon.domains.user.application.dto.UserNameRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserUpdateController {
  private final CoupleUpdateService coupleUpdateService;

  @PutMapping("/couple/{userIndex}")
  public ResponseEntity updateCouple(
      @RequestBody CoupleUpdateRequest coupleUpdateRequest, @PathVariable Long userIndex)
      throws IOException {
    coupleUpdateService.updateCouple(coupleUpdateRequest, userIndex);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{token}/user")
  public ResponseEntity updateName(
      @PathVariable String token, @RequestBody UserNameRequest userNameRequest) {
    coupleUpdateService.updateName(token, userNameRequest.getName());
    return ResponseEntity.ok().build();
  }

  @PutMapping("/user/{userIndex}")
  public ResponseEntity updatePremium(@PathVariable Long userIndex) throws IOException {
    coupleUpdateService.updatePremium(userIndex);
    return ResponseEntity.ok().build();
  }
}
