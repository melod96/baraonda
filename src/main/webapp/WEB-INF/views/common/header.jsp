<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<style>

	.menu1{display:inline-block;}
	.menu1:hover{color:white;cursor:pointer;}
	*{font-family:'Chungchunsidae'}
				
		/*쪽지div*/
		.msgDiv1{height:222px;}
		#message{position:fixed;bottom:20px;right:20px;z-index: 999999;}
		.messageDiv{width:400px;height:327px;position:fixed;bottom:70px;right:20px;z-index: 999999;visibility:hidden;
					background:white;border:7px solid #FFE8B5; border-radius:10px;}
		.messageArea th{border:2px solid #FFE8B5;text-align:center;width:100px;height:22px;}
		.messageArea td{text-align:center;font-size:0.7em;height:21px;}
		.messageArea{height:auto;}
		.msgTr:hover{background:#ddd;color:black;cursor:pointer;}
		
		.msgTr2{border:2px solid #FFE8B5;text-align:center;width:100px;}
		.msgTr2 td{border:2px solid #FFE8B5;text-align:center;width:500px;}
		.msgTr3 td{border:2px solid #FFE8B5;text-align:center;width:500px;height:252px;}
		.msgTr3 textarea[name="msgContent"]{width:170px;height:230px;}
		#sendMessageBtn1{position:relative; right:90px; top:24px;}
		#sendMessageBtn2{position:relative; right:90px; bottom:-63px;}
		
		/*페이징 버튼*/
		.paginate2{margin-right:auto;margin-left:auto;text-align:center;margin-top:15px;margin-bottom:20px;}
		.paginate2>button{background:white !important;}
		
		
		/*글자 수 넘치면 ...으로 변환*/			
		.msgTd2{text-overflow: ellipsis; overflow: hidden; white-space: nowrap}
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
	    	<div class="msgDiv1">
			    <table class="messageArea">
						<tbody class="viewBody2"></tbody>
			    </table>
			</div>
		  	<div class="paginate2"></div>
		  	
		  	<div class="btns">
		  	</div>
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
					<button type = "button" id="message" class="btn btn-primary">쪽지함</button>
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='changeInfoView.my'" class="btn btn-success">마이페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		    
		    <c:if test="${loginUser.company_right == 0  && loginUser.admin_right == 0}">
				<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" id="message" class="btn btn-primary">쪽지함</button>
					<button type = "button" class="btn btn-primary" data-toggle="modal" data-target="#chat-modal">채팅하기</button>
			     	<button onclick="location.href='changeInfoView.my'" class="btn btn-success">마이페이지</button>
			     	<button onclick="location.href='logout.me'" class="btn btn-default">로그아웃</button>
			    </div>
		    </c:if>
		    
		    <c:if test="${loginUser.admin_right == 1}">
				<h4 align="right"><c:out value="${sessionScope.loginUser.nick_name }님 환영합니다."/></h4>
				<div style="float:right;">
					<button type = "button" id="message" class="btn btn-primary">쪽지함</button>
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
    
    $('#message').click(function(){
		 if(onoff == 1){
			 messageBox(1);
			 $(".messageDiv").css("visibility","visible");
			 onoff = 0;
		 }else{
			 $(".messageDiv").css("visibility","hidden");
			 onoff = 1;
		 }
	 });
   
    	function messageBox(currentPage){
    		
    		$('.messageArea').empty();
			$('.paginate2').empty();
			$('.btns').empty();
			
    			var member_no = ${loginUser.member_no};
				var $paginate2 = $(".paginate2");
				
				
    			 $.ajax({
 					url:"messageList.my",
 					type:"post",
 					data:{member_no:member_no, currentPage:currentPage},
 					success:function(data){
 						
 							var $messageArea = $(".messageArea");
 							$messageArea.append(
 									"<tr>" +
 										"<th>날짜</th>"+
 										"<th colspan='2' class='msgTd2'>제목</th>"+
 										"<th>발신인</th>"+
 										"<th>수신인</th>"+
 									"</tr>"
 								); 
 								
 						 	for(var key in data["msgList"]){
 								$messageArea.append(
 									"<tr class='msgTr' onclick='readMsg("+ data["msgList"][key].message_no+")'>" +
 										"<td>"+data["msgDate"][key]+ "</td>"+
 										"<td colspan='2' class='msgTd2'>"+data["msgList"][key].message_title+"</td>"+
 										"<td>"+data["msgList"][key].dispatch_nickname+"</td>"+
 										"<td>"+data["msgList"][key].receive_nickname+"</td>"+
 									"</tr>"
 								); 
 							}
 						 	
 						 	$('.btns').append("<button type = 'button' id='sendMessageBtn1' class='btn btn-primary' onclick='sendMessageForm();'>쪽지작성하기</button>");
 						 	
 						//--게시판 조회 끝--
 						 
 						
 						//--페이징 버튼--
 					 	if(data["msgPi"].currentPage == 1){
 					 		$paginate2.append("<button disabled class='btn-first' value=1 onclick='messageBox(value)'><< </button>");
 					 		$paginate2.append("<button disabled class='btn-prev' value="+(data["msgPi"].currentPage-1)+" onclick='messageBox(value)'><</button>");
 					 	}else{
 					 		$paginate2.append("<button class='btn-first' value=1 onclick='messageBox(name,value)'><< </button>");
 					 		$paginate2.append("<button class='btn-prev' value="+(data["msgPi"].currentPage-1)+" onclick='messageBox(value)'><</button>");
 					 	}
 					 	
 					 	for(var i = 1 ; i <= data["msgPi"].endPage; i++){
 					 		if(i == data["msgPi"].currentPage ){
 					 			$paginate2.append("<button disabled class='btn-next' value="+i+" onclick='messageBox(value)'>"+i+"</button>")
 					 		}else{
 					 			$paginate2.append("<button class='btn-next' value="+i+" onclick='messageBox(value)'>"+i+"</button>")
 					 		}
 					 	}
 					 	
 					 	if(data["msgPi"].currentPage < data["msgPi"].maxPage){
 					 		$paginate2.append("<button class='btn-next' value="+(data["msgPi"].currentPage+1)+" onclick='messageBox(value)'>></button>");
 					 		$paginate2.append("<button class='btn-next' value="+(data["msgPi"].endPage)+" onclick='messageBox(value)'> >></button>");
 					 	}else{
 					 		$paginate2.append("<button disabled class='btn-next' value="+(data["msgPi"].currentPage+1)+" onclick='messageBox(value)'>></button>");
 					 		$paginate2.append("<button disabled class='btn-next' value="+(data["msgPi"].endPage)+" onclick='messageBox(value)'> >></button>");
 					 	}
 					}
 					,
 					error:function(){
 						console.log("에러 발생!");
 					}
 				});
    	}
    
    	
    	
    	function sendMessageForm(){
    		$('.messageArea').empty();
			$('.paginate2').empty();
			$('.btns').empty();
			
			$(".messageArea").append(
							"<tr class='msgTr2'>" +
								"<td>받는 사람</td>"+
								"<td><input type='text' id='reNick' name='reNick'></td>"+
							"</tr>"+
							
							"<tr class='msgTr2'>" +
								"<td>제목</td>"+
								"<td><input type='text' id='msgTitle' name='msgTitle'></td>"+
							"</tr>"+
							
							"<tr class='msgTr3'>" +
								"<td>내용</td>"+
								"<td><textarea id='msgContent' name='msgContent'></textarea></td>"+
							"</tr>"
							
					); 
    		$('.btns').append("<button type = 'button' id='sendMessageBtn2' class='btn btn-primary' onclick='sendMessage();'>전송</button>");
    	}
    	
    	function sendMessage(){
    		onoff = 1;
    		if($('#reNick').val() == ""){
    			alert("받는 사람의 닉네임을 입력해주세요.");
    		}else{
    			
    			var dispatch_member_no = ${loginUser.member_no};
    			var receive_nickname = $("#reNick").val();
    			var message_title = $("#msgTitle").val();
    			var message_content = $("#msgContent").val();
    			
    			console.log(message_content);
    			
    			 $.ajax({
  					url:"sendMsg.my",
  					type:"post",
  					data:{dispatch_member_no:dispatch_member_no, receive_nickname:receive_nickname,
  						message_title:message_title, message_content:message_content},
  					success:function(data){
  						
  						messageBox(1);
  						
  					}
  					,
  					error:function(){
  						alert("닉네임을 확인해주세요.");
  						console.log("에러 발생!");
  					}
  				});
    		}
    	}
    	
    	function readMsg(message_no){
    		$('.messageArea').empty();
			$('.paginate2').empty();
			$('.btns').empty();
			
			 $.ajax({
					url:"msgDetail.my",
					type:"post",
					data:{message_no:message_no},
					success:function(data){
						
						$(".messageArea").append(
								"<tr class='msgTr2'>" +
									"<td>보낸 사람</td>"+
									"<td>" + data["msgDetail"].dispatch_nickname + "</td>"+
								"</tr>"+
								
								"<tr class='msgTr2'>" +
									"<td>받은 사람</td>"+
									"<td>"+
										data["msgDetail"].receive_nickname +
									"</td>"+
								"</tr>"+
								
								"<tr class='msgTr2'>" +
									"<td>제목</td>"+
									"<td>"+ 
										data["msgDetail"].message_title + 
									"</td>"+
								"</tr>"+
								
								"<tr class='msgTr3'>" +
									"<td>내용</td>"+
									"<td><textarea id='msgContent' name='msgContent'readonly>"+ 
										data["msgDetail"].message_content + 
									"</textarea></td>"+
								"</tr>"
								
						); 
	    		$('.btns').append("<button type = 'button' id='sendMessageBtn2' class='btn btn-primary' onclick='messageBox(1);'>목록으로</button>");
						
					}
					,
					error:function(){
						console.log("에러 발생!");
					}
				});
			
    	}
    	
    </script>
    
  </section> 
  
</header>  

