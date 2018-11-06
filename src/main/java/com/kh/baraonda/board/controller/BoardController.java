package com.kh.baraonda.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.service.BoardService;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.notice.model.vo.NoticeComment;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;


	//게시글 전체 목록 조회
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mv, @RequestParam int writing_type, PageInfo pi) {
		int currentPage = 1;

		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}

		List<HashMap<String, Object>> list;

		try {
			int listCount = boardService.selectBoardListCount();

			PageInfo info = Pagination.getPageInfo(currentPage, listCount);

			list = boardService.listAll(writing_type, info);

			mv.setViewName("board/board");
			mv.addObject("list", list);
			mv.addObject("pi", info);

			return mv;

		} catch (BoardException e) {
			mv.setViewName("board/board");
			mv.addObject("errorMessgae", "리스트 조회 실패");

			return mv;
		}
	}
	
	//게시글 상세보기(댓글 포함), 조회수 증가 처리
	@RequestMapping(value="view.do")
	public ModelAndView view(@RequestParam int board_no, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//게시글 상세보기(제목, 내용, 작성자, 날짜, 댓글수, 조회수) 
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

	//게시글 작성 페이지로 이동
	//@RequestMapping("board/write.do")
	//value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/boardWrite";
	}
	
	//게시글 작성처리
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(HttpSession session,
			@ModelAttribute Board b, HttpServletRequest request) {
		try {
			boardService.create(b);

			return "redirect:list.do?writing_type=1";
		} catch (Exception e) {

			return "common/errorPage";
		}
	}
	
	//게시물 수정
	@RequestMapping(value="updateBoardPage.do")
	public ModelAndView updateBoardPage(@RequestParam int board_no) {
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> detail;
		try {
			detail = boardService.detail(board_no);
			//뷰 이름
			mv.setViewName("board/boardUpdate");
			//뷰에 전달할 데이터
			mv.addObject("detail", detail);

			return mv;

		} catch (BoardException e) {
			mv.setViewName("board/boardUpdate");
			mv.addObject("errorMessgae", "게시물 수정 실패");

			return mv;
		}
	}
	
	//게시물 update
	@RequestMapping(value="updateBoard.do")
	public String updateBoard(@SessionAttribute("loginUser") Member m, @ModelAttribute Board b) {

		try {
			b.setMember_no(m.getMember_no());

			boardService.updateBoard(b);

			return "redirect:list.do?writing_type=1";
		} catch (Exception e) {

			return "common/errorPage";
		}
	}
	//게시물 delete
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(@RequestParam int board_no) {
		try {
			boardService.deleteBoard(board_no);
			
			return "redirect:list.do?writing_type=1";
			
		} catch (BoardException e) {
			return "common/errorPage";
		}
		
	}
	//댓글 insert
	@RequestMapping("insertComment.do")
	public String insertComment(@SessionAttribute("loginUser") Member m, Comments c, Model model) {
		c.setMEMBER_NO(m.getMember_no());
		
		int insert = boardService.insertComment(c);
		
		return "redirect:view.do?board_no="+c.getBOARD_NO();
	}
	

}































