package com.kbstar.daylog.member.model.mapper;

import com.kbstar.daylog.member.model.vo.User;
import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    // 회원 전체 조회
    public List<MemberInfoRes> getAllMembers() throws Exception;

    // 로그인
    public MemberInfoRes getLoginMember(MemberInfoReq member) throws Exception;

    // 회원조회(id)
    public MemberInfoRes getMemberById(String id) throws Exception;

    // 회원조회(jwt용)
    public User findById(String id);

    // 회원조회(idx)
    public MemberInfoRes getMemberByIdx(int idx) throws Exception;

    // 회원 가입
    public int insertMember(MemberInfoReq member) throws Exception;

    // 회원정보 수정
    public int updateMember(MemberInfoReq member) throws Exception;

    // 회원 삭제
    public int deleteMember(int memberIdx) throws Exception;

}
