<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.div-join1{width:350px;height:400px;border:5px solid #BFE6F2; border-radius:20px;border-style:double;}
	.div-join2{width:270px;height:330px; margin-right:auto;margin-left:auto;margin-top:40px;}
	#joinCompanyView{width:330px; height:700px;}
	#checkBtn2, #checkBtn3{background:#7cd635;border-radius:5px;color:white;}
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
						<form onsubmit="return validate2(this);" action="insert.me" method="post">
							<div class="form-group">
							   <label for="id">*아이디</label>
							   <input type="text" class="form-control" name="id1" id="id1" placeholder="아이디를 입력하세요"  onchange="changeText2(value)">
							   <button type="button" id="checkBtn3" onclick="checkId2();">중복확인</button>
							   <input type="hidden" name="company_right" value="1">
							</div>
					 		<br>
							<div class="form-group">
							   <label for="password">*비밀번호</label>
							   <input type="password" class="form-control" name="password1" id="password1" placeholder="비밀번호를 입력하세요">
							</div>
							<br>
							<div class="form-group">
							   <label for="password">*비밀번호 확인</label>
							   <input type="password" class="form-control" name="pwdCheck1" id="pwdCheck1" placeholder="비밀번호 확인">
							</div>
							<br>
							<div class="form-group">
							   <label for="nick_name">*기업명</label>
							   <input type="text" class="form-control" name="nick_name1" id="nick_name1" placeholder="기업명을 입력하세요">
							</div>
							<br>
							<div class="form-group">
							   <label for="ceo_name">*대표자명</label>
							   <input type="text" class="form-control" name="ceo_name" id="ceo_name" placeholder="대표자명을 입력하세요">
							</div>
							<br>
							<div class="form-group">
							   <label for="company_no">*사업자등록번호</label>
							   <input type="text" class="form-control" name="company_no" id="company_no" placeholder="'-' 제외한  10자리입력"  onchange="changeText3(value)">
							   <button type="button" id="checkBtn2" onclick="checkBizID();">중복확인</button>
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
	
	var idCheck2 = false;	
	var BizID = false;
	   function validate2(check) {
	       if(check.id1.value ==""){
	    	   alert("아이디를 입력해주세요.");
	    	   return false;
	       }
	       
	       if(idCheck2 == false){
				alert("아이디 중복확인을 해주세요!");
				return false;
			}
	       
	       
	       if(check.password1.value ==""){
	    	   alert("비밀번호를 입력해주세요.");
	    	   return false;
	       }
	       
	       if(check.pwdCheck1.value ==""){
	    	   alert("비밀번호를 확인해주세요.");
	    	   return false;
	       }
	       
	       if(check.password1.value != check.pwdCheck1.value){
	    	   alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	    	   return false;
	       }
	       
	       if(check.nick_name1.value ==""){
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
	   
	   //아이디 중복체크
		
		function checkId2() {
			var id = $("#id1").val();
			var idCheck = false;
			var result = "";

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
							idCk2();
						}
					},
					error : function() {
						console.log("실패");
					}
				});
			}
		}

		function idCk2() {
			idCheck2 = true;
		} 
		
		function changeText2(text){
			idCheck2 = false;
		}
		
		function changeText3(text){
			BizID = false;
		}
		
		
		
		
		//사업자등록번호 체크 
		function checkBizID(){ 
			var BizID = false;
			var bizID = $("#company_no").val();
			
		    // bizID는 숫자만 10자리로 해서 문자열로 넘긴다. 
		    var checkID = new Array(1, 3, 7, 1, 3, 7, 1, 3, 5, 1); 
		    var tmpBizID, i, chkSum=0, c2, remander; 
		     bizID = bizID.replace(/-/gi,''); 

		     for (i=0; i<=7; i++) chkSum += checkID[i] * bizID.charAt(i); 
		     c2 = "0" + (checkID[8] * bizID.charAt(8)); 
		     c2 = c2.substring(c2.length - 2, c2.length); 
		     chkSum += Math.floor(c2.charAt(0)) + Math.floor(c2.charAt(1)); 
		     remander = (10 - (chkSum % 10)) % 10 ; 
		     

		    if (Math.floor(bizID.charAt(9)) == remander){
		    	
		    	if (bizID != "" && bizID != null) {
		    		
					$.ajax({
						url : "checkBizID.me",
						type : "post",
						data : {bizID : bizID},
						success : function(data) {
							if(data != 0){
								alert("이미 등록된 사업자번호 입니다.");
								BizID = false;
							}else{
								alert("사업자등록번호 확인이 완료되었습니다.");
								BizID = true;
							}
						},
						error : function() {
							console.log("실패");
						}
					});
				}
		    	
		    }else{
		    	alert("사업자등록번호가 잘못되었습니다.");
		    	BizID = false;
		    }
		} 
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	