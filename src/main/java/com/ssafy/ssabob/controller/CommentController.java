package com.ssafy.ssabob.controller;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.dto.CommentCreateRequestDto;
import com.ssafy.ssabob.service.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public String createComment(@PathVariable Long postId,
                                @ModelAttribute CommentCreateRequestDto requestDto,
                                HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        commentService.createComment(postId, loginUser.getMessengerId(), requestDto.getContent());

        return "redirect:/posts/" + postId;
    }
}
