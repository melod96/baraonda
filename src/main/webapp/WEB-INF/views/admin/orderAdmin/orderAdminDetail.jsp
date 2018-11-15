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
                    <h1 class="page-header">주문</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	주문 상세
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="col-lg-6">
								<table width="100%" class="table table-striped">
	                                <tbody>
	                                	<tr>
	                                		<th width="15%"><h5>NO</h5></th>
	                                		<td><h5>${ orderInfo.ORDERS_NO }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>주문자</h5></th>
	                                		<td><h5>${ orderInfo.NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>연락처</h5></th>
	                                		<td><h5>${ orderInfo.PHONE }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>상품명</h5></th>
	                                		<td><h5>${ orderInfo.PRODUCT_NAME }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>상품수</h5></th>
	                                		<td><h5>${ orderInfo.PRODUCT_QUANTITY }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>상품가격</h5></th>
	                                		<td><h5>${ orderInfo.PRODUCT_PRICE }</h5></td>
	                                	</tr>
	                                	<tr>
	                                		<th><h5>주문날짜</h5></th>
	                                		<td><h5>${ fn:substring(orderInfo.ORDERS_DATE, 0, 10) }</h5></td>
	                                	</tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        <div class="col-lg-6">
	                        	<div id="chart_div" style="width: 100%; height: 400px;"></div>
	                        </div>
	                        <div class="form-group" align="center">
	                           <button type="button" class="btn btn-default" onclick="location.href='goOrderAdminList.adm'">목록으로</button>
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
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    
    function drawChart() {
    	var thisYear = new Date().getFullYear();
    	var thisMonth = new Date().getMonth() + 1;
		var data = google.visualization.arrayToDataTable([
	        ['Year', '판매량'],
	        [thisYear + '.' + (thisMonth - 4),  1],
	        [thisYear + '.' + (thisMonth - 3),  2],
	        [thisYear + '.' + (thisMonth - 2),  3],
	        [thisYear + '.' + (thisMonth - 1),  4],
	        [thisYear + '.' + thisMonth,  5]
	    ]);
    	

      var options = {
        title: '월별 ${ orderInfo.PRODUCT_NAME } 판매량',
        hAxis: {title: 'Month',  titleTextStyle: {color: '#333'}},
        vAxis: {minValue: 0}
      };

      var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
    </script>
    
</body>
</html>