<%@ page contentType="text/html; charset=UTF-8"  
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style>
.err { color:red; }
#msg_pnl 
{
	background-color:yellow;
	width:700px;
	color:red;
}
</style>
<link rel="stylesheet" 
	  href="<c:url value="/css/insertBoard.css" />"></link>
<link rel="stylesheet" 
	  href="<c:url value="/css/getBoard.css" />"></link>
</head>
<body>

  <div id="msg_pnl">
	<b>boardVo :</b> ${boardVo}<br>
	<b>session boardVo :</b> ${sessionScope.boardSession}<br> 
  </div>

  <!-- 게시글 수정 -->
  <div id="wrap">
  
	<form:form commandName="boardVo" 
  			   method="post" 
  			   name="updateform" 
  			   action="${pageContext.request.contextPath}/board/updateBoardAction">
	  
	  <!-- 작성자 -->
	  <div id="writer_lbl" class="fld_title">작성자</div>	
	  	   
	  <div id="writer_fld" class="fld_val">
	  	   <input type="text"
	  			  id="userName" 
	  			  name="userName" 
	  			  size="20" 
	  			  maxlength="20"
	  			  readonly 
	  			  value="${boardVo.userName}" />
		   <form:errors path="userName" cssClass="err"/>
	  </div> 
	
	  <!-- 패쓰워드 -->		
	  <div id="pw_lbl" class="fld_title">패쓰워드</div>
	  
	  <div id="writer_fld" class="fld_val"> 
	  	<input type="password" 
	  		   id="passwd" 
	  		   name="passwd" 
	  		   size="20" 
	  		   maxlength="20" 
	  		   value="${not empty boardSession.passwd ? 
	  		   			boardSession.passwd : boardVo.passwd}"/>
		<form:errors path="passwd" cssClass="err"/>	  		   
	  </div>
	  
	  <!-- 글 제목 -->
	  <div id="title_lbl" class="fld_title">제목</div>
	  
	  <div id="title_fld" class="fld_val">
	  	<input type="text" 
	  		   id="title" 
	  		   name="title" 
	  		   size="50" 
	  		   maxlength="50" 
	  		   value="${not empty boardSession.title ? 
	  		   			boardSession.title : boardVo.title}"/>
	    
	    <form:errors path="title" cssClass="err"/>
	  </div> 

	  <!-- 이메일 -->
	  <div id="email_lbl" class="fld_title">이메일</div>
	  
	  <div id="title_fld" class="fld_val">
	  	<input type="text" 
	  		   id="email" 
	  		   name="email" 
	  		   size="50" 
	  		   maxlength="50"
	  		   value="${boardVo.email}" />
	  </div> 
 		  
	  <!-- 관련 링크 -->
	  <div id="link_lbl" class="fld_title">관련링크</div>
	  
	  <div id="link_fld" class="fld_val">
  		<input type="text" 
  			   id="homeUrl" 
  			   name="homeUrl" 
  			   size="50" 
  			   maxlength="50" 
  			   value="${not empty boardSession.homeUrl ?
  			   			boardSession.homeUrl : boardVo.homeUrl}"/>
	  </div>
	  
	  <!-- 글 내용 -->
	  <div id="content_lbl" 
	  	   class="fld_title fld_content_title">내용</div> 
	  	   
	  <div id="content_fld" 
	  	   class="fld_val fld_content_val">
	  	<textarea id="content" 
	  			  name="content" 
	  			  cols="70" 
	  			  rows="11">${not empty boardSession.content ? 
	  		   				 boardSession.content : boardVo.content}</textarea>
	    <br>
	  	<form:errors path="content" cssClass="err"/>		  
	  </div>
	    
	  <!-- 수정/취소 버튼 -->
	  <div id="menu_fld" class="btn_fld">
	  
		  <input type="submit" 
		  		 value="글수정" 
		  		 class="btn_style" />&nbsp;
		  		 
		  <input type="reset" 
		  		 value="취소" 
		  		 class="btn_style" />
	  </div>	
	  
	  <!-- 히든 필드  -->  
	  <input type="hidden" 
	  		 id="articleid" 
	  		 name="articleid"
	  		 value="${not empty boardSession.articleid ? 
	  		   	      boardSession.articleid : articleid}" />

	</form:form>	
		   
  </div>	
  <!-- 게시글 수정 끝 -->	

</body>
</html>
