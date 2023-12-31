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
			<a class="item" href="javascript:void(0)" data-dir="${subdir.getPath()}" data-file="${file.getName()}">
				${file}
			</a> <br/>
		</c:forEach>
		
	</c:forEach>

</div>

<script>
	const projectPath = '${pageContext.request.contextPath}';
	
	const item_els = document.querySelectorAll('.item');
	item_els.forEach((item) => {
		
		item.addEventListener('click',function(){
			
			const filepath = encodeURIComponent(item.getAttribute('data-dir') + "\\" + item.getAttribute('data-file'))
			alert(filepath);
			location.href = projectPath + "/download?path=" + filepath;
		})
		
	})
</script>





</body>
</html>