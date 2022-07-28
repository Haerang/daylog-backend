package com.kbstar.daylog.post.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@ToString
@Component
public class PostInfoRes {
    private int postIdx;
    private String postThumbnailPath;
    private String title;
    private String content;
    private String nickname;
}
