package com.kbstar.daylog.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@NoArgsConstructor
@Getter
@ToString
@Component
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
