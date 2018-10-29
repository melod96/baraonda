<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <style>
    	.myHeader{width:800px;margin-right:auto;margin-left:auto;;margin-top:100px;}
    	.listBtn{margin-left:20px;}
    	.btn-default{width:125px; border:1px solid darkgray !important;; border-radius:3px !important;}
    </style>
    <div class="myHeader">
		<h3>마이페이지</h3>
			<div class="listBtn">
				<button type="button" id="changeInfo" class="btn btn-default" onclick="location.href='changeInfoView.my'">내 정보 변경</button>
				<button type="button" class="btn btn-default" onclick="location.href='footprintsView.my'">내 활동 정보</button>
				<button type="button" class="btn btn-default">1:1 채팅</button>
				<button type="button" class="btn btn-default" onclick="location.href='growingChicksView.my'">병아리 키우기</button>
			</div>
	</div>
	
	
	
	
	
	<%-- 
	클릭시 해당 메뉴로 이동 + 컬러 변경하는 소스

<%
	String pageName = "";
	if(request.getParameter("pageName") != null){
		pageName = request.getParameter("pageName");
	}else if(request.getAttribute("pageName") != null){
		pageName = (String)request.getAttribute("pageName");
	}
%>

<script>
	$(function(){
		<% switch(pageName){
			case "mainAdmin" : %>
			$("#mainAdmin").css({"background":"white", "color":"black"});
		<% break;
			case "commissionAdmin" :%>
			$("#commissionAdmin").css({"background":"white", "color":"black"});
		<% break; 
			case "memberAdmin" : %>
			$("#memberAdmin").css({"background":"white", "color":"black"});
		<% break;
			case "customerAdmin" : %>
			$("#customerAdmin").css({"background":"white", "color":"black"});
			<% break;
			case "customerQna" : %>
			$("#customerAdmin").css({"background":"white", "color":"black"});
			<% break;
			case "transactionAdmin" : %>
			$("#transactionAdmin").css({"background":"white", "color":"black"});
			<% break;
			case "statsAdmin" : %>
			$("#statsAdmin").css({"background":"white", "color":"black"});
			<% break;
			case "ratingAdmin" : %>
			$("#ratingAdmin").css({"background":"white", "color":"black"});
			<% break;
			case "noticeList" : %>
			$("#noticeList").css({"background":"white", "color":"black"});
			<% break;
			default : %>
			$("#mainAdmin").css({"background":"white", "color":"black"});
		<% break;
		} %>
	});
</script>

<section class="tit-area bg-yellow"><!-- 컬러변경시 bg-컬러명(gray,green,blue,yellow) 으로 바꿔주세요 -->
	<div class="container">
		<h2>관리자 페이지</h2>
		<ul class="tab-menu">
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectMain.ad?pageName=mainAdmin'" id="mainAdmin">메인관리 </a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectCommision.ad?pageName=commissionAdmin'" id="commissionAdmin">커미션 관리</a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectList.msg?pageName=customerAdmin'" id="customerAdmin">고객문의 관리</a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectMemberList.ad?pageName=memberAdmin'" id="memberAdmin">회원 관리</a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectTrs.ad?pageName=transactionAdmin'" id="transactionAdmin">거래내역 관리</a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectNoticeList.no?pageName=noticeList'" id="noticeList">공지사항</a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectRating.ad?pageName=ratingAdmin'" id="ratingAdmin">등급 관리</a></li>
		<li><a onclick = "location.href='<%= request.getContextPath() %>/selectStatsList.ad?pageName=statsAdmin'" id="statsAdmin">통계 관리</a></li>
		</ul>
	</div>
</section>

 --%>

	