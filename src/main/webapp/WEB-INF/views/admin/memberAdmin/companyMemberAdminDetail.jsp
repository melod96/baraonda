<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	                                		<td><h5>${ memberInfo.member_no }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>아이디</h5></th>
	                                		<td><h5>${ memberInfo.id }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>이름</h5></th>
	                                		<td><h5>${ memberInfo.name }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>닉네임</h5></th>
	                                		<td><h5>${ memberInfo.nick_name }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>연락처</h5></th>
	                                		<td><h5>${ memberInfo.phone }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>이메일</h5></th>
	                                		<td><h5>${ memberInfo.email }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>가입일자</h5></th>
	                                		<td><h5>${ memberInfo.enroll_date }</h5></td>
	                                	</tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        <div class="col-lg-6">
	                        	<table width="100%" class="table table-striped">
	                                <tbody>
	                                	<tr>
	                                		<th width="15%"><h5>회사명</h5></th>
	                                		<td><h5>${ memberInfo.company_name }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>사업자번호</h5></th>
	                                		<td><h5>${ memberInfo.company_no }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>법인</h5></th>
	                                		<td><h5>${ memberInfo.ceo_type }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>은행</h5></th>
	                                		<td><h5>${ memberInfo.bank }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>계좌번호</h5></th>
	                                		<td><h5>${ memberInfo.account }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>대표자명</h5></th>
	                                		<td><h5>${ memberInfo.ceo_name }</h5></td>
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