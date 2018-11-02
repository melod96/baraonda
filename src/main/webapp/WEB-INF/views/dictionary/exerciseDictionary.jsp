<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exerciseDictionary</title>
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
	<div class="container category">
    	<a href="foodDictionary.dt" >음식 칼로리</a>
    	<a href="exerciseDictionary.dt">운동 칼로리</a>
    </div>
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">
		<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG" style="width:732px; height:180px;">
		<h2 class="title">운동 칼로리</h2>
		<div class="search">
			<div class="ui action input" style="width:100%;">
				<input type="text" placeholder="Search...">
				<button class="ui icon button">
					<i class="search icon"></i>
				</button>
			</div>
		</div>
		<div class="list">
					<table class="tbl-type02">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 45%;">
							<col style="width: 15%;">
							<col style="width: 15%;">
							<col style="width: 15%;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">No</th>
								<th scope="col">운동 칼로리</th>
								<th scope="col">강도 / 세트</th>
								<th scope="col">분 / 초 / 횟수</th>
								<th scope="col">칼로리</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
							<tr>
								<td>1</td>
								<td>보통 걷기</td>
								<td>가볍게</td>
								<td>10(분)</td>
								<td>21kcal</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="paginate">
                        <a href="#" class="btn-first" title="처음"><em class="blind">목록에서 처음 페이지 이동</em></a>
                        <a href="#" class="btn-prev" title="이전"><em class="blind">목록에서 이전 페이지 이동</em></a>
                        <span class="paging-numbers">
                            <a href="#">1<span class="blind">페이지로 이동</span></a>
                            <a href="#" class="on">2<span class="blind">페이지로 이동</span></a>
                            <a href="#">3<span class="blind">페이지로 이동</span></a>
                            <a href="#">4<span class="blind">페이지로 이동</span></a>
                            <a href="#">5<span class="blind">페이지로 이동</span></a>
                        </span>
                        <a href="#" class="btn-next" title="다음"><span class="spr"><em class="blind">목록에서 다음 페이지 이동</em></span></a>
                        <a href="#" class="btn-last" title="끝"><span class="spr"><em class="blind">목록에서 끝 페이지 이동</em></span></a>
				</div>
	</div>
	<jsp:include page="../common/rightBoard.jsp" />
  </div>
  </div>
</body>
</html>