<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
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
	font-size: 11px;
	margin-top: 20px;
	line-height: 20px;
}

.p-gray {
	color: #7b7b7b !important;
	padding-left: 25px;
}

.btn-ac {
	text-align: center;
	margin-top: 30px;
}

.gender {
	-webkit-appearance: radio;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">
		<jsp:include page="../common/banner.jsp" />
		<h2 class="title">나의 BMI 지수 확인</h2>
		<form action="BMICal.ds" method="get">
		<div class="tbl-y-wrap r5">
				<table class="tbl-y">
					<colgroup>
						<col style="width:144px">
						<col style="width:auto">
					</colgroup>
					<tbody>
						<tr>
							<th>성별 </th>
							<td class="form-inline">
								<input type="radio" class="gender" id="female" name="gender" value="F" checked><label class="pre" for="female"> 여자      </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="gender" id="male" name="gender" value="M"><label class="pre" for="male"> 남자</label>
							</td>
						</tr>
						<tr>
							<th> 연령</th>
							<td class="form-inline">
								만&nbsp;&nbsp;<input id="" name="age" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요">
							</td>
						</tr>
						<tr>
							<th>키</th>
							<td class="form-inline">
								<input id="" name="height" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요" maxlength="3"><span class="dash">&nbsp;&nbsp;cm</span>
							</td>
						</tr>
						<tr>
							<th>몸무게</th>
							<td class="form-inline">
								<input id="" name="weight" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요" maxlength="3"><span class="dash">&nbsp;&nbsp;kg</span>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
		<p class="fbold">
			<i class="fa fa-exclamation-circle" aria-hidden="true" style="font-size:20px;"></i>
			&nbsp;비만도 측정(BMI) 이란?
			<br>
			<span class="p-gray">나이, 신장(cm)과 체중(kg)만으로 비만을 판정하는 비만 지수</span>
		</p>
		<div class="btn-ac">
			<button type="submit" class="btn btn-danger btn-lg" style="width:130px;">확인</button>
		</div>
		</form>
	</div>
	<jsp:include page="../common/rightBoard.jsp" />
  </div>
  </div>
  <jsp:include page="../common/footer.jsp"/>
</body>
</html>