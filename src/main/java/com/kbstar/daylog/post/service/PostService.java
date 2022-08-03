package com.kbstar.daylog.post.service;

import org.springframework.stereotype.Service;

public interface PostService {
    public Object getPostById(int postIdx) throws Exception;
    public Object getPostImagesById(int postIdx) throws Exception;
    public Object getPostListByPlace(Object place) throws Exception;
}
