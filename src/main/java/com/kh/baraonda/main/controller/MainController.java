package com.kh.baraonda.main.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.main.model.exception.NoticeSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.notice.model.vo.Notice;


@Controller
@SessionAttributes("main")
public class MainController {
	@Autowired
	private MainService ms;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Inject
	MainService mainService;

	//메인 리스트 조회
	@RequestMapping("main.m")
	public String selectMainView(Model model){
		//공지사항
		ArrayList<Notice> list;
		try {
			list = mainService.selectNotice();
			model.addAttribute("list", list);
			System.out.println(list.size());
			
			
			
			return "main/main";
			
		} catch (NoticeSelectListException e) {
			
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
		

	
}
	
	
/*	@RequestMapping(value = "/board/view", method = RequestMethod.GET)
	public String boardView(HttpServletRequest request, Model model) {
		logger.info("/view in");
		
		Integer boardIndex = Integer.parseInt(request.getParameter("boardIndex"));
		
		ArrayList<Board> boardList = boardDAO.selectByBoardIndex(boardIndex);
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		return "board/board_view";
	}*/
	
	
	

}
