package com.pepe.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pepe.demo.dto.MemberDto;
import com.pepe.demo.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MemberController {
    
    @Autowired
    MemberService memberService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping("/member/signin")
    public String siginin(){
        return "member/signin";
    }

    @PostMapping("/member/signin")
    @ResponseBody
    public String signinProcess(@RequestBody MemberDto memberDto, HttpSession session) {
        MemberDto loggedMember = memberService.loginMember(memberDto);
        if (loggedMember != null) {
            session.setAttribute("loggedMember", loggedMember);
            Cookie cookie = new Cookie("loggedUserId", loggedMember.getId());
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
            response.addCookie(cookie);
            //response.addCookie(cookie);
            log.info(loggedMember.toString());
            return "success";
        }
    
        return "failure";
    }

  

    @GetMapping("/member/signup")
    public String signup(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "member/signup";
    }

    @RequestMapping("/member/signup")
    public String signupProcess(
        @Valid MemberDto memberDto,
        BindingResult bindingResult,
        Model model
    ){
        if (bindingResult.hasErrors()) {
            model.addAttribute("memberDto", memberDto);
            model.addAttribute("msg","회원가입 실패");
            return "/member/signup";
          }
          int result = memberService.insertMember(memberDto);
          model.addAttribute("msg","회원가입 성공!");
          return "redirect:/main/list";
    }
    

    @GetMapping("/member/logout")
    public String logOut(HttpSession session) {

      // 세션에서 값 가져오기
      MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");

      // 값이 존재하는지 확인
      if (loggedMember != null) {
        System.out.println("현재 세션에 저장된 username: " + loggedMember.getName());
        Cookie cookie = new Cookie("loggedUserId", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
      } else {
        System.out.println("세션에 저장된 username이 없습니다.");
      }

      session.removeAttribute("loggedMember"); // session삭제
      return "redirect:/main/list";
    }

    
}
