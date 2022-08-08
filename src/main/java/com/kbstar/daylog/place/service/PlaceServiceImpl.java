package com.kbstar.daylog.place.service;

import com.kbstar.daylog.member.model.vo.MemberInfoReq;
import com.kbstar.daylog.place.model.mapper.PlaceMapper;
import com.kbstar.daylog.place.model.vo.HistoryReq;
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
    public int checkSavePlace(Object history) throws Exception {
        System.out.println(">>>> placeService checkSave");
        return placeMapper.checkSavePlace((HistoryReq) history);
    }

    @Override
    public Object getPlaceIf(Object place) throws Exception {
        System.out.println(">>>> placeService getPlaceByRegion");
        final List<PlaceInfoRes> placeList = placeMapper.getPlaceIf((PlaceInfoReq) place);
        return placeList;
    }

    @Override
    public int savePlace(Object history) throws Exception {
        System.out.println(">>>> placeService savePlace");
        return placeMapper.savePlace((HistoryReq) history);
    }

    @Override
    public int deleteSavedPlace(Object history) throws Exception {
        System.out.println(">>>>> placeService deleteSavedPlace");
        return placeMapper.deleteSavedPlace((HistoryReq) history);
    }

    @Override
    public Object getSavedPlaces(Object member) throws Exception {
        System.out.println(">>>>>> placeService getSavedPlace");
        return placeMapper.getSavedPlaces((MemberInfoReq) member);
    }

}
