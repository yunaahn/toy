package com.pepe.demo.controller;

import java.util.List;
import org.springframework.ui.Model;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pepe.demo.dto.BoardDto;
import com.pepe.demo.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

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
      boardService.writenoticeBoard(boardDto);
      return "redirect:/board/writenotice";
    }
    
    
  

    @GetMapping("/board/list")
    public String list(@RequestParam(name = "page", defaultValue = "1") Integer currentPage,
     Model model) {

       int pageSize = 10;
       // 전체 게시물 수 조회
       int totalItems = boardService.getTotalBoardCount();

       // 페이징에 필요한 정보 계산
       int totalPages = (int) Math.ceil((double) totalItems / pageSize);

       // 현재 페이지 번호를 모델에 추가
       model.addAttribute("currentPage", currentPage);
         model.addAttribute("page", currentPage);
       // 전체 페이지 수를 모델에 추가
       model.addAttribute("totalPages", totalPages);
       model.addAttribute("boardList", boardService.getList(currentPage, pageSize));
       model.addAttribute("totalItems", totalItems);

       System.out.println("Current Page: " + currentPage);
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
    
    @GetMapping("/board/reply")
    public String reply(Model model, @RequestParam("no") Integer no) {
      BoardDto boardDto = boardService.replyBoard(no);
      logger.info("GET /board/reply endpoint called with parameter 'no': {}", no);
      model.addAttribute("boardDto", boardDto);
      return "/board/reply";
    }

    @PostMapping("/board/reply")
    public String replyInsert(
    @Valid BoardDto boardDto,
    @RequestParam("no") Integer no,
    BindingResult bindingResult,
    Model model) {
      if (bindingResult.hasErrors()) {
        model.addAttribute("boardDto", boardDto);
        return "/board/write";
      }
      boardDto.setNo(no);
      int BoardGroup = boardService.getBoardGroup(no);
      int BoardLevel = boardService.getMaxBoardLevel(BoardGroup);
      boardDto.setBoardLevel(BoardLevel + 1);
      int result = boardService.writeBoardReply(boardDto);
      return "redirect:/board/list";
    }

}
