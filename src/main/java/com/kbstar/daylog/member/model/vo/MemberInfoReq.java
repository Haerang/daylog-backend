package com.kbstar.daylog.member.model.vo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Slf4j
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
public class MemberInfoReq {
    private String idx;
    private String id;
    private String password;
    private String nickname;
    private String authType;
    private String token;

    public MemberInfoReq(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }

    public MemberInfoReq(String id, String password){
        this.id = id;
        this.password = password;
    }

    public MemberInfoReq(String id, String password, String nickname,
                         String authType, String token) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.authType = authType;
        this.token = token;
    }
}
