package com.tickettaca.domains.coupon.application.dto;

import com.tickettaca.domains.coupon.domain.CouponEntity;
import com.tickettaca.domains.coupon.domain.CouponStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter

public class CouponListResponse {
    private CouponStatus state;
    private String deadLine;
    private String desc;
    private String name;
    private Long ownSeq;
    private Long seq;
    private String deadDay;

    public CouponListResponse(CouponStatus state, LocalDate deadLine, String desc, String name, Long ownSeq, Long seq, LocalDate deadDay) {
        this.state = state;
        this.deadLine = convertDate(deadLine);
        this.desc = desc;
        this.name = name;
        this.ownSeq = ownSeq;
        this.seq = seq;
        this.deadDay = convertDate(deadDay);
    }

    public String convertDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        return date.format(formatter);
    }
}
