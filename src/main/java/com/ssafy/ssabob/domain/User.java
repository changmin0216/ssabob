package com.ssafy.ssabob.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    // --- 기본 정보 (수정 불가) ---
    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String region;

    @Column(nullable = false, updatable = false)
    private String classInfo;

    @Column(name = "messenger_id", nullable = false, unique = true, updatable = false)
    private String messengerId;
}
