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
    public Comments select(int no) throws Exception {
        Comments comments = commentsMapper.select(no);
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
    public int delete(int no) throws Exception {
        int result = commentsMapper.delete(no);
        return result;
    }
    
}
