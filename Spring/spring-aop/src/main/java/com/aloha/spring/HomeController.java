package com.aloha.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		// ---
		// 게시글 목록 요청
//		List<Board> boardList = boardService.list();
//		model.addAttribute("boardList", boardList);
		
		// 게시글 조회 요청
		Board board = boardService.select(10);
		if(board == null) {
			logger.info("board is null");
			model.addAttribute("board",board);
		}
		
		// 게시글 등록 요청
		Integer result = boardService.insert(board);
		
		return "home";
	}
	
}
