package com.kbstar.daylog.place.model.mapper;

import com.kbstar.daylog.place.model.vo.PlaceInfoReq;
import com.kbstar.daylog.place.model.vo.PlaceInfoRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {
    // 장소 전체 조회
    public List<PlaceInfoRes> getAllPlaces() throws Exception;

    // 카테고리별 장소 조회
    public List<PlaceInfoRes> getPlacesByCategory() throws Exception;

    // 장소 단일 조회
    public PlaceInfoRes getPlaceById(int placeIdx) throws Exception;

    // 장소 추가
    public int insertPlace(PlaceInfoReq place) throws Exception;

    // 장소 정보 수정
    public int updatePlace(PlaceInfoReq place) throws Exception;

    // 장소 삭제
    public int deletePlace(int placeIdx) throws Exception;
}
