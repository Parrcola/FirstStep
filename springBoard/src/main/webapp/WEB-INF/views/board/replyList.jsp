<%@ page contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elfn" uri="ELFunction" %> 
<html>
<head>
	<link rel="StyleSheet" 
		  href="<c:url value="/css/replyList.css" />"></link>
	<script src="<c:url value='/js/replyList.js' />"></script>
</head>
<body>

<div id="replyList_vars">
	총 게시글 수 : ${total_cnt}<br>
	페이지당 글의 갯수 : ${list_num}<br>
	총 페이지 : ${t_page}<br>
	페이지 끊기 간격 : ${page_num}<br>
	총 페이지 구분 : ${t_page_gubun}<br>
	현재 페이지 구분 : ${c_page_gubun}<br>
	<%-- 이전 페이지 : ${pre_page}<br>
	다음 페이지 : ${next_page}<br>  --%>
</div>

<form name="board_search" method="post">

	<div id="wrap">
	
		<div id="top_board">등록 : ${today_cnt}/${total_cnt}(오늘/전체)</div>
		
		<!-- 게시판 타이틀 -->
		<div id="board_top">
		 &nbsp;
		</div>
		
		<!-- 게시판 내용 시작 -->
		<c:choose> 		
			
			<c:when test="${total_cnt == 0}">
				<div>검색결과가 없습니다.</div>
			</c:when>
						
			<c:when test="${(v_articleid == null) && (c_page == 0)}">
		     	<script>
	           	 	alert("답글 검색 기능은 제한됩니다.");
	           		location.href="${pageContext.request.contextPath}/board/replyList";
   			  </script>	      
			</c:when>			
			
	        <c:when test="${not empty v_articleid}">
			  
			   <c:forEach var="j" begin="0" 
			   			  end="${v_articleid.size()-1}" step="1">
			   
			      <c:choose>
			      
			      	<c:when test="${v_type.get(j) =='I'}"> <!-- 일반글 : I -->		
			      	
			      	    <!-- 일반 게시글 한 행(1 row) 시작 -->
			      		<div class="board_row">
			      		
				      	  <div class="board_row_common board_no">	      	
							 ${((c_page-1) *list_num) + j+1}
						  </div>	 
						  
						  <div class="board_row_common board_title">
							 <a href="javascript:readContents(${v_articleid.get(j)})">
						     	${v_title.get(j)}
						     </a>
						  </div>
						  
						  <div class="board_row_common board_date">
						     ${v_write_date.get(j)}
						  </div>
						  	
						  <div class="board_row_common board_user_name">
						  	 ${v_user_name.get(j)}
						  </div>	 
						  
						  <div class="board_row_common board_hits">
							 ${v_hits.get(j)}
						  </div>
					  
					  </div>
					  <!-- 일반 게시글 한 행(1 row) 끝 -->
					  
		  			</c:when>
		  			
			      	<c:when test="${v_type.get(j) == 'R'}"> <!-- 답글 : R -->			      	

						<!-- 답글 게시글 한 행(1 row) 시작 -->
			      		<div class="board_row">
			      		
			      		  <div class="board_row_common board_no">	      	
							 ${((c_page-1) *list_num) + j+1}
						  </div>	

						  <div class="board_row_common board_title">
						     <img src='<c:url value="/img/reply.gif" />' border="0"> 
							 <a href="javascript:readContents(${v_articleid.get(j)})">
						     	${v_title.get(j)}
						     </a>
						  </div>
						  
  						  <div class="board_row_common board_date">
						     ${v_write_date.get(j)}
						  </div>
						  
						  <div class="board_row_common board_user_name">
						  	 ${v_user_name.get(j)}
						  </div>	 
						  
						  <div class="board_row_common board_hits">
							 ${v_hits.get(j)}
						  </div>
					  
					  </div>
					  <!-- 답글 게시글 한 행(1 row) 끝 -->
						  
			      	</c:when>
			      	
			      </c:choose>
			   		
			   </c:forEach>
			   
			</c:when>
			
		</c:choose>
	  
	  </div> 
	  <!-- 게시판 내용 끝 -->
	  
	  <!-- 페이징 시작 -->
		<div id="board_paging">
					
			<c:choose>
			   <c:when test="${t_page % page_num == 0}" >
	      			 <c:set var="temp_t_page_gubun" value="${t_page / page_num}" />
			   </c:when>
			   <c:otherwise>
			   		<c:set var="temp_t_page_gubun" value="${(t_page / page_num) + 1}" />
			   </c:otherwise>
			</c:choose>
			
			<c:choose>
			   <c:when test="${c_page % page_num == 0}" >
	      			 <c:set var="temp_c_page_gubun" value="${c_page / page_num}" />
			   </c:when>
			   <c:otherwise>
			   		<c:set var="temp_c_page_gubun" value="${(c_page / page_num) + 1}" />
			   </c:otherwise>
			</c:choose>
	
		<c:set var="c_page_gubun" value="${elfn:abs(temp_c_page_gubun)}" /> 
		<c:set var="t_page_gubun" value="${elfn:abs(temp_t_page_gubun)}" /> 
		
		 <c:if test="${total_cnt > 0 }"> 
			
		  <c:if test="${(c_page_gubun == 1) && (c_page_gubun == t_page_gubun)}">
		     <c:forEach var="k" begin="1" end="${t_page}" step="1">
		     	<a href="javascript:go_page(${k})">[
		     	    <c:if test="${c_page == k}">
		     	        <b>
		     	    </c:if>
		     	    ${k}
		     	    <c:if test="${c_page == k}">
		     	        </b>
		     	    </c:if>
		     	    ]</a>
		     </c:forEach>
		  </c:if>
		  
		  <c:if test="${(c_page_gubun == 1) && (c_page_gubun != t_page_gubun)}">
		   		<c:forEach var="k" begin="1" end="${page_num}" step="1">
		   			<a href="javascript:go_page(${k})">[
		   				<c:if test="${c_page == k}">
		     	        <b>
		     	    </c:if>
		     	    ${k}
		     	    <c:if test="${c_page == k}">
		     	        </b>
		     	    </c:if>
		   			]</a>
		   		</c:forEach>
		   		<c:set var="next_page" value="${c_page_gubun * page_num + 1}" />
		   		<a href="javascript:go_page(${next_page})"> ▶</a>
		  </c:if>
		  
		  <c:if test="${(c_page_gubun != 1) && (c_page_gubun != t_page_gubun)}">
		       				  
		   		<c:set var="pre_page" value="${(c_page_gubun - 1) * page_num -2 }" /> <!--  //  페이지당 글의 수에 따라 변수값 조정 !  ex) page_num-4-->
		   		<a href="javascript:go_page(${pre_page})">◀</a>
		   		
			   		<c:forEach var="k" begin="${((c_page_gubun - 1) * page_num)+1}"
			   		                      end="${c_page_gubun * page_num}" step="1">
			   			<a href="javascript:go_page(${k})">[
			   				<c:if test="${c_page == k}">
			     	        <b>
				     	    </c:if>
				     	    ${k}
				     	    <c:if test="${c_page == k}">
				     	        </b>
				     	    </c:if>
						]</a>
			   		</c:forEach>
			   		
		   		<c:set var="next_page" value="${c_page_gubun * page_num +1}" />
		   		<a href="javascript:go_page(${next_page})"> ▶</a>
		  </c:if>
		  
				  <c:if test="${c_page_gubun != 1 && c_page_gubun == t_page_gubun}">
		   		<c:set var="pre_page" value="${ (c_page_gubun - 1) * page_num - 2 }" /> <!--  //  페이지당 글의 수에 따라 변수값 조정 ! ex) page_num-4 -->
		   		<a href="javascript:go_page(${pre_page})">◀</a>
		   		
		   		<c:forEach var="k" begin="${(c_page_gubun - 1) * page_num + 1}" 
		   		                    end="${t_page}" step="1">
		   			<a href="javascript:go_page(${k})">[
		   				<c:if test="${c_page == k}">
		     	        <b>
			     	    </c:if>
			     	    ${k}
			     	    <c:if test="${c_page == k}">
			     	        </b>
			     	    </c:if>
					]</a>
		   		</c:forEach>
		  </c:if>
				  
		</c:if> 
	  </div>		
	  
	  <!-- 페이징 끝 -->	

	  <!-- 게시판 하단부 시작 : 메뉴 등 -->
	  <div id="board_menu">
		  <a href="../board/insertBoard">
		  	글쓰기
	 		  </a>	
	 		 &nbsp;		  
		   <a href="../board/replyList">
		   	 목록보기
	   	   </a>
	  </div>
	
	  <div id="board_search">
			
			<span style="color:red">
				주의) 댓글은 검색 기능이 없으므로 추후에 추가해야 됨.
			</span><br>
			
			범위 :
			<select name=search_gubun>
				<option value="1">제목</option>
				<option value="2">작성자</option>
			</select>
			
			&nbsp;검색어 :
			<input type="text" name="search_word" maxlength="20">
			<input type="submit" value="찾기" onClick="searchData()"> 
     </div>
     <!-- 게시판 하단부 끝 : 메뉴 등 -->

</form>

<!-- 히든 필드들 : 글 아이디, 검색어 관련 -->
<div>
	<form name="go_read" method="get">
		<input type=hidden name=articleid>
	</form>
	
	<form name="go_page" method="post">
		<input type=hidden name=str_c_page>
		<input type=hidden name=search_gubun value="${search_gubun}">
		<input type=hidden name=search_word value="${search_word}">
	</form>
</div>

</body>
</html>