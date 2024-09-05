/**
 * bookSearch1.js
 */
 
 $(document).ready(function() {
 	// 검색 폼이 전송(submit) 되었을 때
 	$('#bookSearchFrm1').on('submit', function() {
 		event.preventDefault();
 		
 		// 폼에 입력한 여러 개의 값을 쿼리스트링 방식의 데이터로 변환 : serialize() 사용
 		let formData = $(this).serialize();
 		
 		let keyword = $('#keyword').val();
 		let type = $('#type').val();
 		
 		if(keyword == "" || type == ""){
 		   alert("검색 조건과 검색어를 입력하세요");
 		} else{ 		
 		
 		$.ajax({
 			type:"post",
 			url:"/book/bookSearch1", 
 			data : formData, 
 			success:function(result) { // 컨트롤러에서 반환한 bookList를 result가 받음
 				// 반환된 결과 (ArrayList<ProductVO>를 searchResultBox에 테이블 형태로 출력
 				$('#searchResultBox').empty();
 				$('#searchResultBox').append('<table id="resultTable" border="1" width="600">' +
 				                             '<tr><th>도서번호</th><th>도서명</th><th>저자</th>' +
				                             '<th>가격</th><th>출판일</th><th>재고</th><th>출판사번호</th><th>사진</th></tr>');
				if(result == ""){ // 검색 결과 없는 경우
				    $('#resultTable').append('<tr align="center"><td colspan="8">찾는 상품이 없습니다</td></tr>');
				} else {
				    for(let i = 0; i < result.length; i++){
				   		    let book_date = new Date(result[i].bookDate);
	 						let year = book_date.getFullYear();
	 						let month = (book_date.getMonth() + 1).toString().padStart(2, '0');
	 						let date = (book_date.getDate().toString().padStart(2, '0'));
	 						let bookDate = `${year}-${month}-${date}`;
				         $('#resultTable').append('<tr><td>' + result[i].bookNo + ' </td><td>' + 
				                                               result[i].bookName + ' </td><td>' + 
				                                               result[i].bookAuthor + ' </td><td>' + 
				                                               result[i].bookPrice + ' </td><td>' + 
				                                               bookDate + '</td><td>' + 
				                                               result[i].bookStock + ' </td><td>' + 
				                                               result[i].pubNo + ' </td><td>' + 
				            '<img src="/book_images/' + result[i].bookNo + '.jpg" width="30" height="20"></td></tr>');
				    }
				}   
				
				$('#searchResultBox').append('</table>');                         
 			},
 			error:function() {
 				alert("실패");
 			}
 		});
 		
 	  } // else 끝
 	
 	}); // submit 끝
 
 });