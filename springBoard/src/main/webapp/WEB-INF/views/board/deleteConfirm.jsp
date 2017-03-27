<%@ page language="java"  
		 contentType="text/html; charset=UTF-8"  
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 		 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<title>패쓰워드 확인</title>
<style>
input#passwd, input#confirm_btn
{ 
	border:1px solid #ccc; 
}
</style>
<script src="<c:url value='/js/updateConfirm.js' />"></script>
</head>
<body>
	
	<!-- 패쓰워드 불일치 여부 팝업 -->
	<c:if test="${confirm_yn == 'N'}">
		<script>
			alert("패쓰워드가 일치하지 않습니다.");
			document.all["passwd"].value = ""; // 초기화
			document.all["passwd"].focus();
		</script>
	</c:if>

	<form id="confirm_passwd"
		  name="confirm_passwd" 
		  method="post" 
          action="${pageContext.request.contextPath}/board/deleteBoard">

      <input type="password" 
      		 id="passwd" 
      		 name="passwd" 
      		 size="20" 
      		 maxlength="20"
      		 value="">
      		 
      <input type="button" 
      		 id="confirm_btn" 
      		 value="확인"
      		 onClick="checkForm()"> 
      		 
	  <input type="hidden" 
	  		 name="articleid" 
	  		 value="${articleid}">

	</form>

</body>