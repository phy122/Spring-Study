package com.aloha.security_method.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Files {

    private Long no;
    private String id;
    private String fileName;
    private String filePath;
    private Long fileSize;
    private String type;
    private String parentTable;
    private Long parentNo;
    private Date createdAt;
    private Date updatedAt;

    private MultipartFile file;     // 파일

    public Files() {
        this.id = UUID.randomUUID().toString();
    }

    
    
}
