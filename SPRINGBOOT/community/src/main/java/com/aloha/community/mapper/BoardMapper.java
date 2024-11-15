package com.aloha.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.community.dto.Board;
import com.aloha.community.dto.Option;
import com.aloha.community.dto.Page;

@Mapper
public interface BoardMapper {


    // public List<Board> list() throws Exception;
    // public List<Board> list(String keyword) throws Exception;
    // public List<Board> list(@Param("option") Option option
    //                         ,@Param("rows") int rows) throws Exception;
    public List<Board> list(@Param("option") Option option
                            ,@Param("page") Page page) throws Exception;
    
    public Board select(@Param("id") String id) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;

    public int delete(String id) throws Exception;
    
    public int maxPk() throws Exception;

    // 데이터 개수
    public int count(@Param("option") Option option) throws Exception;
    
}