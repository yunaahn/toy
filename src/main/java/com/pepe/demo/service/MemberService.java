package com.pepe.demo.service;

import com.pepe.demo.dto.MemberDto;

public interface MemberService {
    int insertMember(MemberDto memberDto);
    MemberDto loginMember(MemberDto meberDto);
}
