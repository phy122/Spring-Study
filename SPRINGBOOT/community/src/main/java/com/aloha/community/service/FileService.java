package com.aloha.community.service;

import java.util.List;

import com.aloha.community.dto.Files;


public interface FileService {

    public List<Files> list() throws Exception;

    public Files select(String id) throws Exception;

    public int insert(Files files) throws Exception;

    public int update(Files files) throws Exception;

    public int delete(String id) throws Exception;

    // 파일 업로드
    public boolean upload(Files file) throws Exception;

    // 부모 테이블 기준 파일 목록
    public List<Files> listByParent(Files file) throws Exception;
    
}
