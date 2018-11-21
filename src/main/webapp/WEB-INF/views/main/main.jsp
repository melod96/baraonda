<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>baraonda</title>
<meta name = "format-detection" content = "telephone=no" />
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/stuck.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/touchTouch.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/script.js"></script> 
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.mobilemenu.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/tmStickUp.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/touchTouch.jquery.js"></script>



<script>
 $(document).ready(function(){

  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});
  $('.gallery .gall_item').touchTouch();

  }); 
</script>


<style>
/* *{font-family:'Easop' !important;} */

#main_category{
	height:300px;
}


#ba_font{
	font-weight:bold;
}

#ba_font:hover{cursor:pointer; color: green;}

#nq_title:hover{cursor:pointer; color: green;}
	
#nq_box{
	background-color: #f1f0f1;
	
}

#notice_img{
	padding-right:10px;
	margin-bottom:10px;
}

#notice_img{
	padding-right:10px;
	margin-bottom:10px;
}

#question_img{
	padding-right:10px;
	margin-bottom:10px;
}

#nq_btn{
	float:left;
}

#user{
	font-size:15px;
}


#profile_font{
	font-size: 17px;
	padding: 10px;
}

#profile_font:hover{cursor:pointer; color:green;}

#user:hover{cursor:pointer; color:green;}

#ba_title:hover{cursor:pointer; color:green;}

#gall_item:hover{cursor:pointer;}

#profile_img{
 	margin-top: -3px; 
}

#number_img{
	width: 25px;
	height:25px;
	margin-right: 10px;
}

#fame_font{
	font-size: 15px;
	padding: 10px;
}

#fame_box{
	border:1px solid black;
	width:340px;
	height:340px;
	padding-left:20px;
}

#fame_box2{
	width:320px;
	height:340px;
	padding-top:17px;

}

hr{
	background-color:black;
	 margin:10px;
}

.row{

	width:1200px;
}

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
<body class="page1" id="top">
<!--==============================
              header
=================================-->
 <jsp:include page="../common/header.jsp"/> 
 <!--==============================
              header
=================================-->
   

<!--=====================
          카테고리 이동
