package com.kbstar.daylog.member.service;

import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;

import java.util.List;

public interface MemberService {
    // 회원 전체 조회
    public Object getAllMembers() throws Exception;

    // 회원 조회
    public Object getLoginMember(Object member) throws Exception;

    // 회원 가입
    public int insertMember(Object member) throws Exception;

    // 회원정보 수정
    public Object updateMember(Object member) throws Exception;

    // 회원 삭제
    public int deleteMember(int memberIdx) throws Exception;

}
