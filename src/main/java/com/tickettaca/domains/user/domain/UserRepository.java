package com.tickettaca.domains.user.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("select u from UserEntity u where u.userToken=:userToken and u.id<>:userId")
    UserEntity findByLover(@Param(value = "userToken")String userToken,@Param(value = "userId")Long userId);

    UserEntity findUserEntityByUserToken(String userToken);
    Optional<UserEntity> findUserEntityBySocialToken(String socialToken);
    List<UserEntity> findAllByUserToken(String userToken);
}
