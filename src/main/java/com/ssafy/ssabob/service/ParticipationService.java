package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.Participation;
import com.ssafy.ssabob.domain.Post;
import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.repository.ParticipationRepository;
import com.ssafy.ssabob.repository.PostRepository;
import com.ssafy.ssabob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void toggleParticipation(Long postId, String userMessengerId) {
        User user = userRepository.findByMessengerId(userMessengerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + userMessengerId));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + postId));

        Optional<Participation> existingParticipation = participationRepository.findByUserAndPost(user, post);

        if (existingParticipation.isPresent()) {
            // 이미 참여 중이면 취소
            participationRepository.delete(existingParticipation.get());
        } else {
            // 참여 중이 아니면 참여
            Participation newParticipation = Participation.builder()
                    .user(user)
                    .post(post)
                    .build();
            participationRepository.save(newParticipation);
        }
    }
}
