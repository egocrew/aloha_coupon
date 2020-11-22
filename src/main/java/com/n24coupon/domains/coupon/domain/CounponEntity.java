package com.n24coupon.domains.coupon.domain;

import com.n24coupon.domains.user.domain.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "coupon")
public class CounponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    private LocalDate issueDate;
    private LocalDate expirationDate;

    private int count;
    private int status;

}
