package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.User;
import com.board.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 폼
    @GetMapping("/joinForm")  // URL: /user/joinForm
    public String joinForm() {
        return "users/joinForm"; // JSP 경로
    }

    // 회원가입 처리
    @PostMapping("/join")  // URL: /user/join
    public String join(User user, Model model) {
        try {
            int count = userService.join(user);
            if(count > 0) {
                model.addAttribute("message", "회원가입 성공");
                return "users/joinSuccess";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "회원가입 실패");
        return "users/joinFailed";
    }

    // 로그인 폼
    @GetMapping("/loginForm") // URL: /user/loginForm
    public String loginForm() {
        return "users/loginForm"; // JSP 경로
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(String id, String password, Model model, HttpSession session) {
        try {
            User user = userService.login(id, password);
            if(user != null) {
                session.setAttribute("loginUser", user);
                return "redirect:/board/boardlist";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "로그인 실패");
        return "users/loginForm";
    }
    
    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 초기화 -> 로그인 정보 삭제
        return "redirect:/board/boardlist"; // 로그아웃 후 이동할 페이지
    }
    
    // 탈퇴처리
    @GetMapping("/delete")
    public String deleteUser(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            try {
                int count = userService.delete(loginUser.getId());
                if (count > 0) {
                    session.invalidate(); // 세션 초기화 → 로그아웃 처리
                    model.addAttribute("message", "회원탈퇴가 완료되었습니다.");
                    return "redirect:/board/boardlist"; // 보드리스트로 이동
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("message", "회원탈퇴 실패");
        return "redirect:/board/boardlist"; // 실패해도 보드리스트로
    }
}
