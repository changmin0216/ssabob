package com.ssafy.ssabob.controller;

import com.ssafy.ssabob.domain.User;
import com.ssafy.ssabob.dto.PostCreateRequestDto;
import com.ssafy.ssabob.dto.PostDetailResponseDto;
import com.ssafy.ssabob.dto.PostListResponseDto;
import com.ssafy.ssabob.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 1. 게시글 목록 페이지
    @GetMapping
    public String listPosts(Model model) {
        List<PostListResponseDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "posts/list";
    }

    // 2. 새 게시글 작성 폼 페이지
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("postCreateRequestDto", new PostCreateRequestDto());
        return "posts/form";
    }

    // 3. 새 게시글 생성 처리
    @PostMapping
    public String createPost(@ModelAttribute PostCreateRequestDto requestDto, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        Long postId = postService.createPost(requestDto, loginUser.getMessengerId());
        return "redirect:/posts/" + postId;
    }

    // 4. 게시글 상세 페이지
    @GetMapping("/{id}")
    public String showPostDetail(@PathVariable Long id, Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        PostDetailResponseDto post = postService.findPostById(id, loginUser);
        model.addAttribute("post", post);
        return "posts/detail";
    }
}
