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
					<h3>새로운 이메일 입력</h3>
					<input type="email" id="email" class="form-control" name="email" placeholder="새로운 이메일을 입력해주세요.">
					<button type="button"  id="checkBtn4" class="changeBtn1" onclick="emailCheck2();">이메일 인증하기</button>
					
				</div>
				<div class="boxPosition3">
					<input type="text" id="emailCheck" class="form-control" name="emailCheck" placeholder="인증번호를 입력해주세요.">
					<button type="button" id="checkBtn5" class="changeBtn1" onclick="insertEmail();">인증완료하기</button> 
				</div>
			</form>
		</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	<script>
	
	var key = "";
	
	function emailCheck2(){
		var email = $("#email").val();
		console.log(email);
		if(email != null && email != ""){
			 $.ajax({
					url:"emailCheck.my",
					type:"post",
					data:{email:email},
					success:function(data){
						key = data;
					},
					error:function(){
						console.log("에러 발생!");
					}
				});
			alert("인증번호가 전송되었습니다.");
			$("#emailCheck").css("visibility","visible");
			$("#checkBtn5").css("visibility","visible");
		}else{
			alert("이메일을 입력해주세요.");
		}
	}
	
	function insertEmail(){
		
		var emailCheck = $("#emailCheck").val();
		var email = $("#email").val();
		if(key == emailCheck){
			alert("인증이 완료되었습니다.");
			location.href="updateEmail.my?email="+email+"&member_no="+${loginUser.member_no};
		}else{
			alert("인증번호가 틀립니다. 다시입력해주세요.")
		}
	}
	
	</script>
</body>
</html>












