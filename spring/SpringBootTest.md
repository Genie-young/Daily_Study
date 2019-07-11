```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>Hello</title>
</head>
<body>
	<!--/* <xmp> */-->
	<h2>Hello! </span></h2>
	<!-- <div th:text="${cnt}">100 </div>  //타임리프틔 장점은  html과 연동되서 content는 가짜고 ${}가 그 자리에 대신 들어감. 그래서 html 파일로 열었을 때도 정상적으로 show 가능 -->
	 
	<tr th:each="board : ${boardlist}"> 
		<td th:text="${board.seq}"> 번호 </td>
		<td th:text="${board.title}"> 제목 </td>
		<td th:text="${board.contents}"> 내용 </td>
		</br>
	<tr>
</body>
</html>
```



```
			<script th:if="!${board?.seq}">
		$('#insert').click(function() {
			var jsonData = JSON.stringify({
				title : $('#board_title').val(),
				content : $('#board_contents').val()
			});
		});
	</script>
		$('#update').click(function() {
			var jsonData = JSON.stringify({
				title : $('#board_title').val(),
				content : $('#board_content').val(),
				createdDate : $('#board_create_date').val()
			});
			//https://github.com/young891221/Spring-Boot-Community-Web
		});
		
		
				$('#delete').click(
				function() {
					$.ajax({
						url : "http://localhost:8081/api/boards/"
								+ $('#board_seq').val(),
						type : "DELETE",
						success : function() {
							alert('삭제 성공!');
							location.href = '/board/list';
						},
						error : function() {
							alert('삭제 실패!');
						}
					});
				});
```

