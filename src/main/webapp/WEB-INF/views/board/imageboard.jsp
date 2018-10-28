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
	height: 300px;
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
	margin-top: -8px;
	cursor: pointer;
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
	cursor: pointer;
}
.card-title{
	margin-top:-10px;
}

.searchForm {
	margin: 0 auto;
	width: 530px;
	margin-top: 40px;
}

.text-center {
	display: table;
	margin-left: auto;
	margin-right: auto;
}
.boardHr{border:1px solid #313131;}
.my-4{margin-bottom: 2.5rem!important;}
.row{padding-top: 10px;}
.card-text{margin-top:-20px;}
a{text-decoration: none!important;}
#boardB{width:53px; padding-top: 8px;}
#searchBtn{float: right;}
#boardInput{margin-left: 7px;}
#boardBtn{margin-top: 0px; margin-left: 7px;}


</style>
</head>
<body>

	<!-------------------------------------------------------- 이미지 형태 게시판 -------------------------------------------------------->
	<div class="imageContainer">

		<!-- 게시판 이름 -->
		<h1 class="my-4">다이어트 식단 </h1>
		<hr class="boardHr">
		
		<!------------------------------ 게시글(이미지) 6개 ------------------------------>
		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#">
						<img class="card-img-top" src="http://placehold.it/700x400" alt="">
					</a>
					<div class="card-body">
						<h4 class="card-title">
						<!------------------------------ 게시글 제목  ------------------------------>
							<a href="#">글제목</a>
							<p>(2)</p>
						</h4>
						<p class="card-text">
						<!------------------------------ 게시글 날짜, 조회수, 좋아요 ------------------------------>
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
		<!-- /.row -->

		<!------------------------------ 글쓰기 버튼 ------------------------------>
					<button id="searchBtn" type="submit" class="btn btn-primary">글쓰기</button>
					
					<!------------------------------ 페이징 처리------------------------------>
					<div class="paginate">
					<a href="#" class="btn-prev" title="이전" id="boardB">이전
						<em class="blind">목록에서 이전 페이지 이동</em>
					</a>
					<span class="paging-numbers">
						<a href="#">1
							<span class="blind">페이지로 이동</span>
						</a>
						<a href="#" class="on">2
							<span class="blind">페이지로 이동</span>
						</a>
						<a href="#">3
							<span class="blind">페이지로 이동</span>
						</a>
						<a href="#">4
							<span class="blind">페이지로 이동</span>
						</a>
						<a href="#">5
							<span class="blind">페이지로 이동</span>
						</a>
					</span>
					<a href="#" class="btn-next" title="다음" id="boardB">다음
						<span class="spr">
							<em class="blind">목록에서 다음 페이지 이동</em>
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
								<td><button id="boardBtn" type="submit" class="btn btn-primary">검색</button></td>
							</tr>
						</table>
					</form>
				</div>
				<!--------------------------------------------------------------------------------------------------->
	</div>
	<br><br><br><br><br><br><br><br><br><br>
	<!-- /.container -->



	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
