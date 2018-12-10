<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BARAON.DA</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../common/header.jsp" />


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
.page1 h2 {
    padding-top: 31px;
    margin-bottom: 20px;
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

#btncmm1 {
	position: absolute;
	right: 21px;
	top: -9px;
	width: 90px;
	height: 120px;
}
#btncmm2 {
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
.pageWriteBtn:hover{cursor: pointer;}
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
#boardList:hover {cursor: pointer;}
.reportBoard{
width:85px;height: 30px; float:right; margin-top: -25px; text-align: center;
cursor: pointer; background: #f72e36; color: white; padding-top: 4px; border-radius: 4px; font-size: 15px;}
#reportContent{display:none;}
#rPopup{width: 250px; margin-left: 880px; margin-top: -170px; box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.5);}
#report{-webkit-appearance: radio !important;}
#closePopup{float:right; color:blue;}
#report{border-bottom: 1px solid #eee;}
.pop_check{float: left;
    position: absolute;
    left: 1408px;
    margin-top: 5px;
    vertical-align: middle;}
#rli{cursor:pointer; margin-left: 22px;}

</style>
<body class="page1" id="top">
	<!---------------------------------- 게시글 상세페이지 ---------------------------------->

	<!--===================== Content======================-->
		<div class="container">
			<div class="row">
				<!---------------------------------------------------------------------------------------------------------------------------------------------->
				<div class="container1">
					<!-- 게시판 명 -->
		
						<h2 class="boardName">자주하는 질문</h2>			
			
				
					<!-- 게시글 제목 -->
					<div>
						<span class="bSubject">자주하는 질문</span>
					</div>
					<hr class="hrline">
					<div class="boardInfo">
						<span class="inner">
						<span class="ico_wrap">
						<a href="#">
							<img src="${pageContext.request.contextPath}/resources/images/uploadFiles/아이유프사.png" style="border-radius:20px;" class="proic">
						</a>
						</span>
							<!------------------------------------ 게시글 작성자명 ------------------------------------>
								<em class="nick_em">
								<div class="inner_nick_box">
									<p class="inner_nick">관리자</p>
								</div>
						</em> <!------------------------------------ 게시글 날짜, 조회수, 댓글수 ------------------------------------>
							<div class="group_inner">
								<ul class="date_menu">
									<li class="da01"><span>18-11-19</span></li>
									<li class="da02"><span>54205</span></li>
								</ul>
							</div>
						</span>
					</div>
					<hr class="hrline">

					<!------------------------------------ 게시글 내용 ------------------------------------>
					<div class="viewContent">
						<p class="view_text">
						<div align="center">
						<iframe
    allow="microphone;"
    width="650"
    height="730"
    src="https://console.dialogflow.com/api-client/demo/embedded/f57b8705-afdb-466c-aba0-92f44c769437">
</iframe>
</div>
						
						</p>
					</div>

					
				
				</div>
				<!-------------------------------------------------------------------------->
			</div>
		</div>
		<br>
		<br>
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