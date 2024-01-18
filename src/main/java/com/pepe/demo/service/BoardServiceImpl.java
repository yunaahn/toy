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

    public class Result {
      private final boolean success;
      private final String message;
  
      public Result(boolean success, String message) {
          this.success = success;
          this.message = message;
      }
  
      public boolean isSuccess() {
          return success;
      }
  
      public String getMessage() {
          return message;
      }
  }
    
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
    public List<BoardDto> getList(int currentPage, int pageSize) {
        // startRow와 endRow를 계산하여 해당 페이지의 데이터를 가져온다.
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = startRow + pageSize - 1;

        List<BoardDto> boardList = boardDao.getListWithPaging(startRow, endRow);
        return boardList;
    }

   @Override
    public List<BoardDto> getListWithPaging(int startRow, int endRow) {
      
      
      List<BoardDto> boardDto = boardDao.getListWithPaging(startRow, endRow);
      return boardDto;
    }

    @Override
    public BoardDto getBoardOne(int no) {
      updateHit(no);
      BoardDto boardDto = boardDao.getBoardOne(no);
      return boardDto;
    }

    @Override
    public BoardDto getBoardrep(int no) {
      BoardDto boardDto = boardDao.getBoardrep(no);
      return boardDto;
    }

    
  @Override
  public int updateHit(int no) {
    int result = boardDao.updateHit(no);
    return result;
  }

  @Override
  public BoardDto replyBoard(int no) {
    BoardDto boardDto = boardDao.replyBoard(no);
      return boardDto;
  }

  @Override
  public int getBoardGroup(int no) {
    int boardDto = boardDao.getBoardGroup(no);
      return boardDto;
  }

  @Override
  public int getMaxBoardLevel(int no) {
    int boardDto = boardDao.getMaxBoardLevel(no);
      return boardDto;
  }

  @Override
    public int writeBoardReply(BoardDto boardDto) {
       // boardDto.setBoardGroup(getMaxGroup() + 1); //글쓰면 증가
        int result = boardDao.writeBoardReply(boardDto);
        return result;
    }

  @Override
    public int getTotalBoardCount() {
        return boardDao.getTotalBoardCount();
    }
  
    
    
}
