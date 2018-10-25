<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.div-join1{width:350px;height:400px;border:5px solid #BFE6F2; border-radius:20px;border-style:double;}
	.div-join2{width:270px;height:330px; margin-right:auto;margin-left:auto;margin-top:40px;}
</style>

	<div class="modal fade" id="join-modal" tabindex="-1" role="dialog"
		aria-labelledby="join" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="z-index: 999999;">
			<div class="modal-content">
			
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<span class="login100-form-title p-b-10">회원가입</span>
				</div>
							<div class="div-join2">
								<form action="insert.me" method="post">
									<div class="form-group">
									   <label for="id">*아이디</label>
									   <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요">
									</div>
									<br><br>
									<div class="form-group">
									   <label for="password">*비밀번호</label>
									   <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요">
									</div>
									<br><br>
									<div class="form-group">
									   <label for="nick_name">*닉네임</label>
									   <input type="text" class="form-control" name="nick_name" id="nick_name" placeholder="닉네임을 입력하세요">
									</div>
									<br>
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