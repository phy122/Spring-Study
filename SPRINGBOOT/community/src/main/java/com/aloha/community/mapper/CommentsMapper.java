package com.aloha.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.community.dto.Comments;

@Mapper
public interface CommentsMapper {

    // 댓글 목록
    public List<Comments> list() throws Exception;
    // 댓글 조회
    public Comments select(int no) throws Exception;
    // 댓글 등록
    public int insert(Comments comments) throws Exception;
    // 댓글 수정
    public int update(Comments comments) throws Exception;
    // 댓글 삭제
    public int delete(int no) throws Exception;
    
    // 댓글 번호(기본키) 최댓값
    public int maxPk() throws Exception;
    
}
