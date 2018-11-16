<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- Morris Charts CSS -->
    <link href="${ pageContext.servletContext.contextPath }/resources/admin/css/morris.css" rel="stylesheet">

<jsp:include page="../commonAdmin/head.jsp" />
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
                            <i class="fa fa-bar-chart-o fa-fw"></i> 일 매출 현황
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-area-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> 월 매출 현황
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Date</th>
                                                    <th>Time</th>
                                                    <th>Amount</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>3:29 PM</td>
                                                    <td>$321.33</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>3:20 PM</td>
                                                    <td>$234.34</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>3:03 PM</td>
                                                    <td>$724.17</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>3:00 PM</td>
                                                    <td>$23.71</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>2:49 PM</td>
                                                    <td>$8345.23</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>2:23 PM</td>
                                                    <td>$245.12</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>2:15 PM</td>
                                                    <td>$5663.54</td>
                                                </tr>
                                                <tr>
                                                    <td>10/21/2013</td>
                                                    <td>2:13 PM</td>
                                                    <td>$943.45</td>
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
                            <i class="fa fa-bell fa-fw"></i> 검색어 순위
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                                <a class="list-group-item">
                                    New Comment
                                    <span class="pull-right text-muted small"><em>4 minutes ago</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    3 New Followers
                                    <span class="pull-right text-muted small"><em>12 minutes ago</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    Message Sent
                                    <span class="pull-right text-muted small"><em>27 minutes ago</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    New Task
                                    <span class="pull-right text-muted small"><em>43 minutes ago</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    Server Rebooted
                                    <span class="pull-right text-muted small"><em>11:32 AM</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    Server Crashed!
                                    <span class="pull-right text-muted small"><em>11:13 AM</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    Server Not Responding
                                    <span class="pull-right text-muted small"><em>10:57 AM</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    New Order Placed
                                    <span class="pull-right text-muted small"><em>9:49 AM</em>
                                    </span>
                                </a>
                                <a class="list-group-item">
                                    Payment Received
                                    <span class="pull-right text-muted small"><em>Yesterday</em>
                                    </span>
                                </a>
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
    $(function() {

        Morris.Area({
            element: 'morris-area-chart',
            data: [{
                period: '2010 Q1',
                iphone: 2666,
                ipad: null,
                itouch: 2647
            }, {
                period: '2010 Q2',
                iphone: 2778,
                ipad: 2294,
                itouch: 2441
            }, {
                period: '2010 Q3',
                iphone: 4912,
                ipad: 1969,
                itouch: 2501
            }, {
                period: '2010 Q4',
                iphone: 3767,
                ipad: 3597,
                itouch: 5689
            }, {
                period: '2011 Q1',
                iphone: 6810,
                ipad: 1914,
                itouch: 2293
            }, {
                period: '2011 Q2',
                iphone: 5670,
                ipad: 4293,
                itouch: 1881
            }, {
                period: '2011 Q3',
                iphone: 4820,
                ipad: 3795,
                itouch: 1588
            }, {
                period: '2011 Q4',
                iphone: 15073,
                ipad: 5967,
                itouch: 5175
            }, {
                period: '2012 Q1',
                iphone: 10687,
                ipad: 4460,
                itouch: 2028
            }, {
                period: '2012 Q2',
                iphone: 8432,
                ipad: 5713,
                itouch: 1791
            }],
            xkey: 'period',
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['iPhone', 'iPad', 'iPod Touch'],
            pointSize: 2,
            hideHover: 'auto',
            resize: true
        });
        
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

        Morris.Bar({
            element: 'morris-bar-chart',
            data: [{
                y: '2006',
                a: 100,
                b: 90
            }, {
                y: '2007',
                a: 75,
                b: 65
            }, {
                y: '2008',
                a: 50,
                b: 40
            }, {
                y: '2009',
                a: 75,
                b: 65
            }, {
                y: '2010',
                a: 50,
                b: 40
            }, {
                y: '2011',
                a: 75,
                b: 65
            }, {
                y: '2012',
                a: 100,
                b: 90
            }],
            xkey: 'y',
            ykeys: ['a', 'b'],
            labels: ['Series A', 'Series B'],
            hideHover: 'auto',
            resize: true
        });
        
    });
    </script>
    
</body>
</html>