======================-->
<section class="content">
  <div class="container">
    <div class="row" >
      <div class="grid_4" >
        <div class="banner" >
		  <div class="gall_block" >
		  <!-- 다이어트꿀팁 이미지 -->
          <img src="${pageContext.request.contextPath}/resources/images/main/꿀팁이미지.png" alt="" >
          <div class="bann_capt " id="main_category">
            <div class="maxheight">
              <img src="${pageContext.request.contextPath}/resources/images/icon2.png" alt="">
              <div class="bann_title">Diet<br>Best Tip</div>
              <a href="tips.tp?writing_type=0">more</a>
            </div>
          </div>
        </div>
	   </div>
      </div>
      <div class="grid_4">
        <div class="banner">
		  <div class="gall_block">
          <div class="bann_capt  bn__1" id="main_category">
            <div class="maxheight">
              <img src="${pageContext.request.contextPath}/resources/images/main/커뮤아이콘.png" alt="">
              <div class="bann_title">Baraonda<br>Community</div>
              <a href="list.do?writing_type=1">more</a>
            </div>
          </div>
          <!-- 커뮤니티 이미지 -->
          <img src="${pageContext.request.contextPath}/resources/images/main/커뮤이미지.png" alt="">
        </div>
		</div>
      </div>
      <div class="grid_4">
        <div class="banner ">
		  <div class="gall_block">
		  <!-- 홈트레이닝 이미지 -->
          <img src="${pageContext.request.contextPath}/resources/images/main/홈트이미지.png" alt="">
          <div class="bann_capt  bn__2" id="main_category">
            <div class="maxheight">
              <img src="${pageContext.request.contextPath}/resources/images/main/홈트아이콘.png" alt="">
              <div class="bann_title">Home<br>Training</div>
              <a href="home.do?writing_type=6">more</a>
            </div>
          </div>
		  </div>
        </div>
      </div>
      <!-- 카테고리 이미지 -->

	<!-- 처방 서비스 -->
      <div class="grid_4">
        <div class="block1">
          <div class="count" id="count">1.</div>
          <img src="${pageContext.request.contextPath}/resources/images/main/bmi.png">
          <br>
          <a onclick="location.href='BMI.ds'" class="btn">more</a>
        </div>
      </div>
      <div class="grid_4">
        <div class="block1">
          <div class="count" id="count">2.</div>
          <img src="${pageContext.request.contextPath}/resources/images/main/칼로리처방.png">
          <br>
          <a onclick="location.href='caloriePresciption.ds'" class="btn">more</a>
        </div>
      </div>
      <div class="grid_4">
        <div class="block1">
          <div class="count" id="count">3.</div>
          <img src="${pageContext.request.contextPath}/resources/images/main/인바디보건소.png">
          <br>
          <a onclick="location.href='healthCenterList.ds'" class="btn">more</a>
        </div>        
      </div>
      <!-- 처방 서비스 -->
      
      <!-- 공지사항&고객센터 -->
      <div class="grid_12">
        <div class="box" id="nq_box">
          <div class="row">
          <!-- 공지사항 -->
            <div class="grid_5 preffix_1" id="nq_box">
              <h2>Notice</h2>
              <br>
              <c:forEach var="n" items="${nlist}" end="4">
	              <label class="noticeTitle"><img src="${pageContext.request.contextPath}/resources/images/main/공지사항아이콘.png" id="notice_img" style="margin-top:5px;">
	              <a onclick= "location.href='noticeDetail.nt?notice_no=' + ${n.board_no}" style="font-size:16px;" id="nq_title">${ n.board_title }</a><input type="hidden" value="${n.board_no }"></label>
	              <br>
              </c:forEach>
              <a href="noticelist.nt" class="btn" id="nq_btn">more</a>
            </div>
              <!-- 공지사항 -->
              
              
              <!-- 고객문의 -->
            <div class="grid_5">
              <h2>Question</h2>
              <br>
              <c:forEach var="q" items="${qlist}" end="4">
              <label><img src="${pageContext.request.contextPath}/resources/images/main/고객센터아이콘.png" id="question_img" style="margin-top:5px;">
              <a onclick= "location.href='view.do?board_no='+${q.board_no}" style="font-size:16px;" id="nq_title"> ${ q.board_title }</a></label>
              <br>
              </c:forEach> 
              <a href="list.do?writing_type=19" class="btn" id="nq_btn">more</a>
            </div>
            <!-- 고객문의 -->
          </div>
        </div>
      </div>
      <!-- 공지사항&고객문의 -->
      
      
      <!-- 비포에프터 -->
      <div class="grid_12">
        <h2>Before&After</h2>
      </div>
		
	<c:forEach var="t" items="${tlist}" end="5">
       <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a id="gall_item" onclick= "location.href='view.do?board_no=' + ${t.board_no}"><img src="${pageContext.request.contextPath}${t.files_root}${t.profile_title}" alt="" style="width:370px;height:230px;"></a>
            <div class="gall_bot">
            <div class="text1"><a onclick= "location.href='view.do?board_no=' + ${t.board_no}" id="ba_title">${t.board_title } </a></div>
	         <label>${t.board_date}</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">${t.board_count }</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">${t.board_good }</label>
	         <br>
	         	<img src="${pageContext.request.contextPath}${t.files_root}${t.files_change_title}" style="width:25px; height:25px; border-radius:20px">&nbsp;
	         <a id="ba_font" onclick="location.href='othersView.my?member_no=' + ${t.member_no}">${t.nick_name }</a>
	         <br>
            <a onclick= "location.href='view.do?board_no=' + ${t.board_no}" class="btn">more</a></div>
          </div>
        </div>
      </div>
      </c:forEach>
      

    <!-- 비포에프터 -->
      
      
      <!-- 베스트 다이어터 -->
       <div class="grid_4">
        <h2>Best Dieter</h2>
        <br>
        <br>
        <blockquote class="bq1">
        <c:forEach var="b" items="${blist}" end="1">
          <img src="${pageContext.request.contextPath}${b.files_root}${b.files_change_title}" alt="" class="${pageContext.request.contextPath}/resources/img_inner fleft noresize" style="height:100px; width:250px;">
          <div class="extra_wrapper">
            <div class="bq_title color1">${b.nick_name }</div>
            <div>
          	 ${b.self_introduction }
            </div>
            <a id="user" onclick="location.href='othersView.my?member_no=' + ${b.member_no}"><span class="fa fa-chevron-right"></span>정보 보기</a>
          </div>
          </c:forEach>
        </blockquote>
      </div>
      <!-- 베스트 다이어터 -->
      
      <!-- 다이어터 랭킹 -->
      <div class="grid_4" >
      <h2>Dieter Ranking</h2>
      <div id="rank_box">
      <div>
      <img src="${pageContext.request.contextPath}/resources/images/main/one.png" style="float:left; padding-top:22px;">
      <img src="${pageContext.request.contextPath}/resources/images/main/two.png" style="float:left; margin-top:90px; margin-left:-30px;"> &nbsp; &nbsp;
      <img src="${pageContext.request.contextPath}/resources/images/main/three.png" style="float:left; margin-top:160px; margin-left:-30px;"> &nbsp; &nbsp;
      <img src="${pageContext.request.contextPath}/resources/images/main/four.png" style="float:left; margin-top:230px; margin-left:-30px;"> &nbsp; &nbsp;
      <img src="${pageContext.request.contextPath}/resources/images/main/five.png" style="float:left; margin-top:300px; margin-left:-30px;"> &nbsp; &nbsp;
      </div>
      
      <c:forEach var="r" items="${rlist}" end="4">
	      <label>
	     	 <div style="float:right; margin-left:100px;"> 
	      <img src="${pageContext.request.contextPath}${r.files_root}${r.files_change_title}" id="profile_img" style="margin-left:15px; width:30px; height:30px; border-radius:20px;">
	      <a id="profile_font" onclick="location.href='othersView.my?member_no=' + ${r.member_no}">${ r.nick_name } </a>
	  	    </div> 
	      <a style="float:left; margin-top:4px;">누적경험치 :&nbsp;</a><a style="float:left; margin-top:4px;">${ r.accrue_point}</a>&nbsp;&nbsp;&nbsp;
	      </label>
	      <br>
	      <hr>
	     </c:forEach>
		</div>
      </div>
      <!-- 다이어터 랭킹 -->
      
      <!-- 명예의 전당 -->
      <div class="grid_4" >
      <h2>Hall of Fame</h2>
      <div id="fame_box">
       	<div id="fame_box2"> 
       	<c:forEach var="f" items="${flist}" end="4">
      	<label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/star.png" id="profile_img">
	      <a id="fame_font" <%-- onclick= "location.href='tipsDetail.tp?tips_no='+${f.board_no}" --%>>${f.board_title}</a>
	      </label>
	      <br>
	      <hr>
	      </c:forEach>
	
	       </div> 
      </div>
      </div>
      <!-- 명예의 전당 -->
      
    </div>
  </div>
<br>

</section>
<jsp:include page="../common/footer.jsp"/> 
</body>
</html>