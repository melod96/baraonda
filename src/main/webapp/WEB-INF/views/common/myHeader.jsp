<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <style>
    	.myHeader{width:800px;margin-right:auto;margin-left:auto;;margin-top:100px;}
    	.listBtn{margin-left:20px;}
    	.btn-default{width:125px; border:1px solid darkgray !important;; border-radius:3px !important;}
    </style>
    <div class="myHeader">
		<h3>마이페이지</h3>
			<div class="listBtn">
				<button type="button" id="changeInfo" class="btn btn-default" onclick="location.href='changeInfoView.my'">내 정보 변경</button>
				<button type="button" id="footprints" class="btn btn-default" onclick="location.href='footprintsView.my'">내 활동 정보</button>
				<button type="button" id="growingChicks" class="btn btn-default" onclick="location.href='growingChicksView.my'">병아리 키우기</button>
			<c:if test="${loginUser.company_right eq 1}">
				<button type="button" id="company" class="btn btn-default" onclick="location.href='companyView.my'">기업</button>
			</c:if>
			</div>
	</div>
	
	
	

