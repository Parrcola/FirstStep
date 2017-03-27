<%@ page language="java"  
		 contentType="text/html; charset=UTF-8"  
		 pageEncoding="UTF-8" %>
<html>
<head>
<script>
function notice(){
	
    var confirm_yn='${confirm_yn}';
    
	if(confirm_yn=='Y'){
		alert("게시글 삭제 성공 !");
		location.href="${pageContext.request.contextPath}/board/replyList";
	} else {
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	}
}

window.onload = function(e) {
	notice();
}
</script>
</head>
<body>
</body>
</html>