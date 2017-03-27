package com.javateam.springBoard.domain;

import java.util.ArrayList;

/**
 * 게시판 Mapper
 * 
 * @author javateam
 */
public interface BoardMapper {
	
	/**
	 * 게시글 쓰기
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
	 * @return 게시판 객체
	 */
	String getBoardPw(int articleid);
	
	// 게시글 조회 관련 메소드들
	int getReplyList1(SearchVo searchVo);
	int getReplyList2(SearchVo searchVo);
	ArrayList<Integer> getReplyList3(SearchVo searchVo);
	ArrayList<BoardMap> getReplyList4(int articleid);
	
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
	void deleteBoard(int articleid);
}