package com.javateam.springBoard;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.springBoard.domain.BoardVo;
import com.javateam.springBoard.service.dao.BoardDAOService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger log 
			= LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDAOService dao;

	@RequestMapping("/insertBoard")
	public String insertBoard(Model model) {
		
		log.info("게시글 쓰기 !");
		model.addAttribute("board", new BoardVo());
		
		return "/board/insertBoard";
	}

	@RequestMapping(value="/insertBoardAction",
					method=RequestMethod.POST)
	public String insertBoardAction(@Valid BoardVo board,
								    BindingResult result) {
		
		log.info("게시글 저장 !");
		log.info("게시글 : {}", board);
		
		if (result.hasErrors()) {
			
			log.info("폼점검 오류 !");
			log.info("폼점검 오류 :\n {}",result.getAllErrors());
			
			return "/board/insertBoard";
		}
		
		dao.insertBoard(board);
		
		// return "/board/insertBoardAction";
		return "redirect:/board/replyList";
	}
	
	@RequestMapping(value="/getBoard",
					method=RequestMethod.GET)
		public String getArticle(@RequestParam("articleid") int articleid,
							 Model model) {
		
		log.info("getBoard called !");
		log.info("articleid :"+articleid);
		
		BoardVo boardVo = dao.getBoard(articleid); 
		dao.updateHits(articleid); 
		
		log.info("board : " + boardVo);
		
		model.addAttribute("board", boardVo);
		model.addAttribute("articleid", articleid);
		
		return "/board/getBoard";
	}
		
		
	@RequestMapping(value="/getBoard/{articleid}", 
					method=RequestMethod.GET)
	public String getArticlePath(@PathVariable("articleid") int articleid,
							     Model model) {
		
		log.info("getArticle called !");
		log.info("articleid :"+articleid);
		
		BoardVo boardVo = dao.getBoard(articleid); 
		dao.updateHits(articleid); 
		
		log.info("board : " + boardVo);
		
		model.addAttribute("board", boardVo);
		model.addAttribute("articleid", articleid);
		
		return "/board/getBoard";
	}
	
}