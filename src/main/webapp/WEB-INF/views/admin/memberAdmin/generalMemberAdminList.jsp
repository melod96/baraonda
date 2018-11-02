<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <h1 class="page-header">일반 회원</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	일반 회원 목록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="form-inline">
                                <div class="input-group custom-search-form" >
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" onclick="#">
                                        <i class="fa fa-search"></i>
                                    </button>
                                    </span>
                                </div>
                                <div class="form-group">
                                    <select class="form-control custom-select-form">
                                        <option>회원상태</option>
                                        <option>------</option>
                                        <option>일반</option>
                                        <option>탈퇴</option>
                                        <option>블랙</option>
                                    </select>
                                </div>
                            </div>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th width="8%">NO</th>
                                        <th width="10%">ID</th>
                                        <th width="10%">이름</th>
                                        <th width="17%">닉네임</th>
                                        <th width="17%">연락처</th>
                                        <th width="17%">이메일</th>
                                        <th width="10%">가입일</th>
                                        <th width="10%">상태</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd gradeX">
                                        <td>1</td>
                                        <td>user01</td>
                                        <td>name01</td>
                                        <td>nickName01</td>
                                        <td>010-0000-1111</td>
                                        <td>asda@naver.com</td>
                                        <td>2018-10-10</td>
                                        <td> - </td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>2</td>
                                        <td>user02</td>
                                        <td>name02</td>
                                        <td>nickName02</td>
                                        <td>010-0000-1111</td>
                                        <td>asda@naver.com</td>
                                        <td>2018-10-10</td>
                                        <td> - </td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>3</td>
                                        <td>user03</td>
                                        <td>name03</td>
                                        <td>nickName03</td>
                                        <td>010-0000-1111</td>
                                        <td>asda@naver.com</td>
                                        <td>2018-10-10</td>
                                        <td> - </td>
                                    </tr>
                                </tbody>
                            </table>

                            <div class="paginate">
                                <button type="button" class="btn btn-outline btn-primary"><</button>
                                <span class="paging-numbers">
                                    <button type="button" class="btn btn-primary">1</button>
                                    <button type="button" class="btn btn-outline btn-primary">2</button>
                                    <button type="button" class="btn btn-outline btn-primary">3</button>
                                    <button type="button" class="btn btn-outline btn-primary">4</button>
                                    <button type="button" class="btn btn-outline btn-primary">5</button>
                                </span>
                                <button type="button" class="btn btn-outline btn-primary">></button>
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
    });
    </script>
    
</body>
</html>