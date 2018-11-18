<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BARAON.DA - 커뮤니티</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	
	/*  $(document).ready( function() {
	    var jbExcerpt = $('.boardDay').text().substring( 0, 9 );
	      $('.boardDay').after('<th>' + jbExcerpt + '</th>' );
	 }); */
	
	/*  function checkAll(){
		 if($("#noInput1").is(':checked')){
			 $("input[name=board_no]").prop("checked", true);
		 }else{
			 $("input[name=board_no]").prop("checked", false);
		 }
	 } */
	
	 var arrayParam = new Array();
	 
	 $("input:checkbox[name=board_no]:checked").each(function(){
		 arrayParam.push($(this).val());
	 });
	 
	 function deleteBoard(){
		 $.ajax({
			 method:'POST',
			 url:'adminDelete.do',
			 traditional:true,
			 data:{
				 'main':arr
			 },
			 success:function(data){
				 alert(data);
			 },
			 error:function(request,status,error){
				 alert(error);
			 }
		 });
	 }
	 
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
	/* margin: auto; */
	/* margin-left: 30px; */
	width: 65%;
	margin-top: -10px;
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
	border: 1.2px solid #313131;
}

.page1 h2 {
	margin-bottom: 0px !important;
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
#noInput1, #noInput2{-webkit-appearance: checkbox !important;}

#boardCategory:hover{cursor:pointer; color : #aaccaa;}
.boardName{font-weight: bold;}
.right{margin-top: -180px; margin-left: 70px !important;}
#deleteBtn{background:red; border-color: white; margin-bottom: 10px;}



</style>

</head>

<body class="page1" id="top">


	<!-------------------------------------Content------------------------------------------->
	<section class="content">
		<br>
		<div class="clear" style="height: 17px; background: white;"></div>
		<div class="container">
			<div class="row">
			<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG" style="width: 732px; height: 180px;">
				<!------------------------------ 작업 공간 ------------------------------>
				<div class="container1">
					<h2 class="boardName">커뮤니티</h2>
					
					<hr class="boardHr">
					
			 		<!-- writing_type: 11.비포&애프터 12.자극사진 13.일기 14.식단 15.고민/질문 18.자유게시판 19관리자에게 20.파워리뷰 -->
					<div style="margin-bottom:10px; margin-left:10px;">
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=11">비포&애프터</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=12">자극사진</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=13">일기</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=14">식단</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=15">고민/질문</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=18">자유게시판</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=20">체험단리뷰</a>&nbsp;|
			 			<a id="boardCategory" href="${path}/baraonda/list.do?writing_type=19">관리자에게</a>
					</div>
					
					
					<table class="table table-hover">
					<c:if test="${sessionScope.loginUser.admin_right != 1}">
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
						<tr class="boardTr" style="font-weight: bold;">
									<th class="boardNo" onclick="location.href='question.do'">.</th>
									<th class="boardSubject2" onclick="location.href='question.do'">자주하는 질문</th>
									<th class="boardWriter" onclick="location.href='question.do'">관리자</th>
									<th class="boardDay" onclick="location.href='question.do'">2018-11-19</th>
									<th class="boardCount" onclick="location.href='question.do'">123</th>
							</tr>
						
							<c:forEach items="${list}" var="row">
								<tr class="boardTr" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'"> 
									<th class="boardNo">${row.BOARD_NO}</th>
									<th class="boardSubject2">${row.BOARD_TITLE}</th>
									<th class="boardWriter">${row.NICK_NAME}</th>
									<th class="boardDay">${ fn:substring(row.BOARD_DATE, 0, 10) }</th>
									<th class="boardCount">${row.BOARD_COUNT}</th>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
					<c:if test="${sessionScope.loginUser.admin_right == 1}">
						<thead>
							<tr>
								<!------------------------------ 게시글 번호, 제목, 작성자, 작성일, 조회수 ------------------------------>
								<th><input id="noInput1" type="checkbox" name="board_no" value="${row.BOARD_NO}" onclick="checkAll();"></th>
								<th class="boardNo">번호</th>
								<th class="boardSubject1">제목</th>
								<th class="boardWriter">작성자</th>
								<th class="boardDay">작성일</th>
								<th class="boardCount">조회수</th>
							</tr>
						</thead>
						<form action="deleteBoard.do" method="post">
							<tbody>
							<tr class="boardTr" style="font-weight: bold;">
								<th></th>
									<th class="boardNo" onclick="location.href='question.do'">.</th>
									<th class="boardSubject2" onclick="location.href='question.do'">자주하는 질문</th>
									<th class="boardWriter" onclick="location.href='question.do'">관리자</th>
									<th class="boardDay" onclick="location.href='question.do'">2018-11-19</th>
									<th class="boardCount" onclick="location.href='question.do'">123</th>
							</tr>
							<c:forEach items="${list}" var="row">
								<tr class="boardTr"> 
									<th><input id="noInput2" type="checkbox" name="board_no" value="${row.BOARD_NO}"></th>
									<th class="boardNo" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'">${row.BOARD_NO}</th>
									<th class="boardSubject2" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'">${row.BOARD_TITLE}</th>
									<th class="boardWriter" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'">${row.NICK_NAME}</th>
									<th class="boardDay" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'">${ fn:substring(row.BOARD_DATE, 0, 10) }</th>
									<th class="boardCount" onclick="location.href='${path}/baraonda/view.do?board_no=${row.BOARD_NO}'">${row.BOARD_COUNT}</th>
								</tr>
							</c:forEach>
						</tbody>
						<c:if test="${sessionScope.loginUser.admin_right == 1}">
							<button id="deleteBtn" type="submit" class="btn btn-primary">삭제</button>
						</c:if>
					</form>
					</c:if>
					</table>
					<hr class="boardHr2">
					<!------------------------------ 글쓰기 버튼 ------------------------------>
					<c:if test="${sessionScope.loginUser.admin_right != 1}">
						<c:if test="${! empty sessionScope.loginUser}">
							<button onclick="btnWrite" id="btnWrite" type="submit" class="btn btn-primary">글쓰기</button>
						</c:if>
						<c:if test="${empty sessionScope.loginUser}">
							<button id="btnWrite login" type="submit" class="btn btn-primary"
							 data-toggle="modal" data-target="#login-modal">글쓰기</button>
						</c:if>
					</c:if>
					<!------------------------------ 페이징 처리------------------------------>
					<div class="paginate">
					
					<c:if test="${empty search }">
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
					</c:if>
					
					<!----------------------- 검색 페이징 처리 ----------------------->
					<c:if test="${! empty search }">
					<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
					</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="list.do">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
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
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
						</c:if>
					</div>

					<!------------------------------ 검색 폼 ------------------------------>
					<form action="searchBoard.do" name="search" method="get" class="searchForm">
						<table>
							<tr>
								<td><select class="form-control input-xshort" name="searchType">
										<option value="title">제목</option>
										<option value="content">내용</option>
										<option value="writer">작성자</option>
								</select></td>
								<td><input id="boardInput" name="search"
									class="form-control input-short" type="text" placeholder="Search...">
								</td>
								<td><button id="boardBtn" type="submit"
										class="btn btn-primary">검색</button></td>
							</tr>
						</table>
					</form>
				</div>
				<!--------------------------------------------------------------------------------------------------->
				<jsp:include page="../common/rightBoard.jsp" />
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
