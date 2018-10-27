<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
<jsp:include page="../common/head.jsp" />
<style>
.customerinfo p {
	margin: 15px;
}

.form-control {
	margin-left: 15px;
}

#check {
	-webkit-appearance: checkbox;
}

.p-red {
	color: #ec434a !important;
}
#left{
	float:left;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row" style="display:block;">
			<h2>경험치 교환하기</h2><br />
			<div class="info">
				<table class="tbl-type02" style="width:100%;">
					<colgroup>
						<col style="width: 50%;">
						<col style="width: 50%;">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">주문 상품명</th>
							<th scope="col">주문 상품 정보</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>고구마</td>
							<td>
								<span class="fleft">갯수</span><span class="fright">10개</span>
							</td>
						</tr>
					</tbody>
				</table>
			<br />
			<p class="p-red">* 구매하실 경우 겸험치가 초기화 됩니다!!</p>
			</div>
			<br /><br />
			<h5>구매자 정보</h5><br />
			<div class="customerinfo"><br />
			<table class="tbl-type01">
                        <colgroup>
                            <col style="width: 20%;">
                            <col style="width: 30%;">
                            <col style="width: 20%;">
                            <col style="width: 30%;">
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>주문자</th>
                                <td colspan="3">
                                    <input id="left" name="" class="form-control input-xshort" type="text" placeholder="아이디를 입력하세요">
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input id="left" name="" class="form-control input-short" type="text" placeholder="">
                                </td>
                            </tr>
                        </tbody>
            </table><br />
			</div>
		</div><br />
		<br /><br />
			<h5>배송지 정보</h5><br />
			<div class="customerinfo"><br />
			<table class="tbl-type01">
                        <colgroup>
                            <col style="width: 20%;">
                            <col style="width: 30%;">
                            <col style="width: 20%;">
                            <col style="width: 30%;">
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>받으실분</th>
                                <td colspan="3">
                                    <input id="left" name="" class="form-control input-xshort" type="text" placeholder="아이디를 입력하세요">
                                </td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>
                                    <input id="left" name="" class="form-control input-xshort" type="text" placeholder="" disabled>
                                    <button type="button" class="btn btn-secondary">우편번호</button>
                                    <input id="left" name="" class="form-control input-mid" type="text" placeholder="텍스트를 입력하세요" disabled style="margin-bottom:15px;">
                                    <input id="left" name="" class="form-control input-mid" type="text" placeholder="텍스트를 입력하세요">
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input id="left" name="" class="form-control input-short" type="text" placeholder="">
                                </td>
                            </tr>
                        </tbody>
            </table><br />
			</div>
		</div><br />
		<div class="btn-center">
			<button type="button" class="btn btn-primary btn-lg">결제하기</button>
			<button type="submit" class="btn btn-secondary btn-lg">취소</button>
		</div>
	</div>
</body>
</html>