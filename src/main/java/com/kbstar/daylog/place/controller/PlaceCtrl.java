package com.kbstar.daylog.place.controller;

import com.kbstar.daylog.place.model.vo.HistoryReq;
import com.kbstar.daylog.place.model.vo.PlaceInfoReq;
import com.kbstar.daylog.place.model.vo.PlaceInfoRes;
import com.kbstar.daylog.place.model.vo.PlaceMsgRes;
import com.kbstar.daylog.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class PlaceCtrl {

    private final PlaceService placeService;
    private List<PlaceInfoRes> placeList;
    private final PlaceMsgRes placeMsgRes;
    private final String FAIL = "fail";
    private final String SUCCESS = "success";

    @GetMapping(value="/place")
    @ResponseBody
    public Object selectPlace(@RequestParam(value="idx") int placeIdx, ModelAndView modelAndView) throws Exception{
        System.out.println(">>>> placeCtrl selectPlace");

        PlaceInfoRes selectedPlace = (PlaceInfoRes) placeService.getPlacebyId(placeIdx);

        modelAndView.setViewName("place");
        modelAndView.addObject("selectedPlace", selectedPlace);

        return modelAndView;
    }

    @PostMapping("place/check")
    @ResponseBody
    public int checkSavePlace(@RequestBody HistoryReq historyReq) throws Exception{
        System.out.println(">>>> placeCtrl checkSavePlace");

        int flag = placeService.checkSavePlace(historyReq);

        // 만약 넘어온 flag가 0이면 save, 1이면 delete
        if(flag > 0)
            flag = 1;

        System.out.println(">>>> placeCtrl check : " + flag);

        return flag;
    }

    @PostMapping("mobile/place/region")
    @ResponseBody
    public Object selectByRegion(@RequestBody PlaceInfoReq placeInfoReq) throws Exception{
        System.out.println(">>>> placeCtrl selectByRegion");
        placeList = (List<PlaceInfoRes>) placeService.getPlaceIf(placeInfoReq);

        if(Objects.isNull(placeList)){
            placeMsgRes.setResMsg(FAIL);
            return placeMsgRes;
        }

        return placeList;
    }

    @PostMapping("place/save")
    @ResponseBody
    public int savePlace(@RequestBody HistoryReq historyReq) throws Exception{
        System.out.println(">>> placeCtrl savePlace");

        int result = -1;

        // 만약 넘어온 flag가 0이면 save, 1이면 delete
        if(historyReq.getFlag()==0) {
            result = placeService.savePlace(historyReq);
        }else if(historyReq.getFlag()==1) {
            result = placeService.deleteSavedPlace(historyReq);
            if(result != -1){
                result = 1;
            }
        }

        System.out.println(">>>>>> placeCtrl result : " + result);
        return result;
    }

}
