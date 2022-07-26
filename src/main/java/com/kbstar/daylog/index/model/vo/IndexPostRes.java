package com.kbstar.daylog.index.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@ToString
@Component
public class IndexPostRes {
    private int postIdx;
    private int placeIdx;
    private int memberIdx;
    private String postThumbnailPath;
    private String title;
    private String content;
}
