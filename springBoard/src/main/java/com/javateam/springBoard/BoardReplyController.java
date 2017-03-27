package com.javateam.springBoard;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.springBoard.domain.BoardVo;
import com.javateam.springBoard.service.dao.BoardDAOService;

@Controller
@RequestMapping("/board")
public class BoardReplyController {
	
	@Autowired 
	private BoardDAOService dao; 
	
	private static final Logger log
		= LoggerFactory.getLogger(BoardReplyController.class);
	
	// 답글(댓글) 입력폼
	@RequestMapping("/replyBoard")
	public String replyArticleForm(@RequestParam("articleid") int articleid,
									Model model) {
		
		log.info("replyBoard !");
		
		model.addAttribute("content", dao.getBoard(articleid).getContent());
		model.addAttribute("articleid", articleid);
		
		return "/board/replyBoard";
	}

	@RequestMapping("/reply")
	public String reply(@Valid BoardVo boardVo,
						BindingResult result,
						Model model) {
		
		String returnPath = "";
		
		log.info("답글 저장 !");
		
		if (result.hasErrors()) {
			
			log.info("폼점검 오류 !");
			log.info("폼점검 오류 :\n {}",result.getAllErrors());
			
			// 폼점검 실패후 다시 게시글 아이디 인자 전송 : 인자 소실 방지
			model.addAttribute("articleid", boardVo.getArticleid());
			
			return "/board/replyBoard";
		}
		
		// 답글의 답글(다중 답글 : level-1 만 허용 !) 방지
		// 원글/답글 여부 점검 : type(I/R)
		
		log.info("답글 : {}", boardVo);
		
		String type = dao.getBoard(boardVo.getArticleid()).getType();
		log.info("type : {}",type);
		
		if (type.equals("I")) { // 원글(type='I') : 답글 작성 가능 !
			
			log.info("원글(I) !");
			boardVo.setParentArticleid(boardVo.getArticleid());
			dao.replyWriteBoard(boardVo);
			
			returnPath="redirect:/board/replyList";
			
		} else { // 답글(type='R') : 답글 작성 불가능(다중 답글 차단)
			
			log.info("답글 작성 실패");
			returnPath="/board/replyFail";
		}
		
		return returnPath;
	}
}
