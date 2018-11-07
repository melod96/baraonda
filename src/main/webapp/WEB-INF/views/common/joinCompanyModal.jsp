<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.div-join1{width:350px;height:400px;border:5px solid #BFE6F2; border-radius:20px;border-style:double;}
	.div-join2{width:270px;height:330px; margin-right:auto;margin-left:auto;margin-top:40px;}
	#joinCompanyView{width:330px; height:700px;}
	#checkBtn1{background:#7cd635;border-radius:5px;color:white;}
</style>

	<div class="modal fade" id="joinCompany-modal" tabindex="-1" role="dialog"
		aria-labelledby="joinCompany" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="z-index: 999999;">
			<div id="joinCompanyView"class="modal-content">
			
				<div class="modal-header">
					<span class="login100-form-title p-b-10">기업회원가입</span>
				</div>
							<div class="div-join2">
								<form action="insert.me" method="post">
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
									   <label for="nick_name">*기업명</label>
									   <input type="text" class="form-control" name="nick_name" id="nick_name" placeholder="닉네임을 입력하세요">
									</div>
									<br>
									<div class="form-group">
									   <label for="nick_name">*대표자명</label>
									   <input type="text" class="form-control" name="ceo_name" id="ceo_name" placeholder="닉네임을 입력하세요">
									</div>
									<br>
									<div class="form-group">
									   <label for="nick_name">*사업자등록번호</label>
									   <input type="text" class="form-control" name="company_no" id="company_no" placeholder="닉네임을 입력하세요">
									   <button id="checkBtn1">중복확인</button>
									</div>
									<br>
									<div class="form-group">
									   <label for="nick_name">*사업자종류</label>
									   <input type="text" class="form-control" name="ceo_type" id="ceo_type" placeholder="닉네임을 입력하세요">
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
		function join(){
			location.href="#";
		}
	</script>