package com.pepe.demo.service;

import java.util.List;

import com.pepe.demo.dto.BoardDto;

public interface BoardService {
    //int writenoticeBoard(BoardDto boardDto);
    int writeBoard(BoardDto boardDto);
    List<BoardDto> getBoardList();
    List<BoardDto> getNoticeList();
    int getMaxGroup();
    BoardDto getBoardOne(int no);
    int updateHit(int no);
}
