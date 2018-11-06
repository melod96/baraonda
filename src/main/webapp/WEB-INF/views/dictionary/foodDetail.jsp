<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodDictionary</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
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

.search{
	margin-top:20px;
	margin-bottom:20px;
}

.category{
	margin-top:15px;
}

.category a{
	margin-right:30px;
}

</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
   <!--  <div class="container category">
    	<a href="foodDictionary.dt" >음식 칼로리</a>
    	<a href="exerciseDictionary.dt">운동 칼로리</a>
    </div> -->
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">
		<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG" style="width:732px; height:180px;">
		<h2 class="title">음식 칼로리</h2>
		<div class="search">
		<form action="searchFoodDictionary.dt" method="get">
			<div class="ui action input" style="width:100%;">
				<input type="text" placeholder="Search..." name="search">
				<button class="ui icon button" type="submit">
					<img src="${pageContext.request.contextPath}/resources/images/dictionaryImg/Search.png" style="width:25px; height:25px;"/>
				</button>
			</div>
		</form>
		</div>
		<div class="list">
			<table class="tbl-type01">
				<colgroup>
					<col style="width: 20%;">
					<col style="width: 80%;">
				</colgroup>
				<tbody>
					<tr>
						<th>음식명</th>
						<td>${foodinfo.food_name }</td>
					</tr>
					<tr>
						<th>칼로리</th>
						<td>${foodinfo.food_kcal }</td>
					</tr>
					<tr>
						<th>탄수화물</th>
						<td>${foodinfo.food_carbohydrate }</td>
					</tr>
					<tr>
						<th>단백질</th>
						<td>${foodinfo.food_protein }</td>
					</tr>
					<tr>
						<th>지방</th>
						<td>${foodinfo.food_fat }</td>
					</tr>
					<tr>
						<th>콜레스테롤</th>
						<td>${foodinfo.food_cholesterol }</td>
					</tr>
					<tr>
						<th>식이섬유</th>
						<td>${foodinfo.food_fiber }</td>
					</tr>
					<tr>
						<th>나트륨</th>
						<td>${foodinfo.food_natrium }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="../common/rightBoard.jsp" />
  </div>
  </div>
</body>
</html>