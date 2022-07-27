package com.kbstar.daylog.index.service;

public interface IndexService {
    // Place 조회
    public Object getFirstIndexPlaces() throws Exception;
    public Object getSecondIndexPlaces() throws Exception;

    // Post 조회
    public Object getIndexPosts() throws Exception;
}
