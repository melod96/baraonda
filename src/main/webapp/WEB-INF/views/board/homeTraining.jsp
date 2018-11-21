<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BARAON.DA - 홈트레이닝</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<jsp:include page="../common/head.jsp" />

<style>
#tips {
	width: 250px;
	height: 360px;
	margin-left: 10px;
}

[class*="grid_"] {
	float: left;
	min-height: 1px;
	margin-left: 10px;
}

.gall_block {
	width: 250px;
	height: 350px;
}

.boxbox {
	margin-top: -10px;
}

#fonts {
	font-size: 11px;
}
.list{width:110%}
.pagi{
	width: 70%;
    text-align: center;
    margin-top: 10px;
}
#homeBtn:hover{
	cursor:pointer;
	color : #aaccaa;
}
.text1{
	text-overflow: ellipsis;
    overflow: hidden;
    width: 100%;
    height: 20px;
    white-space: nowrap;
}
.pageWriteBtn{
	float:right; margin-right: -47px; width:70px; height:28px;
}
.title{font-weight: bold; margin-left: 8px;}
.boardHr{margin-left: 8px; 	width: 105%; border-top: 1.5px solid black;}
.right{margin-left: 100px !important; }
.gall_block:hover{
	box-shadow:2px 2px 4px #888;
	cursor: pointer;
}

</style>

</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row">
			<div class="left">
				<jsp:include page="../common/banner.jsp" />
				<h2 class="title">홈트레이닝</h2>
				<hr class="boardHr">
				<div class="clear" style="height: 20px; background: white;"></div>
				<div style="margin-bottom: 10px; margin-left: 10px;">
					<a id="homeBtn" href="home.do?writing_type=6" class="home1">전신</a>&nbsp;|&nbsp;
					<a id="homeBtn" href="home.do?writing_type=7">복부</a>&nbsp;|&nbsp;
					<a id="homeBtn" href="home.do?writing_type=8">상체</a>&nbsp;|&nbsp;
					<a id="homeBtn" href="home.do?writing_type=9">하체</a>
					<c:if test="${sessionScope.loginUser.admin_right == 1}">
						<a href="homeWrite.do">
							<img class="pageWriteBtn" src="<%=request.getContextPath()%>/resources/images/boardImg/btn_write2.gif">
						</a> 
					</c:if>
				</div> 
				<c:forEach items="${list}" var="list" end="8">
				<div class="list">
					<div class="grid_4" id="tips" onclick="location.href='view.do?board_no=' + ${list.board_no}">
						<div class="gall_block">
							<div class="maxheight">
								<a href="${pageContext.request.contextPath}${list.files_root}${list.files_change_title}" class="gall_item" ><img src="${pageContext.request.contextPath}${list.files_root}${list.files_change_title}" alt="" style="width:300px; height:170px;"></a>
								<div class="gall_bot">
									<div class="boxbox">
										<div class="text1">
											<a onclick="location.href='view.do?board_no= ' + ${list.board_no}">${list.board_title}</a>
										</div>
										<div id="fonts">
											<label>${list.board_date}</label>&nbsp;|&nbsp;
											조회수&nbsp;<label style="color: red">${list.board_count }</label><%-- &nbsp;|&nbsp;
											좋아요&nbsp;<label style="color: red">${list.board_good }</label> --%>
										</div>
										<img src="<%=request.getContextPath()%>/resources/images/boardImg/woman.png" style="width: 25px; height: 25px; border-radius: 20px">
										<a id="ba_font">홈트레이닝</a> <br> <a onclick="location.href='view.do?board_no=' + ${list.board_no}" class="btn">more</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<jsp:include page="../common/rightBoard.jsp" />
		</div>
		<div class="pagi">
						<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
						</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="home.do">
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
								<c:url var="blistCheck" value="home.do">
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
							<c:url var="blistEnd" value="home.do">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
								<c:param name="writing_type" value="${writing_type}"/>
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
					</div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>
















