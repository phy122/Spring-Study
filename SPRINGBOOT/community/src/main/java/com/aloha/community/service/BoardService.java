package com.aloha.community.service;

import java.util.List;

import com.aloha.community.dto.Board;

public interface BoardService {

    
    public List<Board> list() throws Exception;
    
    public Board select(String id) throws Exception;
    
    public int insert(Board board) throws Exception;
    
    public int update(Board board) throws Exception;
    
    public int delete(String id) throws Exception;
    
}
