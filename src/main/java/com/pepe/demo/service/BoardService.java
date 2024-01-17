package com.pepe.demo.service;

import java.util.List;

import com.pepe.demo.dto.BoardDto;

public interface BoardService {
    int writenoticeBoard(BoardDto boardDto);
    int writeBoard(BoardDto boardDto);
    int writeBoardReply(BoardDto boardDto);
    BoardDto replyBoard(int no);
    List<BoardDto> getBoardList();
    List<BoardDto> getNoticeList();
    int getMaxGroup();
    BoardDto getBoardOne(int no);
    BoardDto getBoardrep(int no);
    int getBoardGroup(int no);
    int getMaxBoardLevel(int no);
    int updateHit(int no);
    int getTotalBoardCount();
    List<BoardDto> getListWithPaging(int startRow, int endRow);
    List<BoardDto> getList(int currentPage, int pageSize);
}
