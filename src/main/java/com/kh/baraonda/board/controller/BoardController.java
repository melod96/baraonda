package com.kh.baraonda.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<Board> list = boardService.listAll();

		/*for(int i = 0; i < list.size(); i++) {
			System.out.println("게시물 : " + list);
		}*/
		
		mv.setViewName("board/board");
		mv.addObject("list", list);

		return mv;
	}
	
	//게시글 작성
	//@RequestMapping("board/wirte.do")
	//value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/boardWrite";//boardWrite.jsp로 이동
	}
	
}































