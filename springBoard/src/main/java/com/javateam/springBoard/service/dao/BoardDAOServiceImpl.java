package com.javateam.springBoard.service.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javateam.springBoard.domain.BoardList;
import com.javateam.springBoard.domain.BoardMap;
import com.javateam.springBoard.domain.BoardMapper;
import com.javateam.springBoard.domain.BoardVo;
import com.javateam.springBoard.domain.SearchVo;

@Repository
public class BoardDAOServiceImpl 
			implements BoardDAOService {
	
	private static final Logger log
		= LoggerFactory.getLogger(BoardDAOService.class);
	
	@Autowired 
	private SqlSession sqlSession;

	@Override
	public void insertBoard(BoardVo boardVo) {

		log.info("게시글 작성 !");
		sqlSession.getMapper(BoardMapper.class)
				  .insertBoard(boardVo);
	}

	@Override
	public BoardVo getBoard(int articleid) {

		log.info("getArticle !");
		log.info("articleid : " +articleid);
		
		return sqlSession.getMapper(BoardMapper.class)
						 .getBoard(articleid); 
	}

	@Override
	public void updateHits(int articleid) {

		log.info("updateHits !");
		sqlSession.getMapper(BoardMapper.class)
				  .updateHits(articleid);
		
	}
	
	@Override
	public ArrayList<Object> getBoard(int articleid, 
									    String passwd,
									    String confirm_yn) {
		
		log.info("getBoard(articleid, passwd, confirm_yn) !");
		
		ArrayList<Object> list = new ArrayList<Object>();
		BoardVo boardVo = new BoardVo();
		
		if (passwd.equals(this.getBoardPw(articleid)))
			confirm_yn = "Y";
		
		if (confirm_yn.equals("Y")) {
			boardVo = this.getBoard(articleid);
		} 
		
		log.info("boardVO : " + boardVo);
		
		list.add(confirm_yn); 
		list.add(boardVo);
		
		return list;
	}

	@Override
	public String getBoardPw(int articleid) {
		
		log.info("getBoardPw !");
		return sqlSession.getMapper(BoardMapper.class)
						 .getBoardPw(articleid);
	}

	@Override
	public ArrayList<Object> getReplyList(ArrayList<Object> bbs_vars) {

		ArrayList<Object> returnList = new ArrayList<Object>();
		
		BoardList boardList = new BoardList();
		
		ArrayList <Integer> v_articleid        = new ArrayList <Integer>();
		ArrayList <String>   v_title                = new ArrayList <String>();
		ArrayList <String>   v_write_date   = new ArrayList <String>();
		ArrayList <String>   v_user_name   = new ArrayList <String>();
		ArrayList <Integer> v_hits                = new ArrayList <Integer>();		
		ArrayList <String>   v_type               = new ArrayList <String>(); 
		
		int total_cnt 		= (Integer)bbs_vars.get(0);
		int today_cnt  		 = (Integer)bbs_vars.get(1);
		int list_num    	 	 = (Integer)bbs_vars.get(2); // 페이지 당 글 갯수
		int t_page        		 = (Integer)bbs_vars.get(3);
		int page_num 		 = (Integer)bbs_vars.get(4); // 5 페이지 씩 끊어서 보여줌 ex) ◀[3][4][5][6][7]▶
		int t_page_gubun  = (Integer)bbs_vars.get(5); // 총 페이지 구분
		int c_page_gubun  = (Integer)bbs_vars.get(6); // 현재 페이지 구분
		int pre_page 			 = (Integer)bbs_vars.get(7); // 이전 페이지
		int next_page 		     = (Integer)bbs_vars.get(8); // 다음 페이지
		
		String search_word = (String)bbs_vars.get(9);
		String search_gubun = (String)bbs_vars.get(10);
		int c_page =  (Integer)bbs_vars.get(11);
		
		int k=0;
		int j=0;
		
		SearchVo searchVo = new SearchVo();
		searchVo.setSearch_gubun(search_gubun);
		searchVo.setSearch_word(search_word);
		
		total_cnt = this.getReplyList1(searchVo);
		today_cnt = this.getReplyList2(searchVo);
		
		ArrayList<Integer> articleidList3 
							= this.getReplyList3(searchVo);
		
		for (int i3=0; i3<articleidList3.size(); i3++) {  // while(rs.next()
		
		   if(k<c_page*list_num) {
			   
			 ArrayList<BoardMap> articleidList4  
			 		= this.getReplyList4(articleidList3.get(i3));
			
			for (int i4=0; i4<articleidList4.size(); i4++) { // while(rs1.next()
				
				 k++;
			
				if (k <= c_page*list_num && k > (c_page-1)*list_num) {
    			
					j++;
					
					System.out.println("articleidList4.get(i4).getWrite_date() : "+ articleidList4.get(i4).getWriteDate());
						            			
					// DTO(VO) Beans Setter		    					
					v_articleid.add(articleidList4.get(i4).getArticleid());
					v_title.add(articleidList4.get(i4).getTitle());
					v_write_date.add(articleidList4.get(i4).getWriteDate());   
					v_user_name.add(articleidList4.get(i4).getUserName());
					v_hits.add(articleidList4.get(i4).getHits());		    					
					v_type.add(articleidList4.get(i4).getType());
				
					boardList.setArticleid((ArrayList <Integer>)v_articleid);					
					boardList.setTitle((ArrayList <String>)v_title);
					boardList.setWriteDate((ArrayList <String>)v_write_date);
					boardList.setUserName((ArrayList <String>)v_user_name);
					boardList.setHits((ArrayList <Integer>)v_hits);			    					
				    boardList.setType((ArrayList <String>)v_type);		   					
				} // if 
		    } // for
			
		} else{
				break;
		}
	 }
	
		if ((total_cnt%list_num)==0) {
			t_page = total_cnt/list_num;
		} else {
			t_page = (total_cnt/list_num)+1;
		}
		
		// return 
		returnList.add(total_cnt);
		returnList.add(today_cnt);
		returnList.add(list_num);
		returnList.add(t_page);
		returnList.add(page_num);
		returnList.add(t_page_gubun);
		returnList.add(c_page_gubun);
		returnList.add(pre_page);
		returnList.add(next_page);			
		returnList.add(boardList);	// VO addition			
		returnList.add(search_word);
		returnList.add(search_gubun);
		returnList.add(c_page);		
		
		return returnList;
	}

	@Override
	public int getReplyList1(SearchVo searchVo) {

		log.info("getReplyList1 !");
		return sqlSession.getMapper(BoardMapper.class)
				         .getReplyList1(searchVo);
	}

	@Override
	public int  getReplyList2(SearchVo searchVo) {

		log.info("getReplyList2 !");
		return sqlSession.getMapper(BoardMapper.class)
			             .getReplyList2(searchVo);
	}

	@Override
	public ArrayList<Integer> getReplyList3(SearchVo searchVo) {
	
		log.info("getReplyList3 !");
		
		return sqlSession.getMapper(BoardMapper.class)
			             .getReplyList3(searchVo);
	}

	@Override
	public ArrayList<BoardMap> getReplyList4(int articleid) {
		
		log.info("getReplyList4 !");
		
		return  sqlSession.getMapper(BoardMapper.class)
					      .getReplyList4(articleid);
	}

	@Override
	public void replyWriteBoard(BoardVo boardVo) {

		log.info("replyWriteBoard !");
		
		sqlSession.getMapper(BoardMapper.class)
				  .replyWriteBoard(boardVo);
	}
	
	@Override
	public void updateBoard(BoardVo boardVo) {

		log.info("updateArticle !");
		sqlSession.getMapper(BoardMapper.class)
				  .updateBoard(boardVo);
	}

	@Override
	public String deleteBoard(String confirm_yn, 
							int articleid, 
							String passwd) {

		log.info("deleteBoard !");
		
		String dbPasswd = sqlSession.getMapper(BoardMapper.class)
				  					.getBoard(articleid)
				  					.getPasswd();
			
		confirm_yn = passwd.equals(dbPasswd) ? "Y" : "N";
		
		if (confirm_yn.equals("Y")) {
	
			sqlSession.getMapper(BoardMapper.class)
					  .deleteBoard(articleid);
			System.out.println("게시글이 삭제되었습니다.");
		} else {
			System.out.println("게시글 삭제에 실패하였습니다.");
		}
		
		return confirm_yn;
	}

}