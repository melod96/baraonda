<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- Morris Charts CSS -->
    <link href="${ pageContext.servletContext.contextPath }/resources/admin/css/morris.css" rel="stylesheet">

<jsp:include page="../commonAdmin/head.jsp" />
<style>
	.table- tbody td{

		
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
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ dashboardInfo.QNA }</div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <span class="pull-left">새로운 문의 수</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ dashboardInfo.BOARD }</div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <span class="pull-left">새로운 게시글 수</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ dashboardInfo.ORDERS }</div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <span class="pull-left">새로운 주문 수</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ dashboardInfo.MEMBER }</div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <span class="pull-left">새로운 회원 수</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> 일 게시글 현황
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="curve_chart" style="width: 100%; height: 500px"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> 월 주문 현황
                        </div>
                        <!-- /.panel-heading -->
                        <jsp:useBean id="toDay" class="java.util.Date" />
						<fmt:formatDate value='${toDay}' pattern='MM' var="nowDate"/>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped table-">
                                            <thead>
                                                <tr>
                                                    <th>Month</th>
                                                    <th>Count</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${ nowDate - 6 }월</td>
                                                    <td>${ orderInfo.N4 }개</td>
                                                </tr>
                                                <tr>
                                                    <td>${ nowDate - 5 }월</td>
                                                    <td>${ orderInfo.N5 }개</td>
                                                </tr>
                                                <tr>
                                                    <td>${ nowDate - 4 }월</td>
                                                    <td>${ orderInfo.N6 }개</td>
                                                </tr>
                                                <tr>
                                                    <td>${ nowDate - 3 }월</td>
                                                    <td>${ orderInfo.N7 }개</td>
                                                </tr>
                                                <tr>
                                                    <td>${ nowDate - 2 }월</td>
                                                    <td>${ orderInfo.N8 }개</td>
                                                </tr>
                                                <tr>
                                                    <td>${ nowDate - 1 }월</td>
                                                    <td>${ orderInfo.N9 }개</td>
                                                </tr>
                                                <tr>
                                                    <td>${ nowDate - 0 }월</td>
                                                    <td>${ orderInfo.N10 }개</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.col-lg-4 (nested) -->
                                <div class="col-lg-8">
                                    <div id="morris-bar-chart"></div>
                                </div>
                                <!-- /.col-lg-8 (nested) -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> 판매 상품 순위
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                            	<c:if test="${ productInfo != null }">
	                              	<c:forEach var="list" items="${ productInfo }" varStatus="status" begin="0">
	                            		<a class="list-group-item">
		                                    ${ list.PRODUCT_NAME }
		                                    <span class="pull-right text-muted small"><em>${ list.CO }</em>
		                                    </span>
		                                </a>
	                            	</c:forEach>
                               	</c:if>
                            </div>
                            <!-- /.list-group --> 
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> 회원 통계
                        </div>
                        <div class="panel-body">
                            <div id="morris-donut-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-4 -->
                
                <!-- ㅁㅁ -->
  				<jsp:include page="../commonAdmin/echo.jsp" />
                <!-- ㅁㅁ -->
                
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    
    <jsp:include page="../commonAdmin/foot.jsp" />
    <!-- Morris Charts JavaScript -->
    <script src="${ pageContext.servletContext.contextPath }/resources/admin/js/raphael.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/admin/js/morris.min.js"></script>
    <script>
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Month', 'BnA', 'stimulate', 'diary', 'diet', 'worry', 'freedom', 'question'],
        ['2월', ${ boardInfo.get(0).N1 }, ${ boardInfo.get(1).N1 }, ${ boardInfo.get(2).N1 }, ${ boardInfo.get(3).N1 }, ${ boardInfo.get(4).N1 }, ${ boardInfo.get(5).N1 }, ${ boardInfo.get(6).N1 }],
        ['3월', ${ boardInfo.get(0).N2 }, ${ boardInfo.get(1).N2 }, ${ boardInfo.get(2).N2 }, ${ boardInfo.get(3).N2 }, ${ boardInfo.get(4).N2 }, ${ boardInfo.get(5).N2 }, ${ boardInfo.get(6).N2 }],
        ['4월', ${ boardInfo.get(0).N3 }, ${ boardInfo.get(1).N3 }, ${ boardInfo.get(2).N3 }, ${ boardInfo.get(3).N3 }, ${ boardInfo.get(4).N3 }, ${ boardInfo.get(5).N3 }, ${ boardInfo.get(6).N3 }],
        ['5월', ${ boardInfo.get(0).N4 }, ${ boardInfo.get(1).N4 }, ${ boardInfo.get(2).N4 }, ${ boardInfo.get(3).N4 }, ${ boardInfo.get(4).N4 }, ${ boardInfo.get(5).N4 }, ${ boardInfo.get(6).N4 }],
        ['6월', ${ boardInfo.get(0).N5 }, ${ boardInfo.get(1).N5 }, ${ boardInfo.get(2).N5 }, ${ boardInfo.get(3).N5 }, ${ boardInfo.get(4).N5 }, ${ boardInfo.get(5).N5 }, ${ boardInfo.get(6).N5 }],
        ['7월', ${ boardInfo.get(0).N6 }, ${ boardInfo.get(1).N6 }, ${ boardInfo.get(2).N6 }, ${ boardInfo.get(3).N6 }, ${ boardInfo.get(4).N6 }, ${ boardInfo.get(5).N6 }, ${ boardInfo.get(6).N6 }],
        ['8월', ${ boardInfo.get(0).N7 }, ${ boardInfo.get(1).N7 }, ${ boardInfo.get(2).N7 }, ${ boardInfo.get(3).N7 }, ${ boardInfo.get(4).N7 }, ${ boardInfo.get(5).N7 }, ${ boardInfo.get(6).N7 }],
        ['9월', ${ boardInfo.get(0).N8 }, ${ boardInfo.get(1).N8 }, ${ boardInfo.get(2).N8 }, ${ boardInfo.get(3).N8 }, ${ boardInfo.get(4).N8 }, ${ boardInfo.get(5).N8 }, ${ boardInfo.get(6).N8 }],
        ['10월', ${ boardInfo.get(0).N9 }, ${ boardInfo.get(1).N9 }, ${ boardInfo.get(2).N9 }, ${ boardInfo.get(3).N9 }, ${ boardInfo.get(4).N9 }, ${ boardInfo.get(5).N9 }, ${ boardInfo.get(6).N9 }],
        ['11월', ${ boardInfo.get(0).N10 }, ${ boardInfo.get(1).N10 }, ${ boardInfo.get(2).N10 }, ${ boardInfo.get(3).N10 }, ${ boardInfo.get(4).N10 }, ${ boardInfo.get(5).N10 }, ${ boardInfo.get(6).N10 }]
      ]);

      var options = {
        title: '',
        curveType: 'function',
        legend: { position: 'bottom' }
      };

      var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

      chart.draw(data, options);
    }
    
    $(function() {
        Morris.Donut({
            element: 'morris-donut-chart',
            data: [{
                label: "GENERAL",
                value: ${ memberInfo.GENERAL }
            }, {
                label: "BLACK",
                value: ${ memberInfo.BLACK }
            }, {
                label: "LEAVE",
                value: ${ memberInfo.LEAVE }
            }],
            resize: true
        });

        var mm = new Date().getMonth()+1;
        
        Morris.Bar({
            element: 'morris-bar-chart',
            data: [{
                y: (mm - 6) + '월',
                a: ${ orderInfo.N4 }
            }, {
                y: (mm - 5) + '월',
                a: ${ orderInfo.N5 }
            }, {
                y: (mm - 4) + '월',
                a: ${ orderInfo.N6 }
            }, {
                y: (mm - 3) + '월',
                a: ${ orderInfo.N7 }
            }, {
                y: (mm - 2) + '월',
                a: ${ orderInfo.N8 }
            }, {
                y: (mm - 1) + '월',
                a: ${ orderInfo.N9 }
            }, {
                y: (mm - 0) + '월',
                a: ${ orderInfo.N10 }
            }],
            xkey: 'y',
            ykeys: ['a'],
            labels: ['Series A'],
            hideHover: 'auto',
            resize: true
        });
        
    });
    </script>
    
</body>
</html>