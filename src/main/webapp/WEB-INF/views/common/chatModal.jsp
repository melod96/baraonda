<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="chat-modal">
  <div class="modal-dialog">
    <div class="modal-content" style="height:500px;">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">채팅</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		<button class="btn btn-default" id="createChannel" style="margin:0; width:230px; height:230px;" onclick = "location.href='createCannel.ch'">
            <span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span> 채널 생성하기
        </button>
          
        <button class="btn btn-default" id="connectChannel" style="margin:0;width:230px; height:230px;" onclick = "location.href='connectCannel.ch'">
            <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 채널 연결하기
        </button>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>