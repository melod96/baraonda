<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<jsp:include page="bResources.jsp"></jsp:include>

<style>
.h-100 {
	border: 1px solid #dfdfdf;
}

.col-lg-4 {
	height: 305px;
}

.imageContainer {
	max-width: 1000px;
	margin: 0 auto;
}

.card-body span {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/ico_member.png")
		no-repeat left 1px;
	padding-left: 30px;
	color: #7f7f7f;
	display: inline-block;
	height: 30px;
	padding-top: 5px;
	font-size: 14px;
}

.card-text em {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/bar_9.gif")
		no-repeat right 6px;
	padding-right: 7px;
	margin-right: 3px;
}

.card-text em:last-child {
	background: none;
}

.card-title p {
	display: inline-block;
}

.searchForm {
	display: table;
	margin-left: auto;
	margin-right: auto;
}

.text-center {
	display: table;
	margin-left: auto;
	margin-right: auto;
}

#writeBtn { float: right; margin-top: -90px; height: 34px; width: 80px; }
.searchTd1{padding-right: 2px;}
.searchSelect{height: 34px;}
#searchInput{margin-left: 60px;}
#searchBtn1{height: 34px; width: 50px; margin-top: 0px; margin-left: 7px;}
.boardHr{border:1px solid #313131;}
.my-4{margin-bottom: 2.5rem!important;}


</style>
</head>
<body>

	<!-- 컨테이너 -->
	<div class="imageContainer">

		<!---------------------------------- 게시판 이름 ---------------------------------->
		<h1 class="my-4">다이어트 식단 </h1>
		<hr class="boardHr"><br>
		
		<!-------------------------------- 게시글(이미지) 6개 -------------------------------->
		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#">
						<img class="card-img-top" src="http://placehold.it/700x400" alt="">
					</a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
							<em>2018-10-26</em> <em>조회수<sapn class="hit">30</sapn></em> <em>좋아요<sapn
									class="hit">3</sapn></em>
						</p>
						<span>운동맨</span>
						
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
							<em>2018-10-26</em> <em>조회수<sapn class="hit">30</sapn></em> <em>좋아요<sapn
									class="hit">3</sapn></em>
						</p>
						<span>운동맨</span>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
							<em>2018-10-26</em> <em>조회수<sapn class="hit">30</sapn></em> <em>좋아요<sapn
									class="hit">3</sapn></em>
						</p>
						<span>운동맨</span>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
							<em>2018-10-26</em> <em>조회수<sapn class="hit">30</sapn></em> <em>좋아요<sapn
									class="hit">3</sapn></em>
						</p>
						<span>운동맨</span>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
							<em>2018-10-26</em> <em>조회수<sapn class="hit">30</sapn></em> <em>좋아요<sapn
									class="hit">3</sapn></em>
						</p>
						<span>운동맨</span>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
							<em>2018-10-26</em> <em>조회수<sapn class="hit">30</sapn></em> <em>좋아요<sapn
									class="hit">3</sapn></em>
						</p>
						<span>운동맨</span>
					</div>
				</div>
			</div>
		</div>

		<!---------------------------------- 페이징 처리 ---------------------------------->
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
		<!---------------------------------- 관리자용 삭제 버튼 ---------------------------------->
		<button id="writeBtn"><img src="<%=request.getContextPath()%>/resources/images/boardImg/btn_delete1.PNG"></button></td>
		
		<!---------------------------------- 검색 폼 ---------------------------------->
		<form name="search" method="post" class="searchForm">
			<table>
				<tr>
					<td class="searchTd1">
					<select class="searchSelect"  class="form-control input-xshort">
							<option>제목</option>
							<option>내용</option>
							<option>작성자</option>
					</select></td>
					<td>
					<input id="searchInput" id="" name="" class="form-control input-short" type="text" placeholder="">
					</td>
					<td><button id="searchBtn1" type="submit" class="btn btn-primary">검색</button></td>
				</tr>
			</table>
		</form>
	</div>
	<br><br><br><br><br><br><br><br><br><br>
	



	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
