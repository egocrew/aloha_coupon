package com.tickettaca.domains.book.domain;

import com.tickettaca.domains.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "book")
@Entity
public class BookEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String contents;
  private String userToken;
  private boolean status;

  @Builder
  public BookEntity(String name, String contents, String userToken) {
    this.name = name;
    this.contents = contents;
    this.userToken = userToken;
  }

  public void updateStatus(boolean status) {
    this.status = status;
  }

  @PrePersist
  public void prePersist() {
    this.status = true;
  }
}
