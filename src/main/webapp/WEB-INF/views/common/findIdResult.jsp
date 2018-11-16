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
		#checkBtn4{float:left; margin-top:10px;}
		#checkBtn11{background:#7cd635;border-radius:5px;color:white;}
		input[name=emailCheck], #checkBtn5{visibility:hidden;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div class="boxPosition1">
			<form onsubmit="return check3(this);" action="updateEmail" method="post">
				<div class="boxPosition2">
				<br>
					<h2>아이디 찾기 결과</h2>
					
					<c:forEach items="${findIdList}" var ="f">
						<input type="text" class="form-control" value="${f.id}" readonly>
					</c:forEach>
				</div>
				<div class="boxPosition3">
					<button type="button" id="checkBtn5" class="changeBtn1" onclick="insertEmail();">Find Password</button> 
				</div>
			</form>
		</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	<script>
	
	
	</script>
</body>
</html>












