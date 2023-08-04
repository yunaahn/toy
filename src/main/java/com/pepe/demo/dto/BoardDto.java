package com.pepe.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BoardDto {
    
  private int no; //고유번호

  private String userName;


  private String title;


  private String contents;

  private int boardGroup;
  private int boardLevel;
  private int boardStep;

  private String regDate;
  private int hit;
  private int available; //1. 글 존재 , 0: 글 삭제
  private int num; //순서정하기

//   @NotEmpty(message = "필수 입력사항입니다.")
//   private String userPw;

}
