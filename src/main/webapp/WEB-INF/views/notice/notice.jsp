<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
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

.tbl-type02 tr:hover{
	cursor:pointer;
	background: #dedede;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">
		<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG" style="width:732px; height:180px;">
		<h2 class="title">공지사항</h2>
		<form action="searchNotice.nt" method="get">
			<div class="search">
				<select class="form-control input-xshort" style="float:left; margin-right:10px; height:45px;" name = "searchtype">
					<option value = "title">제목</option>
					<option value = "content">내용</option>
					<option value = "writer">작성자</option>
				</select>
				<div class="ui action input">
					<input type="text" placeholder="Search..." name = "search">
					<button class="ui icon button" type="submit">
						<img src="${pageContext.request.contextPath}/resources/images/dictionaryImg/Search.png" style="width:20px; height:20px;"/>
					</button>
				</div>
				<c:if test="${sessionScope.loginUser.admin_right == 1}">
					<button type="button" class="btn btn-primary" style="float:right; margin:0;" onclick = "location.href='noticeWrite.nt'">작성하기</button>
				</c:if>
			</div>
		</form>
		<div class="list">
					<table class="tbl-type02">
						<colgroup>
							<col style="width: 40%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">조회수</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${noticelist}" var ="nlist">
								<tr onclick= "location.href='noticeDetail.nt?notice_no='+${nlist.board_no}">
									<td>${nlist.board_title }</td>
									<td>관리자</td>
									<td>${nlist.board_count }</td>
									<td>${nlist.board_date }</td>
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
							<c:url var="blistBack" value="noticelist.nt">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="noticelist.nt">
									<c:param name="currentPage" value="${ p }"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="noticelist.nt">
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
							<c:url var="blistBack" value="searchNotice.nt">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
								<c:param name="search" value="${search}"/>
								<c:param name="searchtype" value="${searchtype}"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="searchNotice.nt">
									<c:param name="currentPage" value="${ p }"/>
									<c:param name="search" value="${search}"/>
									<c:param name="searchtype" value="${searchtype}"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="searchNotice.nt">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
								<c:param name="search" value="${search}"/>
								<c:param name="searchtype" value="${searchtype}"/>
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