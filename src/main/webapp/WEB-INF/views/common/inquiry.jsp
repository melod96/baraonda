<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#inquiry-modal{
/*  width:650px;
height:400px;  */

}

#modal1{
margin-top:180px;
margin-right:47%;

}

#modal2{
width:550px;
height:430px; 
background:white;

}

.modal-header{
background:darkgray;
}
	
.limiter{
font-weight: bold;
}

.limiter2{
width:300px;
height:45px;
background:lightgray;
color:white;
border-radius: 10px;
}

#btn{
width:80px;
height:35px;
background:#aad4b3;
border-radius: 5px;
}

#btn:hover{
background:#a4b68f;
}
 
</style>

	<div class="modal fade" id="inquiry-modal" tabindex="-1" role="dialog"
		aria-labelledby="inquiry" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="z-index: 999999;" id="modal1">
			<div class="modal-content" id="modal2">
			
				<div class="modal-header">
					<span class="login100-form-title p-b-10" style="z-index:50; color:white; height:20px;">제휴·광고문의</span>
				</div>

					
									<div class="limiter" align="center">
									<br>
									<br>
									아래 이메일 주소로 연락주시면<br>
									빠른 시일내에 회신드리도록 하겠습니다.
									<br>
									<br>
									
									<div class="limiter2" align="center">
									<p style="padding-top:10px;"><p style="float:left; margin-left:25px;">담당자 : </p><p style="color:green; float:left;width:100px;;">&nbsp;baraonda5949@gmail.com</p></p>
									</div>
									<br>
									<p>감사합니다.</p>
									<hr style="width:400px; background-color:lightgray;">
									<br>
										<button type="button" id="btn" data-dismiss="modal" aria-hidden="true">확인</button>
						</div>


				
			</div>
		</div>
	</div>
	