<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<script>
 $(document).ready(function(){

  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});
  $('.gallery .gall_item').touchTouch();

  }); 
</script>
<!--[if lt IE 9]>
 <div style=' clear: both; text-align:center; position: relative;'>
   <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
     <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
   </a>
</div>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="css/ie.css">


<![endif]-->
</head>

<body class="page1" id="top">
<!--==============================
              header
=================================-->
<header>
<!--==============================
            Stuck menu
=================================-->
  <section id="stuck_container">
    <div class="container">
      <div class="row">
        <div class="grid_12">
        <h1>
          <a href="index.html">
            <img src="images/logo.png" alt="Logo alt">
          </a>
        </h1>  
          <div class="navigation">
            <nav>
              <ul class="sf-menu">
               <li class="current"><a href="index.html">home</a></li>
               <li><a href="index-1.html">menu</a></li>
               <li><a href="index-2.html">reservation</a></li>
               <li><a href="index-3.html">blog</a></li>
               <li><a href="index-4.html">contacts</a></li>
             </ul>
            </nav>        
            <div class="clear"></div>
          </div>
        </div>
      </div>
    </div>
  </section> 
</header>        

<!--=====================
          Content
======================-->
<section class="content"><div class="ic">More Website Templates @ TemplateMonster.com - July 30, 2014!</div>
  <div class="container">
    <div class="row">
      <!-- 작업 공간-->
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <h2 class="text-left">글쓰기</h2><p></p>
        <form action="BoardReWriteProc.jsp" method="post">
            <div class="table table-responsive">
                      <table class="table table-striped">
            <tr>
                <td>카테고리</td>
                <td>
			<select class="form-control input-xshort">
                       		<option>자유게시판</option>
                        	<option>다이어트식단</option>
                    	</select>
		</td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text"  class="form-control" name="subject"></td>
            </tr>
	    <tr>
		<td colspan="2">내용</td>
	    </tr>
	    <tr>
                <td colspan="2"><textarea rows="10" cols="50" name="content" class="form-control"></textarea></td>
            </tr>
            <tr>  
                <td colspan="2"  class="text-center">
                 
                    <%-- <input type="hidden" name="num"  value="<%= num %>">
                    <input type="hidden" name="ref"  value="<%= ref %>">
                    <input type="hidden" name="ref_step"  value="<%= ref_step %>">
                    <input type="hidden" name="ref_level"  value="<%= ref_level %>"> --%>
                 
                    <input type="submit" value="작성하기" class="btn btn-success">
                    <input type="reset" value="취소" class="btn btn-warning">
                </td>
            </tr>
             
          </table>
         
     
            </div>
        </form>   
    </div>
</div>
 
      <!-- 작업 공간-->
    </div>
  </div>
</section>
<!--==============================
              footer
=================================-->
<footer id="footer">
  <div class="container">
    <div class="row">
      <div class="grid_12">  
        <div class="socials">
          <a href="#" class="fa fa-twitter"></a>
          <a href="#" class="fa fa-facebook"></a>
          <a href="#" class="fa fa-google-plus"></a>
          <a href="#" class="fa fa-pinterest"></a>
        </div>
        <div class="copyright"><span class="brand">Bliss </span> &copy; <span id="copyright-year"></span> | <a href="#">Privacy Policy</a> <div>Website designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a></div>
        </div>
      </div>
    </div>
  </div> 
</footer> 
</body>
</html>