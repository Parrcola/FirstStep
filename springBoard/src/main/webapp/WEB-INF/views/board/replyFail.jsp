<%@ page contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 작성 실패</title>
</head>
<body>
<script>
	alert("다중 댓글을 작성하실 수 없습니다.\n\n게시판으로 돌아갑니다.");
	location.href="${pageContext.request.contextPath}/board/replyList";
</script>	
</body>
</html>