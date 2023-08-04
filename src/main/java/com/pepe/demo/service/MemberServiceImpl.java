package com.pepe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepe.demo.dao.MemberDao;
import com.pepe.demo.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
    
    @Autowired
    MemberDao memberDao;

    @Override
    public int insertMember(MemberDto memberDto) {
        int result = memberDao.insertMember(memberDto);
        return result;
    }

    @Override
    public MemberDto loginMember(MemberDto memberDto) {
        MemberDto loginMember = memberDao.loginMember(memberDto);
        return loginMember;
    }
}
