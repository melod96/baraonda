package com.kh.baraonda.myPage.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.dao.MyPageDao;
import com.kh.baraonda.myPage.model.vo.Comments;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Marking;
import com.kh.baraonda.myPage.model.vo.Message;
import com.kh.baraonda.myPage.model.vo.Orders;
import com.kh.baraonda.myPage.model.vo.Point;
import com.kh.baraonda.myPage.model.vo.PointRecord;

@Service
public class MyPageServiceImpl implements MyPageService{

	
	@Autowired //의존성 주입을 위함.
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MyPageDao mpd;
	
	@Override
	public Point selectPoint(Member loginUser) {
		return mpd.selectPoint(sqlSession, loginUser);
	}

	@Override
	public int updateMemberInfo(Member m) {
		return mpd.updateMemberInfo(sqlSession, m);
	}

	@Override
	public void insertPhoto(Files file) {
		mpd.insertPhoto(sqlSession, file);
	}

	@Override
	public Files selectPhoto(Member loginUser) {
		return mpd.selectPhoto(sqlSession, loginUser);
	}

	@Override
	public Footprints selectFootprints(Member loginUser) {
		return mpd.selectFootprints(sqlSession, loginUser);
	}

	@Override
	public int selectListCount(int id) {
		return mpd.selectListCount(sqlSession, id);
	}

	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi, int member_no) {
		System.out.println("service실행");
		return mpd.selectBoardList(sqlSession,pi, member_no);
	}

	@Override
	public ArrayList<Marking> selectLikeCount(int member_no) {
		return mpd.selectLikeCount(sqlSession, member_no);
	}

	@Override
	public int selectCommentsListCount(int member_no) {
		return mpd.selectCommentsListCount(sqlSession, member_no);
	}

	@Override
	public ArrayList<Comments> selectCommentList(PageInfo cPi, int member_no) {
		return mpd.selectCommentList(sqlSession,cPi, member_no);
	}

	@Override
	public int selectBookMarkListCount(int member_no) {
		return mpd.selectBookMarkListCount(sqlSession, member_no);
	}

	@Override
	public ArrayList<Marking> selectBookMarkList(PageInfo bPi, int member_no) {
		return mpd.selectBookMarkList(sqlSession,bPi, member_no);
	}

	@Override
	public int selectPointListCount(int member_no) {
		return mpd.selectPointListCount(sqlSession, member_no);
	}

	@Override
	public ArrayList<PointRecord> selectPointList(PageInfo pPi, int member_no) {
		return mpd.selectPointList(sqlSession,pPi, member_no);
	}

	@Override
	public int selectChangeGoodsListCount(int member_no) {
		return mpd.selectChangeGoodsListCount(sqlSession, member_no);
	}

	@Override
	public ArrayList<Orders> selectChangeGoodsList(PageInfo gPi, int member_no) {
		return mpd.selectChangeGoodsList(sqlSession,gPi, member_no);
	}

	@Override
	public Member selectMemberView(int member_no) {
		return mpd.selectMemberView(sqlSession, member_no);
	}

	@Override
	public ArrayList<Product> selectProductList() {
		
		return mpd.selectProductList(sqlSession);
	}

	@Override
	public void updateEmail(Member m) {
		mpd.updateEmail(sqlSession, m);
		
	}

	@Override
	public void updateNick(Member loginUser) {
		mpd.updateNick(sqlSession, loginUser);
	}

	@Override
	public void updatePwd(Member loginUser) {
		mpd.updatePwd(sqlSession, loginUser);
	}

	@Override
	public int selectId(Member m) {
		return mpd.selectId(sqlSession,m);
	}

	@Override
	public int selectPwd(Member m) {
		return mpd.selectPwd(sqlSession,m);
	}

	@Override
	public void updatePwd2(Member m) {
		mpd.updatePwd2(sqlSession, m);
	}

	@Override
	public void updateDelPhoto(int member_no) {
		mpd.updateDelPhoto(sqlSession, member_no);
	}	

	@Override
	public void updateStatus(int member_no) {
		mpd.updateStatus(sqlSession, member_no);
	}	

	@Override
	public int selectMessageListCount(int member_no) {
		return mpd.selectMessageListCount(sqlSession, member_no);
	}

	@Override
	public ArrayList<Message> selectMessageList(PageInfo pi, int member_no) {
		return mpd.selectMessageList(sqlSession, pi, member_no);
	}
	
	@Override	
	public int selectNicksNo(String receive_nickname){
		return mpd.selectNicksNo(sqlSession, receive_nickname);
	}
	
	@Override
	public void insertMsg(Message msg){
		mpd.insertMsg(sqlSession, msg);
	}
	
	@Override
	public Message selectMsgOne(int message_no){
		return mpd.selectMsgOne(sqlSession, message_no);
	}
}
