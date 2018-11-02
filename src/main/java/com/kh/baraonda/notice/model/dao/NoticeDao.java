package com.kh.baraonda.notice.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.notice.model.exception.NoticeException;

public interface NoticeDao {

	int selectNoticeListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pgif) throws NoticeException;

}
