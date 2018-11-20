<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<style>

	.menu1{display:inline-block;}
	.menu1:hover{color:white;cursor:pointer;}
	*{font-family:'Chungchunsidae'}
	#message{position:fixed;bottom:20px;right:20px;z-index: 999999;}
	#messageArea{width:300px;height:300px;position:fixed;bottom:70px;right:20px;z-index: 999999;visibility:hidden;
				background:white;}
				
		/*쪽지div*/
		.messageDiv{width:400px;height:300px;position:fixed;bottom:70px;right:20px;z-index: 999999;visibility:hidden;
					background:white;}
		.messageArea th{border:2px solid #ddd;text-align:center;width:100px;}
		.messageArea td{text-align:center;font-size:0.8em;}
		.msgTr:hover{background:#ddd;color:black;cursor:pointer;}
		
		/*페이징 버튼*/
		.pagingArea{margin-right:auto;margin-left:auto;text-align:center;margin-top:15px;margin-bottom:20px;}
		.paginate2>button{background:white !important;}					

</style>

<jsp:include page="loginModal.jsp"/>
<jsp:include page="joinModal.jsp"/>
<jsp:include page="joinCompanyModal.jsp"/>
<jsp:include page="head.jsp"/>
<jsp:include page="chatModal.jsp"/>
<jsp:include page="inquiry.jsp"/>


    <header>
<!--==============================
            Stuck menu
=================================-->
  <section id="stuck_container">
    <div class="container">
    
    <div class="messageDiv">
	    <table class="messageArea">
				<tbody class="viewBody2">
				
				</tbody>
	    </table>
  	<div class="paginate"></div>
	</div>
	    <!--로그인 전-->
	    <c:if test="${empty sessionScope.loginUser}">
		    <div style="float:right;">
		    	<div class="menu1"><a data-toggle="modal" data-target="#inquiry-modal" class="inquiry">제휴·광고문의</a></div>&nbsp;&nbsp;&nbsp;
		     	<div class="menu1"><a data-toggle="modal" data-target="#login-modal" class="login">로그인</a></div>&nbsp;&nbsp;&nbsp;
		     	<div class="menu1"><a data-toggle="modal" data-target="#join-modal" class="join">회원가입</a></div>
		    </div>
	    </c:if>
	    
	    <!--로그인 후-->
	    <c:if test="${!empty sessionScope.loginUser}">
	    
		    <c:if test="${loginUser.company_right == 1  }">
			    <h4 align="right"><c:out value="${sessionScope.loginUser.company_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" id="message" class="btn btn-primary" onclick="messageBox(1);">쪽지함(0)</button>
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='changeInfoView.my'" class="btn btn-success">마이페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		    
		    <c:if test="${loginUser.company_right == 0  && loginUser.admin_right == 0}">
				<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" id="message" class="btn btn-primary" onclick="messageBox(1);">쪽지함(0)</button>
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='changeInfoView.my'" class="btn btn-success">마이페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		    
		    <c:if test="${loginUser.admin_right == 1}">
				<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" id="message" class="btn btn-primary" onclick="messageBox(1);">쪽지함(0)</button>
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
              
               <li><a href="tips.tp?writing_type=0"><img src="${pageContext.request.contextPath}/resources/images/main/다이어트꿀팁.png" alt="Logo alt"></a></li>
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
    
    <script>
    var onoff = 1;
    
    	function messageBox(currentPage){
    		
    		$('.messageArea').empty();
			$('.paginate2').empty();
			
    		if(onoff == 1){
    			
    			var member_no = ${loginUser.member_no};
				var $paginate = $(".paginate2");
				
				
    			 $.ajax({
 					url:"messageList.my",
 					type:"post",
 					data:{member_no:member_no, currentPage:currentPage},
 					success:function(data){
 						
 							var $messageArea = $(".messageArea");
 							$messageArea.append(
 									"<tr>" +
 										"<th>날짜</th>"+
 										"<th colspan='2'>제목</th>"+
 										"<th>수신인</th>"+
 										"<th>발신인</th>"+
 									"</tr>"
 								); 
 								
 						 	for(var key in data["msgList"]){
 								$messageArea.append(
 									"<tr class='msgTr'>" +
 										"<td>"+data["msgList"][key].message_date+ "</td>"+
 										"<td colspan='2'>"+data["msgList"][key].message_title+"</td>"+
 										"<td>"+data["msgList"][key].dispatch_nickname+"</td>"+
 										"<td>"+data["msgList"][key].receive_nickname+"</td>"+
 									"</tr>"
 								); 
 							}
 						//--게시판 조회 끝--
 						 
 						
 						//--페이징 버튼--
 					 	/* if(data["pi"].currentPage == 1){
 					 		$paginate2.append("<button name='"+name+"' disabled class='btn-first' value=1 onclick='messageBox(value)'><<</button>");
 					 		$paginate2.append("<button name='"+name+"' disabled class='btn-prev' value="+(data["pi"].currentPage-1)+" onclick='messageBox(value)'><</button>");
 					 	}else{
 					 		$paginate2.append("<button name='"+name+"' class='btn-first' value=1 onclick='messageBox(name,value)'><<</button>");
 					 		$paginate2.append("<button name='"+name+"' class='btn-prev' value="+(data["pi"].currentPage-1)+" onclick='messageBox(value)'><</button>");
 					 	}
 					 	
 					 	for(var i = 1 ; i <= data["pi"].endPage; i++){
 					 		if(i == data["pi"].currentPage ){
 					 			$paginate2.append("<button name='"+name+"' disabled class='btn-next' value="+i+" onclick='messageBox(value)'>"+i+"</button>")
 					 		}else{
 					 			$paginate2.append("<button name='"+name+"'  class='btn-next' value="+i+" onclick='messageBox(value)'>"+i+"</button>")
 					 		}
 					 	}
 					 	
 					 	if(data["pi"].currentPage < data["pi"].maxPage){
 					 		$paginate2.append("<button name='"+name+"' class='btn-next' value="+(data["pi"].currentPage+1)+" onclick='messageBox(value)'>></button>");
 					 		$paginate2.append("<button name='"+name+"' class='btn-next' value="+(data["pi"].endPage)+" onclick='messageBox(value)'>>></button>");
 					 	}else{
 					 		$paginate2.append("<button name='"+name+"' disabled class='btn-next' value="+(data["pi"].currentPage+1)+" onclick='messageBox(value)'>></button>");
 					 		$paginate2.append("<button name='"+name+"' disabled class='btn-next' value="+(data["pi"].endPage)+" onclick='messageBox(value)'>>></button>");
 					 	} */ 
 					}
 					,
 					error:function(){
 						console.log("에러 발생!");
 					}
 				});
    			$(".messageDiv").css("visibility","visible");
    			onoff = 0;
    		}else{
    			$(".messageDiv").css("visibility","hidden");
    			onoff = 1;
    		}
    	}
    
    </script>
    
  </section> 
  
</header>  

