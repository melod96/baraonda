package com.kh.baraonda.myPage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Comments;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Marking;
import com.kh.baraonda.myPage.model.vo.Orders;
import com.kh.baraonda.myPage.model.vo.Point;
import com.kh.baraonda.myPage.model.vo.PointRecord;
import com.kh.baraonda.myPage.model.vo.Message;

@Repository
public class MyPageDaoImpl implements MyPageDao {

	@Override
	public Point selectPoint(SqlSessionTemplate sqlSession, Member loginUser) {
		return sqlSession.selectOne("MyPage.selectPoint", loginUser);
	}

	@Override
	public int updateMemberInfo(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("MyPage.updateMemberInfo", m);
	}

	@Override
	public void insertPhoto(SqlSessionTemplate sqlSession, Files file) {
		sqlSession.insert("MyPage.insertPhoto", file);
	}

	@Override
	public Files selectPhoto(SqlSessionTemplate sqlSession, Member loginUser) {
		return (Files) sqlSession.selectOne("MyPage.selectPhoto", loginUser);
	}

	@Override
	public Footprints selectFootprints(SqlSessionTemplate sqlSession, Member loginUser) {
		return (Footprints) sqlSession.selectOne("MyPage.selectFootprints", loginUser);
	}

	@Override
	public int selectListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectListCount", member_no);
	}

	@Override
	public ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi, int member_no) {

		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		System.out.println(member_no);

		return (ArrayList) sqlSession.selectList("MyPage.selectBoardList", member_no, rowBounds);
	}

	@Override
	public ArrayList<Marking> selectLikeCount(SqlSessionTemplate sqlSession, int member_no) {
		return (ArrayList) sqlSession.selectList("MyPage.selectLikeCount", member_no);
	}

	@Override
	public int selectCommentsListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectCommentsListCount", member_no);
	}

	@Override
	public ArrayList<Comments> selectCommentList(SqlSessionTemplate sqlSession, PageInfo cPi, int member_no) {

		int offset = (cPi.getCurrentPage() - 1) * cPi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, cPi.getLimit());

		return (ArrayList) sqlSession.selectList("MyPage.selectCommentList", member_no, rowBounds);
	}

	@Override
	public int selectBookMarkListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectBookMarkListCount", member_no);
	}

	@Override
	public ArrayList<Marking> selectBookMarkList(SqlSessionTemplate sqlSession, PageInfo bPi, int member_no) {

		int offset = (bPi.getCurrentPage() - 1) * bPi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, bPi.getLimit());

		return (ArrayList) sqlSession.selectList("MyPage.selectBookMarkList", member_no, rowBounds);
	}

	@Override
	public int selectPointListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectPointListCount", member_no);
	}

	@Override
	public ArrayList<PointRecord> selectPointList(SqlSessionTemplate sqlSession, PageInfo pPi, int member_no) {

		int offset = (pPi.getCurrentPage() - 1) * pPi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pPi.getLimit());

		return (ArrayList) sqlSession.selectList("MyPage.selectPointList", member_no, rowBounds);
	}

	@Override
	public int selectChangeGoodsListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectChangeGoodsListCount", member_no);
	}

	@Override
	public ArrayList<Orders> selectChangeGoodsList(SqlSessionTemplate sqlSession, PageInfo gPi, int member_no) {

		int offset = (gPi.getCurrentPage() - 1) * gPi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, gPi.getLimit());

		return (ArrayList) sqlSession.selectList("MyPage.selectChangeGoodsList", member_no, rowBounds);
	}

	@Override
	public Member selectMemberView(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectMemberView", member_no);
	}

	@Override
	public ArrayList<Product> selectProductList(SqlSessionTemplate sqlSession) {

		return (ArrayList) sqlSession.selectList("MyPage.selectProductList");
	}

	@Override
	public void updateEmail(SqlSessionTemplate sqlSession, Member m) {
		System.out.println("dao : " + m.getEmail());
		System.out.println("dao : " + m.getMember_no());
		sqlSession.update("MyPage.updateEmail", m);

	}

	@Override
	public void updateNick(SqlSessionTemplate sqlSession, Member loginUser) {
		sqlSession.update("MyPage.updateNick", loginUser);
	}

	@Override
	public void updatePwd(SqlSessionTemplate sqlSession, Member loginUser) {
		sqlSession.update("MyPage.updatePwd", loginUser);
	}

	@Override
	public int selectId(SqlSessionTemplate sqlSession, Member m) {
		return ((ArrayList)sqlSession.selectList("MyPage.selectId", m)).size();
	}

	@Override
	public int selectPwd(SqlSessionTemplate sqlSession, Member m) {
		System.out.println("name, email : " + m.getName() + m.getEmail());
		return ((ArrayList)sqlSession.selectList("MyPage.selectPwd", m)).size();
	}
	
	@Override
	public void updatePwd2(SqlSessionTemplate sqlSession, Member m) {
		sqlSession.update("MyPage.updatePwd2", m);
	}
	
	@Override
	public void updateDelPhoto(SqlSessionTemplate sqlSession, int member_no) {
		sqlSession.update("MyPage.updateDelPhoto", member_no);
	}

	@Override
	public void updateStatus(SqlSessionTemplate sqlSession, int member_no) {
		sqlSession.update("MyPage.updateStatus", member_no);
	}
	
	@Override
	public int selectMessageListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectMessageListCount", member_no);
	}	

	@Override
	public ArrayList<Message> selectMessageList(SqlSessionTemplate sqlSession, PageInfo pi, int member_no) {

		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		return (ArrayList) sqlSession.selectList("MyPage.selectMessageList", member_no, rowBounds);
	}

	@Override
	public int selectNicksNo(SqlSessionTemplate sqlSession, String receive_nickname){
		Member m = sqlSession.selectOne("MyPage.selectNicksNo", receive_nickname);
		System.out.println("m : " + m);
		System.out.println("no :" + m.getMember_no());
		return m.getMember_no();
	}
	
	@Override
	public void insertMsg(SqlSessionTemplate sqlSession, Message msg){
		sqlSession.insert("MyPage.insertMsg", msg);
	}
	
	@Override
	public Message selectMsgOne(SqlSessionTemplate sqlSession, int message_no){
		return sqlSession.selectOne("MyPage.selectMsgOne",message_no);
	}
}
