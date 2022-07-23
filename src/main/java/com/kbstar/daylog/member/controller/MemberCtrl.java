package com.kbstar.daylog.member.controller;

import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import com.kbstar.daylog.member.model.vo.MemberMsgRes;
import com.kbstar.daylog.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MemberCtrl {

    private final MemberServiceImpl memberService;
    private final MemberMsgRes memberMsgRes;
    private MemberInfoRes memberinfoRes;
    private final String FAIL = "fail";

    @PostMapping("/user/register")
    @ResponseBody
    public Object register(@RequestBody MemberInfoReq memberInfoReq) throws Exception {
        System.out.println(">>> memberCtrl register");
        int code = memberService.insertMember(memberInfoReq);
        if(code == -1){
            memberMsgRes.setResMsg(FAIL);
        }
        return memberMsgRes;
    }

    @PostMapping("/user/login")
    @ResponseBody
    public Object login(@RequestBody MemberInfoReq memberInfoReq) throws Exception {
        System.out.println(">>> memberCtrl login");
        memberinfoRes = (MemberInfoRes) memberService.getLoginMember(memberInfoReq);

        // 로그인 실패하였을 경우, native에 실패 메시지를 넘겨줌
        if(Objects.isNull(memberinfoRes)){
            memberMsgRes.setResMsg(FAIL);
            return memberMsgRes;
        }

        // 로그인 성공하였을 경우, native에 로그인한 사람 정보를 넘겨줌
        return memberinfoRes;
    }

    @PostMapping("/user/modify")
    @ResponseBody
    public Object changeUserInfo(@RequestBody MemberInfoReq memberInfoReq) throws Exception{
        System.out.println(">>> memberCtrl changeUserInfo");

        memberinfoRes = (MemberInfoRes) memberService.updateMember(memberInfoReq);

        if(Objects.isNull(memberinfoRes)){
            memberMsgRes.setResMsg(FAIL);
            return memberMsgRes;
        }

        return memberinfoRes;
    }

    @PostMapping("/user/delete")
    @ResponseBody
    public Object deleteUser(@RequestBody MemberInfoReq memberInfoReq) throws Exception{
        System.out.println(">>> memberCtrl deleteUser");
        int code = memberService.deleteMember(Integer.parseInt(memberInfoReq.getIdx()));

        if(code == -1){
            memberMsgRes.setResMsg(FAIL);
        }
        return memberMsgRes;
    }



}
