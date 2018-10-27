<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<jsp:include page="../common/head.jsp"></jsp:include>

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
	width: 400px;
}
.container{width: 732px;}
#boardInput{margin-left: 7px;}
#boardBtn{margin-top: 0px; margin-left: 7px;}
.boardTr:hover{cursor:pointer;}
.boardHr{border:1px solid #313131;}
.page1 h2{margin-bottom: 25px;}


</style>

</head>

<body class="page1" id="top">
	<!---------------------------------- 커뮤니티 게시판 ---------------------------------->

	<!--============================== header=================================-->
	<header>
	<!--============================== Stuck menu=================================-->
		<section id="stuck_container">

			<div class="container">
				<div class="row">
					<div class="grid_12">
						<h1>
							<a href="index.html"> <img src="images/logo.png"
								alt="Logo alt">
							</a>
						</h1>
						<div class="navigation">
							<nav>
								<ul class="sf-menu">
									<li class="current"><a href="index.html">home</a></li>
									<li><a href="index-1.html">menu</a></li>
									<li><a href="index-2.html">reservation</a></li>
									<li><a href="index-3.html">blog</a></li>
									<li><a href="index-4.html">contacts</a></li>
								</ul>
							</nav>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</header>

	<!-------------------------------------Content------------------------------------------->
	<section class="content">
		<div class="ic">More Website Templates @ TemplateMonster.com -
			July 30, 2014!</div>
			<br>
		<div class="container">
			<div class="row">
				<!------------------------------ 작업 공간 ------------------------------>

				<div class="container">
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
							<tr class="boardTr">
								<th class="boardNo">165</th>
								<th class="boardSubject2">부트스트랩 연습중</th>
								<th class="boardWriter">김재엽</th>
								<th class="boardDay">2018-10-25</th>
								<th class="boardCount">25</th>
							</tr>
							<tr class="boardTr">
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
							</tr>
						</tbody>
					</table>
					<hr>
					<!------------------------------ 글쓰기 버튼 ------------------------------>
					<a class="btn btn-default pull-right">글쓰기</a>
					
					<!------------------------------ 페이징 처리------------------------------>
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#"><</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">></a></li>
						</ul>
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
								<td><button id="boardBtn" type="submit" class="btn btn-primary">검색</button></td>
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
