package com.aloha.security5.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class HomeController {
    
    /***
     * 메인 화면
     * @return
     */
    @GetMapping({"", "/"})
    public String home() {

        return "index";
    }
    
}
