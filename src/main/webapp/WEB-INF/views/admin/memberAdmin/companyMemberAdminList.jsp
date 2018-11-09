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
                    <h1 class="page-header">기업 회원</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	기업 회원 목록
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
                                        <th width="6%">NO</th>
                                        <th width="6%">ID</th>
                                        <th width="10%">사업자명</th>
                                        <th width="9%">닉네임</th>
                                        <th width="12%">연락처</th>
                                        <th width="12%">회사명</th>
                                        <th width="12%">사업자 번호</th>
                                        <th width="14%">계좌</th>
                                        <th width="11%">가입일</th>
                                        <th width="8%">상태</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${ list != null }">
	                                	<c:forEach var="list" items="${ list }" varStatus="status" begin="0">
	                               			<tr class="odd gradeX">
		                                        <input type="hidden" value="${ list.member_no }" id="member_no"/>
		                                        <td>${ status.count + ((pi.currentPage - 1) * pi.limit) }</td>
		                                        <td>${ list.id }</td>
		                                        <td>${ list.name }</td>
		                                        <td>${ list.ceo_name }</td>
		                                        <td>${ list.phone }</td>
		                                        <td>${ list.company_name }</td>
		                                        <td>${ list.company_no }</td>
		                                        <td>${ list.bank } ${ list.account }</td>
		                                        <td>${ list.enroll_date }</td>
		                                        <td>
		                                        	<c:if test="${ list.member_status == 0 }">일반</c:if>
		                                        	<c:if test="${ list.member_status == 1 }">블랙</c:if>
		                                        	<c:if test="${ list.member_status == 2 }">탈퇴</c:if>
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
                            		<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goCompanyMemberAdminList.adm?currentPage=' + ${ pi.startPage }">&laquo;</button>
                            	</c:if>
                            	<c:if test="${ pi.currentPage <= 1 }">
                            		<button type="button" class="btn btn-outline btn-primary" disabled>&lt;</button>
                            	</c:if>
                            	<c:if test="${ pi.currentPage > 1}">
                            		<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goCompanyMemberAdminList.adm?currentPage=' + ${ pi.currentPage - 1 }">&lt;</button>
                            	</c:if>
                                <span class="paging-numbers">
                                	<c:if test="${ pi.currentPage <= 1 }">
		                               	<c:forEach begin="${ pi.currentPage }" end="${ pi.currentPage + 2 }" step="1" var="num">
		                               		<c:if test="${ num > 0 && num <= pi.endPage }">
			                               		<c:if test="${ num == pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" disabled>${ num }</button>
			                               		</c:if>
			                               		<c:if test="${ num != pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goCompanyMemberAdminList.adm?currentPage=' + ${ num }">${ num }</button>
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
			                               			<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goCompanyMemberAdminList.adm?currentPage=' + ${ num }">${ num }</button>
			                               		</c:if>
		                               		</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${ pi.currentPage > 1 && (pi.currentPage > (pi.maxPage - 1)) }">
		                               	<c:forEach begin="${ pi.currentPage - 2 }" end="${ pi.currentPage }" step="1" var="num">
		                               		<c:if test="${ num <= pi.maxPage }">
			                               		<c:if test="${ num == pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" disabled>${ num }</button>
			                               		</c:if>
			                               		<c:if test="${ num != pi.currentPage }">
			                               			<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goCompanyMemberAdminList.adm?currentPage=' + ${ num }">${ num }</button>
			                               		</c:if>
		                               		</c:if>
										</c:forEach>
									</c:if>
                                </span>
                                <c:if test="${ pi.currentPage < pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goGeneralMemberAdminList.adm?currentPage=' + ${ pi.currentPage + 1 }">&gt;</button>
                                </c:if>
                                <c:if test="${ pi.currentPage >= pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" disabled>&gt;</button>
                                </c:if>
                                <c:if test="${ pi.currentPage < pi.endPage }">
                                	<button type="button" class="btn btn-outline btn-primary" onclick="location.href='goGeneralMemberAdminList.adm?currentPage=' + ${ pi.endPage }">&raquo;</button>
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
        
        $("#search-option-1").children().each(function(){
    		if($(this).val() == "${ search.option1 }"){
    			$(this).attr("selected","selected"); 
    		}
    	});
        
        $(".gradeX").children().each(function(){
    		$(this).click(function(){
    			var member_no = $(this).parent().children("#member_no").val();
        		location.href="goCompanyMemberAdminDetail.adm?num=" + member_no;
    		});
    	});
    });
    
    function search(){
    	var content = $('#search-content').val();
    	
    	location.href="goCompanyMemberAdminList.adm?currentPage=1&searchContent=" + content;
    }
    </script>
    
</body>
</html>