package com.aloha.security_method.domain;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Comments {

    private Long no;
    private String id;
    private Long boardNo;
    private Long parentNo;
    private String writer;
    private Long userNo;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Comments() {
        this.id = UUID.randomUUID().toString();
    }

    
}
