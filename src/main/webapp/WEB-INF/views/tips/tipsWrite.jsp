<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0" />
<title>다이어트꿀팁</title>
<link href='https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.8.5/css/froala_editor.min.css' rel='stylesheet' type='text/css' />
<link href='https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.8.5/css/froala_style.min.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.8.5/js/froala_editor.min.js'></script>
<jsp:include page="../common/head.jsp"></jsp:include>
<jsp:include page="../board/floalaResources.jsp"></jsp:include>

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
<jsp:include page="../common/header.jsp" />
	<!---------------------------------- 게시글 작성 페이지(글쓰기) ---------------------------------->
	<section class="content">
		<div class="container">
				<!------------------------------------------------------------------------------------------>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<h2 class="text-left">다이어트꿀팁 작성하기</h2>
						<hr class="hrline"><br>
						<p></p>
						<!------------------------------ 카테고리 ------------------------------>
						<form action="BoardReWriteProc.jsp" method="post">
							<div class="table table-responsive" style="height:600px;">
								<table class="table table-striped" >
									<tr>
										<td class="cateTd">카테고리</td>
										<td>
											<select>
												<option>식단</option>
												<option>운동</option>
												<option>칼럼</option>
											</select>
										</td>
									</tr>
									<!------------------------------ 글 제목 ------------------------------>
									<tr>
										<td>제목</td>
										<td><input type="text" class="form-control"
											name="subject" id="title"></td>
											<tr>
										<td colspan="2" style="background-color:white;">

											
											    <textarea id='edit' name="content" style="height: 600px; width:685px;"></textarea>
												<script>
													$(function() {
														$('#edit').froalaEditor()
													});
													$(function() {
														$('#edit2').froalaEditor()
													});
												</script>
																
										</td>
								</tr>
								</table>								
								<!------------------------------ 글작성 공간 에디터 ------------------------------>
							<!-- 	<div id="editor" >
									<div id='edit' style="margin-top: 30px;">
									
									</div>
								</div> -->

							</div>
						</form>
						
						<script>
	                   	function formCheck(frm){
	                   		var title = $("#title");
	                   		var editor = $("#editor");
							
							if(frm.title.value == "" || frm.editor.value == ""){
								alert("제목 또는 내용을 입력하세요");
								frm.title.focus();
								return false;
							}
	                   	}
	                </script>
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