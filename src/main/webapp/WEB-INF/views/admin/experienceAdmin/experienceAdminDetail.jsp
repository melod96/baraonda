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
	.fr-view {
        height: 300px !important;
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
                    <h1 class="page-header">체험단</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	체험단 상세
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="col-lg-12">
                                <div class="panel panel-primary">
                                    <div class="panel-heading">
                                        	제목 : ${ boardInfo.BOARD_TITLE }
                                    </div>
                                    <div class="panel-body content">
                                        <p>${ boardInfo.BOARD_CONTENT }</p>
                                    </div>
                                    <div class="panel-footer">
                                        	${ fn:substring(boardInfo.BOARD_DATE, 0, 10) }  작성자 : ${ boardInfo.NICK_NAME }
                                    </div>
                                </div>
	                            <form name="frmSubmit">
			                        <div class="panel-body">
			                            <div class="form-group">
			                            	<label>처리 사유</label>
			                                <textarea id="editor" name="content"></textarea>
			                            </div>
			                            <div class="form-group" align="center">
			                                <button type="button" class="btn btn-default" onclick="location.href='goExperienceAdminList.adm'">목록</button>
	                                <button type="button" class="btn btn-primary" onclick="location.href=''">승인</button>
	                                <button type="button" class="btn btn-danger" onclick="location.href=''">거절</button>
			                            </div>
			                        </div>
		                        </form>
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
    $(function() { 
    	$('#editor').froalaEditor({
            imageUploadURL:'http://i.froala.com/upload'
    	});
    });
    </script>
    
</body>
</html>