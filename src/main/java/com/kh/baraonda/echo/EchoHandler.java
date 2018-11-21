package com.kh.baraonda.echo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.baraonda.admin.model.vo.AdminBoard;
import com.kh.baraonda.admin.model.vo.Member;

public class EchoHandler extends TextWebSocketHandler {
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	// 클라이언트와 연결 이후에 실행되는 메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.info("{} 연결됨", session.getId());
	}

	// 클라이언트가 서버로 메시지를 전송했을 때 실행되는 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
		ChatController cc = new ChatController();
		
		String result = "";
		String data = message.getPayload();
		String member_no = data.substring(0, data.lastIndexOf("|||"));
		String content = data.substring(data.lastIndexOf("|||") + 3);
		AdminBoard adminBoard = new AdminBoard(member_no, null, content);
		if(member_no.trim().length() > 0) {
			try {
				Member member = cc.doEcho(adminBoard); 
				result += member.getMember_no() + "|||" + member.getNick_name() + "|||" + member.getFiles_root() + "|||" + member.getFiles_change_title();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		result += "|||" + content;
		for (WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(result));
		}
	}

	// 클라이언트와 연결을 끊었을 때 실행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} 연결 끊김", session.getId());
	}
}
