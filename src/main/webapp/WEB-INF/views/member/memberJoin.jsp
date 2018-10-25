<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
	.div-join1{width:350px;height:400px;border:5px solid #BFE6F2; border-radius:20px; margin-right:auto;margin-left:auto;margin-top:100px;
				border-style:double;}
	.div-join2{width:300px;height:330px; margin-right:auto;margin-left:auto;margin-top:40px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="div-join1">
		<div class="div-join2">
			<h1 align="center">회원가입</h1>
			
			<form action="insert.me" method="post" enctype="multipart/form-data">
				<div class="form-group">
				   <label for="id">*아이디</label>
				   <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요">
				</div>
				<br><br>
				<div class="form-group">
				   <label for="password">*비밀번호</label>
				   <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요">
				</div>
				<br><br>
				<div class="form-group">
				   <label for="nick_name">*닉네임</label>
				   <input type="text" class="form-control" name="nick_name" id="nick_name" placeholder="닉네임을 입력하세요">
				</div>
				<br>
				<div align="center">
					<button type="submit" class="btn btn-primary">가입하기</button>
					<button type="reset" class="btn btn-default">취소하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>