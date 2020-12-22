package com.tickettaca.domains.user.application;

import com.tickettaca.domains.user.application.dto.UserListResponse;
import com.tickettaca.domains.user.domain.UserEntity;
import com.tickettaca.domains.user.domain.UserRepository;
import com.tickettaca.domains.user.domain.UserSupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoupleListService {

  private final UserRepository userRepository;
  private final UserSupportRepository userSupportRepository;

    public List<UserListResponse> userInfo(String userToken){
//      List<UserEntity> userEntity = userRepository.findAllByUserToken(socialToken);
      return userSupportRepository.coupleList(userToken);
    }


}
