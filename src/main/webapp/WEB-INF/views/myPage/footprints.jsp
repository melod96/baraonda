<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
	<style type="text/css">
	/*첫 번째 div*/
		.firstDiv{margin-right:auto;margin-left:auto;margin-top:20px;margin-bottom:50px;width:800px;height:350px;border-radius:5px;border:3px solid #ddd;}
		
		
		.fTable{width:760px;height:300px;margin-right:auto;margin-left:auto;margin-top:22px;}
		.fTable td{width:33%; height:50%;}
		.lineTr1{border-bottom:3px solid #ddd;}	
		.lineTd2{border-right:3px solid #ddd;border-left:3px solid #ddd;}
		.footIcon1{width:50px;height:50px;margin-left:35%;margin-top:20px;}
		.footIcon2{width:50px;height:50px;margin-left:35%;margin-top:40px;}
		.mov1{margin-left:40%;}
		.fpD{width:230px;height:30px;margin-top:10px;text-align:center;}
		.mov2{margin-left:17px;text-align:center;}
		
	/*두 번째 div*/
		.secondDiv{margin-right:auto;margin-left:auto;margin-top:20px;width:800px;margin-bottom:100px;height:auto;}
		.pickTable{margin-right:auto;margin-left:auto;}
		.pickBtn{width:200px;height:30px;margin:5px;margin-top:12px;}
		
	/*세 번째 div*/
		.thirdDiv{margin-right:auto;margin-left:auto;width:800px;margin-bottom:100px;height:350px;margin-top:-80px;
					border-radius:5px;border:3px solid #ddd;}
		.viewTable{margin-right:auto;margin-left:auto;width:97%;margin-top:30px;margin-bottom:10px;}
		.viewTable th{border:2px solid #ddd;text-align:center;width:100px;}
		.viewTable td{text-align:center;font-size:0.8em;}
		.hTr:hover{background:orangered;color:white;cursor:pointer;}
		
		/*페이징 버튼*/
		.pagingArea{margin-right:auto;margin-left:auto;text-align:center;margin-top:15px;margin-bottom:20px;}
		.paginate>button{background:white !important;}		
	</style>

	
<meta charset="UTF-8">
<title>myfootprints</title>
</head>
<body>

		<jsp:include page="../common/header.jsp"/>
		<jsp:include page="../common/myHeader.jsp"/>


		<div>
			<div class="firstDiv">
				<table class="fTable">
					<tr class="lineTr1">
						<td>
							<img class="footIcon1" src="${pageContext.request.contextPath}/resources/images/myPageImages/fp1.png">
							<div class="fpD">출석 : <label><c:out value="${footprints.check_count}"/>회</label> </div>
						</td>					
						
						<td class="lineTd2">
							<img class="footIcon1 mov1" src="${pageContext.request.contextPath}/resources/images/myPageImages/fp2.png">
							<div class="fpD mov2">게시글 작성 : <label><c:out value="${footprints.board_count}"/>회</label> </div>
						</td>
						
						<td>
							<img class="footIcon1 mov1" src="${pageContext.request.contextPath}/resources/images/myPageImages/fp3.png">
							<div class="fpD mov2">댓글 작성 : <label><c:out value="${footprints.comments_count}"/>회</label> </div>
						</td>
					</tr>
					
					<tr>
						<td>
							<img class="footIcon2" src="${pageContext.request.contextPath}/resources/images/myPageImages/fp4.png">
							<div class="fpD">받은 추천 : <label><c:out value="${footprints.marking_count}"/>회</label> </div>
						</td>					
						
						<td class="lineTd2">
							<img class="footIcon2 mov1" src="${pageContext.request.contextPath}/resources/images/myPageImages/fp5.png">
							<div class="fpD mov2">모은 경험치 : <label><c:out value="${footprints.accrue_point}"/></label> </div>
						</td>
						
						<td>
							<img class="footIcon2 mov1" src="${pageContext.request.contextPath}/resources/images/myPageImages/fp6.png">
							<div class="fpD mov2">가입일 : <label><c:out value="${footprints.enroll_date}"/></label> </div>
						</td>
					</tr>
				</table>
			</div>
		
		
		
			<div class="secondDiv">
				<table class="pickTable">
					<tr>
						<td><button name="WriteBoard" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">작성한 게시물</button></td>
						<td><button name="WriteComments" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">작성한 댓글</button></td>
						<td><button name="GoodPoint" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">받은 추천</button></td>
						<td><button name="LikeThis" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">북마크</button></td>
						<td><button name="Point" type="button" class="btn btn-default pickBtn" value=1 onclick="ViewList(name,value)">경험치</button></td>
					</tr>
					
					<tr>
						<td><button name="ChangeGoods" type="button" class="btn btn-default pickBtn" onclick="ViewList(name)">교환한 상품</button></td>
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
			
			var member_no = ${loginUser.member_no};
			var $paginate = $(".paginate");
			
			$.ajax({
				url:"footList.my",
				type:"post",
				data:{member_no:member_no, name:name, currentPage:currentPage},
				success:function(data){
					
					//--게시판 조회--
					if(name="WriteBoard"){
						var $viewBody = $(".viewBody");
						$viewBody.append(
								"<tr class='hTr'>" +
									"<th>게시판</th>"+
									"<th colspan='2'>제목</th>"+
									"<th>추천수</th>"+
									"<th>조회수</th>"+
									"<th>작성일</th>"+
								"</tr>"
							); 
							
					 	for(var key in data["list"]){
							var $tr = $("<tr class='hTr'>");
							
							
							
							$viewBody.append(
								"<tr class='hTr'>" +
									"<td>"+data["list"][key].board_type + "</td>"+
									"<td colspan='2'>"+data["list"][key].board_title+"</td>"+
									"<td>"+55+"</td>"+
									"<td>"+data["list"][key].board_count+"</td>"+
									"<td>"+data["date"][key]+"</td>"+
								"</tr>"
							); 
						};
					};
					//--게시판조회 끝--
					
					//--댓글 조회--
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
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
	






















</body>
</html>