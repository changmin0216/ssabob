package com.ssafy.ssabob.controller;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.service.ParticipationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/participate")
public class ParticipationController {

    private final ParticipationService participationService;

    @PostMapping
    public ResponseEntity<Void> toggleParticipation(@PathVariable Long postId, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        participationService.toggleParticipation(postId, loginUser.getMessengerId());

        return ResponseEntity.ok().build();
    }
}
