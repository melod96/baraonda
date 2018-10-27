<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
<jsp:include page="../common/head.jsp" />
<style>
.left {
	float: left;
	width: 70%;
	display: inline-block;
}

.title {
	border-bottom: 2px solid #5d5d5d;
	font-size: 30px;
}

.tbl-y th {
	padding: 22px 0 22px 14px;
}

.tbl-y td {
	padding: 10px 0 10px 14px;
}

.tbl-y-wrap {
	border: 1px solid #dedede;
}

.tbl-y {
	width: 100%;
}

.tbl-y tr {
	border-bottom: 1px solid #dedede;
}

.fbold {
	font-weight: bold !important;
	font-size: 11px;
	margin-top: 20px;
	line-height: 20px;
}

.p-gray {
	color: #7b7b7b !important;
	padding-left: 25px;
}

.btn-ac {
	text-align: center;
	margin-top: 30px;
}

.gender {
	-webkit-appearance: radio;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="clear" style="height:40px;background:white;"></div>
	<div class="container">
    <div class="row">
	<div class="left">
		<img src="/baraonda/src/main/webapp/resources/images/berrywater.PNG" style="width:732px; height:180px;">
		<h2 class="title">공지사항</h2>
		<div class="search">
			<select class="form-control input-xshort">
				<option>제목</option>
				<option>내용</option>
				<option>작성자</option>
			</select>
			<button type="button" class="btn btn-primary">작성하기</button>
		</div>
		<div class="list">
					<table class="tbl-type02">
						<colgroup>
							<col style="width: 40%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">조회수</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
							<tr>
								<td>아삭킹 체험단 발표</td>
								<td>관리자</td>
								<td>57</td>
								<td>2018.10.17</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="paginate">
                        <a href="#" class="btn-first" title="처음"><em class="blind">목록에서 처음 페이지 이동</em></a>
                        <a href="#" class="btn-prev" title="이전"><em class="blind">목록에서 이전 페이지 이동</em></a>
                        <span class="paging-numbers">
                            <a href="#">1<span class="blind">페이지로 이동</span></a>
                            <a href="#" class="on">2<span class="blind">페이지로 이동</span></a>
                            <a href="#">3<span class="blind">페이지로 이동</span></a>
                            <a href="#">4<span class="blind">페이지로 이동</span></a>
                            <a href="#">5<span class="blind">페이지로 이동</span></a>
                        </span>
                        <a href="#" class="btn-next" title="다음"><span class="spr"><em class="blind">목록에서 다음 페이지 이동</em></span></a>
                        <a href="#" class="btn-last" title="끝"><span class="spr"><em class="blind">목록에서 끝 페이지 이동</em></span></a>
                    </div>
	</div>
	<jsp:include page="../common/rightBoard.jsp" />
  </div>
  </div>
</body>
</html>