package com.kh.baraonda.echo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.baraonda.admin.model.vo.AdminBoard;
import static com.kh.baraonda.echo.Template.*;

public class EchoHandler extends TextWebSocketHandler {
   private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
   private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      sessionList.add(session);
      logger.info("{} 연결됨", session.getId());
   }

   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
      SqlSession sqlSession = getSqlSession();
      
      String result = "";
      String data = message.getPayload();
      String member_no = data.substring(0, data.lastIndexOf("|||"));
      String content = data.substring(data.lastIndexOf("|||") + 3);
      AdminBoard adminBoard = new AdminBoard(member_no, null, content);
      if(member_no.trim().length() > 0) {
         try {
        	 sqlSession.insert("Chat.insertChat", adminBoard);
        	 Map<String, Object> member = sqlSession.selectOne("Chat.selectMemberForChat", member_no);
        	 result += member.get("MEMBER_NO") + "|||" + member.get("NICK_NAME") + "|||" + member.get("FILES_ROOT") + "|||" + member.get("FILES+CHANGE_TITLE");
         }catch(Exception e){
            e.printStackTrace();
         }
      }
      result += "|||" + content;
      for (WebSocketSession sess : sessionList) {
         sess.sendMessage(new TextMessage(result));
      }
   }

   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      sessionList.remove(session);
      logger.info("{} 연결 끊김", session.getId());
   }
}