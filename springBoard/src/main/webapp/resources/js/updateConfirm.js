/**
 * 
 */
function checkForm(){
		
  if (document.all["passwd"].value.length==0){
	  
  	alert("암호를 입력하여 주십시오");
  	document.confirm_passwd.passwd.focus();
  	
  } else {
  	document.confirm_passwd.submit();
  }
  
}

window.onload = function(e) {
	
	document.all["passwd"].focus();
}