package com.kbstar.daylog.place.controller;

import com.kbstar.daylog.place.model.vo.PlaceInfoRes;
import com.kbstar.daylog.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/place")
public class PlaceCtrl {

    private final PlaceService placeService;

    @GetMapping
    @ResponseBody
    public Object selectPlace(@RequestParam(value="idx") int placeIdx, ModelAndView modelAndView) throws Exception{
        System.out.println(">>>> placCtrl selectPlace");

        PlaceInfoRes selectedPlace = (PlaceInfoRes) placeService.getPlacebyId(placeIdx);

        modelAndView.setViewName("place");
        modelAndView.addObject("selectedPlace", selectedPlace);

        return modelAndView;
    }
}
