package com.pepe.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pepe.demo.dto.BoardDto;

@Mapper
public interface BoardDao {
    int writeBoard(BoardDto boardDto);
    List<BoardDto> getBoardList();
    int getMaxGroup();
    BoardDto getBoardOne(int no);
    int updateHit(int no);
}