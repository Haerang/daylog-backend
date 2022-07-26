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
    public Object getIndexPlaces() throws Exception {
        System.out.println(">>> indexService getMainPlaces");
        return indexMapper.getIndexPlaces();
    }

    @Override
    public Object getIndexPosts() throws Exception {
        System.out.println(">>> indexService getAllMembers");
        return indexMapper.getIndexPosts();
    }
}
