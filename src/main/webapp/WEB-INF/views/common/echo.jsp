<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../admin/commonAdmin/head.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/admin/js/sockjs-0.3.4.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#sendBtn").click(function() {
            sendMessage();
            $("#message").val('');
        });
    });

    var sock;
    sock = new SockJS("<c:url value="/echo"/>");

    sock.onmessage = onMessage;

    sock.onclose = onClose;

    function sendMessage() {
        sock.send("${ num }" + "|||"  + $("#message").val());
    }

    function onMessage(evt) {
        var data = evt.data;
        var arr = data.split('|||');
        
        if(arr[2] == ''){
        	arr[2] = '/resources/images/myPageImages/level.png';
        }
        
        var content = '';
        if(arr.length >= 5){
	        if(arr[0] == '${ num }'){
	        	content = '<li class="right clearfix">' +
						  	'<span class="chat-img pull-right">' +
								'<img src="${pageContext.request.contextPath}' + arr[2] + arr[3] + '" alt="User Avatar" class="img-circle" />' +
							'</span>' +
							'<div class="chat-body clearfix">' +
								'<div class="header">' +
									'<strong class="pull-right primary-font">' + arr[1] + '</strong>' +
							    '</div>' +
									'<p>' +
							        	arr[4] +
							        '</p>' +
							    '</div>' +
							'</li>';
	        }else{
	        	content = '<li class="left clearfix">' +
					      	'<span class="chat-img pull-left">' +
					      		'<img src="${pageContext.request.contextPath}' + arr[2] + arr[3] + '" alt="User Avatar" class="img-circle" />' +
					        '</span>' +
					        '<div class="chat-body clearfix">' +
					        	'<div class="header">' +
					                '<strong class="primary-font">' + arr[1] + '</strong>' +
					            '</div>' +
					            '<p>' +
					                arr[4] +
					            '</p>' +
					        '</div>' +
					      '</li>';
	        }
        }
        
        $("#data").append(content);
        //sock.close();
    }

    function onClose(evt) {
        $("#data").append("연결 끊김");
    }
</script>
<style>
	.img-circle {
		width: 50px;
		height: 50px;
	}
	#main-content {
		width: 700px;
	}
</style>
</head>
<body>
    <div id="wrapper">
        <div id="main-content">
            <div class="row">
                <div class="modal-header">
					<h4 class="modal-title">Chat</h4>
				</div>
				<div class="chat-panel panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<ul class="chat" id="data">
                        	
                        	</ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                                <input id="message" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                                <span class="input-group-btn">
                                    <button class="btn btn-warning btn-sm" id="sendBtn">
                                        Send
                                    </button>
                                </span>
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div>

            </div>
            <!-- /.row -->
        </div>

    </div>
    <!-- /#wrapper -->
    
</body>
</html>