package com.aloha.spring_response.dto;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;

    // ctrl + .: 추가작업 단축키
    // 기본 생성자
    public Person() {
         this.name = "aloha";
         this.age = 20;
    }

    
}
