<%@ page language="java" 
		 contentType="text/html; charset=UTF-8" 
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" 
		  href="<c:url value="/css/getBoard.css" />"></link>
</head>
<body>

	<!-- 게시글 보기 -->
	<div id="wrap">
	
		<div id="board_lbl">게시글 읽기</div>
		
		<!-- 작성자 -->
		<div id="writer_lbl" class="fld_title">작성자</div>
		<div id="writer_fld" class="fld_val">${board.userName}</div>
		
		<!-- 글제목 -->
		<div id="title_lbl" class="fld_title">제목</div>
		<div id="title_fld" class="fld_val">${board.title}</div>
		
		<!-- 작성일 -->
		<div id="writeDate_lbl" class="fld_title">작성일</div>
		<div id="writeDate_fld" class="fld_val">
			<fmt:formatDate value="${board.writeDate}" 
							pattern="yyyy-M-d hh:mm:ss" />
		</div>
		
		<!-- 이메일 -->
		<div id="email_lbl" class="fld_title">이메일</div>
		<div id="email_fld" class="fld_val">${board.email}</div>
		
		<!-- 관련링크 -->
		<div id="homeUrl_lbl" class="fld_title">관련링크</div>
		<div id="homeUrl_fld" class="fld_val">
		   	<c:choose>
				<c:when test="${fn:startsWith(board.homeUrl, 'http://')}">
					<a href="${board.homeUrl}">${board.homeUrl}</a>
				</c:when>
				<c:otherwise>
					<a href="http://${board.homeUrl}">http://${board.homeUrl}</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<!-- 글내용 -->
		<div id="content_lbl" class="fld_title fld_content_title">내용</div>
		<div id="content_fld" class="fld_val fld_content_val">${board.content}</div>
		
	</div>	
	<br>
    <div id="bottom_menu">
	    <a href="${pageContext.request.contextPath}/board/replyBoard?articleid=${articleid}">
	       답글
	    </a>
	    &nbsp;
		<a href="${pageContext.request.contextPath}/board/updateConfirm?articleid=${articleid}">
		  수정
	    </a> 
    	&nbsp;
    	<a href="${pageContext.request.contextPath}/board/deleteConfirm?articleid=${articleid}">
   	 	 삭제
  	    </a> 
  	    &nbsp;
  	    <a href="${pageContext.request.contextPath}/board/replyList">
  	       게시글 목록
	    </a>
    </div>	
	
</body>
</html>