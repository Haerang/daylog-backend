package com.kbstar.daylog.member.service;

import com.kbstar.daylog.member.model.mapper.MemberMapper;
import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Object getAllMembers() throws Exception {
        System.out.println(">>> memberService getAllMembers");
        final List<MemberInfoRes> memberList = memberMapper.getAllMembers();
        return memberList;
    }

    @Override
    public Object getLoginMember(Object member) throws Exception {
        System.out.println(">>> memberService getLoginMember");
        final MemberInfoRes memberRes = memberMapper.getLoginMember((MemberInfoReq) member);
        System.out.println(memberRes);
        return memberRes;
    }

    @Override
    public int insertMember(Object member) throws Exception {
        System.out.println(">>> memberService insertMember");
        return memberMapper.insertMember((MemberInfoReq) member);
    }

    @Override
    public Object updateMember(Object member) throws Exception {
        System.out.println(">>> memberService updateMember");
        memberMapper.updateMember((MemberInfoReq) member);
        int memberIdx = Integer.parseInt(((MemberInfoReq) member).getIdx());
        final MemberInfoRes memberRes = memberMapper.getMemberById(memberIdx);
        return memberRes;
    }

    @Override
    public int deleteMember(int memberIdx) throws Exception {
        System.out.println(">>> memberService deleteMember");
        return memberMapper.deleteMember(memberIdx);
    }
}
