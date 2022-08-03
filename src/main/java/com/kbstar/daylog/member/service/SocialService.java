package com.kbstar.daylog.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletResponse;

public interface SocialService {
    // 로그인
    public Object socialLogin(String code, HttpServletResponse response) throws Exception;
}
