package com.kbstar.daylog.post.controller;

import com.kbstar.daylog.place.model.vo.PlaceInfoReq;
import com.kbstar.daylog.post.model.vo.PostImageRes;
import com.kbstar.daylog.post.model.vo.PostInfoRes;
import com.kbstar.daylog.post.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostCtrl {

    private final PostServiceImpl postService;
    private List<PostInfoRes> postList;

    @GetMapping(value="/post")
    @ResponseBody
    public Object selectPost(@RequestParam(value="idx") int postIdx, ModelAndView modelAndView) throws Exception{
        System.out.println(">>> postCtrl selctPost");

        PostInfoRes selectedPost = (PostInfoRes) postService.getPostById(postIdx);
        List<PostImageRes> postImageList = (List<PostImageRes>) postService.getPostImagesById(postIdx);
        String nlString = System.getProperty("line.separator").toString();

        modelAndView.setViewName("post");
        modelAndView.addObject("selectedPost", selectedPost);
        modelAndView.addObject("postImageList", postImageList);

        return modelAndView;
    }

    @PostMapping("place/posting")
    @ResponseBody
    public Object selectPostByPlaceIdx(@RequestBody PlaceInfoReq placeInfoReq) throws Exception{
        System.out.println(">>>>> placeCtrl selectPostByPlaceIdx");
        postList = (List<PostInfoRes>) postService.getPostListByPlace(placeInfoReq);
        System.out.println(postList);
        return postList;
    }
}
