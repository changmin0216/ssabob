package com.ssafy.ssabob.repository;

import com.ssafy.ssabob.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNameAndClassInfo(String name, String classInfo);
}
