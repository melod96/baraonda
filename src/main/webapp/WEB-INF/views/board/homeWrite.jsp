<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0" />
<title>BARAON.DA - 글쓰기</title>

<jsp:include page="../common/header.jsp" />
<jsp:include page="floalaResources.jsp"/>

<style>
body {
	text-align: left;
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
	border-top: 1.5px solid #313131;
	margin-bottom: 4px;
}
#form_control {width: 150px; float:left;}
#board_content{height: 470px; width: 700px; margin-top: 20px;}
#froala-editor{{height: 470px; width: 700px; margin-top: 20px;}}
.fr-box{border: 1px solid #dee2e6; margin-top: -16px;}
.boardC{height: 500px; width: 730px; margin-top: -18px; border: 1px solid #dee2e6;}
.boardWriteBtn{text-align: center;}
.text-left{font-weight: bold;}
#uploadBtn:hover{color:#28a745;}
</style>

</head>

<body>

	<!---------------------------------- 게시글 작성 페이지(글쓰기) ---------------------------------->
		<div class="container">
				<!------------------------------------------------------------------------------------------>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<h2 class="text-left">홈트레이닝 - 글쓰기</h2>
						<hr class="hrline"><br>
						<p></p>
						<!------------------------------ 카테고리 ------------------------------>
						<form action="insertHome.do" method="post" enctype = "multipart/form-data">
							<div class="table table-responsive">
								<table class="table table-striped">
									<tr>
										<td class="cateTd">카테고리</td>
										<td>
											<select name="writing_type" id="form_control" class="form-control input-xshort">
												<option value="6">전신</option>
												<option value="7">복부</option>
												<option value="8">상체</option>
												<option value="9">하체</option>
											</select>
										</td>
									</tr>
									<!------------------------------ 글 제목 ------------------------------>
									<tr>
										<td id="title">제목</td>
										<td>
											<input type="text" class="form-control"name="board_title">
										</td>
									</tr>
									<tr>
									<td>썸네일 추가</td>
										<td>
											<button type="button" id="uploadBtn" onclick="uploadPhoto();">사진 불러오기</button>
												
											<input type="file" id="uploadInput" name="photo" style="display:none; float:right;">
										</td>
									</tr>

								</table>
								<!------------------------------ 글작성 공간 (froala editor) ------------------------------>
								<textarea id="edit" name="board_content"></textarea>
								
							</div>
						<div class="boardWriteBtn">
							<input id="subBtn" type="submit" value="작성하기" class="btn btn-success">
							<input type="reset" value="취소" class="btn btn-warning">
						</div>
						</form>
						<!------------------------------ 작성완료, 취소 버튼 ------------------------------>
					</div>
				</div>
				<!------------------------------------------------------------------------------------------>
			</div>
			<br><br><br><br><br><br><br><br><br>

	<script>
		/* froala editor를 textarea에 적용 */
	  	$('#edit').froalaEditor({   
			imageUploadURL:'http://i.froala.com/upload'});
		
		/* 제목, 내용 입력 체크 */
		$(document).ready(function(){
			$("#subBtn").click(function(){
				var title = $("#board_title").val();
				var content = $("#edit").val();
				if(title == ""){
					alert("제목을 입력하세요.");
					document.getElementById('title').focus();
					return;
				}
				if(content == ""){
					alert("내용을 입력하세요.");
					document.getElementById('edit').focus();
					return;
				}
				document.form1.submit();
			});
		});
		
		/* 썸네일 이미지 DB업로드 */
		var key = "";
	
		function uploadPhoto(){
			$("#uploadInput").trigger("click");
		}

	</script>
</body>
</html>





























