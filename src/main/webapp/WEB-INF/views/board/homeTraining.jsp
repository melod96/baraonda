<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BARAON.DA - 홈트레이닝</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
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
</style>

</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height: 40px; background: white;"></div>
	<div class="container">
		<div class="row">
			<div class="left">
				<img
					src="${pageContext.request.contextPath}/resources/images/berrywater.PNG"
					style="width: 732px; height: 180px;">
				<h2 class="title">다이어트꿀팁</h2>
				<div class="clear" style="height: 40px; background: white;"></div>
				<div style="margin-bottom: 10px; margin-left: 10px;">
					<a id="tipsBtn" href="tips.tp?writing_type=6">전신</a>&nbsp;|&nbsp;
					<a id="tipsBtn" href="tips.tp?writing_type=7">복부</a>&nbsp;|&nbsp;
					<a id="tipsBtn" href="tips.tp?writing_type=8">상체</a>&nbsp;|&nbsp;
					<a id="tipsBtn" href="tips.tp?writing_type=9">하체</a>
				</div>
	
				<c:forEach items="${list}" var="list" end="8">
				<div class="list">
					<div class="grid_4" id="tips">
						<div class="gall_block">
							<div class="maxheight">
								<a href="${pageContext.request.contextPath}${t.files_root}"
									class="gall_item"><img
									src="${pageContext.request.contextPath}${t.files_root}" alt=""
									style="width: 300px; height: 170px;"></a>
								<div class="gall_bot">
									<div class="boxbox">
										<div class="text1">
											<a onclick="location.href='tipsDetail.tp?tips_no='+${t.board_no}">${t.board_title }</a>
										</div>
										<div id="fonts">
											<label>${t.board_date}</label>&nbsp;|&nbsp;조회수&nbsp;<label
												style="color: red">${t.board_count }</label>&nbsp;|&nbsp;좋아요&nbsp;<label
												style="color: red">${t.board_good }</label>
										</div>
										<img src="${pageContext.request.contextPath}${t.profile_root}"
											style="width: 25px; height: 25px; border-radius: 20px">
										<a id="ba_font">${t.nick_name }</a> <br> <a
											onclick="location.href='tipsDetail.tp?tips_no='+${t.board_no}"
											class="btn">more</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
















