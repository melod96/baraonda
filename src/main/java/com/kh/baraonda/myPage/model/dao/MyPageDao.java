package com.kh.baraonda.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

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

public interface MyPageDao {

	Point selectPoint(SqlSessionTemplate sqlSession, Member loginUser);

	int updateMemberInfo(SqlSessionTemplate sqlSession, Member m);

	void insertPhoto(SqlSessionTemplate sqlSession, Files file);

	Files selectPhoto(SqlSessionTemplate sqlSession, Member loginUser);

	Footprints selectFootprints(SqlSessionTemplate sqlSession, Member loginUser);

	int selectListCount(SqlSessionTemplate sqlSession, int id);

	ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi, int member_no);

	ArrayList<Marking> selectLikeCount(SqlSessionTemplate sqlSession, int member_no);

	int selectCommentsListCount(SqlSessionTemplate sqlSession, int member_no);

	ArrayList<Comments> selectCommentList(SqlSessionTemplate sqlSession, PageInfo cPi, int member_no);

	int selectBookMarkListCount(SqlSessionTemplate sqlSession, int member_no);

	ArrayList<Marking> selectBookMarkList(SqlSessionTemplate sqlSession, PageInfo bPi, int member_no);

	int selectPointListCount(SqlSessionTemplate sqlSession, int member_no);

	ArrayList<PointRecord> selectPointList(SqlSessionTemplate sqlSession, PageInfo pPi, int member_no);

	int selectChangeGoodsListCount(SqlSessionTemplate sqlSession, int member_no);

	ArrayList<Orders> selectChangeGoodsList(SqlSessionTemplate sqlSession, PageInfo gPi, int member_no);

	Member selectMemberView(SqlSessionTemplate sqlSession, int member_no);

	ArrayList<Product> selectProductList(SqlSessionTemplate sqlSession);

	void updateEmail(SqlSessionTemplate sqlSession, Member m);

	void updateNick(SqlSessionTemplate sqlSession, Member loginUser);

	void updatePwd(SqlSessionTemplate sqlSession, Member loginUser);

	int selectId(SqlSessionTemplate sqlSession, Member m);





}
