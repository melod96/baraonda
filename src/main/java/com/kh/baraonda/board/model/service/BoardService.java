package com.kh.baraonda.board.model.service;

import java.util.List;

import com.kh.baraonda.board.model.vo.Board;

public interface BoardService {
	
	//게시글 전체 목록 조회
	public List<Board> listAll() throws Exception;
}
