<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exchange</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
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
	<form action="expExchange.ex" method = "post">
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
							<input type="hidden" name = "product_no" value = "${product.product_no }" />
							<td>${product.product_name }</td>
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
                                    <input id="left" name="orderer" class="form-control input-xshort" type="text" placeholder="">
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input id="left" name="orderer_tel" class="form-control input-short" type="text" placeholder="">
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
                                    <input id="left" name="accept_name" class="form-control input-xshort" type="text" placeholder="">
                                </td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>
                                    <input name="accept_address1" id = "sample6_postcode" class="form-control input-xshort" type="text" style="float:left;" readonly>
                                    <button type="button" class="btn btn-secondary" style = "margin:0; margin-left:15px;" onclick= "sample6_execDaumPostcode()">우편번호</button>
                                    <input name="accept_address2" id = "sample6_address" class="form-control input-mid" type="text" readonly style="float:left;margin-top:15px;margin-bottom:15px;">
                                    <input name="accept_address3" id = "sample6_address2" class="form-control input-mid" type="text" placeholder="텍스트를 입력하세요" style="float:left;">
                                </td>
                            </tr>
							
							<tr>
                                <th>전화번호</th>
                                <td>
                                    <input id="left" name="accept_tel" class="form-control input-short" type="text" placeholder="">
                                </td>
                            </tr>
                        </tbody>
            </table><br />
			</div>
		</div>
		<div class="btn-center">
			<button type="submit" class="btn btn-primary btn-lg">교환하기</button>
			<button type="button" class="btn btn-secondary btn-lg">취소</button>
		</div>
		</form>
		<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;
                console.log($("#sample6_postcode").val());
                console.log($("#sample6_address").val());

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
    
</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>