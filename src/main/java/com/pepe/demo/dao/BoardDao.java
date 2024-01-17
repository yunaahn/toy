package com.pepe.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pepe.demo.dto.BoardDto;

@Mapper
public interface BoardDao {
    int writenoticeBoard(BoardDto boardDto);
    int writeBoard(BoardDto boardDto);
    int writeBoardReply(BoardDto boardDto);
    BoardDto  replyBoard(int no);
    List<BoardDto> getNoticeList();
    List<BoardDto> getBoardList();
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
