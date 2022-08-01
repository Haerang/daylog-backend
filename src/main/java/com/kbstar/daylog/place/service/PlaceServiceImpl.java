package com.kbstar.daylog.place.service;

import com.kbstar.daylog.place.model.mapper.PlaceMapper;
import org.springframework.stereotype.Service;

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

}
