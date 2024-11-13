package com.aloha.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.community.dto.Board;
import com.aloha.community.dto.Comments;
import com.aloha.community.dto.Files;
import com.aloha.community.service.BoardService;
import com.aloha.community.service.CommentsService;
import com.aloha.community.service.FileService;

import lombok.extern.slf4j.Slf4j;


@Slf4j                      
@Controller                 
@RequestMapping("/board")   
                            
public class BoardController {
    
    @Autowired                              
    private BoardService boardService;      

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private FileService fileService;

    @GetMapping("/list")
    public String list(Model model) throws Exception {

        List<Board> boardList = boardService.list();

        model.addAttribute("boardList", boardList);

        return "/board/list";       
    }
    

    @GetMapping("/read")
    public String read(@RequestParam("id") String id, Model model, Files file) throws Exception {
        Board board = boardService.select(id);
        List<Comments> commentsList = commentsService.list();

        model.addAttribute("board", board);
        model.addAttribute("commentsList", commentsList);

        // 파일 목록 조회
        file.setParentNo(board.getNo());
        file.setParentTable("board");
        List<Files> fileList = fileService.listByParent(file);
        model.addAttribute("fileList", fileList);
        
        return "/board/read";
    }

    @PostMapping("/addComments")
    public String addComments(@RequestParam("id") String id, Model model, Comments comments) throws Exception {

        commentsService.insert(comments);

        Board board = boardService.select(id);
        List<Comments> commentsList = commentsService.list();
        model.addAttribute("board", board);
        model.addAttribute("commentsList", commentsList);
        return "/board/read";
    }

    @PostMapping("/deleteComments")
    public String deleteComments(@RequestParam("id") String id, Model model, Comments comments) throws Exception {

        commentsService.delete(comments.getNo());

        Board board = boardService.select(id);
        List<Comments> commentsList = commentsService.list();
        model.addAttribute("board", board);
        model.addAttribute("commentsList", commentsList);
        return "/board/read";
    }

    @PostMapping("/updateComments")
    public String updateComments(@RequestParam("id") String id, Model model, Comments comments) throws Exception {

        commentsService.update(comments);

        Board board = boardService.select(id);
        List<Comments> commentsList = commentsService.list();
        model.addAttribute("board", board);
        model.addAttribute("commentsList", commentsList);
        return "/board/read";
    }
    

    @GetMapping("/insert")
    public String insert() {

        return "/board/insert";
    }


    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        log.info("board : " + board);
        int result = boardService.insert(board);
        if( result > 0 ) {
            return "redirect:/board/list";
        }
        return "redirect:/board/insert?error";  
    }
    

    @GetMapping("/update")
    public String update(@RequestParam("id") String id, Model model) throws Exception {
        Board board = boardService.select(id);
        model.addAttribute("board", board);
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
