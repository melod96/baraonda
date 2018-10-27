<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0" />
<title>Insert title here</title>

<jsp:include page="../common/head.jsp"></jsp:include>
<jsp:include page="floalaResources.jsp"></jsp:include>

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

</style>

</head>

<body>
	<!---------------------------------- 게시글 작성 페이지(글쓰기) ---------------------------------->
	<section class="content">
		<div class="ic">More Website Templates @ TemplateMonster.com -
			July 30, 2014!</div>
		<div class="container">
				<!------------------------------------------------------------------------------------------>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<h2 class="text-left">글쓰기</h2>
						<hr class="hrline"><br>
						<p></p>
						<!------------------------------ 카테고리 ------------------------------>
						<form action="BoardReWriteProc.jsp" method="post">
							<div class="table table-responsive">
								<table class="table table-striped">
									<tr>
										<td class="cateTd">카테고리</td>
										<td><select id="form_control" class="form-control input-xshort">
												<option>다이어트 꿀팁</option>
												<option>다이어트 식단</option>
												<option>칼로리 사전</option>
												<option>홈트레이닝</option>
												<option>체험단</option>
												<option>자유게시판</option>
												<option>고객문의</option>
												<!-- 공지사항 게시판은 관리자만 사용가능하게 설정  -->
												<!-- <option>공지사항</option> -->
												
										</select></td>
									</tr>
									<!------------------------------ 글 제목 ------------------------------>
									<tr>
										<td>제목</td>
										<td><input type="text" class="form-control"
											name="subject"></td>
									<tr>
									</tr>

								</table>
								</tr>
								<!------------------------------ 글작성 공간 에디터 ------------------------------>
								<div id="editor" >
									<div id='edit' style="margin-top: 30px;">
									
									</div>
								</div>

							</div>
						</form>
						<!------------------------------ 작성완료, 취소 버튼 ------------------------------>
						<input type="submit" value="작성하기" class="btn btn-success">
						<input type="reset" value="취소" class="btn btn-warning">
					</div>
				</div>
				<!------------------------------------------------------------------------------------------>
			</div>
	</section>

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
	</script>
</body>
</html>