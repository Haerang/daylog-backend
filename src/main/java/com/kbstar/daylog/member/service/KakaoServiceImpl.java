package com.kbstar.daylog.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kbstar.daylog.member.model.mapper.MemberMapper;
import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.member.model.vo.MemberInfoRes;
import com.kbstar.daylog.member.model.vo.MemberMsgRes;
import com.kbstar.daylog.member.model.vo.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class KakaoServiceImpl implements SocialService{

    private final String REST_API_KEY = "04b4b2f469cd2781c1d21fb04f0dd933";
    private final String REDIRECT_URI = "http://10.10.223.31:8080/member/kakao/callback";
    private MemberInfoReq memberInfoReq = new MemberInfoReq();
    private MemberMsgRes memberMsgRes = new MemberMsgRes();

    private MemberMapper memberMapper;
    public KakaoServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public User socialLogin(String code, HttpServletResponse response) throws Exception {
        System.out.println(">>> kakaoServiceImpl socialLogin");

        if(response.getStatus()==HttpServletResponse.SC_OK) {
            // 1. 인가 코드를 가지고 액세스 토큰을 요청함
            String accessToken = getAccessToken(code);

            // 2. 액세스 토큰을 가지고 카카오 API를 호출함
            getKakaoUserInfo(accessToken);
            memberInfoReq.setAuthType("kakao");

            // 3. 카카오 ID로 회원가입을 처리한다
            // TODO: user가 없는지 확인해서 예외처리 해야함
            // 이 떄 비밀번호는 랜덤한 값으로 지정
            memberInfoReq.setPassword(UUID.randomUUID().toString());
            System.out.println(memberInfoReq);
            int flag = memberMapper.insertMember(memberInfoReq);
        }

            // 4. 강제로 로그인 처리를 한다.
                return memberMapper.findById(memberInfoReq.getId());

    }

    // 액세스 토큰을 가져오는 함수
    public String getAccessToken(String code) throws JsonProcessingException{
        System.out.println(">>> kakaoServiceImpl getAccessToken");
        // HTTP Header 생성
        org.springframework.http.HttpHeaders header = new HttpHeaders();
        header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", REST_API_KEY); // REST API 키
        body.add("redirect_uri", REDIRECT_URI);
        body.add("code", code);

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String >> kakaoTokenRequest = new HttpEntity<>(body, header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // HTTP 응답 받아서 JsonParser로 액세스 토큰 파싱하기(Gson 라이브러리 사용)
        String responseBody = response.getBody();
        JsonObject jsonElement = JsonParser.parseString(responseBody).getAsJsonObject();
        return jsonElement.get("access_token").getAsString();
    }

    // getAccessToken 함수에서 가져온 토큰으로 카카오 API 호출
    private void getKakaoUserInfo(String accessToken) throws JsonProcessingException{
        System.out.println(">>> kakaoServiceImpl getKaKaoUserInfo");
        System.out.println(accessToken);
        // HTTP Header 생성
        org.springframework.http.HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer " + accessToken);
        header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoUserInfoRequest,
                String.class
        );

        // 이메일 주소와 닉네임 정보를 꺼내서 MemberInfoRes 객체에 넣기 (jsonNode 이용해서 key value 읽어옴)
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        String email = jsonNode.get("kakao_account").get("email").asText();
        String nickname = jsonNode.get("properties").get("nickname").asText();

        memberInfoReq.setId(email);
        memberInfoReq.setNickname(nickname);
    }

}
