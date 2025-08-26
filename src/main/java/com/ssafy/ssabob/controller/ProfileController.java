package com.ssafy.ssabob.controller;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.dto.ProfileResponseDto;
import com.ssafy.ssabob.dto.ProfileUpdateRequestDto;
import com.ssafy.ssabob.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping("/profile/{userId}")
    public String showProfile(@PathVariable Long userId, Model model) {
        ProfileResponseDto profileDto = userService.getProfile(userId);
        model.addAttribute("profile", profileDto);
        return "profile/detail";
    }

    @GetMapping("/profile/edit")
    public String getProfileEditForm(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login"; // 로그인하지 않았으면 로그인 페이지로
        }

        ProfileResponseDto profileDto = userService.getProfile(loginUser.getId());
        model.addAttribute("profile", profileDto);
        return "profile/form";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute ProfileUpdateRequestDto requestDto, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        userService.updateProfile(loginUser.getMessengerId(), requestDto);

        return "redirect:/profile/" + loginUser.getId();
    }
}
