<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    //웸소켓을 지정한 url로 연결한다.
    sock = new SockJS("<c:url value="/echo"/>");

    //자바스크립트 안에 function을 집어넣을 수 있음.
    //데이터가 나한테 전달되읐을 때 자동으로 실행되는 function
    sock.onmessage = onMessage;

    //데이터를 끊고싶을때 실행하는 메소드
    sock.onclose = onClose;

    /* sock.onopen = function(){
        sock.send($("#message").val());
    }; */

    function sendMessage() {
        /*소켓으로 보내겠다.  */
        sock.send("${ loginUser.member_no }" + "|||"  + $("#message").val());
    }

    //evt 파라미터는 웹소켓을 보내준 데이터다.(자동으로 들어옴)
    function onMessage(evt) {
        var data = evt.data;
        var arr = data.split('|||');
        for ( var i in arr ) {
        	console.log(arr[i]);
        }
        console.log("arr길이" + arr.length)
        
        if(arr[2] == ''){
        	arr[2] = '/resources/images/myPageImages/level.png';
        }
        
        var content = '';
        if(arr.length >= 5){
	        if(arr[0] == '${ loginUser.member_no }'){
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
	.chat-button {
		
	}
</style>
<div class="container">
	<!-- Trigger the modal with a button -->
	<button type="button" class="btn btn-info btn-lg chat-button" data-toggle="modal"
		data-target="#myModal">Open Modal</button>

	<!-- Modal -->
	<div class="modal" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Chat</h4>
				</div>
				<div class="chat-panel panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
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
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

</div>