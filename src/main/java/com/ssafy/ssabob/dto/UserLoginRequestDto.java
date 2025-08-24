package com.ssafy.ssabob.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // 컨트롤러가 폼 데이터를 받아오려면 Setter가 필요합니다.
public class UserLoginRequestDto {

    private String name;
    private String region;
    private String classInfo;
}