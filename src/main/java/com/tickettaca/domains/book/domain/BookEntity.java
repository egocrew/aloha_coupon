package com.tickettaca.domains.book.domain;

import com.tickettaca.domains.user.domain.UserEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "book")
@Entity
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String contents;
  private String userToken;

  @Builder
  public BookEntity(String name, String contents, String userToken) {
    this.name = name;
    this.contents = contents;
    this.userToken = userToken;
  }
}