package com.aloha.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.community.dto.Files;

@Mapper
public interface FilesMapper {

    // 파일  목록
    public List<Files> list() throws Exception;
    // 파일  조회
    public Files select(int no) throws Exception;
    // 파일  등록
    public int insert(Files files) throws Exception;
    // 파일  수정
    public int update(Files files) throws Exception;
    // 파일  삭제
    public int delete(int no) throws Exception;
    
    // 파일  번호(기본키) 최댓값
    public int maxPk() throws Exception;
    
}
