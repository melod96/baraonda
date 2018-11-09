<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.div-join1{width:350px;height:400px;border:5px solid #BFE6F2; border-radius:20px;border-style:double;}
	.div-join2{width:270px;height:330px; margin-right:auto;margin-left:auto;margin-top:40px;}
	#joinCompanyView{width:330px; height:700px;}
	#checkBtn1{background:#7cd635;border-radius:5px;color:white;}
	raido{background:black;}
</style>

	<div class="modal fade" id="joinCompany-modal" tabindex="-1" role="dialog"
		aria-labelledby="joinCompany" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="z-index: 999999;">
			<div id="joinCompanyView"class="modal-content">
			
				<div class="modal-header">
					<span class="login100-form-title p-b-10">기업회원가입</span>
				</div>
							<div class="div-join2">
								<form onsubmit="return validate(this);" action="insert.me" method="post">
									<div class="form-group">
									   <label for="id">*아이디</label>
									   <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요">
									   <input type="hidden" name="company_right" value="1">
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
									   <label for="nick_name">*기업명</label>
									   <input type="text" class="form-control" name="nick_name" id="nick_name" placeholder="기업명을 입력하세요">
									</div>
									<br>
									<div class="form-group">
									   <label for="ceo_name">*대표자명</label>
									   <input type="text" class="form-control" name="ceo_name" id="ceo_name" placeholder="대표자명을 입력하세요">
									</div>
									<br>
									<div class="form-group">
									   <label for="company_no">*사업자등록번호</label>
									   <input type="text" class="form-control" name="company_no" id="company_no" placeholder="사업자등록번호를 입력하세요">
									   <button id="checkBtn1">중복확인</button>
									</div>
									<br>
									<div class="form-group">
									   <label for="ceo_type">*사업자종류</label>
										<select name="ceo_type">
										    <option value="0" selected="selected">개인</option>
										    <option value="1">법인</option>
										</select>
									</div>
									<div align="center">
										<button type="submit" class="btn btn-primary">가입하기</button>
										<button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">취소하기</button>
									</div>
								</form>
							</div>
				</div>
			</div>
		</div>
	
	<script>
	
	var idCheck = false;	
	
	   function validate(check) {
	       if(check.id.value ==""){
	    	   alert("아이디를 입력해주세요.");
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
	    	   alert("기업명을 입력해주세요.");
	    	   return false;
	       }
	       
	       if(check.ceo_name.value ==""){
	    	   alert("대표자명을 입력해주세요.");
	    	   return false;
	       }
	       
	       if(check.company_no.value ==""){
	    	   alert("사업자 등록번호를 입력해주세요.");
	    	   return false;
	       }
	       
	       	       
	   }
	</script>