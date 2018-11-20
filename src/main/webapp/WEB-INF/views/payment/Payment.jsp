<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
<jsp:include page="../common/head.jsp" />
<style>
.payment p{margin: 15px;}
.form-control{margin-left:15px;}
#check{-webkit-appearance: checkbox;}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row" style="display:block;">
			<h2>결제하기</h2><br />
			<div class="info">
				<table class="tbl-type02" style="width:100%;">
					<colgroup>
						<col style="width: 30%;">
						<col style="width: 40%;">
						<col style="width: 30%;">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">주문 상품명</th>
							<th scope="col">주문 상품 정보</th>
							<th scope="col">주문 금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>배너 광고</td>
							<td><span class="fleft">사이즈</span><span class="fright">300px
									* 300px</span><br /> <span class="fleft">서비스 기한</span><span
								class="fright">15일</span></td>
							<td>10000000원</td>
						</tr>
					</tbody>
				</table>
			</div>
			<br /><br />
			<div class="payment" style="background:#dedede;"><br />
				<p style="display:inline-block;">
					<span>주문자</span><span><input id="" name="" class="form-control input-xshort" type="text" placeholder="텍스트를 입력하세요"></span>
				</p>
				<p style="float: right">
					<span>입금자명
							<input id="" name="" class="form-control input-xshort" type="text" placeholder="텍스트를 입력하세요">
					</span>
				</p>
				<p class="form-inline">
					<span>이메일</span>
					<span class="form-inline" >
						<input id="" name="" class="form-control input-xshort" type="text" placeholder="텍스트를 입력하세요">&nbsp;&nbsp; @
						<input id="" name="" class="form-control input-xshort" type="text" placeholder="텍스트를 입력하세요">
					</span> 
						<span class="form-inline">
							<select class="form-control input-xshort">
								<option>직접입력</option>
								<option>naver.com</option>
								<option>hanmail.net</option>
								<option>gmail.com</option>
								<option>nate.com</option>
								<option>hotmail.com</option>
							</select>
						</span> 
				</p>
						
				<p class="form-inline">
					<span>전화번호</span><span><input id="" name="" class="form-control input-xshort" type="text" placeholder="텍스트를 입력하세요"></span>
				</p><br />
			</div>
		</div><br />
		<input type="checkbox" id="check"/>
		<label for="check">주문할 상품의 상품, 가격, 결제 정보 등을 최종 확인하였으며, 개인정보 제3자 제공 동의에 관한 내용을 모두 이해하였으며, 이에 동의합니다.</label>
		<div class="btn-center">
			<button type="button" class="btn btn-primary btn-lg">결제하기</button>
			<button type="submit" class="btn btn-secondary btn-lg">취소</button>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>