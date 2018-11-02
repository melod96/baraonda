package com.kh.baraonda.main.model.service;

import java.util.ArrayList;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.vo.Tips;


public interface MainService {
	//메인 공지 select
	ArrayList<Notice> selectNotice() throws MainSelectListException;
	//메인 고객문의 select
	ArrayList<Board> selectQuestion() throws MainSelectListException;
	//메인 다이어터랭킹 select
	ArrayList<Ranking> selectRanking() throws MainSelectListException;
	//메인 명예의전당 select
	ArrayList<Fame> selectFame() throws MainSelectListException;
	//메인 다이어트꿀팁 select
	ArrayList<Tips> selectTips() throws MainSelectListException;
	//메인 베스트다이어터 select
	ArrayList<Ranking> selectBest() throws MainSelectListException;

}
