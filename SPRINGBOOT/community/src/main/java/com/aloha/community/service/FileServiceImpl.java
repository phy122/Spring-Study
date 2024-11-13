package com.aloha.community.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.community.dto.Files;
import com.aloha.community.mapper.FileMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Value("${upload.path}")        // application.properties 에서 지정한 업로드 경로 가져옴
    private String uploadPath;

    @Override
    public List<Files> list() throws Exception {
        List<Files> fileList = fileMapper.list();
        return fileList;
    }

    @Override
    public Files select(String id) throws Exception {
        Files file = fileMapper.select(id);
        return file;
    }

    @Override
    public int insert(Files file) throws Exception {
        int result = fileMapper.insert(file);
        return result;
    }

    @Override
    public int update(Files file) throws Exception {
        int result = fileMapper.update(file);
        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        int result = fileMapper.delete(id);
        return result;
    }

    @Override
    public boolean upload(Files file) throws Exception {
       log.info("file : " + file);

       // 파일 정보
       MultipartFile mf = file.getFile();
       String origninName = mf.getOriginalFilename();
       long fileSize = mf.getSize();
       byte[] fileData = mf.getBytes();

       log.info("원본파일명 : " + origninName);
       log.info("파일용량 : " + fileSize);
       log.info("파일데이터 : " + fileData);

       // 파일 업로드
       // 파일 데이터를 업로드 경로에 복사
       // 업로드된 파일 정보를 DB 에 등록

       // 파일 복사
       // * 파일명 중복 방지 : 파일명 앞에 날짜데이터 또는 UID 를 붙여준다.
       String fileName = UUID.randomUUID().toString() + "_" + origninName;
       File uploadFile = new File(uploadPath, fileName);
       // 파일 경로 : C:/upload/UID_강아지.png
       // FileCopyUtils.copy(파일데이터, 파일객체);
       FileCopyUtils.copy(fileData, uploadFile);        // 파일 업로드
       
       // DB 등록
       file.setFileName(fileName);
       file.setFilePath(uploadFile.getPath());
       file.setFileSize(fileSize);

       fileMapper.insert(file);

       return true;
    }

    @Override
    public List<Files> listByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.listByParent(file);
        return fileList;
    }
}