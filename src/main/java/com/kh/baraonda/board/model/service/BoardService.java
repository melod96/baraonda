package com.kh.baraonda.board.model.service;

import java.util.List;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

public interface BoardService {
	
	//게시글 전체 목록 조회
	public List<Board> listAll() throws Exception;
	
	//게시글 작성
	public void create(Board b, Member m) throws Exception;
}
