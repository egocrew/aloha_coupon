package com.tickettaca.domains.user.presantation;

import com.tickettaca.domains.user.application.CoupleUpdateService;
import com.tickettaca.domains.user.application.dto.CoupleUpdateRequest;
import com.tickettaca.domains.user.application.dto.UserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserUpdateController {
    private final CoupleUpdateService coupleUpdateService;

    @PutMapping("/couple/{userId}")
    public ResponseEntity updateCouple(@RequestBody CoupleUpdateRequest coupleUpdateRequest, @PathVariable Long userId){
                coupleUpdateService.updateCouple(coupleUpdateRequest,userId);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/user/{userId}")
//    public ResponseEntity updateUser(@RequestBody UserInfoRequest userInfoRequest,@PathVariable Long userId){
//                coupleUpdateService.updateUser(userInfoRequest,userId);
//        return ResponseEntity.ok().build();
//    }
}
