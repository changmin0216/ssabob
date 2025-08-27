package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.SsabobMenu;
import com.ssafy.ssabob.dto.SsabobMenuResponseDto;
import com.ssafy.ssabob.repository.SsabobMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SsabobMenuService {
    private final SsabobMenuRepository ssabobMenuRepository;

    @Autowired
    public SsabobMenuService(SsabobMenuRepository ssabobMenuRepository) {
        this.ssabobMenuRepository = ssabobMenuRepository;
    }

    public Optional<SsabobMenuResponseDto> getTodaySeoulMenu() {
//        LocalDate today = LocalDate.now();
//        String campus = "서울";
//        return lunchMenuRepository.findByMenuDateAndCampus(today, campus);
//        LocalDate today = LocalDate.now();
        LocalDate today = LocalDate.of(2025, 8, 25);
        String campus = "SEOUL";

        // 1. DB에서 Entity 조회
        Optional<SsabobMenu> optionalMenuEntity = ssabobMenuRepository.findByMenuDateAndCampus(today, campus);

        // 2. 조회된 Entity를 DTO로 변환하여 반환
        return optionalMenuEntity.map(SsabobMenuResponseDto::new);
    }
}
