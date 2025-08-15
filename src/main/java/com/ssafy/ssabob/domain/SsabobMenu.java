package com.ssafy.ssabob.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class SsabobMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 id를 자동으로 생성하고 관리하게 만드는 기능
    private Long id;

    @Column(nullable = false)
    private LocalDate menuDate;

    @Column(nullable = false)
    private String campus;

    @Column(name = "korean_food_20f")
    private String koreanFood20f;

    @Column(name = "special_food_20f")
    private String specialFood20f;

    @Column(name = "lunch_box_10f")
    private String lunchBox10f;

    @Column(name = "brunch_10f")
    private String brunch10f;

    @Column(name = "salad_10f")
    private String salad10f;
}
