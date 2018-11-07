<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
		.imgCover{width:200px; height:200px;border:2px solid gray; border-radius:6px;}
		.imgArea{width:180px;height:180px; margin-right:auto; margin-left:auto; margin-top:10px;}
		#photo{border:2px solid #ddd; margin-top:15px; border-radius:50%;}
		.otInfo td{border:1px solid black; width:100px; height:50px;}
		.otInfo{width:500px;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:include page="../common/header.jsp"/>
	
	<div>
		<div>
			<div class="imgCover">
				<div class="imgArea">
					<img id="photo" src="${pageContext.request.contextPath}/resources/images/myPageImages/level.png">
				</div>
			</div>
			
			<div>
				<table class="otInfo">
					<tr>
						<td>등급</td>
						<td colspan='3'>병아리</td>
					</tr>
					
					<tr>
						<td>닉네임</td>
						<td colspan='4'>형우</td>
					</tr>
					
					<tr>
						<td>자기소개</td>
						<td colspan='5'>힘내쇼</td>
					</tr>
				
				</table>
			</div>
		</div>
		
		<div></div>	
	</div>
	
	
	
	
	
	
	
	
	
	
</body>
</html>