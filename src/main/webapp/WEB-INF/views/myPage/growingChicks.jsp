<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
	
	/*버튼 구역*/
	#growingChicks{background:#B7E6A8;color:white;}
	
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
	.itemTable{width:800px; height:auto;text-align:center;}
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
			<c:if test="${point.accrue_point < 100 }">
					<img id="chicks" src="${pageContext.request.contextPath}/resources/images/myPageImages/egg.png">
				</c:if>
				<c:if test="${point.accrue_point >= 100 && point.accrue_point < 300 }">
					<img id="chicks" src="${pageContext.request.contextPath}/resources/images/myPageImages/chicks.png">
				</c:if>
				<c:if test="${point.accrue_point >= 300 && point.accrue_point < 600}">
					<img id="chicks" src="${pageContext.request.contextPath}/resources/images/myPageImages/chick.png">
				</c:if>
				<c:if test="${point.accrue_point >= 600 && point.accrue_point <= 1000}">
					<img id="chicks" src="${pageContext.request.contextPath}/resources/images/myPageImages/adultchick.png">
				</c:if>
			
			<div class="chicksDiv1">
				<c:if test="${point.accrue_point < 100 }">
					<label>알 등급</label>
				</c:if>
				<c:if test="${point.accrue_point >= 100 && point.accrue_point < 300 }">
					<label>병아리 등급</label>
				</c:if>
				<c:if test="${point.accrue_point >= 300 && point.accrue_point < 600}">
					<label>사춘기 닭 등급</label>
				</c:if>
				<c:if test="${point.accrue_point >= 600 && point.accrue_point <= 1000}">
					<label>성인 닭 등급</label>
				</c:if>
				<br>
				<c:if test="${point.accrue_point < 100 }">
					<label>경험치양 (${point.accrue_point} / 100)</label>
				</c:if>
				<c:if test="${point.accrue_point >= 100 && point.accrue_point < 300 }">
					<label>경험치양 (${point.accrue_point} / 300)</label>
				</c:if>
				<c:if test="${point.accrue_point >= 300 && point.accrue_point < 600}">
					<label>경험치양 (${point.accrue_point} / 600)</label>
				</c:if>
				<c:if test="${point.accrue_point >= 600 && point.accrue_point <= 1000}">
					<label>경험치양 (${point.accrue_point} / 1000)</label>
				</c:if>
				
				<c:if test="${point.accrue_point < 100 }">
					<div class="progress">
				 	<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:${point.accrue_point}%">
						${point.accrue_point} / 100
					</div>
				</div>
				</c:if>
				<c:if test="${point.accrue_point >= 100 && point.accrue_point < 300 }">
					<div class="progress">
				 	<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:${point.accrue_point / 3}%">
						${point.accrue_point} / 300
					</div>
				</div>
				</c:if>
				<c:if test="${point.accrue_point >= 300 && point.accrue_point < 600}">
					<div class="progress">
				 	<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:${point.accrue_point / 6}%">
						${point.accrue_point} / 600
					</div>
				</div>
				</c:if>
				<c:if test="${point.accrue_point >= 600 && point.accrue_point <= 1000}">
					<div class="progress">
				 	<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:${point.accrue_point / 10}%">
						${point.accrue_point} / 1000
					</div>
				</div>
				</c:if>
				
				
			</div>
		</div>
		
		
		
		
		<div class="itemsArea">
			<h2 id="itemTitle">[등급상점]</h2>
			<br>
			
			<div>
				
				<table class="itemTable">
				
					<c:forEach items="${product }" var="p">
					<c:if test="${p.point_step == 2}">
					<tr><td><h5>병아리 등급 상품</h5></td></tr>
					<tr class="lv lv-1">
						<td>
							<img class="itemImg lv1Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/productegg.jpg">
							<p>${p.product_name }</p>
						</td>
					</tr>
					<c:if test="${point.accrue_point >= 300 }">
						<tr><td>
							<button type="button" class="btn btn-info" onclick = "location.href='exchangePage.ex?change_type='+${p.product_no}">교환하기</button>
						</td></tr>
					</c:if>
					</c:if>
					<tr><td>&nbsp;</td></tr>
					
					<c:if test="${p.point_step == 3}">
					<tr><td><h5>청소년 닭 등급 상품</h5></td></tr>
					<tr>
						<td class="lv lv-2">
							<img class="itemImg lv3Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/productsweet.jpg">
							<p>${p.product_name }</p>
						</td>
						
					</tr>
					
					<c:if test="${point.accrue_point >= 600 }">
						<tr><td>
							<button type="button" class="btn btn-info" onclick = "location.href='exchangePage.ex?change_type='+${p.product_no}">교환하기</button>
						</td></tr>
					</c:if>
					</c:if>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					
					<c:if test="${p.point_step == 4}">
					<tr><td><h5>어른 닭 등급 상품</h5></td></tr>
					<tr>
						<td class="lv lv-3">
							<img class="itemImg lv2Img" src="${pageContext.request.contextPath}/resources/images/myPageImages/productchick.jpg">
							<p>${p.product_name }</p>
						</td>
					</tr>
					
					<c:if test="${point.accrue_point == 1000 }">
						<tr><td>
							<button type="button" class="btn btn-info" onclick = "location.href='exchangePage.ex?change_type='+${p.product_no}">교환하기</button>
						</td></tr>
					</c:if>
					</c:if>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					</c:forEach>
				</table>
			</div>
			
		</div>
		<jsp:include page="../common/footer.jsp"/>

</body>
</html>