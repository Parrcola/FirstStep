CREATE TABLE board (
	articleid 	  	 number(10), 
	title 			 varchar2(200), 
	userName 		 varchar2(20),   
	writeDate  	     date,						
	type             varchar2(1),		
	email 		  	 varchar2(50),   
	homeUrl	  	     varchar2(100),	
	parentArticleid  number(10) ,		
	hits			 number(10),      
	content			 varchar2(4000),						
	passwd			 varchar2(20),	
	CONSTRAINT pk_board PRIMARY KEY(articleid) 
);

-- 컬럼명 변경 : parentarticleid -> parent_articleid
alter table board
	rename column parentarticleid to parent_articleid;

drop table board;

-- sequence
CREATE sequence seq_board 
start with 1
increment by 1
maxvalue 99999
cycle
nocache;

-- 필수 항목 변경(상황에 따라 변경 가능)
alter table board
	modify (title varchar2(200) NOT NULL,
	        userName varchar2(20) NOT NULL,
	        content varchar2(4000) NOT NULL,
	        passwd varchar2(20) NOT NULL);

-- 테이블 종류 확인
SELECT * FROM USER_COL_COMMENTS; -- system view

-- SEQUENCE 정보 확인
SELECT sequence_name, min_value,
 max_value, increment_by, last_number
 FROM user_sequences; 
 
SELECT * FROM user_sequences; 

SELECT distinct(a.articleid) 
		     FROM (SELECT * FROM board 
		     		WHERE type='I') a,
		     	  (SELECT * FROM board WHERE type='R') b
	       			WHERE 1=1	
						and a.userName like '%java%'
						and a.articleid = b.parentArticleid(+)
	          ORDER BY a.articleid ASC;

-- getReplyList3
	SELECT distinct(a.articleid) 
		     FROM (SELECT * FROM board 
		     		WHERE type='I') a,
		     	  (SELECT * FROM board WHERE type='R') b 
		     	    WHERE 1=1	  
	      			and a.articleid = b.parentArticleid(+)
      		  ORDER BY a.articleid ASC;
      
	        