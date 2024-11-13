package com.aloha.community.service;

import java.util.List;

import com.aloha.community.dto.Comments;

public interface CommentsService {

    public List<Comments> list() throws Exception;

    public Comments select(int no) throws Exception;

    public int insert(Comments comments) throws Exception;

    public int update(Comments comments) throws Exception;

    public int delete(int no) throws Exception;
    
}
