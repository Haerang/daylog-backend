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
        System.out.println(">>> memberService getMemberById");
        final MemberInfoRes memberRes = memberMapper.getLoginMember((MemberInfoReq) member);
        System.out.println(memberRes);
        return memberRes;
    }

    @Override
    public Object getMemberById(Object member) throws Exception {
        System.out.println(">>> memberService getMemberById");
        final MemberInfoRes memberRes = memberMapper.getMemberById((MemberInfoReq) member);
        System.out.println(memberRes);
        return memberRes;
    }

    @Override
    public int insertMember(Object member){
        System.out.println(">>> memberService insertMember");
        int flag;

        try {
            flag = memberMapper.insertMember((MemberInfoReq) member);
        }catch (Exception e){
            flag = -1;
            System.out.println(">>>>> duplicate exeption flag: " + flag);
        }
        return flag;
    }

    @Override
    public Object updateMember(Object member) throws Exception {
        System.out.println(">>> memberService updateMember");
        memberMapper.updateMember((MemberInfoReq) member);
        int memberIdx = Integer.parseInt(((MemberInfoReq) member).getIdx());
        final MemberInfoRes memberRes = memberMapper.getMemberByIdx(memberIdx);
        return memberRes;
    }

    @Override
    public int deleteMember(int memberIdx) throws Exception {
        System.out.println(">>> memberService deleteMember");
        return memberMapper.deleteMember(memberIdx);
    }
}
