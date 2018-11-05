<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/header.jsp" />

<script>
 $(document).ready(function(){

  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});
  $('.gallery .gall_item').touchTouch();

  }); 
 
	//게시글 작성 버튼
	$(document).ready(function(){
		$("#writeBtn").click(function(){
			location.href="${path}/baraonda/write.do";
		});
	});
	 //댓글 작성
 	$("#btncmm").click(function(){
 		var comment=$("#comment").val();
 		var bno="${detail.board_no}"
 		var param="comment="+comment+"&board_no"+bno;
 		$.ajax({
 			type:"post",
 			url:"${path}/insertComment.do",
 			data:param,
 			success:function(){
 				alert("댓글이 등록되었습니다.");
 				
 			}
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
.boardName {
	display: block;
	font-size: 24px;
	padding-bottom: 8px;
	margin-bottom: 20px;
	border-bottom: 2px solid #5d5d5d;
	line-height: 1.3em;
	color: #2e2e2e;
	font-weight: 600;
}

.boardSubject {
	font-size: 17px;
	font-weight: bold;
}

.view_text {
	width: 80%;
}

.proic {
	width: 35px;
	height: 35px;
}

.nick_em {
	display: inline-block;
}

.inner_nick_box {
	margin-top: 8px;
}

.date_menu li.da01 span {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/ico_time.gif")
		no-repeat left 1px;
}

.date_menu li.da02 span {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/ico_eye.gif")
		no-repeat left 1px;
	color: #ff2626;
}

.date_menu li.da03 span {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/ico_balloon.gif")
		no-repeat left 1px;
	color: #ff2626;
}

.date_menu li {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/bar_9.gif")
		no-repeat left center;
	padding-left: 9px;
	margin-left: 0px;
}

.date_menu li span {
	display: inline-block;
	padding-left: 18px;
	margin-right: 12px;
}

.date_menu li:first-child {
	margin-left: 0;
	padding-left: 0;
	background: none;
}

.date_menu li {
	display: inline-block;
	color: #a1a0a0;
	font-size: 12px;
	line-height: 14px;
	font-weight: normal;
}

.group_inner {
	display: inline-block;
	margin-top: 10px;
	float: right;
}

.allmark {
	text-align: center;
	margin-top: 50px;
}

.allmark .bmark {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/bg_heart.gif")
		no-repeat;
	width: 150px;
	height: 50px;
	display: inline-block;
	line-height: 50px;
}

.allmark .bmark span {
	display: inline-block;
	padding-left: 32px;
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/ico_bmark_off.png")
		no-repeat left center;
	font-weight: bold;
	font-size: 15px;
	color: #323232;
	font-weight: bold;
	vertical-align: top;
}

.allmark .heart {
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/bg_heart.gif")
		no-repeat;
	width: 150px;
	height: 50px;
	display: inline-block;
	line-height: 50px;
	margin-left: 20px;
}

.allmark .heart span {
	display: inline-block;
	padding-left: 35px;
	background:
		url("<%=request.getContextPath()%>/resources/images/boardImg/ico_heart.png")
		no-repeat left center;
	font-weight: bold;
	font-size: 15px;
	color: #323232;
	font-weight: bold;
	vertical-align: top;
}

.btn_ar {
	float: right;
	margin-top: 50px;
}

.tit_comment {
	margin-top: 130px;
}

.comment-write {
	background: #f9f9f9;
	border: 1px solid #ececec;
	padding: 15px;
	position: relative;
	margin-top: 12px;
}

.comment-write textarea {
	width: 90%;
	height: 120px;
}

#btncmm {
	position: absolute;
	right: 21px;
	top: -9px;
	width: 90px;
	height: 120px;
}

.hrline {
	border-top: 1px solid #cecece;
}

.comment-count {
	border-bottom: 1px solid #cecece;
	margin-top: 35px;
}

.comment-count-1 {
	display: inline-block;
	color: #383838;
	font-size: 13px;
}

.comment-count-2 {
	display: inline-block;
	font-size: 13px;
	color: #fa111a;
}

.comment-txt {
	display: inline-block;
	padding-left: 15px;
	width: 93%;
}

.comment-pic {
	display: inline-block;
}

.comment-list-li {
	padding-top: 15px;
}

#ptxt {
	padding-top: 7px;
}

.comment-txt span {
	padding-left: 10px;
}

.btn-re {
	padding-left: 70px;
	color: #545050;
}

.balist1 {
	margin-top: 30px;
}

.belist1, .aflist1 {
	color: #423f3f;
}

.belist2, .aflist2 {
	display: inline-block;
	padding-left: 18px;
}

.belist3, .aflist3 {
	display: inline-block;
	float: right;
	font-size: 14px;
	color: #9e9e9e;
	font-size: 15px;
}
.belist3{margin-right: -2px;}

.listpic {
	padding-left: 10px;
	padding-right: 10px;
}
.listpic1{
	float: right;
    margin-top: 24px;
    padding-left: 10px;
	padding-right: 10px;
	
}
.bSubject{font-size: 17px; font-weight: bold;}
.pageWriteBtn{margin-right: 12px;}
.commentPro{width: 50px; height: 50px;}
.aflistp{display: inline-block;}
.re{padding-top: 10px;}
.modifyB, .deleteB{font-weight: 400; font-size:13px; float:right;	color:#9c9c9cbf; padding-top:13px;}
.modifyB:hover, .deleteB:hover{cursor: pointer;}
.remd{display: inline-block; float: right;}
.listpic2{padding-left: 10px; padding-bottom: 8px;}
.modifyB2, .deleteB2{font-weight: 400; font-size:13px;color:#9c9c9cbf;}
.modifyB2:hover, .deleteB2:hover{cursor: pointer;}
.paging-numbers a.on{background:#f13d3d;}
.container1{margin: auto; width:75%;}
#writeBtn:hover{cursor: pointer;}

</style>
<body class="page1" id="top">
	<!---------------------------------- 게시글 상세페이지 ---------------------------------->

	<!--===================== Content======================-->
		<div class="container">
			<div class="row">
				<!---------------------------------------------------------------------------------------------------------------------------------------------->
				<div class="container1">
					<!-- 게시판 명 -->
					<h2 class="boardName">자유게시판
					<!------------------------ 게시물 수정, 삭제 (로그인시 적용(해당 게시물 작성자만 가능하도록 설정)) ------------------------>
					<span class="modifyB">수정</span>
					<img src="/baraonda/resources/images/boardImg/bar_9.gif" class="listpic1">
					<span class="deleteB">삭제</span>
					</h2>
					
					<!-- 게시글 제목 -->
					<div>
						<span class="bSubject">${detail.BOARD_TITLE}</span>
					</div>
					<hr class="hrline">
					<div class="boardInfo">
						<span class="inner">
						<span class="ico_wrap">
						<a href="#">
							<img src="<%=request.getContextPath()%>/resources/images/boardImg/img_male.gif" class="proic">
						</a>
						</span>
							<!------------------------------------ 게시글 작성자명 ------------------------------------>
								<em class="nick_em">
								<div class="inner_nick_box">
									<p class="inner_nick">${detail.NICK_NAME}</p>
								</div>
						</em> <!------------------------------------ 게시글 날짜, 조회수, 댓글수 ------------------------------------>
							<div class="group_inner">
								<ul class="date_menu">
									<li class="da01"><span>${detail.BOARD_DATE}</span></li>
									<li class="da02"><span>${detail.BOARD_COUNT}</span></li>
									<li class="da03"><span>${detail.COMMENTS_COUNT}</span></li>
								</ul>
							</div>
						</span>
					</div>
					<hr class="hrline">

					<!------------------------------------ 게시글 내용 ------------------------------------>
					<div class="viewContent">
						<p class="view_text">${detail.BOARD_CONTENT}</p>
					</div>

					<!------------------------------------ 북마크, 좋아요------------------------------------>
					<div class="allmark">
						<a href="#" class="bmark"> <span>북마크</span>
						</a> <a href="#" class="heart"> <span>1</span>
						</a>
					</div>
					<!------------------------------------ 글쓰기, 목록 ------------------------------------>
					<div class="btn_ar">
						<img id="writeBtn" class="pageWriteBtn" src="<%=request.getContextPath()%>/resources/images/boardImg/btn_write2.gif">
						<img src="<%=request.getContextPath()%>/resources/images/boardImg/btn_list.gif">
					</div>
					<div id="commList">
						<p class="tit_comment">
							<img
								src="<%=request.getContextPath()%>/resources/images/boardImg/tit_cmt_write.png">
						</p>

						<!------------------------------------ 댓글 작성 폼 ------------------------------------>
						<div id="comment-write" class="comment-write">
							<form action="insertComment.do" method="post">
								<textarea name="COMMENTS_CONTENT" id="comment" class="txtarea r5 placeholder"
									placeholder="댓글 등록 시 상대에 대한 비방이나 욕설 등은 피해주시고, 따뜻한 격려와 응원을 보내주세요~
댓글에 대한 신고가 접수될 경우, 내용에 따라 즉시 삭제될 수 있습니다."
									onfocus="setFlag();"></textarea>
								<input name="MEMBER_NO" type="hidden" value= "${loginUser.member_no}">
								<input name="NICK_NAME" type="hidden" value= "${loginUser.nick_name}">
								
								<input name="BOARD_NO" type="hidden" value= "${BOARD_NO}">
								
								<button type="submit" id="btncmm" class="btn btn-primary">입력</button>
							</form>
						</div>
					</div>

					<!------------------------------------ 게시글에 작성된 댓글 수 ------------------------------------>
					<div class="comment-count">
						<p class="comment-count-1">댓글</p>
						<p class="comment-count-2">${detail.COMMENTS_COUNT}</p>
					</div>
					
					<c:forEach items="${commentList}" var="row">
					<table class="comment-list">
						<ul>
							<li class="comment-list-li">
								<div class="comment-pic">
									<img class="commentPro" 
										src="<%=request.getContextPath()%>/resources/images/boardImg/img_male.gif">
								</div>
								<div class="comment-txt">
									<!--------------------------------- 댓글 작성자명 ---------------------------------->
									<strong id="ntxt">${row.NICK_NAME}</strong>
									<!---------------------------------- 댓글 작성 시간---------------------------------->
									<span>${row.COMMENTS_DATE}</span>
									<!----------------- 댓글 수정, 삭제 (로그인시 적용(해당 게시물 댓글만 가능하도록 설정)) ----------------->
									<div class="remd">
										<span class="modifyB2">수정</span>
											<img src="/baraonda/resources/images/boardImg/bar_9.gif" class="listpic2">
											<span class="deleteB2">삭제</span>
									</div>
									<!-- 댓글 내용 -->
									<p id="ptxt">${row.COMMENTS_CONTENT}</p>
								</div>
								<div class="re">
									<a href="#" class="btn-re">답글 ▼</a>
								</div>
							</li>
							<hr class="hrline">
						</ul>
					</table>
					</c:forEach>
					<div class="paginate">
						<span class="paging-numbers">
							<a href="#" class="on">1
								<span class="blind">페이지로 이동</span>
							</a>
						</span>
					</div>

					<hr class="hrline">
					<!------------------------------------ 다음글 제목, 날짜, 조회수 ------------------------------------>
					<div class="balist1">
						<a href="#" class="aflist1">다음글 ▲
							<p class="aflist2">저녁추천좀요</p>
						</a>
						<div class="aflist3">
							<p class="aflistp">17:30</p>
							<img src="<%=request.getContextPath()%>/resources/images/boardImg/bar_9.gif" class="listpic">
							<p class="aflistp">조회수 10</p>
						</div>
					</div>
					<!------------------------------------ 이전글 제목, 날짜, 조회수 ------------------------------------>
					<div>
						<a href="#" class="belist1">이전글 ▼
							<p class="belist2">오늘 먹은 점심임니다</p>
						</a>
						<div class="belist3">
							<p class="aflistp">13:30</p>
							<img src="<%=request.getContextPath()%>/resources/images/boardImg/bar_9.gif" class="listpic">
							<p class="aflistp">조회수 32</p>
						</div>
					</div>
				</div>
				<!-------------------------------------------------------------------------->
			</div>
		</div>
	<!----------------- footer----------------->
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
						 <a href="#">Privacy Policy</a>
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