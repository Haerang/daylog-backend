package com.kbstar.daylog.member.controller;

import com.kbstar.daylog.common.jwt.JwtTokenProvider;
import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import com.kbstar.daylog.member.model.vo.MemberMsgRes;
import com.kbstar.daylog.member.model.vo.User;
import com.kbstar.daylog.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mobile/user/")
public class MemberCtrl {

    private final MemberServiceImpl memberService;
    private final MemberMsgRes memberMsgRes;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private MemberInfoRes memberinfoRes;
    private final String FAIL = "fail";
    private final String SUCCESS = "success";

    @PostMapping("register")
    @ResponseBody
    public Object register(@RequestBody MemberInfoReq memberInfoReq) throws Exception {
        System.out.println(">>> memberCtrl register");
        int code = memberService.insertMember(memberInfoReq);
        if(code == -1){
            memberMsgRes.setResMsg(FAIL);
            return memberMsgRes;
        }
        return memberinfoRes;
    }

    @PostMapping("idCheck")
    @ResponseBody
    public Object getMemberById(@RequestBody MemberInfoReq memberInfoReq) throws  Exception{
        System.out.println(">>> memberCtrl getMemberById");

        MemberInfoRes memberInfoRes = (MemberInfoRes) memberService.getMemberById(memberInfoReq.getId());

        if(memberInfoRes==null) {
            memberMsgRes.setResMsg(SUCCESS);
            return memberMsgRes;
        }

        memberMsgRes.setResMsg(FAIL);
        return memberMsgRes;
    }

    @PostMapping("login")
    @ResponseBody
    public Object login(@RequestBody MemberInfoReq memberInfoReq) throws Exception {
        System.out.println(">>> memberCtrl login");

        User user = memberService.findById(memberInfoReq.getId());
        System.out.println(">>>> user: " + user);

        if (!passwordEncoder.matches(memberInfoReq.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        // 로그인 실패 시 에러 메시지 넘겨주기
        if(Objects.isNull(user)){
            memberMsgRes.setResMsg(FAIL);
            return memberMsgRes;
        }

        // 로그인 성공 시 jwt 토큰 넘겨주기
        return jwtTokenProvider.createToken(user.getUsername(), user.getNickname());


//        memberinfoRes = (MemberInfoRes) memberService.getLoginMember(memberInfoReq);
//        // 로그인 성공하였을 경우, native에 로그인한 사람 정보를 넘겨줌
//        return memberinfoRes;
    }

    @PutMapping("modify")
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

    @DeleteMapping("delete")
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
