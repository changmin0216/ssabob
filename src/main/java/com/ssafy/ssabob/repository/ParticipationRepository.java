package com.ssafy.ssabob.repository;

import com.ssafy.ssabob.domain.Participation;
import com.ssafy.ssabob.domain.Post;
import com.ssafy.ssabob.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    Optional<Participation> findByUserAndPost(User user, Post post);

    List<Participation> findByPost(Post post);

    long countByPost(Post post);
}
