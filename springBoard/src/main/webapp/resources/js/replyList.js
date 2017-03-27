/**
 * 
 */
function searchData(){
	
	var form = document.board_search;
	
	if(!form.search_word.value){
		alert("검색어를 입력하세요!");
		form.search_word.focus();
		return ;
	}
	
	form.action = "../board/replyList";
	form.submit();
}

function readContents(articlenum) {
	
	document.go_read.articleid.value = articlenum;
	document.go_read.action ="../board/getBoard";
	document.go_read.submit();
}

function go_page(page){
	
	document.go_page.str_c_page.value = page;
	document.go_page.submit();
}