<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<style>
	.menu1{display:inline-block;}
	.menu1:hover{color:white;cursor:pointer;}

</style>

<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="loginModal.jsp"/>
<jsp:include page="joinModal.jsp"/>


    <header>
<!--==============================
            Stuck menu
=================================-->
  <section id="stuck_container">
    <div class="container">
	    <!--로그인 전-->
	    <c:if test="${empty sessionScope.loginUser}">
		    <div style="float:right;">
		     	<div class="menu1"><a data-toggle="modal" data-target="#login-modal" class="login">로그인</a></div>&nbsp;&nbsp;&nbsp;
		     	<div class="menu1"><a data-toggle="modal" data-target="#join-modal" class="join">회원가입</a></div>
		    </div>
	    </c:if>
	    
	    <!--로그인 후-->
	    <c:if test="${!empty sessionScope.loginUser}">
			<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
			<div style="float:right;">
		     	<button onclick="location.href='changeInfo.my'" class="btn btn-success">정보수정</button>
		     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
		    </div>
		</c:if>
	
	
	
      <div class="row">
      <!-- 헤더 카테고리 -->
        <div class="grid_12">
        <h1>
          <a href="goMain.me">
            <img src="${pageContext.request.contextPath}/resources/images/main/logo.png" alt="Logo alt">
          </a>
        </h1>  
          <div class="navigation">
            <nav>
              <ul class="sf-menu">
               <li class="current">
              
               <li><a href="tips.tp"><img src="${pageContext.request.contextPath}/resources/images/main/다이어트꿀팁.png" alt="Logo alt"></a></li>
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