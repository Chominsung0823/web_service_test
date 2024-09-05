<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 상세 조회</title>
	</head>
	<body>
		<h3>도서 상세 정보 조회</h3>
		<table border="1" width="300">
				<tr><td>도서번호</td><td>${book.bookNo }</td></tr>
				<tr><td>도서명</td><td>${book.bookName }</td></tr>
				<tr><td>저자</td><td>${book.bookAuthor }</td></tr>
				<tr><td>가격</td><td>${book.bookPrice }</td></tr>
				<tr><td>발행일</td>
				<td><fmt:formatDate value="${book.bookDate }" pattern="YYYY-MM-dd" /></td></tr>
				<tr><td>재고</td><td>${book.bookStock }</td></tr>
				<tr><td>출판사 번호</td><td>${book.pubNo }</td></tr>
				
		</table><br>
		
		<a href="<c:url value='/book/updateBookForm/${book.bookNo}' />">[도서 정보 수정]</a>
		<a href="javascript:deleteBook()">[도서 정보 삭제]</a>
		<script>
			function deleteBook(){
				let answer = confirm("삭제하시겠습니까?");
				if(answer){
					location.href="/book/deleteBook/${book.bookNo}";
				}
			}
		</script>
		
		<br><br>
		<a href="<c:url value='/' />">[홈으로 이동]</a><br>
		<a href="<c:url value='/book/listAllBook' />">[전체 도서 조회로 이동]</a>
	</body>
</html>