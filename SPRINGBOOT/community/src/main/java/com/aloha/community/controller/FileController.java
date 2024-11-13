package com.aloha.community.controller;

import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.community.dto.Files;
import com.aloha.community.service.FileService;
import com.aloha.community.util.MediaUtil;


@Slf4j
@Controller
public class FileController {
    
    @Autowired
    private FileService fileService;

    @GetMapping("/img")
    public ResponseEntity<byte[]> thumbnail(@RequestParam("id") String id) throws Exception {
        Files file = fileService.select(id);

        String filePath = file.getFilePath();
        // 파일 객체 생성
        File f = new File(filePath);
        
        // 파일 데이터
        byte[] fileData = FileCopyUtils.copyToByteArray(f);

        // 컨텐츠 타입 지정
        String ext = filePath.substring( filePath.lastIndexOf(".") + 1); // 확장자
        MediaType mediaType = MediaUtil.getMediaType(ext);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }
    
}
