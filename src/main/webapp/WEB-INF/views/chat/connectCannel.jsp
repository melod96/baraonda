<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>화상채팅</title>
  <meta charset="utf-8">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .local-video {
      width: 320px;
      height: 240px;
      z-index: 10;
      position: relative;
      border:1px solid black;
    }
    .remote-video {
      margin-top: 20px;
      margin-bottom: 20px;
      width: 320px;
      height: 240px;
      border:1px solid black;
      margin-left:15px;
    }
    .title {
	border-bottom: 2px solid #5d5d5d;
	font-size: 30px;
}
  </style>
</head>

<body>
<jsp:include page="header.jsp" />
	<div class="clear" style="height:40px;background:white;"></div>
  <div class="container">
    <div class="row">

      <div class="left">
		<jsp:include page="../common/banner.jsp" />
		<h2 class="title">화상채팅</h2>
		<div class="col-md-6">
        <h2 class="h3">채널 입장하기</h2>
        <h3 class="h4">채널ID를 입력하세요</h3>
        <form class="form-inline" style="flex-flow:inherit;">
          <div class="form-group">
            <label class="sr-only" for="connectChannelId">Channel Id</label>
            <input class="form-control" type="text" id="connectChannelId" placeholder="채널 ID를 입력해주세요" value="">
          </div>
          <button class="btn btn-default" id="connectChannel" style="margin:0;">
            <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 채널 연결하기
          </button>
        </form>

        <div style="width:700px;">
        <video class="local-video pull-right" id="calleeLocalVideo"></video>
	        <video class="remote-video center-block" id="calleeRemoteVideo"></video>
        </div>

      </div>
  </div>

      


    </div>
  </div>

  <!--<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>-->
  <!--<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->

 <!--  <script src="http://www.playrtc.com/sdk/js/playrtc.js"></script>  -->
 <script src="${pageContext.request.contextPath}/resources/js/playrtc.js"></script>
  <script>
    'use strict';
    var createChannelButton = document.querySelector('#createChannel');
    var createChannelId = document.querySelector('#createChannelId');
    var appCaller;
    appCaller = new PlayRTC({
      projectKey: "60ba608a-e228-4530-8711-fa38004719c1",
      localMediaTarget: "callerLocalVideo",
      remoteMediaTarget: "callerRemoteVideo"
    });
    appCaller.on('connectChannel', function(channelId) {
      createChannelId.value = channelId;
    });
    createChannelButton.addEventListener('click', function(e) {
      e.preventDefault();
      appCaller.createChannel();
    }, false);
  </script>
  <script>
    'use strict';
    var connectChannelId = document.querySelector('#connectChannelId');
    var connectChannelButton = document.querySelector('#connectChannel');
    var appCallee;
    appCallee = new PlayRTC({
      projectKey: "60ba608a-e228-4530-8711-fa38004719c1",
      localMediaTarget: "calleeLocalVideo",
      remoteMediaTarget: "calleeRemoteVideo"
    });
    connectChannelButton.addEventListener('click', function(e) {
      e.preventDefault();
      var channelId = connectChannelId.value;
      if (!channelId) { return };
      appCallee.connectChannel(channelId);
    }, false);
  </script>
  <jsp:include page="../common/footer.jsp"/>
  
</body>
</html>