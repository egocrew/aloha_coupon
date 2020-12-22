package com.tickettaca.domains.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
@Getter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String pushToken;
  private String userToken;
  private String socialToken;

  @Builder
  public UserEntity(String userToken, String socialToken,String name) {
    this.userToken = userToken;
    this.socialToken = socialToken;
    this.name = name;
  }

  public void update(String userToken) {
    this.userToken = userToken;
  }
}
