package com.kh.baraonda.main.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.vo.Tips;

public interface MainDao {

	
	//메인 공지사항 select
	ArrayList<Notice> selectNotice(SqlSessionTemplate sqlSession);
	//메인 고객센터 select
	ArrayList<Board> selectQuestion(SqlSessionTemplate sqlSession);
	//메인 다이어터랭킹
	ArrayList<Ranking> selectRanking(SqlSessionTemplate sqlSession);
	//메인 명예의전당
	ArrayList<Fame> selectFame(SqlSessionTemplate sqlSession);
	//메인 다이어트꿀팁
	ArrayList<Tips> selectTips(SqlSessionTemplate sqlSession);
	
}
