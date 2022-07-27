package com.kbstar.daylog.place.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@ToString
@Component
public class PlaceInfoRes {
    private int placeIdx;
    private String placeName;
    private String category;
    private String loc1;
    private String loc2;
    private String address;
    private String log;
    private String lat;
    private String placeThumbnailPath;
}
