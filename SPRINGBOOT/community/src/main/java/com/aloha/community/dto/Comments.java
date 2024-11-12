package com.aloha.community.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comments {

    private int no;
    private String id;
    private int boardNo;
    private String writer;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
