package com.kh.baraonda.myPage.model.service;

import java.util.ArrayList;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Comments;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Marking;
import com.kh.baraonda.myPage.model.vo.Point;

public interface MyPageService {

	Point selectPoint(Member loginUser);

	int updateMemberInfo(Member m);

	void insertPhoto(Files file);

	Files selectPhoto(Member loginUser);

	Footprints selectFootprints(Member loginUser);

	int selectListCount(int member_no);

	ArrayList<Board> selectBoardList(PageInfo pi, int member_no);

	ArrayList<Marking> selectLikeCount(int member_no);

	int selectCommentsListCount(int member_no);

	ArrayList<Comments> selectCommentList(PageInfo cPi, int member_no);



}
