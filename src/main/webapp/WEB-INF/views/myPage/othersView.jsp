<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
		.imgCover{width:170px; height:170px;border:2px solid #89B6C4; border-radius:6px;}
		.imgArea{width:150px;height:150px; margin-right:auto; margin-left:auto; margin-top:10px;}
		#photo{border:2px solid #205FD4; margin-top:15px; border-radius:50%;}
		.otInfo2 td{border:1px solid #89B6C4; border-radius:5px; width:100px; height:55px;}
		.otInfo2{width:500px;}
		.imgCover, .otInfo1{display:inline-block;}
		.InOform{margin-right:auto; margin-left:auto; width:680px; margin-top:100px;}
		.td1{background:#D4F2FC;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:include page="../common/header.jsp"/>
	
	<div>
		<div class="InOform">
		<h4>회원정보 보기</h4>
		<hr style="border:0.05em solid #307ABA; ">
			<div class="imgCover">
				<div class="imgArea">
					<img id="photo" src="${pageContext.request.contextPath}/resources/images/myPageImages/level.png">
				</div>
			</div>
			
			<div class="otInfo1">
				<table class="otInfo2">
					<tr>
						<td class="td1">등급</td>
						<td colspan='3'>병아리 다이어터</td>
					</tr>
					
					<tr>
						<td class="td1">닉네임</td>
						<td colspan='4'>형우</td>
					</tr>
					
					<tr>
						<td class="td1">자기소개</td>
						<td colspan='5'>힘내쇼</td>
					</tr>
					
				</table>
			</div>
		</div>
		
		<div></div>	
	</div>
	
	
	
	
	
	
	
	
	
	
</body>
</html>