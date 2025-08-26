package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.User;
import lombok.Getter;

@Getter
public class ProfileResponseDto {

    private final Long id;
    private final String name;
    private final String region;
    private final String classInfo;
    private final String shortBio;
    private final String githubUrl;
    private final String techStacks;
    private final String interestFields;

    public ProfileResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.region = user.getRegion();
        this.classInfo = user.getClassInfo();
        this.shortBio = user.getShortBio();
        this.githubUrl = user.getGithubUrl();
        this.techStacks = user.getTechStacks();
        this.interestFields = user.getInterestFields();
    }
}