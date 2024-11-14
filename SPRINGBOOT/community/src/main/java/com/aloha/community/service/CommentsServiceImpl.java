package com.aloha.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.community.dto.Comments;
import com.aloha.community.mapper.CommentsMapper;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public List<Comments> list() throws Exception {
        List<Comments> commentsList = commentsMapper.list();
        return commentsList;
    }
    
    @Override
    public Comments select(String id) {
        Comments comments = commentsMapper.select(id);
        return comments;
    }

    @Override
    public int insert(Comments comments) throws Exception {
        int result = commentsMapper.insert(comments);
        return result;
    }

    @Override
    public int update(Comments comments) throws Exception {
        int result = commentsMapper.update(comments);
        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        int result = commentsMapper.delete(id);
        return result;
    }

    @Override
    public List<Comments> listByParent(int boardNo) throws Exception {
        List<Comments> commentsList = commentsMapper.listByParent(boardNo);
        return commentsList;
    }

    @Override
    public int deleteByParent(int boardNo) throws Exception {
        int result = commentsMapper.deleteByParent(boardNo);
        return result;
    }
    
}
