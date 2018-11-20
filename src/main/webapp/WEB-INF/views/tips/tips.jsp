<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다이어트꿀팁</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<jsp:include page="../common/head.jsp" />
<style>
.left {
	float: left;
	width: 72%;
	display: inline-block;
}

.title {
	border-bottom: 2px solid #5d5d5d;
	font-size: 30px;
	width:780px;
}

.tbl-y th {
	padding: 22px 0 22px 14px;
}

.tbl-y td {
	padding: 10px 0 10px 14px;
}

.tbl-y-wrap {
	border: 1px solid #dedede;
}

.tbl-y {
	width: 100%;
}

.tbl-y tr {
	border-bottom: 1px solid #dedede;
}

.fbold {
	font-weight: bold !important;
	font-size: 11px;
	margin-top: 20px;
	line-height: 20px;
}

.p-gray {
	color: #7b7b7b !important;
	padding-left: 25px;
}

.btn-ac {
	text-align: center;
	margin-top: 30px;
}

.gender {
	-webkit-appearance: radio;
}

.search{
	margin-top:20px;
	margin-bottom:20px;
}


/* 다이어트꿀팁부분 */

#tips{
width:250px;
height:360px;
margin-left : 10px;
}


[class*="grid_"]{
	float: left;
    min-height: 1px;
    margin-left: 10px;
}

.gall_block{
width:250px;
height:350px;
}

.boxbox{
margin-top: -10px;
}

#fonts{
	font-size:11px;
}

/* 다이어트꿀팁부분 */

/* 서치부분 */
#searchBtn{float:right;margin: auto;}
#boardInput{margin-left: 3px;}
#boardBtn{margin-top: 0px; margin-left: 3px;}
#select{width:100px;}
.searchForm {
	margin: 0 auto;
	width: 530px;
}
#searchForm{
	margin-left:-20px;
}
/* 서치부분 */


/*식단,운동,컬럼*/
/* #tipsBtn{
	font-weight: bold:
} */
#tipsBtn:hover{
	cursor:pointer;
	color : #aaccaa;
}

/*페이징*/
.paginate{
 	margin-right:70px;
}

#titleText1:hover{cursor:pointer; color:green;}

#tips_title:hover{cursor:pointer;}


.text1{
	text-overflow: ellipsis;
    overflow: hidden;
    width: 100%;
    height: 20px;
    white-space: nowrap;
}

</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">

	
		
		<jsp:include page="../common/banner.jsp" />

		<h2 class="title">다이어트꿀팁</h2>
		<div class="clear" style="height:40px;background:white;"></div>
		<div style="margin-bottom:10px; margin-left:10px;">
			<a id="tipsBtn" href="tips.tp?writing_type=0">전체</a>&nbsp;|&nbsp;
			<a id="tipsBtn" href="tips.tp?writing_type=3">식단</a>&nbsp;|&nbsp;
			<a id="tipsBtn" href="tips.tp?writing_type=2">운동</a>&nbsp;|&nbsp;
			<a id="tipsBtn" href="tips.tp?writing_type=1">칼럼</a>
			 
			 <c:if test="${sessionScope.loginUser.admin_right == 1}">
							<a href="tipsWrite.tp"> 
								<img class="pageWriteBtn" src="<%=request.getContextPath()%>/resources/images/boardImg/btn_write2.gif" style="float:right; margin-right:40px; width:70px; height:28px;">
							</a> 
						</c:if>
		</div>
	
		
		<c:forEach items="${tipslist}" var ="t" end="8">
	<div class="list">
      <div class="grid_4" id="tips">
      
        <div class="gall_block">
          <div class="maxheight">
            <a onclick= "location.href='tipsDetail.tp?tips_no='+${t.board_no}" id="tips_title"><img src="${pageContext.request.contextPath}${t.files_root}${t.files_change_title}" alt="" style="width:300px; height:170px;"></a>
            <div class="gall_bot">
            <div class="boxbox">
           <div id="titleText1" class="text1"><a onclick= "location.href='tipsDetail.tp?tips_no='+${t.board_no}">${t.board_title }</a></div>
           <div id="fonts">
	         <label>${t.board_date}</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">${t.board_count }<%-- </label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">${t.board_good }</label> --%>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/uploadFiles/아이유프사.png" style="width:25px; height:25px; border-radius:20px">
	         <a id="ba_font">${t.nick_name }</a>
	         <br>
            <a onclick= "location.href='tipsDetail.tp?tips_no='+${t.board_no}" class="btn">more</a></div>
            </div>
          </div>
        </div>
      </div>
