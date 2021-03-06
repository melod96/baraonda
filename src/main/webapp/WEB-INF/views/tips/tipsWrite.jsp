<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0" />
<title>Tips Write</title>
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
						<h2 class="text-left">

						다이어트꿀팁 작성하기</h2>
						<hr class="hrline"><br>
						<p></p>
						<!------------------------------ 카테고리 ------------------------------>
						<form action="insertTips.tp" method="post" enctype = "multipart/form-data">
							<div class="table table-responsive">
								<table class="table table-striped">
									<tr>
										<td class="cateTd">카테고리</td>
										<td>다이어트꿀팁</td>
										</tr>
										<tr>
										<td class="cateTd">종류</td>
										<td>
											<select name="writing_type" id="form_control" class="form-control input-xshort">
												<option value="3">식단</option>
												<option value="2">운동</option>
												<option value="1">칼럼</option>	
											</select>
										
										</td>
									</tr>
									<!------------------------------ 글 제목 ------------------------------>
									<tr>
										<td>제목</td>
										<td><input type="text" class="form-control"
											name="board_title">
											</td>
									</tr>
									<tr>
										<td>썸네일 추가</td>
										<td>
												<button type="button" id="uploadBtn" onclick="uploadPhoto();">사진 불러오기</button>
												
												<input type="file" id="uploadInput" name="photo" style="display:none; float:right;">
										</td>
								
								</table>
								<!------------------------------ 글작성 공간 에디터 ------------------------------>
							
								<textarea id="edit" name="board_content" style="margin-top: 30px;"></textarea>

							</div>
						<!------------------------------ 작성완료, 취소 버튼 ------------------------------>
							<input type="submit" id="subBtn" value="작성하기" class="btn btn-success">
							<input type="reset" value="취소" class="btn btn-warning">
						</form>
					</div>
				</div>
				<!------------------------------------------------------------------------------------------>
			</div>
	</section>

	<script>
    $(function(){
    	$('#edit').froalaEditor({   
    		imageUploadURL:'http://i.froala.com/upload'});
    });
    
    </script>
    
    <script>
    
	var key = "";

	function uploadPhoto(){
		$("#uploadInput").trigger("click");
	}

  </script>
</body>
</html>