package com.aloha.security_method.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.aloha.security_method.domain.Board;
import com.aloha.security_method.domain.CustomUser;
import com.aloha.security_method.domain.Files;
import com.aloha.security_method.domain.Option;
import com.aloha.security_method.domain.Page;
import com.aloha.security_method.domain.Users;
import com.aloha.security_method.service.BoardService;
import com.aloha.security_method.service.FileService;
import com.aloha.security_method.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j                      
@Controller                 
@RequestMapping("/board")   
                            
public class BoardController {
    
    @Autowired                              
    private BoardService boardService;      

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model
                    // , @RequestParam(name = "keyword", defaultValue = "") String keyword
                    , Option option
                    // , @RequestParam(name = "rows", defaultValue = "10") 
                       , Page page
                    ) throws Exception {

        List<Board> boardList = boardService.list(option, page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("option", option);
        model.addAttribute("rows", page.getRows());
        model.addAttribute("page", page);

        String pageUrl =UriComponentsBuilder.fromPath("/board/list")
                            // .queryParam("page", page.getPage())
                            .queryParam("keyword", option.getKeyword())
                            .queryParam("code", option.getCode())
                            .queryParam("rows", page.getRows())
                            .queryParam("orderCode", option.getOrderCode())
                            .build()
                            .toUriString();

        model.addAttribute("pageUrl", pageUrl);

        return "/board/list";       
    }
    

    @GetMapping("/read")
    public String read(@RequestParam("id") String id, Model model, Files file) throws Exception {
        Board board = boardService.select(id);

        model.addAttribute("board", board);

        // 파일 목록 조회
        file.setParentNo(board.getNo());
        file.setParentTable("board");
        List<Files> fileList = fileService.listByParent(file);
        model.addAttribute("fileList", fileList);
        
        return "/board/read";
    }
    

    @GetMapping("/insert")
    public String insert() {

        return "/board/insert";
    }


    @PostMapping("/insert")
    public String insertPro(@AuthenticationPrincipal CustomUser authUser, Board board) throws Exception {
        log.info("board : " + board);
        Users user = userService.select(authUser.getUsername());
        board.setUserNo(user.getNo());
        int result = boardService.insert(board);
        if( result > 0 ) {
            return "redirect:/board/list";
        }
        return "redirect:/board/insert?error";  
    }
    

    @GetMapping("/update")
    public String update(@RequestParam("id") String id, Model model, Files file) throws Exception {
        Board board = boardService.select(id);
        model.addAttribute("board", board);

         // 파일 목록 조회
         file.setParentNo(board.getNo());
         file.setParentTable("board");
         List<Files> fileList = fileService.listByParent(file);
         model.addAttribute("fileList", fileList);
         
        return "/board/update";
    }


    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        int result = boardService.update(board);

        if( result > 0 ) {
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error&id="+board.getId();
    }
    

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id) throws Exception {
        int result = boardService.delete(id);
        if( result > 0 ) {
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error&id="+id;
    }
    
    
}

