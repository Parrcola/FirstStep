package com.javateam.springBoard.service.dao;

import java.util.ArrayList;

import com.javateam.springBoard.domain.BoardMap;
import com.javateam.springBoard.domain.BoardVo;
import com.javateam.springBoard.domain.SearchVo;

/**
 * 게시판 DAO
 * 
 * @author javateam
 */
public interface BoardDAOService {
	
	/**
	 * 게시글 작성
	 * @param boardVo 게시판 객체
	 */
	void insertBoard(BoardVo boardVo);
	
	/**
	 * 게시글 조회
	 * @param articleid 게시글 아이디
	 * @return 게시판 객체
	 */
	BoardVo getBoard(int articleid);
	
	/**
	 * 조회수 갱신
	 * @param articleid 게시글 아이디
	 */
	void updateHits(int articleid);
	
	/**
	 * 게시글 조회(패쓰워드)
	 * @param articleid 게시글 아이디
	 * @param passwd 게시글 패쓰워드
	 * @param confirm_yn 
	 * @return 게시글 객체(들)
	 */
	ArrayList<Object> getBoard(int articleid, String passwd, String confirm_yn);
	String getBoardPw(int articleid);
	
	// 게시글 조회 관련 메소드들 
	int getReplyList1(SearchVo searchVo);
    int getReplyList2(SearchVo searchVo);
	ArrayList<Integer> getReplyList3(SearchVo searchVo);
    ArrayList<BoardMap> getReplyList4(int articleid);
	ArrayList<Object> getReplyList(ArrayList <Object> bbs_vars);
	
	/**
	 * 댓글 작성
	 * @param boardVo 게시판 객체
	 */
	void replyWriteBoard(BoardVo boardVo);
	
	/**
	 * 게시글 수정
	 * @param boardVo 게시판 객체
	 */
	void updateBoard(BoardVo boardVo);
	
	/**
	 * 게시글 삭제
	 * @param articleid 게시글 아이디
	 */
	String deleteBoard(String confirm_yn, 
					   int articleid, 
					   String passwd);
}