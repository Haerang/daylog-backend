package com.kbstar.daylog.post.service;

import com.kbstar.daylog.post.model.mapper.PostMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    private PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    @Override
    public Object getPostById(int postIdx) throws Exception {
        System.out.println(">>>>> postService getPostById");
        return postMapper.getPostById(postIdx);
    }

    @Override
    public Object getPostImagesById(int postIdx) throws Exception {
        System.out.println(">>>>> postService getPostImagesById");
        return postMapper.getPostImagesById(postIdx);
    }

    @Override
    public Object getPostListByPlace(Object place) throws Exception {
        System.out.println(">>>> postService getPostListByPlace");
        return postMapper.getPostListByPlace(place);
    }
}
