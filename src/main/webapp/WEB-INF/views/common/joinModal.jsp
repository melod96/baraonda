<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.div-join1{width:350px;height:400px;border:5px solid #BFE6F2; border-radius:20px;border-style:double;}
	.div-join2{width:270px;height:330px; margin-right:auto;margin-left:auto;margin-top:40px;}
	.modal-content{width:330px; height:700px;}
	#joinCompanyBtn{background:#7cd635;color:white;}
	#checkBtn1, #checkBtn11{background:#7cd635;border-radius:5px;color:white;}
</style>

	<div class="modal fade" id="join-modal" tabindex="-1" role="dialog"
		aria-labelledby="join" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="z-index: 999999;">
			<div class="modal-content">
			
				<div class="modal-header">
					<span class="login100-form-title p-b-10">회원가입</span>
				</div>
							<div class="div-join2">
								<form onsubmit="return validate(this);" action="insert.me" method="post">
									<div class="form-group">
									   <label for="id">*아이디</label>
									   <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요" onchange="changeText(value)">
									    <button type="button" id="checkBtn1" onclick="checkId();">중복확인</button>
									</div>
									<br>
									<div class="form-group">
									   <label for="password">*비밀번호</label>
									   <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요">
									</div>
									<br>
									<div class="form-group">
									  <label for="password">*비밀번호 확인</label>
									  <input type="password" class="form-control" name="pwdCheck" id="pwdCheck" placeholder="비밀번호 확인">
									</div>
									<br>
									<div class="form-group">
									   <label for="nick_name">*닉네임</label>
									   <input type="text" class="form-control" name="nick_name" id="nick_name" placeholder="닉네임을 입력하세요" onchange="changeNickText(value)">
									   <button type="button" id="checkBtn11" onclick="checkNick();">중복확인</button>
									</div>
									<br>
									<div class="form-group">
									   <label for="name">*이름</label>
									   <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요">
									</div>
									<br>
									<div align="center">
										<button type="submit" class="btn btn-primary">가입하기</button>
										<button id="joinCompanyBtn" class="btn btn-default"  data-toggle="modal" data-target="#joinCompany-modal"
										 data-dismiss="modal" aria-hidden="true">기업 회원 가입</button>
										<button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">취소하기</button>
									</div>
								</form>
							</div>
							
							
				</div>
			</div>
		</div>
	
	<script>
	
	
	
	var idCheck = false;	
	var nicknameCheck = false;
	
	   function validate(check) {
	       if(check.id.value ==""){
	    	   alert("아이디를 입력해주세요.");
	    	   return false;
	       }
	       
	       if(idCheck == false){
				alert("아이디 중복확인을 해주세요!");
				return false;
			}
	       
	       if(check.password.value ==""){
	    	   alert("비밀번호를 입력해주세요.");
	    	   return false;
	       }
	       
	       if(check.pwdCheck.value ==""){
	    	   alert("비밀번호를 확인해주세요.");
	    	   return false;
	       }
	       
	       if(check.password.value != check.pwdCheck.value){
	    	   alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	    	   return false;
	       }
	       
	       if(check.nick_name.value ==""){
	    	   alert("닉네임을 입력해주세요.");
	    	   return false;
	       }
	       
	       if(nicknameCheck == false){
				alert("닉네임 중복확인을 해주세요!");
				return false;
			}
	       
	       if(check.name.value ==""){
	    	   alert("이름을 입력해주세요.");
	    	   return false;
	       }
	       
	       
	   }
	   
	
	 //아이디 중복체크
		
		function checkId() {
			var id = $("#id").val();
			var idCheck = false;
			var result = "";
				 
			var re = /^[a-zA-Z0-9]{3,12}$/;
			
			
			if(!re.test(id)){
				alert("3~12자의 영문 대소문자와 숫자만 입력 가능합니다.");
				
			}else{
				if (id != "" && id != null) {
					$.ajax({
						url : "checkId.me",
						type : "post",
						data : {id : id},
						success : function(data) {
							if(data != 0){
								alert("이미 사용중인 아이디 입니다.");
							}else{
								alert("사용 가능한 아이디 입니다.");
								idCk();
							}
						},
						error : function() {
							console.log("실패");
						}
					});
				}
			}
		}
	 
		function checkNick() {
			var nick_name = $("#nick_name").val();
			var nicknameCheck = false;
			
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
								nicknameCk();
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

		function idCk() {
			idCheck = true;
		} 
		
		function nicknameCk() {
			nicknameCheck = true;
		} 
		
		function changeText(text){
			idCheck = false;
		}
		
		function changeNickText(text){
			nicknameCheck = false;
		}
		
		
		   
	</script>
	
	
	
	
	
	