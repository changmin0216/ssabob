package com.ssafy.ssabob.service;

import com.ssafy.ssabob.domain.Comment;
import com.ssafy.ssabob.domain.Post;
import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.repository.CommentRepository;
import com.ssafy.ssabob.repository.PostRepository;
import com.ssafy.ssabob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void createComment(Long postId, String userMessengerId, String content) {
        User author = userRepository.findByMessengerId(userMessengerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + userMessengerId));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + postId));

        Comment comment = Comment.builder()
                .content(content)
                .author(author)
                .post(post)
                .build();

        commentRepository.save(comment);
    }
}
