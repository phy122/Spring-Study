package com.aloha.security_method.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.security_method.domain.Comments;
import com.aloha.security_method.mapper.CommentsMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
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
        log.info(comments.toString());
        // 답글 등록
        int result = commentsMapper.insert(comments);

        // 댓글 등록
        // : 댓글 번호를 부모 댓글 번호로 수정 (no = parent_no)
        Long parentNo = comments.getParentNo();
        if(parentNo == 0){
            comments.setParentNo(comments.getNo());
            commentsMapper.update(comments);

        }

        return result;
    }

    @Override
    public int update(Comments comments) throws Exception {
        String id = comments.getId();
        String updatedWriter = comments.getWriter();
        String updatedContent = comments.getContent();
        comments = commentsMapper.select(id);

        comments.setWriter(updatedWriter);
        comments.setContent(updatedContent);
        int result = commentsMapper.update(comments);
        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        int result = 0;
        Comments deletedComment = commentsMapper.select(id);

        // 답글 삭제
        Long parentNo = deletedComment.getNo();
        Long no = deletedComment.getParentNo();
        if(no == parentNo){
            commentsMapper.deleteReplyByParent(parentNo);
        }
        else{
            // 댓글 삭제
            result = commentsMapper.delete(id);
        }

        // 댓글 삭제
        result = commentsMapper.delete(id);
        return result;
    }

    @Override
    public List<Comments> listByParent(Long boardNo) throws Exception {
        List<Comments> commentsList = commentsMapper.listByParent(boardNo);
        return commentsList;
    }

    @Override
    public int deleteByParent(Long boardNo) throws Exception {
        int result = commentsMapper.deleteByParent(boardNo);
        return result;
    }

    @Override
    public List<Comments> replyList(Long parentNo) throws Exception {
        List<Comments> replyList = commentsMapper.replyList(parentNo);
        return replyList;
    }

    @Override
    public int deleteReplyByParent(Long parentNo) throws Exception {
        int result = commentsMapper.deleteReplyByParent(parentNo);
        return result;
    }
    
}
