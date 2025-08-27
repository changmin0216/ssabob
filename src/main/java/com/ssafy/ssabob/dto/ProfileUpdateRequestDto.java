package com.ssafy.ssabob.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileUpdateRequestDto {

    private String shortBio;
    private String githubUrl;
    private String techStacks;
    private String interestFields;
    private String statusBadge; // UserStatusBadge Enum과 매칭될 문자열

}
