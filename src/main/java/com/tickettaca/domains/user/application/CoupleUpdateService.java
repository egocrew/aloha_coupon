package com.tickettaca.domains.user.application;

import com.tickettaca.commons.firebase.FCMService;
import com.tickettaca.domains.user.application.dto.CoupleUpdateRequest;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoupleUpdateService {

  private final UserRepository userRepository;
  private final FCMService fcmService;

  @Transactional
  public ResponseEntity updateCouple(CoupleUpdateRequest coupleUpdateRequest, Long userId)
      throws IOException {
    UserEntity lover =
        userRepository
            .findUserEntityByUserToken(coupleUpdateRequest.getToken())
            .orElseThrow(() -> new IllegalArgumentException("Invalid lover"));
    UserEntity userEntity =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid userId"));
    String convertUuid = UUID.randomUUID().toString().replace("-", "");
    lover.update(convertUuid);
    userEntity.update(lover.getUserToken());

    fcmService.sendMessageTo(
        lover.getPushToken(),
        userEntity.getName() + "님과 커플이 되었어요! \uD83D\uDE0A",
        "소소한 선물\uD83C\uDF81 쿠폰을 발행해볼까요?");
    return ResponseEntity.ok().build();
  }

  @Transactional
  public void updateName(String token, String name) {
    UserEntity userEntity =
        userRepository
            .findUserEntityBySocialToken(token)
            .orElseThrow(() -> new IllegalArgumentException("Invalid SocialToken"));
    userEntity.updateName(name);
  }
}
