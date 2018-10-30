<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
		/*내 프로필 구역*/
		.mainFrame{width:800px;height:auto;margin-right:auto;margin-left:auto;margin-top:0px;margin-bottom:150px;}
		.profileFrame{
				width:800px;height:auto;margin-right:auto;margin-left:auto;border:3px solid #CFCFCF;border-radius:10px;
				margin-top:20px;}
		.profileImg{width:150px;margin-left:10px;}
		#uploadBtn, #removeBtn, #subBtn{width:90px;height:30px;margin-left:30px;font-size:10px;}
		#uploadBtn{ margin-top:15px; border:1px solid darkgray;}
		#subBtn{ margin-top:8px; border:1px solid darkgray;}
		#removeBtn{ margin-top:8px; border:1px solid darkgray; margin-bottom:10px;}
		#photo{border:2px solid #ddd; margin-top:15px; border-radius:50%;}
		.profileImg, .profileInfo{display:inline-block;}
		.profileInfo{margin-top:17px;margin-left:20px; }
		.exeInfo{border:1px solid black; width:250px; height:170px;border:1px solid darkgray; border-radius:3px;}
		#level{width:50px; height:50px; margin-left:10px; margin-top:35px;display:inline-block;}
		.exe1{display:inline-block;margin-left:15px;margin-top:5px;}	
		#exe3{margin-top:30px; margin-left:auto; margin-right:auto;width:150px;text-align:center;
				font-weight:bold; font-size:16px; }	
		.introInfo{width:250px;margin-top:20px;display:inline-block;}
		#introText{width:300px;height:300px; border:1px solid darkgray; border-radius:3px;}
		#myExe{margin-bottom:10px;}
		 .profileArea1, .profileArea2{display:inline-block;}
		 .profileArea1{margin-top:20px;}
		 .profileArea2{margin-left:30px;}
		 #introText{margin-top:10px;height:170px;}
		 
		 /*내 정보 수정 구역*/
		 input[name=id], input[name=nick_name],input[name=password],input[name=password2],input[name=password3]{width:300px; height:31px;margin-top:-26px;margin-bottom:15px;margin-right:280px;}
		.textLabel{border:1px solid darkgray; border-radius:3px;width:150px;text-align:center;
					background:#ddd ;color:white;}
		.position2{margin-top:15px;margin-bottom:15px;margin-left:30px;}
		
		.changeInfo{border:3px solid #CFCFCF;border-radius:10px;margin-top:30px;}
		
		.osArea{width:100%;}
		.selectBtn{width:100%;margin-left:570px;}
		.btn-yn{border:1px solid #ddd !important; width:100px; margin:5px;}
		#btnS{background:#1C95BD; color:white;}
		#btnR, #btn1{background:#ddd;}
		#btn1{float:left;}
		
		.emptyLogin{width:800px; margin-left: auto; margin-right: auto;text-align:center;}
		
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:include page="../common/header.jsp"/>
	
	<c:if test="${!empty sessionScope.loginUser}">
	<jsp:include page="../common/myHeader.jsp"/>
		<div class="mainFrame">
			<div class="profileFrame">
				<div class="profileImg">
					<img id="photo" src="${pageContext.request.contextPath}/resources/images/uploadFiles/${file.files_change_title}">
					<form action="uploadPhoto.my" method="post"  enctype="multipart/form-data">
						<div class="Position1">
							<button type="button" id="uploadBtn" class="btn btn-default" onclick="uploadPhoto();">사진 불러오기</button>
							<button type="submit" id="subBtn" class="btn btn-default">등록하기</button>
							<input type="file" id="uploadInput" name="photo" style="display:none;">
						</div>
					</form>
					<div class="Position1"><button type="button" id="removeBtn" class="btn btn-default">사진 삭제</button></div>
				</div>
				
				<div class="profileInfo">
					<div class="profileArea1">
							<h5 id="myExe">[내 경험치]</h5>
						<div class="exeInfo">
							<img id="level" src="${pageContext.request.contextPath}/resources/images/myPageImages/chicks.png">
							<div class="exe1">
								<br>
								<h6>현재 경험치 량 : <c:out value="${point.accrue_point}"/></h6>
								<br>
								<h6>다음 단계까지 :900</h6>
							</div>
							<h5 id="exe3">현재 등급 : 병아리</h5>
						</div>
					</div>
					<div class="profileArea2">
						<div class="introInfo">
							<h5>[한 줄 다짐]</h5>
							<pre id="introText">다들 한 번 열심히 해봅시다.</pre>
						</div>
					</div>
				</div>
			</div>
			<form action="changeInfo.my" method="post">
				<div class="changeInfo">
					<div class="position2">
						<div class="textLabel">계정</div>
						<input type="text" class="form-control" name="id" value="${loginUser.id }" readonly>
					</div>
					
					<div class="position2">
						<div class="textLabel">닉네임</div>
						<input type="text" class="form-control" name="nick_name" value="${loginUser.nick_name}">
					</div>
					
					<br>
					
					<div class="position2">
						<div class="textLabel">현재 비밀번호</div>
						<input type="password" class="form-control" name="password2" placeholder="현재 비밀번호 입력">
						
					</div>
					
					<div class="position2">
						<div class="textLabel">변경 비밀번호</div>
						<input type="password" class="form-control" name="password" placeholder="변경할 비밀번호 입력">
						
					</div>
					
					<div class="position2">
						<div class="textLabel">비밀번호 확인</div>
						<input type="password" class="form-control" name="password3" placeholder="비밀번호 확인">
					</div>
				</div>
				
				<input type="hidden" name="member_no" value="${loginUser.member_no }">
				
				<div class="osArea">
					<div id="out1">
						<button id="btn1" class="btn btn-yn">회원탈퇴</button>
					</div>
					
					<div class="selectBtn">
						<button type="submit" id="btnS" class="btn btn-yn">확인</button>
						<button type="reset" id="btnR" class="btn btn-yn">취소</button>
					</div>
				</div>
			</form>
		</div>
	</c:if>
	
	<c:if test="${empty sessionScope.loginUser}">
		<div class="emptyLogin">
			<h2>로그인 후 이용해주세요.</h2>
			<button onclick="location.href='goMain.me'">메인으로 이동</button>
		</div>
	</c:if>
	
	<script>
		function uploadPhoto(){
			$("#uploadInput").trigger("click");
		}
	
	
	</script>
</body>
</html>