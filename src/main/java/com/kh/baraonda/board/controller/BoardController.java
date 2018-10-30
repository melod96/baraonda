package com.kh.baraonda.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kh.baraonda.board.model.service.BoardService;
import com.kh.baraonda.board.model.vo.Board;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;

	//게시글 전체 목록 조회
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		List<Board> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();

		System.out.println("list : " + list);

		mav.setViewName("board/board");
		mav.addObject("list", list);

		return mav;

	}

}































