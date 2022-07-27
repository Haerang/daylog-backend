package com.kbstar.daylog.index.service;

import com.kbstar.daylog.index.model.mapper.IndexMapper;
import com.kbstar.daylog.index.model.vo.IndexPlaceRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService{
    private IndexMapper indexMapper;

    public IndexServiceImpl(IndexMapper indexMapper){
        this.indexMapper = indexMapper;
    }

    @Override
    public Object getFirstIndexPlaces() throws Exception {
        System.out.println(">>> indexService getFirstIndexPlaces");
        return indexMapper.getFirstIndexPlaces();
    }

    @Override
    public Object getSecondIndexPlaces() throws Exception {
        System.out.println(">>> indexService getSecondIndexPlaces");
        return indexMapper.getSecondIndexPlaces();
    }

    @Override
    public Object getIndexPosts() throws Exception {
        System.out.println(">>> indexService getAllMembers");
        return indexMapper.getIndexPosts();
    }
}
