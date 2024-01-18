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
    public String signinProcess(@RequestBody MemberDto memberDto, HttpSession session
        , HttpServletResponse response) {
        MemberDto loggedMember = memberService.loginMember(memberDto);
        if (loggedMember != null) {
            // 성공적으로 로그인했을 때
            session.setAttribute("loggedMember", loggedMember);
            Cookie cookie = new Cookie("loggedUserId", loggedMember.getId());
    
            int adminYn = loggedMember.getAdminYn();
            Cookie getAdminYn = new Cookie("getAdminYn", String.valueOf(adminYn));
    
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
    
            getAdminYn.setMaxAge(60*60*24);
            getAdminYn.setPath("/");
    
            response.addCookie(cookie);
            response.addCookie(getAdminYn);
    
            log.info(loggedMember.toString());
            return "loggedMember";
        } else {
            // 로그인 실패일 때
            memberDto.setPasswordNotMatch(true);
            return "failure";
        }
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

        int adminYn = loggedMember.getAdminYn();
        Cookie getAdminYn = new Cookie("getAdminYn", String.valueOf(adminYn));
        getAdminYn.setMaxAge(0);
        getAdminYn.setPath("/");
        response.addCookie(getAdminYn);
      } else {
        System.out.println("세션에 저장된 username이 없습니다.");
      }

      session.removeAttribute("loggedMember"); // session삭제
      return "redirect:/main/list";
    }

    
}
