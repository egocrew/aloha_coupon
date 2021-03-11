package com.aloha_coupon.domains.user.domain;

import com.aloha_coupon.domains.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
@Getter
public class UserEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String pushToken;
  private String userToken;
  private String socialToken;

  @Enumerated(EnumType.STRING)
  private PremiumType premium;

  @Builder
  public UserEntity(String userToken, String pushToken, String socialToken, String name) {
    this.userToken = userToken;
    this.pushToken = pushToken;
    this.socialToken = socialToken;
    this.name = name;
  }

  public void update(String userToken) {
    this.userToken = userToken;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void updatePush(String pushToken) {
    this.pushToken = pushToken;
  }

  public void updatePremium(PremiumType premiumType) {
    this.premium = premiumType;
  }

  @PrePersist
  public void prePersist() {
    this.name = this.name == null ? "" : this.name;
    this.premium = this.premium == null ? PremiumType.BASIC : this.premium;
  }
}
