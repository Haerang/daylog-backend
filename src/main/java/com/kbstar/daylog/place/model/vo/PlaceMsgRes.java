package com.kbstar.daylog.place.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public class PlaceMsgRes {
    private String resMsg = "success";
}
