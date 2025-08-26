package com.ssafy.ssabob.repository;

import com.ssafy.ssabob.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 생성일시 기준 내림차순으로 모든 게시글을 조회 (최신순)
    List<Post> findAllByOrderByCreatedAtDesc();
}
