package com.aloha.community.dto;

import java.lang.reflect.Type;
import java.util.Date;

import lombok.Data;

@Data
public class Files {

    private int no;
    private String id;
    private String fileName;
    private String filePath;
    private int fileSize;
    private Type type;
    private int parentNo;
    private Date createdAt;
    private Date updatedAt;
    
}
