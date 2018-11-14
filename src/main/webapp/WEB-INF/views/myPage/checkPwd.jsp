<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
		.boxPosition1{width:500px; height:260px;border:1px solid #ddd; margin-left:auto; margin-right:auto; margin-top:150px;text-align:center;
						border-radius:5px; }
		.boxPosition2{width:500px; height:170px; margin-left:auto; margin-right:auto;text-align:center;}
		.boxPosition3{width:500px; height:70px; margin-left:auto; margin-right:auto; text-align:center;}
		.changeBtn1{background:#90C3D4;border-radius:5px;color:white;width:150px;height:30px;}
		input[name="pwd"]{width:250px;margin-right:127px; margin-top:30px;}
		#subBtn1{margin-top:10px;margin-left:auto; margin-right:auto;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="boxPosition1">
	
	<form action="selectPwd.my" method="post">
		<div class="boxPosition2">
			<h2>비밀번호 확인</h2>
			<input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요">
			<input type="hidden" id="type" name="type" value="${type}">
		</div>
		<div class="boxPosition3">
			<button type="submit" id="subBtn1" class="changeBtn1">확인</button>
		</div>
	</form>
	
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	
	<script>
	
	/* $(function(){
		if(${msg} != "" && ${msg} != null){
			alert("${msg}");
		}
	});
	*/
	
	</script>
	
</body>
</html>












