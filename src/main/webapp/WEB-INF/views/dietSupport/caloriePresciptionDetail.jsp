<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
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
	font-size: 15px;
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

.fblod {
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

.p-red {
	color: #ec434a !important;
}

.p-org {
	color: #fb4d00 !important;
}

.r5.box {
	border: 1px solid #e5e5e5;
	padding: 25px 0;
}

.calorie {
	text-align: center;
}

.progress {
	height: 40px;
}

.progress-bar {
	font-size: 15px;
	line-height: 40px;
}

.box {
	background-color: white;
}

.list-f12 {
	font-size: 12px;
	margin-top: 15px;
	list-style: inside;
}

.tbl-y.pink th {
	background: #faede6;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row">
			<div class="left">
		<img src="images/berrywater.PNG" style="width:732px; height:180px;">
		<h2 class="title">칼로리 처방 받기</h2>
		<div class="tbl-y-wrap r5">
				<table class="tbl-y">
					<colgroup>
						<col style="width:144px">
						<col style="width:auto">
					</colgroup>
					<tbody>
						<tr>
							<th>총 감량기간</th>
							<td>${cp.dateweight }개월</td>
						</tr>
						<tr>
							<th> 현재체중</th>
							<td>${cp.weight }kg</td>
						</tr>
						<tr>
							<th>목표체중</th>
							<td>${cp.goalweight }kg</td>
						</tr>
					</tbody>
				</table>
		</div>
		<p><span class="label label-primary">TIP</span><span>표준체중 ${cp.avgweight}</span> / 미용 추천 체중 <span>${cp.avgweight-6.0}</span> 입니다.</p>
		<p class="fblod p-gray">※ 건강을 위해서는 <span class="p-red">1달에 3kg 이내의 감량</span>을 추천해 드립니다.</p>
		<h3>하루 소비 칼로리는<span class = "p-org">${cp.basal+cp.acienergy+cp.energy}kcal</span></h3>
		<div class="r5 box calorie">
			<div class="progress">
 				<div class="progress-bar bg-success" role="progressbar" style="width:80%">
    					${cp.basal}
				</div>
				<div class="progress-bar bg-warning" role="progressbar" style="width:10%">
    					${cp.acienergy }
  				</div>
  				<div class="progress-bar bg-danger" role="progressbar" style="width:10%">
    					${cp.energy }
  				</div>
			</div>
		</div>
		<ul class="list-f12">
			<li>하루 소비 칼로리는 일상생활을 하는데 기본적으로 소비되는 칼로리입니다.</li>
			<li>칼로리 처방 시, 선택하는 활동량에 따라 달라질 수 있습니다.</li>
		</ul>
		<h3>처방 칼로리</h3>
		<div class="tbl-y-wrap r5">
			<table class="tbl-y view pink">
				<colgroup>
					<col style="width:280px">
					<col style="width:auto">
				</colgroup>
				<tbody>
					<tr>
						<th>하루 동안 섭취해야 할 음식 칼로리 </th>
						<td><span id="day_eat_cal">${cp.needenergy }kcal</span></td>
					</tr>
					<tr>
						<th>하루 동안 운동으로 소모해야 할 칼로리 </th>
						<td><span id="day_excersice_cal">${cp.exercise }kcal</span></td>
					</tr>
				</tbody>
			</table>
		</div>
		<ul class="list-f12">
			<li>일일 음식 섭취 칼로리가 1000kcal 이하일 때는 감량 목표를 하향 조절해 주세요.</li>
			<li>1000kcal 이하의 음식 섭취는 영양 불균형 및 요요 현상의 원인이 될 수 있어요.</li>
		</ul>
		<div class="btn-ac">
			<button type="button" class="btn btn-danger btn-lg" style="width:150px;" onclick="location.href='caloriePresciption.ds'">다시하기</button>
		</div>
	</div>
			<jsp:include page="../common/rightBoard.jsp" />
		</div>
	</div>
</body>
</html>