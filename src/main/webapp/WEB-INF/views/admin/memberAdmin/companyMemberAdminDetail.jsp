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
                    <h1 class="page-header">기업 회원</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	기업 회원 상세
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
	                        	<table width="100%" class="table table-striped">
	                                <tbody>
	                                	<tr>
	                                		<th width="15%"><h5>회사명</h5></th>
	                                		<td><h5>${ memberInfo.COMPANY_NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>사업자번호</h5></th>
	                                		<td><h5>${ memberInfo.COMPANY_NO }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>법인</h5></th>
	                                		<td><h5>
	                                			<c:if test="${ memberInfo.CEO_TYPE == 0 }">일반</c:if>
		                                        <c:if test="${ memberInfo.CEO_TYPE == 1 }">법인</c:if>
	                                		</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>은행</h5></th>
	                                		<td><h5>${ memberInfo.BANK }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>계좌번호</h5></th>
	                                		<td><h5>${ memberInfo.ACCOUNT }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>대표자명</h5></th>
	                                		<td><h5>${ memberInfo.CEO_NAME }</h5></td>
	                                	</tr>
	                                </tbody>
	                            </table>
	                        </div>
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