package com.kh.baraonda.main.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.vo.Tips;


@Repository
public class MainDaoImpl implements MainDao{

	//메인 공지사항 select
	@Override
	public ArrayList<Notice> selectNotice(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("Main.selectNotice");
	}
	
	//메인 고객센터 select
	@Override
	public ArrayList<Board> selectQuestion(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("Main.selectQuestion");
	}
	
	//메인 다이어터랭킹 select
		@Override
		public ArrayList<Ranking> selectRanking(SqlSessionTemplate sqlSession) {
			return (ArrayList)sqlSession.selectList("Main.selectRanking");
		}
		
		//메인 명예의전당 select
			@Override
			public ArrayList<Fame> selectFame(SqlSessionTemplate sqlSession) {
				return (ArrayList)sqlSession.selectList("Main.selectFame");
				}

		//메인 다이어트꿀팁 select
			@Override
			public ArrayList<Tips> selectTips(SqlSessionTemplate sqlSession) {
				return (ArrayList)sqlSession.selectList("Main.selectTips");
				}
			
			//메인 베스트다이어터 select
			@Override
			public ArrayList<Ranking> selectBest(SqlSessionTemplate sqlSession) {
				return (ArrayList)sqlSession.selectList("Main.selectBest");
				}

}
