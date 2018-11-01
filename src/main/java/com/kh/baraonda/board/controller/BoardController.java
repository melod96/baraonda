package com.kh.baraonda.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.service.BoardService;

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

	//게시글 작성
	//@RequestMapping("board/wirte.do")
	//value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		System.out.println("write");
		return "board/boardWrite";//boardWrite.jsp로 이동
	}
	
	//게시글 상세 보기, 조회수 증가 처리
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int board_no, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		/*List<HashMap<String, Object>> detail;*/
		HashMap<String, Object> detail;
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































