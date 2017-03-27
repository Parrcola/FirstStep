/**
 * 
 */
package com.javateam.springBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javateam.springBoard.domain.BoardVo;
import com.javateam.springBoard.service.dao.BoardDAOService;

/**
 * @author javateam
 *
 */
@Controller
@RequestMapping("/board")
// @SessionAttributes("boardSess")
public class BoardUpdateController {
	
	private static final Logger log 
		= LoggerFactory.getLogger(BoardListController.class);
	
	@Autowired
	private BoardDAOService dao;
	
	@RequestMapping("/updateBoard")
	public String updateBoard(@RequestParam("articleid") int articleid,
							  @RequestParam("passwd") String passwd,
					          Model model,
					          HttpSession session) {
		
		log.info("updateBoard called !");
		String confirm_yn = "N";
		
		String pw = dao.getBoardPw(articleid);
		
		if (!pw.equals(passwd)) { // 패쓰워드 불일치...
			
			log.info("패쓰워드 불일치");
			
			model.addAttribute("confirm_yn", "N");
			model.addAttribute("articleid", articleid);
			
			return "/board/updateConfirm";
		}
		
		log.info("id/pw : {}/{}", articleid, passwd);
		
		ArrayList<Object> result_v 
			= dao.getBoard(articleid, passwd, confirm_yn); 
		
		// model.addAttribute("confirm_yn", result_v.get(0));
		
		model.addAttribute("boardVo", result_v.get(1));
		// 회원정보 세션 : session
		session.setAttribute("boardSession", result_v.get(1)); 
		
		// model.addAttribute("boardSess", result_v.get(1)); // session Sample
		
		model.addAttribute("articleid", articleid);
		
		return "/board/updateBoard";
	}
	
	@RequestMapping("/updateSession")
	public void updateSession(@ModelAttribute("boardSess") BoardVo boardSess) {
		
		log.info("session boardSess : "+boardSess);
		log.info("updateSession !");
		
	}
	
	
	@RequestMapping(value="/updateBoardAction",
					method=RequestMethod.POST)
	public String updateBoardAction(@Valid BoardVo boardVo,
									BindingResult result,
									Model model,
									HttpSession session) {
		
		log.info("updateBoardAction called !");
		log.info("boardVO {}",boardVo);
		
		if (result.hasErrors()) {
			
			log.info("폼점검 오류 !");
			log.info("폼점검 오류 :\n {}",result.getAllErrors());
			
			return "/board/updateBoard";
		}
		
		dao.updateBoard(boardVo);
		
		return "/board/updateBoardAction";
	}
	
	@RequestMapping("/updateConfirm")
	public String updateConfirm(@RequestParam("articleid") int articleid,
								Model model) {
		
		log.info("update confirm called !");
		model.addAttribute("articleid", articleid);
		
		return "/board/updateConfirm";
	}

}
