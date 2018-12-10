<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commonAdmin/head.jsp" />
<style>
	.content{
		height: 500px;
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
                    <h1 class="page-header">공지</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	공지 상세
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="col-lg-12">
                                <div class="panel panel-primary">
                                    <div class="panel-heading">
                                        	제목 : ${ boardInfo.BOARD_TITLE }
                                    </div>
                                    <div class="panel-body content" style="overflow-y:scroll;">
                                        <p>${ boardInfo.BOARD_CONTENT }</p>
                                    </div>
                                    <div class="panel-footer">
                                        	${ fn:substring(boardInfo.BOARD_DATE, 0, 10) }  작성자 : ${ boardInfo.NICK_NAME }
                                    </div>
                                </div>
                            </div>
                            <div class="form-group" align="center">
                                <button type="button" class="btn btn-default" onclick="location.href='goNoticeAdminList.adm'">목록</button>
                                <button type="button" class="btn btn-primary" onclick="location.href='goNoticeAdminWriteForm.adm?num=${ boardInfo.BOARD_NO }'">수정</button>
                                <button type="button" class="btn btn-danger" onclick="location.href='goNoticeAdminDelete.adm?num=${ boardInfo.BOARD_NO }'">삭제</button>
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