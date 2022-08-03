package com.kbstar.daylog.post.model.mapper;

import com.kbstar.daylog.post.model.vo.PostImageRes;
import com.kbstar.daylog.post.model.vo.PostInfoRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public PostInfoRes getPostById(int postIdx) throws Exception;
    public List<PostImageRes> getPostImagesById(int postIdx) throws Exception;
    public List<PostInfoRes> getPostListByPlace(Object place) throws Exception;
}
