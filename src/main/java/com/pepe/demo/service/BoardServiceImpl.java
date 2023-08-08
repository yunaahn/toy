package com.pepe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepe.demo.dao.BoardDao;
import com.pepe.demo.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao boardDao;
    
    @Override
    public int writeBoard(BoardDto boardDto) {
        //boardDto.setBoardGroup(getMaxGroup() + 1); //글쓰면 증가
        int result = boardDao.writeBoard(boardDto);
        return result;
    }

    @Override
    public int writenoticeBoard(BoardDto boardDto) {
        //boardDto.setBoardGroup(getMaxGroup() + 1); //글쓰면 증가
        int result = boardDao.writenoticeBoard(boardDto);
        return result;
    }
    @Override
    public int getMaxGroup() {
      int max = boardDao.getMaxGroup();
      return max;
    }
  
    @Override
    public List<BoardDto> getBoardList() {
        List<BoardDto> boardList = boardDao.getBoardList();
        return boardList;
    }

    @Override
    public List<BoardDto> getNoticeList() {
        List<BoardDto> noticeList = boardDao.getNoticeList();
        return noticeList;
    }

    @Override
    public BoardDto getBoardOne(int no) {
      updateHit(no);
      BoardDto boardDto = boardDao.getBoardOne(no);
      return boardDto;
    }

    
  @Override
  public int updateHit(int no) {
    int result = boardDao.updateHit(no);
    return result;
  }


  
    
    
}
