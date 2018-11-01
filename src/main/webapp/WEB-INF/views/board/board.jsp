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

#searchBtn {
	float: right;
	margin: auto;
}

.boardHr2 {
	margin-top: -15px;
}
</style>

</head>

<body class="page1" id="top">

	<!-------------------------------------Content------------------------------------------->
	<section class="content">
		<div class="ic">More Website Templates @ TemplateMonster.com -
			July 30, 2014!</div>
		<br>
		<div class="container">
			<div class="row">
				<!------------------------------ 작업 공간 ------------------------------>

				<div class="container1">
					<h2>자유게시판</h2>
					<hr class="boardHr">

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
								<tr class="boardTr">
									<th class="boardNo">${row.BOARD_NO}</th>
									<th class="boardSubject2"><a
										href="${path}/baraonda/board/view.do?board_no=${row.BOARD_NO}">${row.BOARD_TITLE}</a></th>
									<!-- <th class="boardSubject2">{row.BOARD_TITLE}</th> -->
									<th class="boardWriter">${row.NICK_NAME}</th>
									<th class="boardDay">${row.BOARD_DATE}</th>
									<th class="boardCount">${row.BOARD_COUNT}</th>
								</tr>
							</c:forEach>

							<!-- <tr class="boardTr">
								<th class="boardNo">164</th>
								<th class="boardSubject2">게시판 만드는중입니다....</th>
								<th class="boardWriter">다신</th>
								<th class="boardDay">2018-10-25</th>
								<th class="boardCount">12</th>
							</tr>
							<tr class="boardTr">
								<th class="boardNo">163</th>
								<th class="boardSubject2">가나다라마바사</th>
								<th class="boardWriter">훈민정음</th>
								<th class="boardDay">2018-10-25</th>
								<th class="boardCount">8</th>
							</tr>
							<tr class="boardTr">
								<th class="boardNo">162</th>
								<th class="boardSubject2">오늘이 목요일이구나?</th>
								<th class="boardWriter">목요일</th>
								<th class="boardDay">2018-10-25</th>
								<th class="boardCount">0</th>
							</tr> -->
						</tbody>
					</table>
					<hr class="boardHr2">
					<!------------------------------ 글쓰기 버튼 ------------------------------>
					<button id="searchBtn" type="submit" class="btn btn-primary">글쓰기</button>

					<!------------------------------ 페이징 처리------------------------------>
					<div class="paginate">
						<a href="#" class="btn-prev" title="이전" id="boardB">이전 <em
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
						</a>
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
