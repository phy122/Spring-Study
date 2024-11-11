package com.aloha.spring_request.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Board 
 * - 게시글 정보
 */
@NoArgsConstructor
@Data
public class Board {
    private int boardNo;        
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;
    
    public Board(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
    
}