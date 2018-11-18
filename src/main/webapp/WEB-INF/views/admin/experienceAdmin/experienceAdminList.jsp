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
    .gradeX td:hover{
    	cursor: pointer;
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
                            	체험단 목록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="form-inline">
                                <div class="input-group custom-search-form" >
                                    <input type="text" class="form-control" placeholder="Search..." id="search-content" value="${ search.content }">
                                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" onclick="search();">
                                        <i class="fa fa-search"></i>
                                    </button>
                                    </span>
                                </div>
                            </div>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th width="10%">NO</th>
                                        <th width="30%">제목</th>
                                        <th width="20%">회사명</th>
                                        <th width="15%">등록날짜</th>
                                        <th width="15%">승인날짜</th>
                                        <th width="10%">승인여부</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${ list != null }">
	                                	<c:forEach var="list" items="${ list }" varStatus="status" begin="0">
	                               			<tr class="odd gradeX">
	                               				<input type="hidden" value="${ list.EXPERIENCE_NO }" id="experience_no"/>
		                                        <td>${ status.count + ((pi.currentPage - 1) * pi.limit) }</td>
		                                        <td>${ list.BOARD_TITLE }</td>
		                                        <td>${ list.COMPANY_NAME }</td>
		                                        <td>${ fn:substring(list.EXPERIENCE_DATE, 0, 10) }</td>
		                                        <td>${ fn:substring(list.APPROVAL_DATE, 0, 10) }</td>
		                                        <td>
		                                        	${ list.EXPERIENCE_APPROVAL }
		                                        </td>
	                                    	</tr>
	                               		</c:forEach>
                               		</c:if>
                                </tbody>
                            </table>

                            <div class="paginate">
                            	<c:if test="${ pi.currentPage <= 1 }">
                            		<button type="button" class="btn btn-outline btn-primary" disabled>&laquo;</button>
                            	</c:if>
                            	<c:if test="${ pi.currentPage > 1}">
                            		<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ pi.startPage });">&laquo;</button>
                            	</c:if>
                            	<c:if test="${ pi.currentPage <= 1 }">
                            		<button type="button" class="btn btn-outline btn-primary" disabled>&lt;</button>
                            	</c:if>
                            	<c:if test="${ pi.currentPage > 1}">
                            		<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ pi.currentPage - 1 });">&lt;</button>
                            	</c:if>
                                <span class="paging-numbers">
                                	<c:if test="${ pi.currentPage <= 1 }">
		                               	<c:forEach begin="${ pi.currentPage }" end="${ pi.currentPage + 2 }" step="1" var="num">
		                               		<c:if test="${ num > 0 && num <= pi.endPage }">
			                               		<c:if test="${ num == pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" disabled>${ num }</button>
			                               		</c:if>
			                               		<c:if test="${ num != pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ num });">${ num }</button>
			                               		</c:if>
		                               		</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${ pi.currentPage > 1 && pi.currentPage <= (pi.maxPage - 1) }">
		                               	<c:forEach begin="${ pi.currentPage - 2 }" end="${ pi.currentPage + 2 }" step="1" var="num">
		                               		<c:if test="${ num > 0 && num <= pi.endPage}">
			                               		<c:if test="${ num == pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" disabled>${ num }</button>
			                               		</c:if>
			                               		<c:if test="${ num != pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ num });">${ num }</button>
			                               		</c:if>
		                               		</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${ pi.currentPage > 1 && (pi.currentPage > (pi.maxPage - 1)) }">
		                               	<c:forEach begin="${ pi.currentPage - 2 }" end="${ pi.currentPage }" step="1" var="num">
		                               		<c:if test="${ num > 0 && num <= pi.maxPage }">
			                               		<c:if test="${ num == pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" disabled>${ num }</button>
			                               		</c:if>
			                               		<c:if test="${ num != pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ num });">${ num }</button>
			                               		</c:if>
		                               		</c:if>
										</c:forEach>
									</c:if>
                                </span>
                                <c:if test="${ pi.currentPage < pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ pi.currentPage + 1 });">&gt;</button>
                                </c:if>
                                <c:if test="${ pi.currentPage >= pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" disabled>&gt;</button>
                                </c:if>
                                <c:if test="${ pi.currentPage < pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" onclick="paginate(${ pi.endPage });">&raquo;</button>
                                </c:if>
                                <c:if test="${ pi.currentPage >= pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" disabled>&raquo;</button>
                                </c:if>
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
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true,
            paginate: false,
            //sort : true
            info : false,
            filter : false
        });
	
        $(".gradeX").children().each(function(){
    		$(this).click(function(){
    			var experience_no = $(this).parent().children("#experience_no").val();
        		location.href="goExperienceAdminDetail.adm?num=" + experience_no;
    		});
    	});
    });
    
    function search(){
    	var content = $('#search-content').val();
    	
    	location.href="goExperienceAdminList.adm?currentPage=1&searchContent=" + content;
    } 
    
    function paginate(num){
    	if(${ search != null }){
    		location.href="goExperienceAdminList.adm?currentPage=" + num + "&searchContent=${ search.content }";
    	}else{
    		location.href="goExperienceAdminList.adm?currentPage=" + num;
    	}
    }
    </script>
    
</body>
</html>