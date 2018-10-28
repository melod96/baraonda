<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width: 75%;
	display: inline-block;
}

.title {
	border-bottom: 2px solid #5d5d5d;
	font-size: 30px;
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
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">
		<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG" style="width:732px; height:180px;">
		<h2 class="title">다이어트꿀팁</h2>
		<div class="clear" style="height:40px;background:white;"></div>
		<div style="margin-bottom:10px; margin-left:10px;">
			 <a id="tipsBtn">식단</a>&nbsp;|&nbsp;<a id="tipsBtn">운동</a>&nbsp;|&nbsp;<a id="tipsBtn">칼럼</a>
		</div>
		
		
		<div class="list">
		<div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig1.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig1.jpg" alt=""></a>
            <div class="gall_bot">
            
            <div class="boxbox">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
            <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
            
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig3.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig3.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
            <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
            
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig8.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig8.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
           <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig5.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig5.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
           <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	        </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig6.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig6.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
            <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig7.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig7.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
           <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig1.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig1.jpg" alt=""></a>
            <div class="gall_bot">
            
            <div class="boxbox">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
            <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
            
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig3.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig3.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
            <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
            
          </div>
        </div>
      </div>
      <div class="grid_4" id="tips">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig8.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig8.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="boxbox">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
           <div id="fonts">
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         </div>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
            </div>
          </div>
        </div>
      </div>
</div>

				<div class="clear sep__1"></div>
				<div class="paginate">
                        <a href="#" class="btn-first" title="처음"><em class="blind">목록에서 처음 페이지 이동</em></a>
                        <a href="#" class="btn-prev" title="이전"><em class="blind">목록에서 이전 페이지 이동</em></a>
                        <span class="paging-numbers">
                            <a href="#">1<span class="blind">페이지로 이동</span></a>
                            <a href="#" class="on">2<span class="blind">페이지로 이동</span></a>
                            <a href="#">3<span class="blind">페이지로 이동</span></a>
                            <a href="#">4<span class="blind">페이지로 이동</span></a>
                            <a href="#">5<span class="blind">페이지로 이동</span></a>
                        </span>
                        <a href="#" class="btn-next" title="다음"><span class="spr"><em class="blind">목록에서 다음 페이지 이동</em></span></a>
                        <a href="#" class="btn-last" title="끝"><span class="spr"><em class="blind">목록에서 끝 페이지 이동</em></span></a>
				</div>
				
				<br>

				<form name="search" method="post" class="searchForm">
				<div id="searchForm">
						<table>
							<tr>
								<td><select class="form-control input-xshort" id="select">
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
						</div>
					</form>
					<br>
					<br>
					
	</div>
	<jsp:include page="../common/rightBoard.jsp" />
  </div>
  </div>
</body>
</html>