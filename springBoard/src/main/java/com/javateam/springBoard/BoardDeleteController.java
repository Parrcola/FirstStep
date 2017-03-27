/**
 * 
 */
package com.javateam.springBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.springBoard.service.dao.BoardDAOService;

/**
 * @author javateam
 *
 */
@Controller
@RequestMapping("/board")
public class BoardDeleteController {
	
	private static final Logger log 
		= LoggerFactory.getLogger(BoardListController.class);
	
	@Autowired
	private BoardDAOService dao;
	
	@RequestMapping(value="/deleteConfirm", method=RequestMethod.GET)
	public String deleteConfirm(@RequestParam("articleid") int articleid,
								Model model) {
		log.info("deleteConfirm !");
		
		model.addAttribute("articleid", articleid);
		return "/board/deleteConfirm";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteBoard(@RequestParam("articleid") int articleid,
						 	  @RequestParam("passwd") String passwd,
						 	  Model model) {
		
		log.info("deleteBoard !");
		
		String pw = dao.getBoardPw(articleid);
		
		if (!pw.equals(passwd)) { // 패쓰워드 불일치...
			
			log.info("패쓰워드 불일치");
			
			model.addAttribute("confirm_yn", "N");
			model.addAttribute("articleid", articleid);
			
			return "/board/deleteConfirm";
		}
		
		log.info("id/pw : {}/{}", articleid, passwd);
		
		String confirm_yn = "N";
		confirm_yn = dao.deleteBoard(confirm_yn, articleid, passwd);
		model.addAttribute("confirm_yn", confirm_yn);
		
		return "/board/deleteBoard";
	}

}
