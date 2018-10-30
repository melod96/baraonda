<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>healthCenterList</title>
<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous"> -->
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

.p-red {
	color: #ec434a !important;
}

.btn-ac {
	text-align: center;
	margin-top: 30px;
}

.tab3-wrap {
	margin: 12px 0 20px;
}

.tab3 li {
	float: left;
	width: 163px;
	height: 40px;
	border: 1px solid #d6d6d6;
}

.tab3 li a {
	float: left;
	width: 100%;
	height: 100%;
	line-height: 40px;
	text-indent: 14px;
	color: #8c8b8b;
}

.tbl-type02 {
	width: 100%;
}
.marker{
	width:25px;
	height:25px;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row">
			<div class="left">
				<img src="images/berrywater.PNG"
					style="width: 732px; height: 180px;">
				<h2 class="title">인바디 측정 가능 보건소 찾기</h2>
				<p>
					<i class="fas fa-exclamation-circle" style="font-size: 20px;"></i>&nbsp;
					지역별 인바디 측정 가능 보건소를 찾아보세요.
				</p>
				<button onclick = "hcdata.ds">데이터 입력</button>
				<div class="tab3-wrap">
					<ul class="tab3 clfix">
						<li><a href="#">서울특별시</a></li>
						<li><a href="#">부산광역시</a></li>
						<li><a href="#">인천광역시</a></li>
						<li><a href="#">대전광역시</a></li>
						<li><a href="#">대구광역시</a></li>
						<li><a href="#">광주광역시</a></li>
						<li><a href="#">울산광역시</a></li>
						<li><a href="#">경기도</a></li>
						<li><a href="#">전라도</a></li>
						<li><a href="#">경상도</a></li>
						<li><a href="#">강원도</a></li>
						<li><a href="#">충청도</a></li>
						<li><a href="#">제주도</a></li>
					</ul>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<h4>
					<span class="p-red">전체 인바디 측정 가능 보건소</span> 254곳이 있습니다.
				</h4>
				<table class="tbl-type02">
					<colgroup>
						<col style="width: 20%;">
						<col style="width: 40%;">
						<col style="width: 20%;">
						<col style="width: 20%;">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">측정장소</th>
							<th scope="col">주소</th>
							<th scope="col">전화번호</th>
							<th scope="col">위치</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>가평군 보건소</td>
							<td>경기도 가평군 가평읍 가화로 155-18</td>
							<td>031-582-2822</td>
							<td><img src="${pageContext.request.contextPath}/resources/images/dietSupportImg/marker.png" class="marker" /></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
						<tr>
							<td>강남구 보건소</td>
							<td>서울특별시 강남구 선릉로 668</td>
							<td>02-3423-7200</td>
							<td><i class="fas fa-map-marker-alt"
								style="color: #626262; font-size: 20px;"></i></td>
						</tr>
					</tbody>
				</table>
				<div class="paginate">
					<a href="#" class="btn-first" title="처음"><em class="blind">목록에서
							처음 페이지 이동</em></a> <a href="#" class="btn-prev" title="이전"><em
						class="blind">목록에서 이전 페이지 이동</em></a> <span class="paging-numbers">
						<a href="#">1<span class="blind">페이지로 이동</span></a> <a href="#"
						class="on">2<span class="blind">페이지로 이동</span></a> <a href="#">3<span
							class="blind">페이지로 이동</span></a> <a href="#">4<span class="blind">페이지로
								이동</span></a> <a href="#">5<span class="blind">페이지로 이동</span></a>
					</span> <a href="#" class="btn-next" title="다음"><span class="spr"><em
							class="blind">목록에서 다음 페이지 이동</em></span></a> <a href="#" class="btn-last"
						title="끝"><span class="spr"><em class="blind">목록에서
								끝 페이지 이동</em></span></a>
				</div>
			</div>
			<jsp:include page="../common/rightBoard.jsp" />
		</div>
	</div>
</body>
</html>