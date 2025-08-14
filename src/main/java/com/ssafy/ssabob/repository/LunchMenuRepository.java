package com.ssafy.ssabob.repository;

import com.ssafy.ssabob.domain.LunchMenu;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface LunchMenuRepository extends JpaRepository<LunchMenu, Long> {
    Optional<LunchMenu> findByMenuDateAndCampus(LocalDate menuDate, String campus);
}
