<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.right {
	float: right;
	margin-left: 30px;
}

.t1 {
	font-size: 16px;
	width: 262px;
	text-align: center;
}

.t1 th {
	text-align: center;
	height: 30px;
	font-size: 20px;
}

.t1 td {
	height: 30px;
}
</style>

	<div class="right">
		<table style="margin-bottom: 30px;" class="t1 tbl-type01">
			<tr>
				<th>명예의 전당</th>
			</tr>
			<c:forEach var="f" items="${flist}" end="4">
				<tr>
					<td>${f.board_title}</td>
				</tr>
			</c:forEach>
		</table>
		<table border="1" style="margin-bottom: 30px;" class="t1 tbl-type01">
			<tr>
				<th>다이어터 랭킹</th>
			</tr>
			<c:forEach var="r" items="${rlist}" end="4">
				<tr>
					<td><a onclick="location.href='othersView.my?member_no=' + ${r.member_no}">${ r.nick_name }</a></td>
				</tr>
			</c:forEach>
		</table>
		<table border="1" class="t1 tbl-type01">
			<tr>
				<th>
					공지사항
					<a href="noticelist.nt" >
						<i class="fa fa-plus-square" aria-hidden="true" style="float:right; font-size:25px;"></i>
					</a>	
				</th>
			</tr>
			<c:forEach var="n" items="${nlist}" end="4">
				<tr>
					<td><a onclick= "location.href='noticeDetail.nt?notice_no=' + ${n.board_no}">${ n.board_title }</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>