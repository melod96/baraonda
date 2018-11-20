<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMIDetail</title>
<jsp:include page="../common/head.jsp" />
<style>
.left {
	float: left;
	width: 70%;
	display: inline-block;
}

.title {
	border-bottom: 2px solid #5d5d5d;
	font-size: 30px;
	margin-bottom:20px;
	line-height:50px;
}

.tbl-y th {
	padding: 22px 0 22px 14px;
}

.tbl-y td {
	padding: 10px 0 10px 14px;
}

.tbl-y-wrap {
	border: 1px solid #dedede;
}

.tbl-y {
	width: 100%;
}

.tbl-y tr {
	border-bottom: 1px solid #dedede;
}

.fbold {
	font-weight: bold !important;
	font-size: 18px;
	margin-top: 20px;
	line-height: 20px;
}


.btn-ac {
	text-align: center;
	margin-top: 30px;
}

.progress {
	height: 40px;
	margin-top: 20px;
}

.progress-bar {
	font-size: 15px;
	line-height: 40px;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row">
			<div class="left">
				<jsp:include page="../common/banner.jsp" />
					style="width: 732px; height: 180px;">
				<h2 class="title">나의 BMI 지수 확인</h2>
				<div class="tbl-y-wrap r5">
					<form name="frm" method="get">
						<table class="tbl-y">
							<colgroup>
								<col style="width: 144px">
								<col style="width: auto">
							</colgroup>
							<tbody>
								<tr>
									<th>성별</th>
								<c:if test="${b.gender=='F'}">
									<td>여자</td>									
								</c:if>
								<c:if test="${b.gender=='M'}">
									<td>남자</td>
								</c:if>
								</tr>
								<tr>
									<th>연령</th>
									<td>만 <c:out value="${b.age }"/>세</td>
								</tr>
								<tr>
									<th>키</th>
									<td><c:out value="${b.height }cm"/></td>
								</tr>
								<tr>
									<th>몸무게</th>
									<td><c:out value="${b.weight }kg"/></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<p class="fbold">비만도(BMI) 검사 결과</p>
				<div class="progress" style="height:30px;">
					<c:if test="${b.gender=='F'}">
						<c:choose>
							<c:when test="${b.bmi<18.5}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi>=18.5 && b.bmi<=25.0}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi>25.0 && b.bmi<=29.9}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi>=30 && b.bmi<=40.0}">
								<div class="progress-bar  progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi > 40.0}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar progress-bar-striped bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${b.gender=='M'}">
						<c:choose>
							<c:when test="${b.bmi < 20.0}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi>=20.0 && b.bmi<=25.0}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi>25.0 && b.bmi<=29.9}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi>=30 && b.bmi<=40.0}">
								<div class="progress-bar  progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
							<c:when test="${b.bmi > 40.0}">
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">저체중</div>
								<div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: 20%">정상</div>
								<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 20%">과체중</div>
								<div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 20%">비만</div>
								<div class="progress-bar progress-bar-striped bg-danger" role="progressbar" style="width: 20%">고도비만</div>
							</c:when>
						</c:choose>
					</c:if>
				</div>
				<p>
					당신의 비만도(BMI) 지수는 <c:out value="${b.bmi }"/>로
					<c:if test="${b.gender=='F'}">
						<c:choose>
							<c:when test="${b.bmi<18.5}">"저체중"</c:when>
							<c:when test="${b.bmi>=18.5 && b.bmi<=25.0}">"정상"</c:when>
							<c:when test="${b.bmi>25.0 && b.bmi<=29.9}">"과체중"</c:when>
							<c:when test="${b.bmi>=30 && b.bmi<=40.0}">"비만"</c:when>
							<c:when test="${b.bmi > 40.0}">"고도비만"</c:when>
						</c:choose>
					</c:if>
					<c:if test="${b.gender=='M'}">
						<c:choose>
							<c:when test="${b.bmi < 20.0}">"저체중"</c:when>
							<c:when test="${b.bmi>=20.0 && b.bmi<=25.0}">"정상"</c:when>
							<c:when test="${b.bmi>25.0 && b.bmi<=29.9}">"과체중"</c:when>
							<c:when test="${b.bmi>=30 && b.bmi<=40.0}">"비만"</c:when>
							<c:when test="${b.bmi > 40.0}">"고도비만"</c:when>
						</c:choose>
					</c:if>
					입니다.
				</p>
				<div class="btn-ac">
					<button type="button" class="btn btn-danger btn-lg"
						style="width: 130px;" onclick="location.href='BMI.ds'">다시하기</button>
				</div>
			</div>
			<jsp:include page="../common/rightBoard.jsp" />
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>