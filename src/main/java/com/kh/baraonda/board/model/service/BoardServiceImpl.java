package com.kh.baraonda.board.model.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.dao.BoardDao;
import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	BoardDao boardDao;
	
	@Autowired //의존성 주입을 위함.
	private SqlSessionTemplate sqlSession;
	
	//게시글 전체 목록 조회
	@Override
	public List<HashMap<String, Object>> listAll() throws BoardException {
		List<HashMap<String, Object>> list = boardDao.listAll(sqlSession) ;
		
		return list;
	}
	
	//게시글 작성
	@Override
	public void create(Board b, Member m) throws Exception {
		String title = b.getBoard_title();
		String content = b.getBoard_content();
		String writer = m.getNick_name();
		//*태그문자 처리(<==> &it; > == > &gt;)
		//replace(A,B)A를 B로 변경
		title = title.replace("<", "&It");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&It;");
		writer = writer.replace("<", "&gt;");
		//*공백문자 처리
		title = title.replace(" ", "&nbsp;&nbsp;");
		writer = writer.replace(" ", "&nbsp;&nbsp;");
		//*줄바꿈 문자 처리
		content = content.replace("\n", "<br>");
		b.setBoard_title(title);
		b.setBoard_content(content);
		m.setNick_name(writer);
		boardDao.create(b, m);
		
		
	}
}
