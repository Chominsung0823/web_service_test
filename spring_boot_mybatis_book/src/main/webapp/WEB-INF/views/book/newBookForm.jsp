<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>newBookForm</title>
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script src="<c:url value='/js/bookNoCheck.js'/>"></script>
	</head>
	<body>
		<h3>상품 정보 등록</h3>
		
		<form method="post" action="<c:url value='/book/insertBook' />">
		<table>
			<tr><td>도서번호</td><td><input type="text" id = "bookNo" name="bookNo">
			<button id="bookNoCheckBtn" name="bookNoCheckBtn">중복확인</button>
			</td></tr>		
			<tr><td>도서명</td><td><input type="text" id = "bookName" name="bookName"></td></tr>		
			<tr><td>저자</td><td><input type="text" id = "bookAuthor" name="bookAuthor"></td></tr>		
			<tr><td>가격</td><td><input type="text" id = "bookPrice" name="bookPrice"></td></tr>	
			<tr><td>발행일</td><td><input type="text" id = "bookDate" name="bookDate"></td></tr>		
			<tr><td>재고</td><td><input type="text" id = "bookStock" name="bookStock"></td></tr>	
			<tr><td>출판사 번호</td><td><input type="text" id = "pubNo" name="pubNo"></td></tr>			
			<tr><td colspan="2"><input type="submit" value="등록">
				<input type="reset" value="취소"></td></tr>
			</table>
		</form>
	</body>
</html>