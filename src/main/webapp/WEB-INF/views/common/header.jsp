<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.menu1{display:inline-block;}
	.menu1:hover{color:white;cursor:pointer;}

</style>

    <header>
<!--==============================
            Stuck menu
=================================-->
  <section id="stuck_container">
    <div class="container">
    <div style="float:right;">
     	<div class="menu1"><a>로그인</a></div>&nbsp;&nbsp;&nbsp;
     	<div class="menu1"><a>회원가입</a></div>
    </div>
      <div class="row">
      <!-- 헤더 카테고리 -->
        <div class="grid_12">
        <h1>
          <a href="index.html">
            <img src="images/main/logo.png" alt="Logo alt">
          </a>
        </h1>  
          <div class="navigation">
            <nav>
              <ul class="sf-menu">
               <li class="current"><a href="index.html"><img src="images/main/다이어트꿀팁.png" alt="Logo alt"></a></li>
               <li><a href="index-1.html"><img src="${pageContext.request.contextPath}/resources/images/main/칼로리사전.png" alt="Logo alt"></a></li>
               <li><a href="index-2.html"><img src="${pageContext.request.contextPath}/resources/images/main/홈트레이닝.png" alt="Logo alt"></a></li>
               <li><a href="index-3.html"><img src="${pageContext.request.contextPath}/resources/images/main/커뮤니티.png" alt="Logo alt"></a></li>
               <li><a href="index-4.html"><img src="${pageContext.request.contextPath}/resources/images/main/바다체험단.png" alt="Logo alt"></a></li>
             </ul>
            </nav>        
            <div class="clear"></div>
          </div>
        </div>
        <!-- 헤더 카테고리 -->
        
      </div>
    </div>
  </section> 
</header>  