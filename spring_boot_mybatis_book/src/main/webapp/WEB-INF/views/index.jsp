<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 정보 조회</title>
	</head>
	<body>
		<h3>도서 정보</h3>
		
		<a href="<c:url value='/book/listAllBook' />">[전체 도서 조회]</a><br>
		<a href="<c:url value='/book/newBookForm' />">[도서 등록]</a><br>
		
		<br>
		<img src="image/apple.png">
		
		<h3>도서 검색</h3>
		<a href="<c:url value='/book/bookSearchForm1' />">[도서 검색]</a><br>
		<a href="<c:url value='/book/bookSearchForm2' />">[도서 검색2]</a><br>
		
		<h3>파일 업로드</h3>
		<a href="<c:url value='/fileUploadForm' />">[파일 업로드]</a><br>
		
	</body>
</html>