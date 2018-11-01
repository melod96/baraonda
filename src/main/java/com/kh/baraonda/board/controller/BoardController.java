package com.kh.baraonda.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.service.BoardService;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;


	//게시글 전체 목록 조회
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mv, @RequestParam int writing_type) {
		List<HashMap<String, Object>> list;

		try {
			list = boardService.listAll(writing_type);

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

	//게시글 작성 페이지로 이동
	//@RequestMapping("board/wirte.do")
	//value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		System.out.println("write");
		return "board/boardWrite";//boardWrite.jsp로 이동
	}
	//게시글 작성처리
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute Board b) {
		try {
			boardService.create(b);
			
			return "redirect:list.do";
		} catch (Exception e) {
			
			return null;
		}
	}
	
	
	
	
	
	//게시글 상세보기(댓글 포함), 조회수 증가 처리
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int board_no, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//게시글 상세보기(제목,내용, 작성자, 날짜, 댓글수, 조회수) 
		HashMap<String, Object> detail;
		//댓글 조회(작성자, 내용, 날짜)
		List<HashMap<String, Object>> commentList;
		
		try {
			//조회수 증가처리
			boardService.increaseViewCnt(board_no, session);
			
			//상세보기 board_no값 넘겨줌
			detail = boardService.detail(board_no);
			commentList = boardService.commentList(board_no);		
			//뷰 이름
			mv.setViewName("board/boardPage");
			//뷰에 전달할 데이터
			mv.addObject("detail", detail);
			mv.addObject("commentList", commentList);
			
			
			return mv;
			
		} catch (BoardException e) {
			mv.setViewName("board/boardPage");
			mv.addObject("errorMessgae", "상세보기 조회 실패");

			return mv;
		}
	}
	
}































