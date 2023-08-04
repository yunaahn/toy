package com.pepe.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pepe.demo.dto.MemberDto;

@Mapper
public interface MemberDao {
  int insertMember(MemberDto memberDto);
  MemberDto loginMember(MemberDto memberDto);
}
