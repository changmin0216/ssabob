package com.ssafy.ssabob.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    // 핵심: 1:1 + 유니크 FK
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    //짧은 자기소개
    @Column(length = 100)
    private String shortBio;

    //github url
    private String githubUrl;

    // 기술 스택
    private String techStacks;

    // 관심 분야
    private String interestFields;
}
