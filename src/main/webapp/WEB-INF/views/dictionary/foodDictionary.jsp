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

.info:hover{
	cursor:pointer;
	background:#dee2e6;
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
					<table class="tbl-type02">
						<colgroup>
							<col style="width: 80%;">
							<col style="width: 20%;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">음식명</th>
								<th scope="col">칼로리</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${foodlist}" var ="flist">
								<tr class="info" onclick="location.href='${path}/baraonda/foodDetail.dt?food_no=${flist.food_no}'">
									<td>${flist.food_name }</td>
									<td>${flist.food_kcal} kcal</td>
								</tr>								
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="paginate">
                        <!-- <a href="#" class="btn-first" title="처음"><em class="blind">목록에서 처음 페이지 이동</em></a>
                        <a href="#" class="btn-prev" title="이전"><em class="blind">목록에서 이전 페이지 이동</em></a>
                        <span class="paging-numbers">
                            <a href="#">1<span class="blind">페이지로 이동</span></a>
                            <a href="#" class="on">2<span class="blind">페이지로 이동</span></a>
                            <a href="#">3<span class="blind">페이지로 이동</span></a>
                            <a href="#">4<span class="blind">페이지로 이동</span></a>
                            <a href="#">5<span class="blind">페이지로 이동</span></a>
                        </span>
                        <a href="#" class="btn-next" title="다음"><span class="spr"><em class="blind">목록에서 다음 페이지 이동</em></span></a>
                        <a href="#" class="btn-last" title="끝"><span class="spr"><em class="blind">목록에서 끝 페이지 이동</em></span></a> -->
                        
                        <c:if test="${empty search }">
						<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
						</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="foodDictionary.dt">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="foodDictionary.dt">
									<c:param name="currentPage" value="${ p }"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="foodDictionary.dt">
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