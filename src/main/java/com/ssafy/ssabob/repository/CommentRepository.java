package com.ssafy.ssabob.repository;

import com.ssafy.ssabob.domain.Comment;
import com.ssafy.ssabob.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostOrderByCreatedAtAsc(Post post);
}
