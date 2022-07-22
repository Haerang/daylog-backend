package com.kbstar.daylog.member.model.vo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberInfoReq {
    private int memberIdx;
    private String id;
    private String password;
    private String nickname;
    private String authType;
    private String token;
    private String memberCreatedDate;
    private String memberModifiedDate;

    public MemberInfoReq(int memberIdx, String id, String password, String nickname,
                         String authType, String token, String memberCreatedDate, String memberModifiedDate) {
        this.memberIdx = memberIdx;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.authType = authType;
        this.token = token;
        this.memberCreatedDate = memberCreatedDate;
        this.memberModifiedDate = memberModifiedDate;
    }
}
