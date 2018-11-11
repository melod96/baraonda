<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/header.jsp" />

<script>
	$(document).ready(function() {

		$().UItoTop({
			easingType : 'easeOutQuart'
		});
		$('#stuck_container').tmStickUp({});
		$('.gallery .gall_item').touchTouch();

	});
	
	//게시글 작성 버튼
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			location.href="${path}/baraonda/write.do";
		});
	});
</script>


<!--[if lt IE 9]>
 <div style=' clear: both; text-align:center; position: relative;'>
   <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
     <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
   </a>
</div>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="css/ie.css">

<![endif]-->
<style>
.boardNo {
	text-align: center;
}

.boardSubject1 {
	text-align: center;
}

.boardSubject2 {
	text-align: left;
}

.boardWriter {
	text-align: center;
}

.boardDay {
	text-align: center;
}

.boardCount {
	text-align: center;
}

.searchForm {
	margin: 0 auto;
	width: 530px;
}

.container1 {
	margin: auto;
	width: 65%;
	margin-top: -35px;
}

#boardInput {
	margin-left: 7px;
}

#boardBtn {
	margin-top: 0px;
	margin-left: 7px;
}

.boardTr:hover {
	cursor: pointer;
}

.boardHr {
	border: 1px solid #313131;
}

.page1 h2 {
	margin-bottom: 25px;
}

#boardB {
	width: 53px;
	padding-top: 8px;
}

.paginate {
	margin-bottom: 40px;
}

#btnWrite {
	float: right;
	margin: auto;
}
.btn:not(:disabled):not(.disabled) {
	float: right;
	margin: auto;
}

.boardHr2 {
	margin-top: -15px;
}

#boardCategory:hover{cursor:pointer; color : #aaccaa;}
.boardName{font-weight: bold;}

</style>

</head>

<body class="page1" id="top">


	<!-------------------------------------Content------------------------------------------->
	<section class="content">
		<br>
		<div class="container">
			<div class="row">
				<!------------------------------ 작업 공간 ------------------------------>
				<div class="container1">
					<h2 class="boardName">커뮤니티</h2>
					
					<hr class="boardHr">
					
			 		<!-- writing_type: 11.비포&애프터 12.자극사진 13.일기 14.식단 15.고민/질문 18.자유게시판 19관리자에게 -->
					<div style="margin-bottom:10px; margin-left:10px;">
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=11">비포&애프터</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=12">자극사진</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=13">일기</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=14">식단</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=15">고민/질문</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=18">자유게시판</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=19">관리자에게</a>
					</div>
					
					
					<table class="table table-hover">
						<thead>
							<tr>
								<!------------------------------ 게시글 번호, 제목, 작성자, 작성일, 조회수 ------------------------------>
								<th class="boardNo">번호</th>
								<th class="boardSubject1">제목</th>
								<th class="boardWriter">작성자</th>
								<th class="boardDay">작성일</th>
								<th class="boardCount">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="row">
								<tr class="boardTr" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'"> 
									<th class="boardNo">${row.BOARD_NO}</th>
									<th class="boardSubject2">${row.BOARD_TITLE}</th>
									<th class="boardWriter">${row.NICK_NAME}</th>
									<th class="boardDay">${row.BOARD_DATE}</th>
									<th class="boardCount">${row.BOARD_COUNT}</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr class="boardHr2">
					<!------------------------------ 글쓰기 버튼 ------------------------------>
					<c:if test="${! empty sessionScope.loginUser}">
						<button onclick="btnWrite" id="btnWrite" type="submit" class="btn btn-primary">글쓰기</button>
					</c:if>
					<c:if test="${empty sessionScope.loginUser}">
						<button id="btnWrite login" type="submit" class="btn btn-primary"
						 data-toggle="modal" data-target="#login-modal">글쓰기</button>
					</c:if>
					
					
					<!------------------------------ 페이징 처리------------------------------>
					<div class="paginate">
						<!-- <a href="#" class="btn-prev" title="이전" id="boardB">이전 <em
							class="blind">목록에서 이전 페이지 이동</em>
						</a> <span class="paging-numbers"> <a href="#">1 <span
								class="blind">페이지로 이동</span>
						</a> <a href="#" class="on">2 <span class="blind">페이지로 이동</span>
						</a> <a href="#">3 <span class="blind">페이지로 이동</span>
						</a> <a href="#">4 <span class="blind">페이지로 이동</span>
						</a> <a href="#">5 <span class="blind">페이지로 이동</span>
						</a>
						</span> <a href="#" class="btn-next" title="다음" id="boardB">다음 <span
							class="spr"> <em class="blind">목록에서 다음 페이지 이동</em>
						</span>
						</a> -->
						
					<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
					</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="list.do">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
								<c:param name="writing_type" value="${writing_type}"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="list.do">
									<c:param name="currentPage" value="${ p }"/>
									<c:param name="writing_type" value="${writing_type}"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="list.do">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
								<c:param name="writing_type" value="${writing_type}"/>
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
					
					
					
					</div>

					<!------------------------------ 검색 폼 ------------------------------>
					<form name="search" method="post" class="searchForm">
						<table>
							<tr>
								<td><select class="form-control input-xshort">
										<option>제목</option>
										<option>내용</option>
										<option>작성자</option>
								</select></td>
								<td><input id="boardInput" name=""
									class="form-control input-short" type="text" placeholder="">
								</td>
								<td><button id="boardBtn" type="submit"
										class="btn btn-primary">검색</button></td>
							</tr>
						</table>
					</form>
				</div>
				<!--------------------------------------------------------------------------------------------------->
			</div>
		</div>
	</section>
	<!--============================== footer =================================-->
	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="grid_12">
					<div class="socials">
						<a href="#" class="fa fa-twitter"></a> <a href="#"
							class="fa fa-facebook"></a> <a href="#" class="fa fa-google-plus"></a>
						<a href="#" class="fa fa-pinterest"></a>
					</div>
					<div class="copyright">
						<span class="brand">Bliss </span> &copy; <span id="copyright-year"></span>
						| <a href="#">Privacy Policy</a>
						<div>
							Website designed by <a href="http://www.templatemonster.com/"
								rel="nofollow">TemplateMonster.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	
</body>
</html>
