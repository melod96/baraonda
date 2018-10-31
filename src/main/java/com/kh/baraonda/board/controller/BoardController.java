package com.kh.baraonda.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.service.BoardService;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;


	//게시글 전체 목록 조회
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mv) {
		List<HashMap<String, Object>> list;

		try {
			list = boardService.listAll();

			mv.setViewName("board/board");
			mv.addObject("list", list);
			
			//System.out.println("list : " + list);
			return mv;

		} catch (BoardException e) {
			mv.setViewName("board/board");
			mv.addObject("errorMessgae", "리스트 조회 실패");

			return mv;
		}
	}

	//게시글 작성
	//@RequestMapping("board/wirte.do")
	//value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/boardWrite";//boardWrite.jsp로 이동
	}

}































