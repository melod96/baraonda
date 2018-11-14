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
	
	<c:set var="changeNick" value="changeNick"/>
	<c:set var="changePwd" value="changePwd"/>
	<c:set var="changeEmail" value="changeEmail"/>
	
	<c:if test="${!empty changeNick} ">
		<form onsubmit="return check1(this);" action="updateInfo.my" method="post">
			<div class="boxPosition2">
			<br>
				<h3>새로운 닉네임 입력</h3>
				<input type="text" class="form-control" id="text" name="text" placeholder="새로운 닉네임 입력">
				<button type="button" id="checkBtn31" onclick="checkNick();">중복확인</button>
				<input type="hidden" id="type" name="type" value="${type}">
			</div>
			<div class="boxPosition3">
				<button type="submit" id="subBtn1" class="changeBtn1">확인</button>
			</div>
		</form>
	</c:if>
	
	<c:if test="${!empty changePwd} ">
		<form onsubmit="return check2(this);" action="updateInfo.my" method="post">
			<div class="boxPosition2">
			<br>
				<h3>새로운 비밀번호 입력</h3>
				<input type="password" class="form-control" id="text" name="text" placeholder="새로운 비밀번호 입력">
				<input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="새로운 비밀번호 확인">
				<input type="hidden" id="type" name="type" value="${type}">
			</div>
			<div class="boxPosition3">
				<button type="submit" id="subBtn1" class="changeBtn1">확인</button>
			</div>
		</form>
	</c:if>
	
	<c:if test="${!empty changeEmail} ">
		<form onsubmit="return check3(this);" action="updateInfo.my" method="post">
			<div class="boxPosition2">
			<br>
				<h3>새로운 이메일 입력</h3>
				<input type="email" id="email" class="form-control" name="email" value="${loginUser.email}" placeholder="이메일을 등록해주세요.">
				<br>
				<button type="button" id="checkBtn4" onclick="emailCheck2();">이메일 인증하기</button>
				<input type="text" id="emailCheck" class="form-control" name="emailCheck" placeholder="인증번호를 입력해주세요.">
				<button type="button" id="checkBtn5" onclick="insertEmail();">인증완료하기</button> 
			</div>
			<div class="boxPosition3">
				<button type="submit" id="subBtn1" class="changeBtn1">확인</button>
			</div>
		</form>
	</c:if>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	<script>
	function check1(check){
		
			if(check.text.value ==""){
	    	   alert("닉네임을 입력해주세요.");
	    	   return false;
	       }
	       
		
	}
	
	function check2(check){
		
		if(check.text.value ==""){
    	   alert("비밀번호를 입력해주세요.");
    	   return false;
       }
       
       if(check.pwd2.value ==""){
    	   alert("비밀번호를 확인해주세요.");
    	   return false;
       }
       
       if(check.text.value != check.pwd2.value){
    	   alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
    	   return false;
       }
	
}
	
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












