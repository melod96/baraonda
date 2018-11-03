<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0" />
<title>Insert title here</title>

<jsp:include page="../common/header.jsp" />
<jsp:include page="floalaResources.jsp"/>

<style>
body {
	text-align: center;
}

div#editor {
	width: 100%;
	margin: auto;
	text-align: left;
	border: 1px solid #e4dbdbb5;
	border-top: none;
	margin-top: -31px;
}

.class1 {
	border-radius: 10%;
	border: 2px solid #efefef;
}

.class2 {
	opacity: 0.5;
}

.fr-element {
	height: 500px;
}

.table-striped {
	border-right: 1px solid #e4dbdbb5;
	border-left: 1px solid #e4dbdbb5;
}

.fr-top {
	border-top: 1px solid #e4dbdbb5;
}
.cateTd{width: 150px;}
.hrline {
	border-top: 1px solid #313131;
	margin-bottom: 4px;
}
#form_control {width: 150px; float:left;}
#board_content{height: 470px; width: 700px; margin-top: 20px;}
.boardC{height: 500px; width: 730px; margin-top: -18px; border: 1px solid #dee2e6;}
</style>

</head>

<body>

	<!---------------------------------- 게시글 작성 페이지(글쓰기) ---------------------------------->
		<div class="container">
				<!------------------------------------------------------------------------------------------>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<h2 class="text-left">글쓰기</h2>
						<hr class="hrline"><br>
						<p></p>
						<!------------------------------ 카테고리 ------------------------------>
						<form action="insert.do" method="post" name="form1">
							<div class="table table-responsive">
								<table class="table table-striped">
									<tr>
										<td class="cateTd">카테고리</td>
										<td>
											<select name="writing_type" id="form_control" class="form-control input-xshort">
												<option value="1">다이어트 꿀팁</option>
												<option value="2">다이어트 식단</option>
												<option value="3">칼로리 사전</option>
												<option value="4">홈트레이닝</option>
												<option value="5">체험단</option>
												<option value="6">자유게시판</option>
												<option value="7">고객문의</option>
												<!-- 공지사항 게시판은 관리자만 사용가능하게 설정  -->
												<!-- <option>공지사항</option> -->
											</select>
										</td>
									</tr>
									<!------------------------------ 글 제목 ------------------------------>
									<tr>
										<td id="title">제목</td>
										<td>
											<input id="board_title" name="board_title" type="text" class="form-control">
											<input name="member_no" type="hidden" value= "${loginUser.member_no}">
										</td>
									<tr>
									</tr>

								</table>
								</tr>
								<!------------------------------ 글작성 공간 에디터 ------------------------------>
								<!-- <div id="editor" >
									<div id='edit' style="margin-top: 30px;">
									</div>
								</div> -->
								<div class="boardC">
									<textarea id="board_content" name="board_content" rows="2" cols="40"></textarea>
								</div>
							</div>
						<input id="btnSave" type="submit" value="작성하기" class="btn btn-success">
						<input type="reset" value="취소" class="btn btn-warning">
						</form>
						<!------------------------------ 작성완료, 취소 버튼 ------------------------------>
					</div>
				</div>
				<!------------------------------------------------------------------------------------------>
			</div>
			<br><br><br><br><br><br><br><br><br>

	<script>
		$(function() {
			$('#edit').froalaEditor().on(
					'froalaEditor.image.beforeUpload',
					function(e, editor, files) {
						if (files.length) {
							var reader = new FileReader();
							reader.onload = function(e) {
								var result = e.target.result;

								editor.image.insert(result, null, null,
										editor.image.get());
							};

							reader.readAsDataURL(files[0]);
						}

						return false;
					})
		});
		
		$(document).ready(function(){
			$("#btnSave").click(function(){
				var title = $("#board_title").val();
				if(title == ""){
					alert("제목을 입력하세요.");
					location.href="${path}/baraonda/write.do";
					document.form1.title.focus();
				}
			});
		});
	</script>
	
	<c:if test="${empty sessionScope.loginUser}">
		<script>
			alert("로그인 후 이용해주세요.");
			location.href="${path}/baraonda/main.m";
		</script>
	</c:if>
</body>
</html>





























