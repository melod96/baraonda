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
/* *{font-family:'Easop' !important;} */

#main_category{
	height:300px;
}


#ba_font{
	font-weight:bold;
}

#nq_box{
	background-color: #fff7fb;
	
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
              <a href="tips.tp">more</a>
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
              <a href="#">more</a>
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
              <a href="#">more</a>
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
          <a href="#" class="btn">more</a>
        </div>
      </div>
      <div class="grid_4">
        <div class="block1">
          <div class="count" id="count">2.</div>
          <img src="${pageContext.request.contextPath}/resources/images/main/칼로리처방.png">
          <br>
          <a href="#" class="btn">more</a>
        </div>
      </div>
      <div class="grid_4">
        <div class="block1">
          <div class="count" id="count">3.</div>
          <img src="${pageContext.request.contextPath}/resources/images/main/인바디보건소.png">
          <br>
          <a href="#" class="btn">more</a>
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
              <c:forEach var="n" items="${ list }">
              <img src="${pageContext.request.contextPath}/resources/images/main/공지사항아이콘.png" id="notice_img">
              <label>${ n.board_title }</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/공지사항아이콘.png" id="notice_img">
              <label>${ n.board_title }</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/공지사항아이콘.png" id="notice_img">
              <label>${ n.board_title }</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/공지사항아이콘.png" id="notice_img">
              <label>${ n.board_title }</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/공지사항아이콘.png" id="notice_img">
              <label>${ n.board_title }</label>
              </c:forEach>
              <br>
              <!-- <p>Post about this <strong class="color1"><a href="http://blog.templatemonster.com/free-website-templates/" rel="nofollow">freebie</a></strong> will tell all you need to know about it. Need a good choice of <strong class="color1"><a href="http://www.templatemonster.com/properties/topic/food-restaurant/" rel="nofollow">themes</a></strong>? Visit TemplateMonster’s website.</p>
              Aliquam nibh e,estas id dictum a, commodo. Praesent faucibus malesuada faucibusonec laeet metus id laoreet malesuadarem ipsum dolor sit <br> -->
              <a href="#" class="btn" id="nq_btn">more</a>
            </div>
              <!-- 공지사항 -->
              
              <!-- 고객문의 -->
            <div class="grid_5">
              <h2>Question</h2>
              <img src="${pageContext.request.contextPath}/resources/images/main/고객센터아이콘.png" id="question_img">
              <label>리스트 항목</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/고객센터아이콘.png" id="question_img">
              <label>리스트 항목</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/고객센터아이콘.png" id="question_img">
              <label>리스트 항목</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/고객센터아이콘.png" id="question_img">
              <label>리스트 항목</label>
              <br>
              <img src="${pageContext.request.contextPath}/resources/images/main/고객센터아이콘.png" id="question_img">
              <label>리스트 항목</label>
              <br>
              <a href="#" class="btn" id="nq_btn">more</a>
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

       <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig1.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig1.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         <br>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
          </div>
        </div>
      </div>
      <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig3.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig3.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         <br>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
          </div>
        </div>
      </div>
      <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig8.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig8.jpg" alt=""></a>
            <div class="gall_bot">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         <br>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
          </div>
        </div>
      </div>
      <div class="clear sep__1"></div>
      <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig5.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig5.jpg" alt=""></a>
            <div class="gall_bot">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         <br>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
          </div>
        </div>
      </div>
      <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig6.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig6.jpg" alt=""></a>
            <div class="gall_bot">
            <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         <br>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
          </div>
        </div>
      </div>
      <div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <a href="${pageContext.request.contextPath}/resources/images/bbig7.jpg" class="gall_item"><img src="${pageContext.request.contextPath}/resources/images/bbig7.jpg" alt=""></a>
            <div class="gall_bot">
           <div class="text1"><a href="#">수지 다이어트 컬럼 </a></div>
	         <label>2018-10-23</label>&nbsp;|&nbsp;조회수&nbsp;<label style="color:red">0</label>&nbsp;|&nbsp;좋아요&nbsp;<label style="color:red">6</label>
	         <br>
	         <img src="${pageContext.request.contextPath}/resources/images/main/profile4.png">
	         <a id="ba_font">태평양이참치</a>
	         <br>
            <a href="#" class="btn">more</a></div>
          </div>
        </div>
      </div>
   
    <!-- 비포에프터 -->
      
      
      <!-- 베스트 다이어터 -->
       <div class="grid_4">
        <h2>Best Dieter</h2>
        <br>
        <br>
        <blockquote class="bq1">
          <img src="${pageContext.request.contextPath}/resources/images/main/참치프로필.png" alt="" class="${pageContext.request.contextPath}/resources/img_inner fleft noresize">
          <div class="extra_wrapper">
            <div class="bq_title color1">태평양이참치</div>
            <div>
          	  자기소개입니다.자기소개입니다.자기소개입니다.자기소개입니다.자기소개입니다.자기소개입니다.자기소개입니다.자기소개입니다.자기소개입니다.
            </div>
            <a href="#" id="user"><span class="fa fa-chevron-right"></span>정보 보기</a>
          </div>
        </blockquote>
      </div>
      <!-- 베스트 다이어터 -->
      
      <!-- 다이어터 랭킹 -->
      <div class="grid_4" >
      <h2>Dieter Ranking</h2>
      <div id="rank_box">
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/one.png" id="number_img">
	      <img src="${pageContext.request.contextPath}/resources/images/main/profile3.png" id="profile_img">
	      <a id="profile_font">태평양이참치 </a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/two.png" id="number_img">
	      <img src="${pageContext.request.contextPath}/resources/images/main/profile3.png" id="profile_img">
	      <a id="profile_font">재엽쓰</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/three.png" id="number_img">
	      <img src="${pageContext.request.contextPath}/resources/images/main/profile3.png" id="profile_img">
	      <a id="profile_font">소진쓰</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/four.png" id="number_img">
	      <img src="${pageContext.request.contextPath}/resources/images/main/profile3.png" id="profile_img">
	      <a id="profile_font">형우쓰</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/five.png" id="number_img">
	      <img src="${pageContext.request.contextPath}/resources/images/main/profile3.png" id="profile_img">
	      <a id="profile_font">현도쓰</a>
	      </label>
		</div>
      </div>
      <!-- 다이어터 랭킹 -->
      
      <!-- 명예의 전당 -->
      <div class="grid_4" >
      <h2>Hall of Fame</h2>
      <div id="fame_box">
       	<div id="fame_box2"> 
      	<label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/star.png" id="profile_img">
	      <a id="fame_font">제목제목제목제목제목제목제목제목</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/star.png" id="profile_img">
	      <a id="fame_font">제목제목제목제목제목제목제목제목</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/star.png" id="profile_img">
	      <a id="fame_font">제목제목제목제목제목제목제목제목</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/star.png" id="profile_img">
	      <a id="fame_font">제목제목제목제목제목제목제목제목</a>
	      </label>
	      <br>
	      <hr>
	      <label>
	      <img src="${pageContext.request.contextPath}/resources/images/main/star.png" id="profile_img">
	      <a id="fame_font">제목제목제목제목제목제목제목제목</a>
	      </label>
	       </div> 
      </div>
      </div>
      <!-- 명예의 전당 -->
      
    </div>
  </div>
<br>

</section>
<!--==============================
              footer
=================================-->
<footer id="footer">
  <div class="container">
    <div class="row">
      <div class="grid_12">  
        <div class="socials">
          <a href="#" class="fa fa-twitter"></a>
          <a href="#" class="fa fa-facebook"></a>
          <a href="#" class="fa fa-google-plus"></a>
          <a href="#" class="fa fa-pinterest"></a>
        </div>
        <div class="copyright"><span class="brand">Bliss </span> &copy; <span id="copyright-year"></span> | <a href="#">Privacy Policy</a> <div>Website designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a></div>
        </div>
      </div>
    </div>
  </div> 
</footer> 
</body>
</html>