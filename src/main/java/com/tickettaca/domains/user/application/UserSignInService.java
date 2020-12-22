package com.tickettaca.domains.user.application;

import com.tickettaca.domains.user.application.dto.UserSignInResponse;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserSignInService {

  private final UserRepository userRepository;

  public UserSignInResponse signIn(String socialToken, String name) {

    UserEntity userEntity =
        userRepository
            .findUserEntityBySocialToken(socialToken)
            .orElseGet(() -> signup(socialToken, name));

    return new UserSignInResponse(userEntity.getId());
  }

  public UserEntity signup(String socialToken, String name) {
    return UserEntity.builder()
        .socialToken(socialToken)
        .name(name)
        .userToken(temporaryToken())
        .build();
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
