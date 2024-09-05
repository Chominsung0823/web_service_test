/**
 * bookNoCheck.js
 */
 
 $(document).ready(function() {
 	// prdNoCheckBtn 버튼 클릭했을 때
 	$('#bookNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 		
 		if(bookNo == "") {
 			alert("도서번호를 입력하세요");
 			return false;
 		} else { 		
	 		$.ajax({
	 			type:"post",
	 			url:"/book/bookNoCheck", 
	 			data : {"bookNo": bookNo}, /* 컨트롤러에서 받는 이름 bookNo  */
	 			dataType:'text', /* 요청하는 데이터 타입 (반환 타입) */
	 			success:function(result) {
	 				if(result == "available") {
	 					alert("사용 가능한 번호입니다");
	 				} else {
	 					alert("사용할 수 없는 번호입니다.");
	 				}
	 			},
	 			error:function() {
	 				alert("실패");
	 			}
	 		});
 		
 		} // else 끝
 	
 	}); // click 끝
 
 });