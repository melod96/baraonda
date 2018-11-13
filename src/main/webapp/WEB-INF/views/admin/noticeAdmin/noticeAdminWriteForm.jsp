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
    .fr-view {
        height: 500px !important;
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
                            공지 등록
                        </div>
                        <!-- /.panel-heading -->
                        <form name="frmSubmit">
	                        <div class="panel-body">
	                            <div class="form-group">
	                                <label>제목</label>
	                                <input class="form-control" name="title" value="${ boardInfo.BOARD_TITLE }">
	                            </div>
	                            <div class="form-group">
	                                <textarea id="editor" name="content">${ boardInfo.BOARD_CONTENT }</textarea>
	                            </div>
	                            <div class="form-group" align="center">
	                                <button type="button" class="btn btn-default" onclick="location.href='goNoticeAdminList.adm'">취소</button>
	                                <button type="button" class="btn btn-primary" onclick="getPost(${ boardInfo.BOARD_NO })">저장</button>
	                            </div>
	                        </div>
                        </form>
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
    	$('#editor').froalaEditor();
    }); 
   	
   	function getPost(num){
   		var theForm = document.frmSubmit;
   		theForm.method="post";
   		if(num != null){
   			theForm.action="goNoticeAdminUpdate.adm?num=${ boardInfo.BOARD_NO }";
   		}else{
   			theForm.action="goNoticeAdminInsert.adm";
   		}
   		theForm.submit();
   	}
    </script>
    
</body>
</html>