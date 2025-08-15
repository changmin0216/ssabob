package com.ssafy.ssabob.repository;

import com.ssafy.ssabob.domain.SsabobMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SsabobMenuRepository extends JpaRepository<SsabobMenu, Long> {
    Optional<SsabobMenu> findByMenuDateAndCampus(LocalDate menuDate, String campus);
}
