package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.LunchMenu;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LunchMenuResponseDto {
    // 클라이언트에게 보여줄 데이터만 선별해서 필드로 선언
    private final LocalDate menuDate;
    private final String campus;
    private final String koreanFood20f;
    private final String specialFood20f;
    private final String lunchBox10f;
    private final String brunch10f;
    private final String salad10f;

    // Entity를 DTO로 변환하는 생성자
    public LunchMenuResponseDto(LunchMenu entity) {
        this.menuDate = entity.getMenuDate();
        this.campus = entity.getCampus();
        this.koreanFood20f = entity.getKoreanFood20f();
        this.specialFood20f = entity.getSpecialFood20f();
        this.lunchBox10f = entity.getLunchBox10f();
        this.brunch10f = entity.getBrunch10f();
        this.salad10f = entity.getSalad10f();
    }
}
