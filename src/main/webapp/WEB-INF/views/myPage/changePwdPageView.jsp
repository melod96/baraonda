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
		input[name="pwd"], input[name="pwd2"]{width:250px;margin-right:127px; margin-top:30px;}
		#subBtn1{margin-top:10px;margin-left:auto; margin-right:auto;}
		#checkBtn11{background:#7cd635;border-radius:5px;color:white;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div class="boxPosition1">
			<form onsubmit="return check2(this);" action="updatePwd.my" method="post">
				<div class="boxPosition2">
				<br>
					<h3>새로운 비밀번호 입력</h3>
					<input type="password" class="form-control" id="pwd" name="pwd" placeholder="새로운 비밀번호 입력">
					<input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="새로운 비밀번호 확인">
					<input type="hidden" id="type" name="type" value="${type}">
				</div>
				<div class="boxPosition3">
					<button type="submit" id="subBtn1" class="changeBtn1">확인</button>
				</div>
			</form>
		</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	<script>
	
function check2(check){
		
		if(check.pwd.value ==""){
    	   alert("비밀번호를 입력해주세요.");
    	   return false;
       }
       
       if(check.pwd2.value ==""){
    	   alert("비밀번호를 확인해주세요.");
    	   return false;
       }
       
       if(check.pwd.value != check.pwd2.value){
    	   alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
    	   return false;
       }
	
}
	</script>
</body>
</html>












