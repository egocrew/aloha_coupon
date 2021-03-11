package com.aloha_coupon.domains.user.application;

import com.aloha_coupon.domains.user.application.dto.CoupleResponse;
import com.aloha_coupon.domains.user.application.dto.UserSignInRequest;
import com.aloha_coupon.domains.user.domain.UserEntity;
import com.aloha_coupon.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserSignInService {

  private final UserRepository userRepository;
  private final CoupleListService coupleListService;

  @Transactional
  public CoupleResponse signIn(UserSignInRequest userSignInRequest) {

    UserEntity userEntity =
        userRepository
            .findUserEntityBySocialToken(userSignInRequest.getToken())
            .orElseGet(
                () -> signup(userSignInRequest.getToken(), userSignInRequest.getPushToken()));

    userEntity.updatePush(userSignInRequest.getPushToken());

    CoupleResponse coupleResponse = coupleListService.userInfo(userSignInRequest.getToken());

    return coupleResponse;
  }

  @Transactional
  public UserEntity signup(String socialToken, String pushToken) {
    return userRepository.save(
        UserEntity.builder()
            .socialToken(socialToken)
            .pushToken(pushToken)
            .userToken(temporaryToken())
            .build());
  }

  public String temporaryToken() {
    Random rand = new Random();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 8; i++) {
      int index = rand.nextInt(3);
      switch (index) {
        case 0:
          sb.append((char) (rand.nextInt(26) + 97));
          break;
        case 1:
          sb.append((char) (rand.nextInt(26) + 65));
          break;
        case 2:
          sb.append(rand.nextInt(8));
          break;
      }
    }
    return sb.toString();
  }
}
