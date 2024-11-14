package com.aloha.community.service;

import java.util.List;

import com.aloha.community.dto.Comments;

public interface CommentsService {

    public List<Comments> list() throws Exception;

    public Comments select(String id);

    public int insert(Comments comments) throws Exception;

    public int update(Comments comments) throws Exception;

    public int delete(String id) throws Exception;
    
    // 부모 기준 댓글 목록
    public List<Comments> listByParent(int boardNo) throws Exception;

    // 부모 기준 댓글 삭제
    public int deleteByParent(int boardNo) throws Exception;
    
}
