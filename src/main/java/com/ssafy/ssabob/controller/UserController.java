package com.ssafy.ssabob.controller;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.dto.UserLoginRequestDto;
import com.ssafy.ssabob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 1. 로그인 폼(페이지)을 보여주는 역할
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // "login.html" 파일을 보여줌
    }

    // 2. 실제 로그인 처리를 하는 역할
    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginRequestDto requestDto, HttpServletRequest request) {

        // 서비스에게 로그인 요청
        Optional<User> loginUserOptional = userService.login(
                requestDto.getName(),
                requestDto.getRegion(),
                requestDto.getClassInfo(),
                requestDto.getMessengerId()
        );

        // 사용자가 존재한다면 (로그인 성공)
        if (loginUserOptional.isPresent()) {
            // 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
            HttpSession session = request.getSession();
            // 세션에 로그인 회원 정보 보관
            session.setAttribute("loginUser", loginUserOptional.get());
            return "redirect:/"; // 로그인 성공 시 메인 페이지로 이동
        }

        // 로그인 실패 시
        return "redirect:/login?error"; // 로그인 폼으로 다시 보내면서 에러 표시
    }

    // 3. 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 세션이 있으면 가져오고, 없으면 만들지 않음
        if (session != null) {
            session.invalidate(); // 세션 만료
        }
        return "redirect:/"; // 메인 페이지로 이동
    }
}