</div> 
      </c:forEach>
      

				<div class="clear sep__1"></div>
				
				
				<div class="paginate">
					<c:if test="${empty search }">
						<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
						</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="tips.tp">
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
								<c:url var="blistCheck" value="tips.tp">
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
							<c:url var="blistEnd" value="tips.tp">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
								<c:param name="writing_type" value="${writing_type}"/>
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
					</c:if>
					<c:if test="${! empty search}">
						<c:if test="${ pi.currentPage <= 1 }">
							[이전] &nbsp;
						</c:if>
						<c:if test="${ pi.currentPage > 1 }">
							<c:url var="blistBack" value="searchTips.tp">
								<c:param name="currentPage" value="${ pi.currentPage -1 }"/>
								<c:param name="search" value="${search}"/>
							</c:url>
							<a href="${ blistBack }">[이전]</a>
						</c:if>
						
						<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
							<c:if test="${ p eq pi.currentPage }">
								<font color="red" size="4"><b>[${ p }]</b></font>
							</c:if>
							<c:if test="${ p ne pi.currentPage }">
								<c:url var="blistCheck" value="searchTips.tp">
									<c:param name="currentPage" value="${ p }"/>
									<c:param name="search" value="${search}"/>
								</c:url>
								<a href="${ blistCheck }">${ p }</a>
							</c:if>
						</c:forEach>
						
						
						
						<c:if test="${ pi.currentPage >= pi.maxPage }">
							&nbsp; [다음]
						</c:if>
						<c:if test="${ pi.currentPage < pi.maxPage}">
							<c:url var="blistEnd" value="searchTips.tp">
								<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
								<c:param name="search" value="${search}"/>
							</c:url>
							&nbsp; 
							<a href="${ blistEnd }">[다음]</a>
						</c:if>
					</c:if>
				</div>
				
				<br>


	<form action="searchTips.tp" method="get" style="margin-left:162px;">
			<div class="search">
				<select class="form-control input-xshort" style="float:left; margin-right:10px; height:45px;" name = "searchtype">
					<option value = "title">제목</option>
					<option value = "content">내용</option>
					<option value = "writer">작성자</option>
				</select>
				<div class="ui action input">
					<input type="text" placeholder="Search..." name = "search">
					<button class="ui icon button" type="submit">
						<img src="${pageContext.request.contextPath}/resources/images/dictionaryImg/Search.png" style="width:20px; height:20px;"/>
					</button>
				</div>
	<!-- 			<button type="button" class="btn btn-primary" style="float:right; margin:0;" onclick = "location.href='noticeWrite.nt'">작성하기</button> -->
			</div>
		</form>
			<!-- 	<form action="searchTips.tp" method="get">
				<div id="searchForm">
						<table>
							<tr>
								<td><select class="form-control input-xshort" id="select" name = "searchtype">
										<option value = "title">제목</option>
										<option value = "content">내용</option>
										<option value = "writer">작성자</option>
								</select></td>
								<td>
								
								<input id="boardInput" name=""
									class="form-control input-short" type="text" placeholder="">
									
								</td>
								<td><button id="boardBtn" type="submit" class="btn btn-primary">검색</button></td>
							</tr>
						</table>
						</div>
					</form> -->
					<br>
					<br>
					
	</div>
	<jsp:include page="../common/rightBoard.jsp" />
  </div>
  </div>
</body>
</html>