package com.kbstar.daylog.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import com.kbstar.daylog.member.service.KakaoServiceImpl;
import com.kbstar.daylog.member.service.SocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class SocialLoginCtrl {
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
