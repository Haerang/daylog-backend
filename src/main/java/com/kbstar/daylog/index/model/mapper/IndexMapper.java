package com.kbstar.daylog.index.model.mapper;

import com.kbstar.daylog.index.model.vo.IndexPlaceRes;
import com.kbstar.daylog.index.model.vo.IndexPostRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexMapper {
    // Index 화면 Place 조회
    public List<IndexPlaceRes> getFirstIndexPlaces() throws Exception;
    public List<IndexPlaceRes> getSecondIndexPlaces() throws Exception;

    // Index 화면 Post 조회
    public List<IndexPostRes> getIndexPosts() throws Exception;
}
