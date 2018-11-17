<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.container-login100{min-height:80vh;}
	.login100-form-btn{height:40px;}
	.btn-login-with{height:40px;}
	.idPwdSearch{margin-right:auto;margin-left:auto;width:220px;}
	.login100-form-title{margin-top:30px;}
</style>

	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="z-index: 999999;">
			<div class="modal-content">
			
				<div class="modal-header">
					<span class="login100-form-title p-b-10" style="z-index:50;">LOGIN</span>
				</div>

					
									<div class="limiter">
							<div class="container-login100">
								<div class="wrap-login100 p-t-15 p-b-15">
									<form class="login100-form validate-form" action="login.me" method="post">
										<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter email: ex@abc.xyz">
											<input class="input100" type="text" name="id" placeholder="Id">
											<span class="focus-input100"></span>
										</div>
					
										<div class="wrap-input100 validate-input m-b-20" data-validate = "Please enter password">
											<input class="input100" type="password" name="password" placeholder="Password">
											<span class="focus-input100"></span>
										</div>
					
										<div class="container-login100-form-btn">
											<button class="login100-form-btn">
												Login
											</button>
										</div>
										<br>
										<br>
										<br>
										<div>
											<a href="#" class="btn-login-with bg1 m-b-10">
												<i class="fa fa-facebook-official"></i>
												페이스북 로그인
											</a>
					
											<a data-toggle="modal" data-target="#join-modal" class="btn-login-with bg2 join"
												data-dismiss="modal"aria-hidden="true">
											회원가입
											</a>
										</div>
										
											<div class="idPwdSearch">
												<button type="button" class="btn btn-default" onclick="location.href='findId.me'">아이디  찾기</button>
												<button type="button" class="btn btn-default" onclick="location.href='changePwd.me'">비밀번호 찾기</button>
											</div>
									</form>
								</div>
							</div>
						</div>

				
			</div>
		</div>
	</div>
	
	<script>
		function join(){
			location.href="#";
		}
	</script>