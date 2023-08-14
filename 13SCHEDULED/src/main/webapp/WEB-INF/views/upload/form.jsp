<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>업로드 폼</h1>
<div>
	MSG : ${msg}
</div>

<form action="${pageContext.request.contextPath}/upload/reqUpload" method="POST" enctype="multipart/form-data" >
	<input type="file" name="files"	multiple/>
	<input type="submit" value="upload" />
</form>
<hr>
<a href="${pageContext.request.contextPath}/upload/list">쇼 파일 리스트</a>


</body>
</html>