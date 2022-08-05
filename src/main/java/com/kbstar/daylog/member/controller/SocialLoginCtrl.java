package com.kbstar.daylog.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kbstar.daylog.common.jwt.JwtTokenProvider;
import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import com.kbstar.daylog.member.model.vo.MemberMsgRes;
import com.kbstar.daylog.member.model.vo.User;
import com.kbstar.daylog.member.service.KakaoServiceImpl;
import com.kbstar.daylog.member.service.SocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class SocialLoginCtrl {
    private final String FAIL = "fail";
    private final KakaoServiceImpl kakaoService;
    private final MemberMsgRes memberMsgRes;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("member/kakao/callback")
    public Object kakaoLogin(@RequestParam String code, HttpServletResponse response) throws Exception{
        System.out.println(">>> SocialLoginCtrl kakaoLogin");
        System.out.println(code);
        Object object = kakaoService.socialLogin(code, response);
        System.out.println(object);
        return object;
    }

}
