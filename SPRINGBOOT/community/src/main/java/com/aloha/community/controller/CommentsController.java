package com.aloha.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aloha.community.dto.Comments;
import com.aloha.community.service.CommentsService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Slf4j
@Controller
@RequestMapping("/comment")
public class CommentsController {


    @Autowired
    private CommentsService commentsService;

    @ResponseBody
    @PostMapping("")
    public String commentPost(@RequestBody Comments comment) throws Exception{
        int result = commentsService.insert(comment);
        if(result > 0)
            return "SUCCESS";
        return "FAIL";
    }

    @GetMapping("")
    public String commentList(Model model, @RequestParam("boardNo") int boardNo) throws Exception{
        List<Comments> commentList = commentsService.listByParent(boardNo);
        model.addAttribute("commentList", commentList);
        return "/comment/list";
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable("id") String id) throws Exception{
        log.info("id : " + id);
        int result = commentsService.delete(id);

        if(result > 0)
            return "SUCCESS";

        return "FAIL";
    }

    @ResponseBody
    @PutMapping("")
    public String updateComment(@RequestBody Comments comment) throws Exception {
        int result = commentsService.update(comment);
        if(result > 0)
            return "SUCCESS";
        return "FAIL";
    }
    
    
}
