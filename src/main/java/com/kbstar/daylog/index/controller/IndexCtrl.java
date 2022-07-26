package com.kbstar.daylog.index.controller;

import com.kbstar.daylog.index.model.vo.IndexPlaceRes;
import com.kbstar.daylog.index.model.vo.IndexPostRes;
import com.kbstar.daylog.index.service.IndexServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class IndexCtrl {

    private final IndexServiceImpl indexService;
    private final IndexPlaceRes indexPlaceRes;
    private final IndexPostRes indexPostRes;

    @GetMapping("/")
    public String index(Model model) throws Exception{
        System.out.println(">>> indexCtrl index");

        Object placeList = indexService.getIndexPlaces();
        Object postList = indexService.getIndexPosts();

        model.addAttribute("indexPlace", placeList);
        model.addAttribute("indexPost", postList);

        // index로 이동
        return "index";
    }

}
