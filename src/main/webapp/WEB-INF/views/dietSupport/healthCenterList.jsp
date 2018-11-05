<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	cursor:pointer;
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
				<h2 class="title">인바디 측정 가능 보건소 찾기</h2>
				<p>
					<i class="fa fa-exclamation-circle" aria-hidden="true" style="font-size:20px;"></i>&nbsp;
					지역별 인바디 측정 가능 보건소를 찾아보세요.
				</p>
				<div class="tab3-wrap">
					<ul class="tab3 clfix">
						<li><a onclick="locations('서울')" style="color: #8c8b8b;">서울특별시</a></li>
						<li><a onclick="locations('부산')" style="color: #8c8b8b;">부산광역시</a></li>
						<li><a onclick="locations('인천')" style="color: #8c8b8b;">인천광역시</a></li>
						<li><a onclick="locations('대전')" style="color: #8c8b8b;">대전광역시</a></li>
						<li><a onclick="locations('대구')" style="color: #8c8b8b;">대구광역시</a></li>
						<li><a onclick="locations('광주')" style="color: #8c8b8b;">광주광역시</a></li>
						<li><a onclick="locations('울산')" style="color: #8c8b8b;">울산광역시</a></li>
						<li><a onclick="locations('경기')" style="color: #8c8b8b;">경기도</a></li>
						<li><a onclick="locations('전라')" style="color: #8c8b8b;">전라도</a></li>
						<li><a onclick="locations('경상')" style="color: #8c8b8b;">경상도</a></li>
						<li><a onclick="locations('강원')" style="color: #8c8b8b;">강원도</a></li>
						<li><a onclick="locations('충청')" style="color: #8c8b8b;">충청도</a></li>
						<li><a onclick="locations('제주')" style="color: #8c8b8b;">제주도</a></li>
					</ul>
				</div>
				<script>
					$(function() {
						$('.tab3').find('li').mouseenter(function() {
							$(this).children('a').css({
								"color" : "black",
								"cursor" : "pointer"
							});
						}).mouseout(function() {
							$(this).children('a').css({
								"color" : "#8c8b8b"
							});
						})
					});
					
				</script>
				<script>
					function locations(state){
						console.log(state);
						location.href="searchHealthCenter.ds?state="+state;
					}
				</script>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<h4>
					<span class="p-red">전체 인바디 측정 가능 보건소</span> ${clistcount}곳이 있습니다.
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
					<c:forEach items="${centerlist}" var ="clist">
						<tr>
							<td>${clist.center_name }</td>
							<td>${clist.center_address}</td>
							<td>${clist.center_tel }</td>
							<td>
								<a href="javascript:void(0)" onclick="setHealthMap('${clist.center_name}')">
									<img src="${pageContext.request.contextPath}/resources/images/dietSupportImg/marker.png" class="marker"/>
								</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				<script>
				
					function setHealthMap(location_name){
						window.open("http://map.daum.net/link/search/"+location_name);
						console.log(location_name);
					}
				
				</script>
				<div class="paginate">
					<!-- <a href="#" class="btn-first" title="처음"><em class="blind">목록에서
							처음 페이지 이동</em></a> <a href="#" class="btn-prev" title="이전"><em
						class="blind">목록에서 이전 페이지 이동</em></a> <span class="paging-numbers">
						<a href="#">1<span class="blind">페이지로 이동</span></a> <a href="#"
						class="on">2<span class="blind">페이지로 이동</span></a> <a href="#">3<span
							class="blind">페이지로 이동</span></a> <a href="#">4<span class="blind">페이지로
								이동</span></a> <a href="#">5<span class="blind">페이지로 이동</span></a>
					</span> <a href="#" class="btn-next" title="다음"><span class="spr"><em
							class="blind">목록에서 다음 페이지 이동</em></span></a> <a href="#" class="btn-last"
						title="끝"><span class="spr"><em class="blind">목록에서
								끝 페이지 이동</em></span></a> -->
					<c:if test="${empty search }">
						<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
						</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="healthCenterList.ds">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="healthCenterList.ds">
									<c:param name="currentPage" value="${ p }"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="healthCenterList.ds">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
					</c:if>
					<c:if test="${! empty search}">
						<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
						</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="searchHealthCenter.ds">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
								<c:param name="state" value="${search}"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="searchHealthCenter.ds">
									<c:param name="currentPage" value="${ p }"/>
									<c:param name="state" value="${search}"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="searchHealthCenter.ds">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
								<c:param name="state" value="${search}"/>
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
					</c:if>
				</div>
			</div>
			<jsp:include page="../common/rightBoard.jsp" />
		</div>
	</div>
</body>
</html>