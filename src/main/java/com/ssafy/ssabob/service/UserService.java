package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 로그인 로직을 처리하는 메소드
     * @param name 이름
     * @param region 지역
     * @param classInfo 반
     * @return 사용자가 존재하면 User 객체를, 없으면 비어있는 Optional을 반환
     */
    public Optional<User> login(String name, String region, String classInfo) {
        // Repository를 이용해 DB에서 해당 사용자가 있는지 조회
        return userRepository.findByNameAndRegionAndClassInfo(name, region, classInfo);
    }
}