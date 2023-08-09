<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>리스트 파일</h1>
<div>업로드 디르 : ${rootDir} </div>
<div>
	<c:forEach items='${rootDir.listFiles() }' var='subdir'>
		<hr>
		뽈더 : ${subdir.getPath() }
		<c:forEach items='${subdir.listFiles() }' var='file'>
			<a href="javascript:void(0)">${file.getName()}</a> <br/>
		</c:forEach>
		<hr>
		
	</c:forEach>

</div>

</body>
</html>