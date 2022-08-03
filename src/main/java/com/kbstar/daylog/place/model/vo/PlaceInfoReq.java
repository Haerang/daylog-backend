package com.kbstar.daylog.place.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@ToString
@Component
public class PlaceInfoReq {
    private int placeIdx;
    private String category;
    private String loc1;
}
