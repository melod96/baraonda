<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>caloriePresciption</title>
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

.date {
	-webkit-appearance: radio;
}

.activity {
	-webkit-appearance: radio;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row">
			<div class="left">
				<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG"
					style="width: 732px; height: 180px;">
				<h2 class="title">칼로리 처방 받기</h2>
				<form action="calpre.ds" method="get">
				<div class="tbl-y-wrap r5">
						<table class="tbl-y">
							<colgroup>
								<col style="width: 144px">
								<col style="width: auto">
							</colgroup>
							<tbody>
								<tr>
									<th>성별</th>
									<td class="form-inline">
										<input type="radio" class="gender" id="female" name="gender" value="F" checked>
										<label class="pre" for="female"> 여자 </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" class="gender" id="male" name="gender" value="M">
										<label class="pre" for="male"> 남자</label>
									</td>
								</tr>
								<tr>
									<th>키</th>
									<td class="form-inline">
										<input id="" name="height" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요" maxlength="3">
										<span class="dash">&nbsp;&nbsp;cm</span>
									</td>
								</tr>
								<tr>
									<th>몸무게</th>
									<td class="form-inline">
										<input id="" name="weight" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요" maxlength="3">
										<span class="dash">&nbsp;&nbsp;kg</span>
									</td>
								</tr>
								<tr>
									<th>목표 체중</th>
									<td class="form-inline">
										<input id="" name="goalweight" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요" maxlength="3">
										<span class="dash">&nbsp;&nbsp;kg</span>
									</td>
								</tr>
								<tr>
									<th>연령</th>
									<td class="form-inline">만&nbsp;&nbsp;
										<input id="" name="age" class="form-control input-short" type="text" placeholder="텍스트를 입력하세요">
									</td>
								</tr>
								<tr>
									<th>체중 감량 기간</th>
									<td class="form-inline"><input id="" name="dateweight"
										class="form-control input-short" type="text"
										placeholder="텍스트를 입력하세요" maxlength="3">&nbsp;&nbsp; 개월
									</td>
								</tr>
								<tr>
									<th>평소 활동량</th>
									<td>
										<input type="radio" class="activity" id="ac1" name="activity" value="No" checked>
										<label class="pre" for="ac1"> 활동안함 <span class="p-gray">(운동을 전혀 안 해요.)</span></label>
										<br />
										<input type="radio" class="activity" id="ac2" name="activity" value="Little">
										<label class="pre" for="ac2"> 가벼운 활동 <span class="p-gray">(평소 가벼운 운동이나 스포츠를 즐겨요.)</span></label>
										<br> 
										<input type="radio" class="activity" id="ac3" name="activity" value="Nomal">
										<label class="pre" for="ac3"> 보통 활동 <span class="p-gray">(평소 적당한 운동이나 스포츠를 즐겨요.)</span></label>
										<br> 
										<input type="radio" class="activity" id="ac4" name="activity" value="Many">
										<label class="pre" for="ac4"> 많은 활동 <span class="p-gray">(평소 강렬한 운동이나 스포츠를 즐겨요.)</span></label>
										<br> 
										<input type="radio" class="activity" id="ac5" name="activity" value="TooMany">
										<label class="pre" for="ac5"> 격심한 활동 <span class="p-gray">(평소 매우 심한 운동을 하거나 육체를 쓰는 직업이예요.)</span></label>
									</td>
								</tr>
							</tbody>
						</table>
				</div>
				<div class="btn-ac">
					<button type="submit" class="btn btn-danger btn-lg" style="width: 170px;">칼로리 처방 받기</button>
				</div>
				</form>
			</div>
			<jsp:include page="../common/rightBoard.jsp" />
		</div>
	</div>
</body>
</html>