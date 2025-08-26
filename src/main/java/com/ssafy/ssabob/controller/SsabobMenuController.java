package com.ssafy.ssabob.controller;

import com.ssafy.ssabob.dto.SsabobMenuResponseDto;
import com.ssafy.ssabob.service.SsabobMenuService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller // 이 클래스가 웹 요청을 처리하는 컨트롤러임을 선언
public class SsabobMenuController {

    private final SsabobMenuService ssabobMenuService;

    public SsabobMenuController(SsabobMenuService ssabobMenuService) {
        this.ssabobMenuService = ssabobMenuService;
    }

    // 사용자가 웹사이트의 메인 페이지("/")에 접속했을 때 이 메소드를 실행
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        // 1. 세션에서 로그인 정보 확인
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            // 로그인되어 있지 않으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // 2. 서비스에게 오늘 서울 캠퍼스 메뉴를 요청
        Optional<SsabobMenuResponseDto> menuDtoOptional = ssabobMenuService.getTodaySeoulMenu();

        // 3. 서비스로부터 받은 데이터를 Model에 담아 View로 전달
        if (menuDtoOptional.isPresent()) {
            model.addAttribute("menu", menuDtoOptional.get());
        } else {
            // 메뉴 정보가 없을 경우를 대비
            model.addAttribute("menu", null);
        }

        // 4. "index.html" 파일을 찾아서 사용자에게 보여주라고 지시
        return "index";
    }
}