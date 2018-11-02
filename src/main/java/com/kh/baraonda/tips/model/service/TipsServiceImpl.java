/*package com.kh.baraonda.tips.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.dao.TipsDao;



@Service
public class TipsServiceImpl {
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private TipsDao td;
	
	
	//다이어트꿀팁 목록 조회
		@Override
		public ArrayList<Notice> selectTipsList() throws MainSelectListException {
			
			return md.selectNotice(sqlSession);
		}

}
*/