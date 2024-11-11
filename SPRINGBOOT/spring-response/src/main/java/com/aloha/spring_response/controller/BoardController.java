package com.aloha.spring_response.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aloha.spring_response.dto.Board;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



// 게시글 목록/조회
// [GET] - /board/list  - /board/list.html
// [GET] - /board/read  - /board/read.html

// 게시글 등록
// [GET] - /board/insert  - /board/insert.html
// [POST] - /board/insert  - redirect:/board/list

// 게시글 수정
// [GET] - /board/update  - /board/update.html
// [POST] - /board/update  - redirect:/board/list

// 게시글 삭제
// [POST] - /board/delete  - redirect:/board/list

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {
    
    @GetMapping("/list")
    public String list(Model model) {

       List<Board> boardList = new ArrayList<>();
        boardList.add(Board.builder().title("제목1").writer("작성자1").content("내용1").build());
        boardList.add(Board.builder().title("제목2").writer("작성자2").content("내용2").build());
        boardList.add(Board.builder().title("제목3").writer("작성자3").content("내용3").build());

        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    /**
     * /board/update?no=10
     * @return
     */
    @GetMapping("/read")
    public String read(Model model, @RequestParam("no") int no) {   
        log.info("no : " + no); 
        Board board = Board.builder()
                            .no(no)
                            .title("제목")
                            .writer("작성자")
                            .content("내용")
                            .build();
        model.addAttribute("board",board);
        return "board/read";
    }

    @GetMapping("/insert")
    public String insert() {    
        return "board/insert";
    }

    @GetMapping("/insert")
    public String insertPost(Board board) {    
        log.info("board : " + board);
        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam("no") int no) {   
        log.info("no : " + no); 
        Board board = Board.builder()
                            .no(no)
                            .title("제목")
                            .writer("작성자")
                            .content("내용")
                            .build();
        model.addAttribute("board",board);   
        return "board/update";
    }

    @GetMapping("/update")
    public String updatePost(Board board) {    
        log.info("board : " + board);
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam("no") int no) {    
        log.info("no : " + no);
        return "redirect:/board/list";
    }

    @ResponseBody
    @PutMapping("")
    public ResponseEntity<String> putUpdate(@RequestBody Board board) {
        
        return ResponseEntity.ok("SUCCESS");
    }

    @ResponseBody
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("no") int no){
        return ResponseEntity.ok("SUCCESS");
    }
    
}
