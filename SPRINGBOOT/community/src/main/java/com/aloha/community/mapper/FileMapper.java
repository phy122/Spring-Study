package com.aloha.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.community.dto.Files;

@Mapper
public interface FileMapper {

    // 파일  목록
    public List<Files> list() throws Exception;
    // 파일  조회
    public Files select(String id) throws Exception;
    // 파일  등록
    public int insert(Files files) throws Exception;
    // 파일  수정
    public int update(Files files) throws Exception;
    // 파일  삭제
    public int delete(String id) throws Exception;

    // 부모 테이블 기준 파일 목록
    public List<Files> listByParent(Files file) throws Exception;
    
}
