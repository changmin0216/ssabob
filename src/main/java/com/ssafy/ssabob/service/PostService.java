package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.Post;
import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.dto.CommentResponseDto;
import com.ssafy.ssabob.dto.PostCreateRequestDto;
import com.ssafy.ssabob.dto.PostDetailResponseDto;
import com.ssafy.ssabob.dto.PostListResponseDto;
import com.ssafy.ssabob.repository.CommentRepository;
import com.ssafy.ssabob.repository.ParticipationRepository;
import com.ssafy.ssabob.repository.PostRepository;
import com.ssafy.ssabob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ParticipationRepository participationRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long createPost(PostCreateRequestDto requestDto, String userMessengerId) {
        User author = userRepository.findByMessengerId(userMessengerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + userMessengerId));

        Post post = requestDto.toEntity(author);
        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }

    public List<PostListResponseDto> findAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostDetailResponseDto findPostById(Long postId, User currentUser) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + postId));

        // 댓글 목록 조회
        List<CommentResponseDto> comments = commentRepository.findByPostOrderByCreatedAtAsc(post).stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());

        // 참여자 수 조회
        long participantCount = participationRepository.countByPost(post);

        // 현재 접속한 유저의 참여 여부 확인
        boolean isUserParticipating = false;
        if (currentUser != null) {
            isUserParticipating = participationRepository.findByUserAndPost(currentUser, post).isPresent();
        }

        return new PostDetailResponseDto(post, participantCount, isUserParticipating, comments);
    }
}
