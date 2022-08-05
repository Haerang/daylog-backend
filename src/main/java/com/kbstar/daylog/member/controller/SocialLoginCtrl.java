package com.kbstar.daylog.member.controller;

import com.kbstar.daylog.common.jwt.JwtTokenProvider;
import com.kbstar.daylog.member.model.vo.MemberMsgRes;
import com.kbstar.daylog.member.service.KakaoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class SocialLoginCtrl {
    private final String FAIL = "fail";
    private final KakaoServiceImpl kakaoService;

    @GetMapping("member/kakao/callback")
    public Object kakaoLogin(@RequestParam String code, HttpServletResponse response) throws Exception{
        System.out.println(">>> SocialLoginCtrl kakaoLogin");
        System.out.println(code);
        Object object = kakaoService.socialLogin(code, response);
        System.out.println(object);
        return object;
    }

}
