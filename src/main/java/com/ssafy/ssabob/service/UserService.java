package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.dto.ProfileResponseDto;
import com.ssafy.ssabob.dto.ProfileUpdateRequestDto;
import com.ssafy.ssabob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    /**
     * 로그인 로직을 처리하는 메소드
     * @param name 이름
     * @param region 지역
     * @param classInfo 반
     * @return 사용자가 존재하면 User 객체를, 없으면 비어있는 Optional을 반환
     */
    public Optional<User> login(String name, String region, String classInfo, String messengerId) {
        // Repository를 이용해 DB에서 해당 사용자가 있는지 조회
        return userRepository.findByNameAndRegionAndClassInfoAndMessengerId(name, region, classInfo, messengerId);
    }

    public ProfileResponseDto getProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + userId));
        return new ProfileResponseDto(user);
    }

    @Transactional
    public void updateProfile(String userMessengerId, ProfileUpdateRequestDto requestDto) {
        User user = userRepository.findByMessengerId(userMessengerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + userMessengerId));

        UserStatusBadge statusBadge = null;
        if (requestDto.getStatusBadge() != null && !requestDto.getStatusBadge().isEmpty()) {
            statusBadge = UserStatusBadge.valueOf(requestDto.getStatusBadge());
        }

        user.updateProfile(
                requestDto.getShortBio(),
                requestDto.getGithubUrl(),
                requestDto.getTechStacks(),
                requestDto.getInterestFields(),
        );
    }
}