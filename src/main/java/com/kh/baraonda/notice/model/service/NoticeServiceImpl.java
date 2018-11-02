package com.kh.baraonda.notice.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.notice.model.dao.NoticeDao;
import com.kh.baraonda.notice.model.exception.NoticeException;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private NoticeDao nd;
	
	@Override
	public int selectNoticeListCount() {
		
		return nd.selectNoticeListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectNoticeList(PageInfo pgif) throws NoticeException {
		
		return nd.selectNoticeList(sqlSession, pgif);
	}

}
