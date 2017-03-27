/**
 * 
 */

// 작성일 자동 입력
function outputDate() {
  
  var date = new Date();
  var today = "20"+date.getYear().toString().substring(1,3) + "-"
            + (date.getMonth()+1) + "-"
            + date.getDate() + " "
            + date.getHours()+":"
            + date.getMinutes()+":"
            + date.getMinutes();
  
  document.all["writeDate"].readOnly = true; // 임의 입력방지
  document.all["writeDate"].value = today;
}

// 페이지 로딩시 시작할 부분
window.onload = function(e) {
	
	outputDate(); // 가입일 생성 표시
}