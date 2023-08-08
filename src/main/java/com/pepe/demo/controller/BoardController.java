package com.pepe.demo.controller;

import java.util.List;
import org.springframework.ui.Model;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pepe.demo.dto.BoardDto;
import com.pepe.demo.service.BoardService;



@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
  
    @GetMapping("/board/write")
    public String write(Model model) {
      model.addAttribute("boardDto", new BoardDto());
      return "/board/write";
    }
  
    @PostMapping("/board/write")
    public String writeProcess(
      @Valid BoardDto boardDto,
      BindingResult bindingResult,
      Model model
    ) {
      if (bindingResult.hasErrors()) {
        model.addAttribute("boardDto", boardDto);
        return "/board/write";
      }
      int result = boardService.writeBoard(boardDto);
      return "redirect:/board/list";
    }

    @GetMapping("/board/writenotice")
    public String noticewrite(Model model) {
      model.addAttribute("boardDto", new BoardDto());
      return "/board/writenotice";
    }
  
    @PostMapping("/board/writenotice")
    public String noticewriteProcess(
      @Valid BoardDto boardDto,
      BindingResult bindingResult,
      Model model
    ) {
      if (bindingResult.hasErrors()) {
        model.addAttribute("boardDto", boardDto);
        return "/board/writenotice";
      }
      int result = boardService.writenoticeBoard(boardDto);
      return "redirect:/board/writenotice";
    }
    
    
  

    @GetMapping("/board/list")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/board/notice")
    public String noticelist(Model model) {
        List<BoardDto> noticeList = boardService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        return "/board/notice";
    }
    
    @GetMapping("/board/view")
    public String view(Model model, int no) {
      BoardDto boardDto = boardService.getBoardOne(no);
      model.addAttribute("boardDto", boardDto);
      return "/board/view";
    }

}
