package com.kbstar.daylog.post.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@ToString
@Component
public class PostImageRes {
    private int imageIdx;
    private String imagePath;
}
