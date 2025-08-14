package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.LunchMenu;
import com.ssafy.ssabob.repository.LunchMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class LunchMenuService {
    private final LunchMenuRepository lunchMenuRepository;

    @Autowired
    public LunchMenuService(LunchMenuRepository lunchMenuRepository) {
        this.lunchMenuRepository = lunchMenuRepository;
    }

    public Optional<LunchMenu> getLunchMenu(String id) {
        LocalDate today = LocalDate.now();
        String campus = "서울";
        return lunchMenuRepository.findByMenuDateAndCampus(today, campus);
    }
}
