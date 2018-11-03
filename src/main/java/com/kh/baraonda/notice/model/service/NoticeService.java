package com.kh.baraonda.notice.model.service;

import java.util.ArrayList;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.notice.model.exception.NoticeException;

public interface NoticeService {

	int selectNoticeListCount();

	ArrayList<Board> selectNoticeList(PageInfo pgif) throws NoticeException;

}
