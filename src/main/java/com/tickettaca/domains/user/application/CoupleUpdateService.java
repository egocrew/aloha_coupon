package com.tickettaca.domains.user.application;

import com.tickettaca.domains.user.application.dto.CoupleUpdateRequest;
import com.tickettaca.domains.user.application.dto.UserInfoRequest;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoupleUpdateService {

  private final UserRepository userRepository;

  // 커플 등록
  @Transactional
  public ResponseEntity updateCouple(CoupleUpdateRequest coupleUpdateRequest, Long userId) {
    UserEntity lover = userRepository.findUserEntityByUserToken(coupleUpdateRequest.getUserToken());
    UserEntity userEntity =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid userId"));
    String convertUuid = UUID.randomUUID().toString().replace("-", "");
    lover.update(convertUuid);
    userEntity.update(convertUuid);
    return ResponseEntity.ok().build();
  }

  //    //개인정보 변경
  //    @Transactional
  //    public ResponseEntity updateUser(UserInfoRequest userInfoRequest, Long userId) {
  //        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new
  // IllegalArgumentException("Invalid userId"));
  //        userEntity.nameUpdate(userInfoRequest.getName());
  //        return ResponseEntity.ok().build();
  //    }
}
