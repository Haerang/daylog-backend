package com.kbstar.daylog.place.controller;

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
@RequestMapping(value="/place")
public class PlaceCtrl {

    private final PlaceService placeService;
    private List<PlaceInfoRes> placeList;
    private final PlaceMsgRes placeMsgRes;
    private final String FAIL = "fail";
    private final String SUCCESS = "success";

    @GetMapping
    @ResponseBody
    public Object selectPlace(@RequestParam(value="idx") int placeIdx, ModelAndView modelAndView) throws Exception{
        System.out.println(">>>> placCtrl selectPlace");

        PlaceInfoRes selectedPlace = (PlaceInfoRes) placeService.getPlacebyId(placeIdx);

        modelAndView.setViewName("place");
        modelAndView.addObject("selectedPlace", selectedPlace);

        return modelAndView;
    }

    @PostMapping("/region")
    @ResponseBody
    public Object selectByRegion(@RequestBody PlaceInfoReq placeInfoReq) throws Exception{
        System.out.println(">>>> placeCtrl selectByRegion");
        placeList = (List<PlaceInfoRes>) placeService.getPlaceByRegion(placeInfoReq);

        if(Objects.isNull(placeList)){
            placeMsgRes.setResMsg(FAIL);
            return placeMsgRes;
        }

        return placeList;
    }
}
