package com.kh.baraonda.main.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.vo.Tips;


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
		ArrayList<Notice> nlist;
		//고객문의
		ArrayList<Board> qlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		//명예의전당
		ArrayList<Fame> flist;
		//다이어트꿀팁
		ArrayList<Tips> tlist;
		//프로필
		ArrayList<Tips> plist;
		try {
			nlist = mainService.selectNotice();
			model.addAttribute("nlist", nlist);
			System.out.println(nlist.size());
			
			qlist = mainService.selectQuestion();
			model.addAttribute("qlist", qlist);
			System.out.println(qlist.size());
		     
			rlist = mainService.selectRanking();
			model.addAttribute("rlist", rlist);
			System.out.println(rlist.size());
			
			flist = mainService.selectFame();
			model.addAttribute("flist", flist);
			System.out.println(flist.size());
			
			tlist = mainService.selectTips();
			model.addAttribute("tlist", tlist);
			System.out.println(tlist);
			System.out.println(tlist.size());
			
			plist = mainService.selectProfile();
			model.addAttribute("plist", plist);
			System.out.println(plist.size());

			return "main/main";
			
		} catch (MainSelectListException e) {
			
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
