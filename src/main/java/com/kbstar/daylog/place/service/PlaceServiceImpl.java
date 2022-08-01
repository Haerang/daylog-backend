package com.kbstar.daylog.place.service;

import com.kbstar.daylog.place.model.mapper.PlaceMapper;
import com.kbstar.daylog.place.model.vo.PlaceInfoReq;
import com.kbstar.daylog.place.model.vo.PlaceInfoRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService{
    private PlaceMapper placeMapper;

    public PlaceServiceImpl(PlaceMapper placeMapper){
        this.placeMapper = placeMapper;
    }

    @Override
    public Object getPlacebyId(int placeIdx) throws Exception{
        System.out.println(">>> placeService getPlaceById");
        return placeMapper.getPlaceById(placeIdx);
    }

    @Override
    public Object getPlaceByRegion(Object place) throws Exception {
        System.out.println(">>>> placeService getPlaceByRegion");
        final List<PlaceInfoRes> placeList = placeMapper.getPlaceByRegion((PlaceInfoReq) place);
        return placeList;
    }

}
