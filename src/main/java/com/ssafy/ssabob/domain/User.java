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

    // --- 추가 정보 (수정 가능) ---
    @Column(length = 100)
    private String shortBio;

    private String githubUrl;

    // MVP에서는 간단한 문자열로 처리. 추후 별도 테이블로 분리하여 고도화 가능
    private String techStacks;

    // MVP에서는 간단한 문자열로 처리. 추후 별도 테이블로 분리하여 고도화 가능
    private String interestFields;

    //== 프로필 업데이트 로직 ==//
    public void updateProfile(String shortBio, String githubUrl, String techStacks, String interestFields) {
        this.shortBio = shortBio;
        this.githubUrl = githubUrl;
        this.techStacks = techStacks;
        this.interestFields = interestFields;
    }
}
