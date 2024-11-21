package com.aloha.security_method.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aloha.security_method.domain.Board;
import com.aloha.security_method.domain.Option;
import com.aloha.security_method.domain.Page;
import com.aloha.security_method.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service    
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

   
    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = boardMapper.list(new Option(),new Page());
        return boardList;
    }

    @Override
    public Board select(String id) throws Exception {
        Board board = boardMapper.select(id);
        return board;        
    }

    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        return result;
    }

    @Override
    public int update(Board board) throws Exception {
        // 게시글 정보 수정
        int result = boardMapper.update(board);

        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        
        // 게시글 삭제
        int result = boardMapper.delete(id);

        return result;
    }

    // 검색
    @Override
    public List<Board> list(String keyword) throws Exception {
        // List<Board> boardList = boardMapper.list(keyword);
        Option option = new Option();
        option.setKeyword(keyword);
        List<Board> boardList = boardMapper.list(new Option(),new Page());
        return boardList;
    }
    // 검색+옵션
    @Override
    public List<Board> list(Option option) throws Exception {
        List<Board> boardList = boardMapper.list(option, new Page());
        return boardList;
    }

    @Override
    public List<Board> list(Option option, int rows) throws Exception {
        List<Board> boardList = boardMapper.list(option,new Page());
        return boardList;
    }

    @Override
    public List<Board> list(Option option, Page page) throws Exception {
        // 데이터 개수
        int total = count(option);
        page.setTotal(total);
        
        List<Board> boardList = boardMapper.list(option, page);

        return boardList;
    }

    @Override
    public int count(Option option) throws Exception {
        return boardMapper.count(option);
    }


}
