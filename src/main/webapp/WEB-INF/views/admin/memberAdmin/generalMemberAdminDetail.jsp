<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commonAdmin/head.jsp" />
<style>
    .custom-search-form{
        width: 30%;
    }
    .custom-select-form{
        width: 10%;
    }
    .paginate{
        margin-top: 10px;
        text-align: center;
    }
    .tab-content{
    	margin-top: 10px;
    }
</style>
</head>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
         	
         	<jsp:include page="../commonAdmin/header.jsp"/>

			<jsp:include page="../commonAdmin/nav.jsp" />
            
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">일반 회원</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	일반 회원 상세
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="col-lg-6">
								<table width="100%" class="table table-striped">
	                                <tbody>
	                                	<tr>
	                                		<th width="15%"><h5>NO</h5></th>
	                                		<td><h5>${ memberInfo.MEMBER_NO }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>아이디</h5></th>
	                                		<td><h5>${ memberInfo.ID }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>이름</h5></th>
	                                		<td><h5>${ memberInfo.NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>닉네임</h5></th>
	                                		<td><h5>${ memberInfo.NICK_NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>연락처</h5></th>
	                                		<td><h5>${ memberInfo.PHONE }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>이메일</h5></th>
	                                		<td><h5>${ memberInfo.EMAIL }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>가입일자</h5></th>
	                                		<td><h5>${ fn:substring(memberInfo.ENROLL_DATE, 0, 10) }</h5></td>
	                                	</tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        <div class="col-lg-6">
	                        	<ul class="nav nav-pills">
	                                <li class="active"><a href="#order" data-toggle="tab">주문</a>
	                                </li>
	                                <li><a href="#declaration" data-toggle="tab">신고</a>
	                                </li>
	                            </ul>
	                        	
	                        	
	                        	<div class="tab-content">
	                                <div class="tab-pane fade in active" id="order">
	                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
			                                <thead>
			                                    <tr>
			                                        <th width="25%">NO</th>
			                                        <th width="25%">상품</th>
			                                        <th width="25%">수량</th>
			                                        <th width="25%">주문날짜</th>
			                                    </tr>
			                                </thead>
			                                <tbody>
				                            	<c:if test="${ membersOrderList != null }">
				                                	<c:forEach var="list" items="${ membersOrderList }" varStatus="status" begin="0">
				                               			<tr class="odd gradeX">
					                                        <td>${ status.count + ((pi.currentPage - 1) * pi.limit) }</td>
					                                        <td>${ list.PRODUCT_NAME }</td>
					                                        <td>${ list.PRODUCT_QUANTITY }</td>
					                                        <td>${ fn:substring(list.ORDERS_DATE, 0, 10) }</td>
				                                    	</tr>
				                               		</c:forEach>
			                               		</c:if>
			                                </tbody>
			                            </table>
	                                </div>
	                                <div class="tab-pane fade" id="declaration">
	                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
			                                <thead>
			                                    <tr>
			                                        <th width="25%">NO</th>
			                                        <th width="25%">유형</th>
			                                        <th width="25%">신고자</th>
			                                        <th width="25%">신고날짜</th>
			                                    </tr>
			                                </thead>
			                                <tbody>
				                            	<c:if test="${ membersDeclartionList != null }">
				                                	<c:forEach var="list" items="${ membersDeclartionList }" varStatus="status" begin="0">
				                               			<tr class="odd gradeX">
					                                        <td>${ status.count + ((pi.currentPage - 1) * pi.limit) }</td>
					                                        <td>
					                                        	<c:if test="${ list.REPORT_TYPE == 1 }">댓글</c:if>
		                                        				<c:if test="${ list.REPORT_TYPE == 2 }">게시글</c:if>
					                                        </td>
					                                        <td>${ list.GIVE_NICK_NAME }</td>
					                                        <td>${ fn:substring(list.REPORT_DATE, 0, 10) }</td>
				                                    	</tr>
				                               		</c:forEach>
			                               		</c:if>
			                                </tbody>
			                            </table>
	                                </div>
	                            </div>
	                        </div>
                        </div>
                        <div class="form-group" align="center">
                           <button type="button" class="btn btn-default" onclick="location.href='goGeneralMemberAdminList.adm'">목록으로</button>
                           <button type="button" class="btn btn-danger" onclick="location.href='addBlackMEmberAdmin.adm?num=${ memberInfo.MEMBER_NO }'">블랙목록 추가</button>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <jsp:include page="../commonAdmin/foot.jsp" />

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>

    </script>
    
</body>
</html>