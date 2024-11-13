package com.aloha.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.community.dto.Board;

@Mapper
public interface BoardMapper {


    public List<Board> list() throws Exception;

    public Board select(@Param("id") String id) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;

    public int delete(String id) throws Exception;
    
    public int maxPk() throws Exception;
    
}