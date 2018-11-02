package com.kh.baraonda.main.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.main.model.dao.MainDao;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.vo.Tips;


@Service
public class MainServiceImpl implements MainService{
@Autowired
private SqlSessionTemplate sqlSession;
@Autowired
private MainDao md;
	
	//메인 공지사항 select
	@Override
	public ArrayList<Notice> selectNotice() throws MainSelectListException {
		
		return md.selectNotice(sqlSession);
	}
	
	//메인 고객센터 select
	@Override
	public ArrayList<Board> selectQuestion() throws MainSelectListException {
		
		return md.selectQuestion(sqlSession);
	}
	
	//메인 다이어터랭킹
	@Override
	public ArrayList<Ranking> selectRanking() throws MainSelectListException {
		
		return md.selectRanking(sqlSession);
	}
	
	//메인 명예의전당
		@Override
		public ArrayList<Fame> selectFame() throws MainSelectListException {
			
			return md.selectFame(sqlSession);
		}
		
	//메인 다이어트 꿀팁
		@Override
		public ArrayList<Tips> selectTips() throws MainSelectListException {
			
			return md.selectTips(sqlSession);
		}
		
		//메인 베스트 다이어터
				@Override
				public ArrayList<Ranking> selectBest() throws MainSelectListException {
					
					return md.selectBest(sqlSession);
				}
	


}

