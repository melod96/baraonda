<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
		.left {width:732px;height:180px; margin-right:auto; margin-left:220px; margin-bottom:-50px; margin-top:40px;}
	
		.imgCover{width:170px; height:170px;border:2px solid #89B6C4; border-radius:6px;margin-top:35px;}
		.imgArea{width:150px;height:150px; margin-right:auto; margin-left:auto; margin-top:10px;}
		#photo{border:2px solid #205FD4; margin-top:15px; border-radius:50%;}
		.otInfo2 td{border:1px solid #89B6C4; border-radius:5px; width:100px; height:55px;}
		.otInfo2{width:610px;}
		.imgCover, .otInfo1{display:inline-block;}
		.InOform{margin-right:auto; margin-left:auto; width:800px; margin-top:100px;}
		.td1{background:#D4F2FC;}
		#introduction1{ border-radius:3px;overflow-y:scroll;overflow-x:hidden; height:130px;}
		
		
		/*두 번째 div*/
		.secondDiv{margin-right:auto;margin-left:auto;margin-top:20px;width:800px;margin-bottom:100px;height:auto;}
		.pickTable{margin-right:auto;margin-left:auto;}
		.pickBtn{width:150px;height:30px;margin:5px;margin-top:12px;}
		
		/*세 번째 div*/
		.thirdDiv{margin-right:auto;margin-left:auto;width:800px;margin-bottom:100px;height:450px;margin-top:-80px;
					border-radius:5px;border:3px solid #ddd;}
		.viewTable{margin-right:auto;margin-left:auto;width:97%;margin-top:30px;margin-bottom:10px;}
		.viewTable th{border:2px solid #ddd;text-align:center;width:100px;}
		.viewTable td{text-align:center;font-size:0.8em;}
		.hTr:hover{background:#ddd;color:black;cursor:pointer;}
		
		/*페이징 버튼*/
		.pagingArea{margin-right:auto;margin-left:auto;text-align:center;margin-top:15px;margin-bottom:20px;}
		.paginate>button{background:white !important;}	
		
		/*rightBoard 위치*/
		.rbPosition{margin-right:-90px;}
		
		/*box위치*/
		.box1{width:1200px;margin-left:27px;}
		
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:include page="../common/header.jsp"/>
		<div class="left">
			<img src="${pageContext.request.contextPath}/resources/images/berrywater.PNG" style="width:732px; height:180px;">
		</div>
		
		<div class="box1">
			<div class="rbPosition">
				<jsp:include page="../common/rightBoard.jsp" />
			</div>
			<div class="InOform">
			<h4>회원정보 보기</h4>
			<hr style="border:0.05em solid #307ABA;width:784px;">
				<div class="imgCover">
					<div class="imgArea">
						<img id="photo" src="${pageContext.request.contextPath}${file.files_root}"
						onerror="this.src='${pageContext.request.contextPath}/resources/images/myPageImages/level.png'">
					</div>
				</div>
				
				<div class="otInfo1">
					<table class="otInfo2">
						<tr>
							<td class="td1">등급</td>
							<td colspan='3'>병아리 다이어터</td>
						</tr>
						
						<tr>
							<td class="td1">닉네임</td>
							<td colspan='4'>${viewUser.nick_name}</td>
						</tr>
						
						<tr>
							<td class="td1">자기소개</td>
							<td  colspan='5'><div id="introduction1">${viewUser.self_introduction}</div></td>
						</tr>
						
					</table>
					
					
				</div>
			</div>
			
			<div class="secondDiv">
				<table class="pickTable">
					<tr>
						<td><button name="WriteBoard" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">작성한 게시물</button></td>
						<td><button name="WriteComments" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">작성한 댓글</button></td>
					</tr>
					
				</table>
			</div>
			<!--1  6  1  1-->
			<div class="thirdDiv">
				<table class="viewTable">
					<tbody class="viewBody">
					
					</tbody>
					<!--페이징 버튼 구역-->
				</table>
				<div class="paginate"></div>
			</div>
		</div>
		
		<!--활동 내역 출력 ajax-->
		<script>
			function ViewList(name,currentPage){
				
				$('.viewBody').empty();
				$('.paginate').empty();
				
				var member_no = ${viewUser.member_no};
				var $paginate = $(".paginate");
				
				 $.ajax({
					url:"footList.my",
					type:"post",
					data:{member_no:member_no, name:name, currentPage:currentPage},
					success:function(data){
						
						switch(name){
						//--게시판 조회--
						case 'WriteBoard' :
							var $viewBody = $(".viewBody");
							$viewBody.append(
									"<tr>" +
										"<th>게시판</th>"+
										"<th colspan='2'>제목</th>"+
										"<th>추천수</th>"+
										"<th>조회수</th>"+
										"<th>작성일</th>"+
									"</tr>"
								); 
								
						 	for(var key in data["list"]){
								var $tr = $("<tr class='msgTr'>");
								var likeCount = 0;
								
								for(var mKey in data["mList"]){
									if(data["list"][key].board_no == data["mList"][mKey].board_no){
										likeCount = data["mList"][mKey].marking_count;
									}
								}							
								
								var board_type = "";
								
								switch(data["list"][key].board_type){
								case 1 : board_type = "다이어트 꿀팁";
								break;
								case 2 : board_type = "칼로리 사전";
								break;
								case 3 : board_type = "홈 트레이닝";
								break;
								case 4 : board_type = "커뮤니티";
								break;
								case 5 : board_type = "바다 체험단";
								break;
								case 6 : board_type = "공지사항";
								break;
								case 7 : board_type = "고객센터";
								break;
								case 8 : board_type = "바다 서비스";
								break;
								default : board_type = "게시판";
								}
								
								$viewBody.append(
									"<tr class='hTr'>" +
										"<td>"+board_type + "</td>"+
										"<td colspan='2'>"+data["list"][key].board_title+"</td>"+
										"<td>"+likeCount+"</td>"+
										"<td>"+data["list"][key].board_count+"</td>"+
										"<td>"+data["date"][key]+"</td>"+
									"</tr>"
								); 
							}
						 	break;
						 //--게시판 조회 끝--
						 
						 
						 //--댓글 조회--	
						case 'WriteComments' :
							var $viewBody = $(".viewBody");
							$viewBody.append(
									"<tr>" +
										"<th>게시판</th>"+
										"<th>게시글 제목</th>"+
										"<th colspan='2'>댓글 내용</th>"+
										"<th>작성일</th>"+
									"</tr>"
								); 
								
						 	for(var key in data["cList"]){
								var $tr = $("<tr class='hTr'>");
								
								var board_type = "";
								
								switch(data["cList"][key].board_type){
								case 1 : board_type = "다이어트 꿀팁";
								break;
								case 2 : board_type = "칼로리 사전";
								break;
								case 3 : board_type = "홈 트레이닝";
								break;
								case 4 : board_type = "커뮤니티";
								break;
								case 5 : board_type = "바다 체험단";
								break;
								case 6 : board_type = "공지사항";
								break;
								case 7 : board_type = "고객센터";
								break;
								case 8 : board_type = "바다 서비스";
								break;
								default : board_type = "게시판";
								}						
								
								$viewBody.append(
									"<tr class='hTr'>" +
										"<td>"+board_type + "</td>"+
										"<td>"+data["cList"][key].board_title+"</td>"+
										"<td colspan='2'>"+data["cList"][key].comments_content+"</td>"+
										"<td>"+data["cDate"][key]+"</td>"+
									"</tr>"
								); 
							}
						 	break;
						//--댓글조회 끝--
						
						//--북마크 조회--
						case 'BookMark' :
							var $viewBody = $(".viewBody");
							$viewBody.append(
									"<tr>" +
										"<th>게시판</th>"+
										"<th>게시글 제목</th>"+
										"<th>북마크 날짜</th>"+
									"</tr>"
								); 
								
						 	for(var key in data["bList"]){
								var $tr = $("<tr class='hTr'>");
								
								var board_type = "";
								
								switch(data["bList"][key].board_type){
								case 1 : board_type = "다이어트 꿀팁";
								break;
								case 2 : board_type = "칼로리 사전";
								break;
								case 3 : board_type = "홈 트레이닝";
								break;
								case 4 : board_type = "커뮤니티";
								break;
								case 5 : board_type = "바다 체험단";
								break;
								case 6 : board_type = "공지사항";
								break;
								case 7 : board_type = "고객센터";
								break;
								case 8 : board_type = "바다 서비스";
								break;
								default : board_type = "게시판";
								}						
								
								$viewBody.append(
									"<tr class='hTr'>" +
										"<td>"+board_type + "</td>"+
										"<td>"+data["bList"][key].board_title+"</td>"+
										"<td>"+data["bDate"][key]+"</td>"+
									"</tr>"
								); 
							}
						 	break;
						//--북마크 조회 끝--
						
						//--경험치 조회--
						case 'Point' :
							var $viewBody = $(".viewBody");
							$viewBody.append(
									"<tr'>" +
										"<th>경험치 획들 날짜</th>"+
										"<th>종류</th>"+
										"<th>얻은 양</th>"+
										"<th>총 합</th>"+
									"</tr>"
								); 
								
						 	for(var key in data["pList"]){
								var $tr = $("<tr class='hTr'>");
								
								var point_type = "";
								
								switch(data["pList"][key].point_type){
								
								case 1 : point_type = "게시글 작성";
								break;
								
								case 2 : point_type = "댓글 작성";
								break;
								
								case 3 : point_type = "출석";
								break;
								
								case 4 : point_type = "좋아요";
								break;
								
								default : board_type = "보너스";
								}
								
								var GetPoint = "";
								GetPoint = data["pList"][key].after_point - data["pList"][key].before_point;
								
								$viewBody.append(
									"<tr class='hTr'>" +
										"<td>"+data["pDate"][key]+ "</td>"+
										"<td>"+point_type+"</td>"+
										"<td>"+ GetPoint +"</td>"+
										"<td>"+data["pList"][key].after_point+"</td>"+
									"</tr>"
								); 
							}
						 	break;
						//--경험치 조회 끝--
						
						//--교환한 상품 조회--
						case 'ChangeGoods' :
							var $viewBody = $(".viewBody");
							$viewBody.append(
									"<tr>" +
										"<th>상품 신청 날짜</th>"+
										"<th>상품 명</th>"+
										"<th>수취인</th>"+
										"<th>수취인 번호</th>"+
										"<th>수취인주소</th>"+
									"</tr>"
								); 
								
						 	for(var key in data["gList"]){
								
								$viewBody.append(
									"<tr class='hTr'>" +
										"<td>"+data["gDate"][key]+ "</td>"+
										"<td>"+data["gList"][key].product_name+"</td>"+
										"<td>"+data["gList"][key].addressee_name+"</td>"+
										"<td>"+data["gList"][key].address+"</td>"+
										"<td>"+data["gList"][key].addressee_phone+"</td>"+
									"</tr>"
								); 
							}
						 	break;
						//--교환한 상품 조회 끝--
						}
						
						
						//--페이징 버튼--
					 	if(data["pi"].currentPage == 1){
					 		$paginate.append("<button name='"+name+"' disabled class='btn-first' value=1 onclick='ViewList(name,value)'><<</button>");
					 		$paginate.append("<button name='"+name+"' disabled class='btn-prev' value="+(data["pi"].currentPage-1)+" onclick='ViewList(name,value)'><</button>");
					 	}else{
					 		$paginate.append("<button name='"+name+"' class='btn-first' value=1 onclick='ViewList(name,value)'><<</button>");
					 		$paginate.append("<button name='"+name+"' class='btn-prev' value="+(data["pi"].currentPage-1)+" onclick='ViewList(name,value)'><</button>");
					 	}
					 	
					 	for(var i = 1 ; i <= data["pi"].endPage; i++){
					 		if(i == data["pi"].currentPage ){
					 			$paginate.append("<button name='"+name+"' disabled class='btn-next' value="+i+" onclick='ViewList(name,value)'>"+i+"</button>")
					 		}else{
					 			$paginate.append("<button name='"+name+"'  class='btn-next' value="+i+" onclick='ViewList(name,value)'>"+i+"</button>")
					 		}
					 	}
					 	
					 	if(data["pi"].currentPage < data["pi"].maxPage){
					 		$paginate.append("<button name='"+name+"' class='btn-next' value="+(data["pi"].currentPage+1)+" onclick='ViewList(name,value)'>></button>");
					 		$paginate.append("<button name='"+name+"' class='btn-next' value="+(data["pi"].endPage)+" onclick='ViewList(name,value)'>>></button>");
					 	}else{
					 		$paginate.append("<button name='"+name+"' disabled class='btn-next' value="+(data["pi"].currentPage+1)+" onclick='ViewList(name,value)'>></button>");
					 		$paginate.append("<button name='"+name+"' disabled class='btn-next' value="+(data["pi"].endPage)+" onclick='ViewList(name,value)'>>></button>");
					 	} 
			 		 
					},
					error:function(){
						console.log("에러 발생!");
					}
				});
				
				
				
				return false; 
			}
		</script>
		
		
		<jsp:include page="../common/footer.jsp"/>
	
	
	
</body>
</html>