package com.aloha.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.community.dto.Board;
import com.aloha.community.dto.Files;
import com.aloha.community.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service    
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileService fileService;
   
    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = boardMapper.list();
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

        List<MultipartFile> fileList = board.getFileList();

        if(fileList != null)
            for (MultipartFile file : fileList) {
                Files uploadFile = new Files();
                uploadFile.setFile(file);
                uploadFile.setParentTable("board");
                uploadFile.setParentNo(board.getNo());
                uploadFile.setType("main");
                fileService.upload(uploadFile);
            }
        return result;
    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        int result = boardMapper.delete(id);
        return result;
    }


}
