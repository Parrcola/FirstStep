<%@ page contentType="text/html; charset=UTF-8" 
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="StyleSheet" 
		  href="<c:url value="/css/insertBoard.css" />"></link>	
    <style>
    .err 
	{ 
		color:red;
	}
    </style>
</head>

<body>

  <!-- 게시글 쓰기 시작 -->
  <div id="wrap">

		<form:form commandName="boardVo" 
				   method="post" 
				   name="reply_form" 
				   action="${pageContext.request.contextPath}/board/reply">

		 
		 <!-- 작성자 -->
	  	 <div id="writer_lbl" class="fld_title">작성자</div>	
	  	 
	  	 <div id="writer_fld" class="fld_val">
	  	   <input type="text"
	  			  id="userName" 
	  			  name="userName" 
	  			  size="20" 
	  			  maxlength="20" />
		   <form:errors path="userName" cssClass="err"/>
	  	 </div> 
	  	 
	  	  <!-- 패쓰워드 -->		
		  <div id="pw_lbl" class="fld_title">패쓰워드</div>
		  
		  <div id="writer_fld" class="fld_val"> 
		  	<input type="password" 
		  		   id="passwd" 
		  		   name="passwd" 
		  		   size="20" 
		  		   maxlength="20" />
			<form:errors path="passwd" cssClass="err"/>	  		   
		  </div>
		  
		  <!-- 글 제목 -->
		  <div id="title_lbl" class="fld_title">제목</div>
		  
		  <div id="title_fld" class="fld_val">
		  	<input type="text" 
		  		   id="title" 
		  		   name="title" 
		  		   size="50" 
		  		   maxlength="50" />
		    
		    <form:errors path="title" cssClass="err"/>
		  </div> 
		  
		   <!-- 이메일 -->
		  <div id="email_lbl" class="fld_title">이메일</div>
		  
		  <div id="title_fld" class="fld_val">
		  	<input type="text" 
		  		   id="email" 
		  		   name="email" 
		  		   size="50" 
		  		   maxlength="50" />
		  </div> 
	 		  
		  <!-- 관련 링크 -->
		  <div id="link_lbl" class="fld_title">관련링크</div>
		  
		  <div id="link_fld" class="fld_val">
	  		<input type="text" 
	  			   id="homeUrl" 
	  			   name="homeUrl" 
	  			   size="50" 
	  			   maxlength="50" />
		  </div>
		  
		  <!-- 글 내용 -->
		  <div id="content_lbl" 
		  	   class="fld_title fld_content_title">내용</div> 
		  	   
		  <div id="content_fld" 
		  	   class="fld_val fld_content_val">
		  	<textarea id="content" 
		  			  name="content" 
		  			  cols="70" 
		  			  rows="11"></textarea>
		    <br>
		  	<form:errors path="content" cssClass="err"/>		  
		  </div>

		  <!-- 전송/취소/게시판 목록 버튼 -->
		  <div id="menu_fld" class="btn_fld">
		  
			  <input type="submit" 
			  		 value="글쓰기" 
			  		 class="btn_style" />&nbsp;
			  		 
			  <input type="reset" 
			  		 value="취소" 
			  		 class="btn_style" />
			  		 
			  <input type="button" 
			  		 value="목록 보기" 
			  		 class="btn_style" 
			  		 onClick="location.href='${pageContext.request.contextPath}/board/replyList'" />		 
		  </div>	
		  
		  <!-- 히든 필드  -->  
		  <!-- 댓글 여부(답글 = R) -->
		  <input type="text" 
		  		 id="articleid" 
		  		 name="articleid"
		  		 value="${articleid}" />
		  <input type="hidden" 
		  		 id="type" 
		  		 name="type" 
		  		 value="R" />
		  	   
		</form:form>	
			   
	  </div>	
	  <!-- 게시글 쓰기 끝 -->	

</body>
</html>