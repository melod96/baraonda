<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<style>
	
	/*병아리 구역*/
	.chicksArea{width:800px; height:auto; margin-left:auto;margin-right:auto; border:3px solid #A8FFE5; background:#FAFCE1;
				border-radius:10px;margin-top:30px;margin-bottom:50px;}
	.chicksDiv1{display:inline-block;margin-top:50px;margin-bottom:50px;margin-left:50px;}
	
	#chicks{width:100px; height:100px;margin-top:50px;margin-left:50px;}
	.progress{margin-top:10px;margin-left:5px;width:300px;}
		 
	/*상품 구역*/
	.itemsArea{width:800px; height:auto; margin-left:auto;margin-right:auto; border:3px solid #ddd; background:#FAFCE1;
				border-radius:10px;margin-top:10px;margin-bottom:150px;}
	#itemTitle{text-align:center;}
	.itemImg{width:150px;height:150px;}
	.itemImg:hover{border:3px solid skyblue; cursor:pointer;}
	.itemTable{width:800px; height:auto;margin-left:50px;}
	.lv td{width:150px; height:200px; margin:10px;}
	.itemTable td>h6{width:170px;text-align:center;}
	.lvLabel{width:100px;height:20px;}
	
	
	
	
	</style>
	
	
	
	
	
<meta charset="UTF-8">
<title>Growing chicks</title>
</head>
<body>
		<jsp:include page="../common/header.jsp"/>
		<jsp:include page="../common/myHeader.jsp"/>
		
		<div class="chicksArea">
			<img id="chicks" src="${pageContext.request.contextPath}/resources/images/myPageImages/chicks.png">
			<div class="chicksDiv1">
				<label>병아리 등급</label>
				<br>
				<label>경험치양 (900/1000)</label>
				
				<div class="progress">
				 	<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:90%">
						<span class="sr-only">70% Complete</span>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		<div class="itemsArea">
			<h2 id="itemTitle">[등급상점]</h2>
			<br>
			
			<div>
				
				<table class="itemTable">
				
					<tr><td><h5>1단계 상품</h5></td></tr>
					<tr class="lv lv-1">
						<td>
							<img class="itemImg lv1Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/lv1_1.png">
							<h6>당신이 키운 병아리</h6>
						</td>
						
						
						<td>
							<img class="itemImg lv1Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/lv1_2.png">
							<h6>먼지</h6>
						</td>
						
						<td>
							<img class="itemImg lv1Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/lv1_3.png">
							<h6>자라</h6>
						</td>
					</tr>
					
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					
					<tr><td><h5>2단계 상품</h5></td></tr>
					<tr>
						<td class="lv lv-2">
							<img class="itemImg lv2Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/nothing.png">
							<h6>준비중</h6>
						</td>
						
						<td>
							<img class="itemImg lv2Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/nothing.png">
							<h6>준비중</h6>
						</td>
						
						<td>
							<img class="itemImg lv2Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/nothing.png">
							<h6>준비중</h6>
						</td>
						
					</tr>
					
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td><h5>3단계 상품</h5></td></tr>
					<tr>
						<td class="lv lv-3">
							<img class="itemImg lv3Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/nothing.png">
							<h6>준비중</h6>
						</td>
						
						<td>
							<img class="itemImg lv3Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/nothing.png">
							<h6>준비중</h6>
						</td>
						
						<td>
							<img class="itemImg lv3Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/nothing.png">
							<h6>준비중</h6>
						</td>
					</tr>
					
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</div>
			
		</div>

</body>
</html>