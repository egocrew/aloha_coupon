package com.aloha_coupon.domains.user.application;

import com.aloha_coupon.domains.user.application.dto.CoupleResponse;
import com.aloha_coupon.domains.user.application.dto.LoverResponse;
import com.aloha_coupon.domains.user.application.dto.UserResponse;
import com.aloha_coupon.domains.user.domain.UserSupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoupleListService {

  private final UserSupportRepository userSupportRepository;

  public CoupleResponse userInfo(String socialToken) {
    UserResponse user = userSupportRepository.coupleList(socialToken);
    LoverResponse lover = userSupportRepository.findLover(user.getToken(), socialToken);
    if (lover == null) {
      lover = new LoverResponse(-1L, "");
    }
    return new CoupleResponse(
        user.getSeq(),
        user.getName(),
        user.getToken(),
        lover.getPartnerSeq(),
        lover.getPartnerName(),
        user.getPremiumType());
  }
}
