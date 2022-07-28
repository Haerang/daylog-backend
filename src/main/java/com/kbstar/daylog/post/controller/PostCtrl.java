package com.kbstar.daylog.post.controller;

import com.kbstar.daylog.post.model.vo.PostImageRes;
import com.kbstar.daylog.post.model.vo.PostInfoRes;
import com.kbstar.daylog.post.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/post")
public class PostCtrl {
    private final PostServiceImpl postService;

    @GetMapping
    @ResponseBody
    public Object selectPost(@RequestParam(value="idx") int postIdx, ModelAndView modelAndView) throws Exception{
        System.out.println(">>> postCtrl register");

        PostInfoRes selectedPost = (PostInfoRes) postService.getPostById(postIdx);
        List<PostImageRes> postImageList = (List<PostImageRes>) postService.getPostImagesById(postIdx);
        modelAndView.setViewName("post");
        modelAndView.addObject("selectedPost", selectedPost);
        modelAndView.addObject("postImageList", postImageList);

        return modelAndView;
    }
}
