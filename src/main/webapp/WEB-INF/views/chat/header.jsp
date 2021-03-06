<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<style>
	.menu1{display:inline-block;}
	.menu1:hover{color:white;cursor:pointer;}
	*{font-family:'Chungchunsidae'}
</style>


<jsp:include page="../common/head.jsp"/>


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
	    
		    <c:if test="${loginUser.company_right == 1  }">
			    <h4 align="right"><c:out value="${sessionScope.loginUser.company_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='changeInfoView.my'" class="btn btn-success">마이페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		    
		    <c:if test="${loginUser.company_right == 0  && loginUser.admin_right == 0}">
				<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='changeInfoView.my'" class="btn btn-success">마이페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		    
		    <c:if test="${loginUser.admin_right == 1}">
				<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='goDashboard.adm'" class="btn btn-success">관리자 페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		</c:if>
	
	
	
      <div class="row">
      <!-- 헤더 카테고리 -->
        <div class="grid_12">
        <h1>
          <a href="main.m">
            <img src="${pageContext.request.contextPath}/resources/images/main/logo.png" alt="Logo alt">
          </a>
        </h1>  
          <div class="navigation">
            <nav>
              <ul class="sf-menu">
               <li class="current">
              
               <li><a href="tips.tp"><img src="${pageContext.request.contextPath}/resources/images/main/다이어트꿀팁.png" alt="Logo alt"></a></li>
               <li><a href="foodDictionary.dt"><img src="${pageContext.request.contextPath}/resources/images/main/칼로리사전.png" alt="Logo alt"></a></li>
               <li><a href="home.do?writing_type=6"><img src="${pageContext.request.contextPath}/resources/images/main/홈트레이닝.png" alt="Logo alt"></a></li>
               <li><a href="list.do?writing_type=11"><img src="${pageContext.request.contextPath}/resources/images/main/커뮤니티.png" alt="Logo alt"></a></li>
               <li><a href="experiencePage.ep"><img src="${pageContext.request.contextPath}/resources/images/main/바다체험단.png" alt="Logo alt"></a></li>
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