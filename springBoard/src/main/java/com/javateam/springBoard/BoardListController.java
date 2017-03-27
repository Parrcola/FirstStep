package com.javateam.springBoard;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.springBoard.domain.BoardList;
import com.javateam.springBoard.service.dao.BoardDAOService;

@Controller
@RequestMapping("/board")
public class BoardListController {
	
	private static final Logger log 
			= LoggerFactory.getLogger(BoardListController.class);
	
	@Autowired
	private BoardDAOService dao;

	// 게시글 목록
	@RequestMapping("/replyList")
	protected String replyList(@RequestParam Map<String, Object> paramMap,
							   Model model) {
		
		 log.info("boardlist !");
		
	 	 String search_word = (paramMap.get("search_word")==null) ? "" 
    				        : paramMap.get("search_word").toString();
		
		 String search_gubun = (paramMap.get("search_gubun")==null) ? "0" 
	 					  	 : paramMap.get("search_gubun").toString();
		
		 String str_c_page = (paramMap.get("str_c_page")==null) ? "1" 
	   					   : paramMap.get("str_c_page").toString();
		
		 int c_page = new Integer(str_c_page);

		 int total_cnt    = 0;  // 총 조회수
		 int today_cnt    = 0;  // 금일 조회수
		 int list_num     = 3;  // 페이지 당 글 갯수
		 int t_page 	  = 0;  // 총 페이지
		 int page_num 	  = 3;  // 3 페이지씩 끊어서 보여줌  ex) ◀[3][4][5]▶
		 int t_page_gubun = 1;  // 총 페이지 구분
		 int c_page_gubun = 1;  // 현재 페이지 구분
		 int pre_page     = 0;  // 이전 페이지
		 int next_page    = 0;  // 다음 페이지			
		 
		 ArrayList<Object> bbsVars = new ArrayList<Object>();
		 
		 ArrayList <Integer> v_articleid = new ArrayList <Integer>();
		 ArrayList <String> v_title = new ArrayList <String>();
		 ArrayList<String> v_write_date = new ArrayList <String>();
		 ArrayList <String> v_user_name = new ArrayList <String>();
		 ArrayList <Integer> v_hits = new ArrayList <Integer>();	 
		 ArrayList <String> v_type = new ArrayList <String>(); // 게시판에 비해 답글에 추가된 변수
		 
		 bbsVars.add(total_cnt);
		 bbsVars.add(today_cnt);
		 bbsVars.add(list_num);
		 bbsVars.add(t_page);
		 bbsVars.add(page_num);
		 bbsVars.add(t_page_gubun);
		 bbsVars.add(c_page_gubun);
		 bbsVars.add(pre_page);	
		 bbsVars.add(next_page);
		
	 	 bbsVars.add(search_word);
	 	 bbsVars.add(search_gubun);
		 bbsVars.add(c_page);
		 
		  ArrayList<Object> return_v = dao.getReplyList(bbsVars);	
		 
		  total_cnt = (Integer)return_v.get(0);
		  today_cnt = (Integer)return_v.get(1);
		  list_num 	= (Integer)return_v.get(2);
		  t_page 	= (Integer)return_v.get(3);
		  page_num 	= (Integer)return_v.get(4);
		  t_page_gubun = (Integer)return_v.get(5);
		  c_page_gubun = (Integer)return_v.get(6);
		  pre_page 	= (Integer)return_v.get(7);
		  next_page = (Integer)return_v.get(8);
		  
		  BoardList boardList = (BoardList)return_v.get(9);
			 
		  v_articleid = (ArrayList <Integer>)boardList.getArticleid();
		  v_title = (ArrayList <String>)boardList.getTitle();
		  v_write_date = (ArrayList <String>)boardList.getWriteDate();
		  v_user_name = (ArrayList <String>)boardList.getUserName();
		  v_hits = (ArrayList <Integer>)boardList.getHits();
		  v_type = (ArrayList <String>)boardList.getType();
		 
		  search_word = (String)return_v.get(10);
		  search_gubun = (String)return_v.get(11);
		  c_page = (Integer)return_v.get(12);		 
		  
		 model.addAttribute("total_cnt", total_cnt);
		 model.addAttribute("today_cnt", today_cnt);
		 model.addAttribute("list_num", list_num);
		 model.addAttribute("t_page", t_page);
		 model.addAttribute("page_num", page_num);
		 model.addAttribute("t_page_gubun", t_page_gubun);
		 model.addAttribute("c_page_gubun", c_page_gubun);
		 model.addAttribute("pre_page", pre_page);
		 model.addAttribute("next_page", next_page);
		 
		 model.addAttribute("v_articleid", v_articleid);
		 model.addAttribute("v_title",  v_title);
		 model.addAttribute("v_write_date", v_write_date);
		 model.addAttribute("v_user_name", v_user_name);
		 model.addAttribute("v_hits", v_hits);
		 model.addAttribute("v_type", v_type);		 
		 
		 model.addAttribute("search_word", search_word);
		 model.addAttribute("search_gubun", search_gubun);
		 model.addAttribute("c_page", c_page);		

		 return "/board/replyList";
	} // 
	
}