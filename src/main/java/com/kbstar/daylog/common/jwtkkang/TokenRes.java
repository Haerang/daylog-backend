package com.kbstar.daylog.common.jwtkkang;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public final class TokenRes {
    private String token;
}
