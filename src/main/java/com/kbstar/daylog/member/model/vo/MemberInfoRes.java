package com.kbstar.daylog.member.model.vo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class MemberInfoRes {
    private int memberIdx;
    private String id;
    private String password;
    private String nickname;
    private String authType;
    private String token;
    private String memberCreatedDate;
    private String memberModifiedDate;
}
