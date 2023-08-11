<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쇼 메모</h1>

	<div class="showMemo">
		<c:forEach items="${list }" var="dto">
			<a href="javascript:void(0)" class="memo"> 
				<span>${dto.id }</span>&nbsp;&nbsp;<span>${dto.text }</span>
			</a>
			&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="cancel" data-id="${dto.id}">X</a><br/>
		</c:forEach>
	</div>
	<hr>
	<h1>포스트 메모</h1>
	<div class="postMemo">
		<form onsubmit="return false" name="post_form">
			<textarea name="postArea"></textarea>
			<button class="post_btn">POST</button>
		</form>
	</div>
	<hr>
	<h1>업데이트 메모</h1>
	<div class="updateMemo">
		<form onsubmit="return false" name="update_form">
			<input name=updateId disabled><br />
			<textarea name="updateArea"></textarea>
			<button class="update_btn">수정</button>
		</form>
	</div>

	<!-- axios Cdn -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js"
		integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
	
// 		Post MEMO
		const post_btn_el = document.querySelector(".post_btn");
		post_btn_el.addEventListener('click',function(){
			console.log("post_btn_el clicked..");
			const postArea_el = document.post_form.postArea;
			console.log("area's value",postArea_el.value)
			

			
// 			요청 헤더 타입 지정
			const header = {
				headers:{
					"Context-Type": "application/json"
				}
			}
			
// 			파라미터
			const params = {
				text: postArea_el.value
			}
			
			axios.post("http://localhost:8080/app/memo/add", params, header)
			.then(response => {
				alert("memo add 성공 🐧🐧", response);
				location.reload();
			})
			.catch(error => {
				alert("memo add 실패 💩💩", error)
			});
		})
		
// 		UPDATE MEMO http://localhost:8080/app/memo/put2

// 		------------01 메모 클릭 시 Update Form으로 전달하기-------------
		const memo_els = document.querySelectorAll('.memo');
		memo_els.forEach((memo_el) => {
			
			memo_el.addEventListener('click',function(){
				console.log('memo clicked..', memo_el.children[1].innerHTML)
				const form = document.update_form;
				form.updateId.value = memo_el.children[0].innerHTML;
				form.updateArea.value = memo_el.children[1].innerHTML;
			})
		})
		
		
// 		----------------02 업데이트 요청하기-------------------------------
		const update_btn_el = document.querySelector(".update_btn");
		update_btn_el.addEventListener('click',function(){
			console.log("update_btn_el clicked..");
		
			const updateArea_el = document.update_form.updateArea;
			const updateId_el = document.update_form.updateId;
			
			console.log("area's value",updateArea_el.value)
		
// 			요청 헤더 타입 지정
			const header = {
				headers:{
					"Context-Type": "application/json"
				}
			}
			
// 			파라미터
			const params = {
				id : updateId_el.value,
				text: updateArea_el.value
			}
			
			axios.put("http://localhost:8080/app/memo/put2", params, header)
			.then(response => {
				alert("memo Update 성공 🐧🐧", response);
				location.reload();
			})
			.catch(error => {
				alert("memo Update 실패 💩💩", error)
			});
		})
		
// 		--------------------------03 delete------------------------(http://localhost:8080/app/memo/remove/{id})
// 		1) .cancel Els 가져오기
		const cancel_els = document.querySelectorAll('.cancel')
		cancel_els.forEach((cancel_el) => {
			
			cancel_el.addEventListener('click',function(){
				const id = cancel_el.getAttribute('data-id');
				console.log("remove id : " + id);
				
				axios.delete("http://localhost:8080/app/memo/remove/" + id)
				.then(response =>{
					location.reload();
				})
				.patch(error => {
					console.log(error);});
				
				
			})
			
		})








	</script>


</body>
</html>