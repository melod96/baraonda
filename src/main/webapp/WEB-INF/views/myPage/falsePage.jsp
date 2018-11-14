<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
	.boxbox1{width:300px;margin-left:auto; margin-right:auto;}
	.changeBtn1{background:#90C3D4;border-radius:5px;color:white;width:150px;height:30px;}
	#subBtn1{margin-top:10px;margin-left:80px; margin-right:auto;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<br><br><br>
	<h4 align="center">${msg }</h4>
	
	<div class="boxbox1">
		<button type="button" id="subBtn1" class="changeBtn1" onclick="backPage();">이전페이지</button>
	</div>
	
	<script>
		function backPage(){
			location.href="checkPwd.my?type="+"${type}";
		}
	</script>
	
</body>
</html>












