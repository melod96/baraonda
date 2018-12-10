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
                    <h1 class="page-header">신고</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	신고 상세
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="col-lg-6">
								<table width="100%" class="table table-striped">
	                                <tbody>
	                                	<tr>
	                                		<th width="20%"><h5>NO</h5></th>
	                                		<td><h5>${ reportInfo.REPORT_NO }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고자</h5></th>
	                                		<td><h5>${ reportInfo.GIVE_NICK_NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고자 연락처</h5></th>
	                                		<td><h5>${ reportInfo.GIVE_PHONE }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고대상</h5></th>
	                                		<td><h5>${ reportInfo.GET_NICK_NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고대상 연락처</h5></th>
	                                		<td><h5>${ reportInfo.GET_PHONE }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고유형</h5></th>
	                                		<td><h5>${ reportInfo.REPORT_TYPE }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고일</h5></th>
	                                		<td><h5>${ fn:substring(reportInfo.REPORT_DATE, 0, 10) }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>처리여부</h5></th>
	                                		<td><h5>
	                                			<c:if test="${ reportInfo.REPORT_APPROVAL == 0 }">미처리</c:if>
												<c:if test="${ reportInfo.REPORT_APPROVAL == 1 }">처리</c:if>
	                                		</h5></td>
	                                	</tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        <div class="col-lg-6">
	                        	<table width="100%" class="table table-striped">
	                                <tbody>
	                                	<tr>
	                                		<th width="15%"><h5>신고내용</h5></th>
	                                		<td><h5>${ reportInfo.REPORT_CONTENT }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>신고글</h5></th>
	                                		<td><h5><div style="overflow-y:scroll; height:400px;">
	                                			${ reportInfo.BOARD_CONTENT }
	                                		</div></h5></td>
	                                	</tr>
	                                </tbody>
	                            </table>
	                        </div>
                        </div>
                        <div class="form-group" align="center">
                            <button type="button" class="btn btn-default" onclick="location.href='goDeclarationAdminList.adm'">목록으로</button>
                            <button type="button" class="btn btn-primary" onclick="location.href='goGeneralMemberAdminDetail.adm?num=${ reportInfo.REPORT_GIVE_NO }'">신고자 계정보기</button>
                            <button type="button" class="btn btn-danger" onclick="location.href='goGeneralMemberAdminDetail.adm?num=${ reportInfo.REPORT_GET_NO }'">신고대상 계정보기</button>
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