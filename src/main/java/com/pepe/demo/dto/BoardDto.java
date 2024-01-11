package com.pepe.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BoardDto {
  private int ROW; //고유번호
  private int no; //고유번호

  private String userName;


  private String title;


  private String contents;

  private int boardGroup;
  private int boardLevel;
  private int boardStep;

  private String regDate;
  private int hit;
  private int type; //1. 공지 , 0: 일반
  private int num; //순서정하기

//   @NotEmpty(message = "필수 입력사항입니다.")
//   private String userPw;

}
