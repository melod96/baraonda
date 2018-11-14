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
			<form onsubmit="return check2(this);" action="updateNick.my" method="post">
				<div class="boxPosition2">
				<br>
					<h3>새로운 닉네임 입력</h3>
					<input type="text" class="form-control" id="nick" name="nick" placeholder="새로운 닉네임 입력" onchange="changeNickText2(value)">
					<button type="button" id="checkBtn31" onclick="checkNick2();">중복확인</button>
				</div>
				
				<div class="boxPosition3">
					<button type="submit" id="subBtn1" class="changeBtn1">확인</button>
				</div>
			</form>
		</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	<script>
	
	var nicknameCheck2 = false;
	
	
		function check2(check) {

			if (check.nick.value == "") {
				alert("닉네임을 입력해주세요.");
				return false;
			}

			if (nicknameCheck2 == false) {
				alert("닉네임 중복확인을 해주세요!");
				return false;
			}
		}
		
		function checkNick2() {
			var nick_name = $("#nick").val();
			var nicknameCheck2 = false;
			
				if (nick_name != "" && nick_name != null) {
					$.ajax({
						url : "checkNick.me",
						type : "post",
						data : {nick_name : nick_name},
						success : function(data) {
							if(data != 0){
								alert("이미 사용중인 닉네임 입니다.");
							}else{
								alert("사용 가능한 닉네임 입니다.");
								nicknameCk2();
							}
						},
						error : function() {
							console.log("실패");
						}
					});
				}else if(nick_name == "" || nick_name== null){
					alert("닉네임을 입력해주세요")
				}
			
		}
		
		function nicknameCk2() {
			nicknameCheck2 = true;
		} 
		
		function changeNickText2(text){
			nicknameCheck2 = false;
		}
	</script>
</body>
</html>












