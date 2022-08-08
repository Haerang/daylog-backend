package com.kbstar.daylog.place.service;

import com.kbstar.daylog.place.model.vo.HistoryReq;

public interface PlaceService {
    public Object getPlacebyId(int placeIdx) throws Exception;
    public int checkSavePlace(Object history) throws Exception;
    public Object getPlaceIf(Object place) throws Exception;
    public int savePlace(Object history) throws Exception;
    public int deleteSavedPlace(Object history) throws Exception;
    public Object getSavedPlaces(Object member) throws Exception;
}
