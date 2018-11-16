package com.kh.baraonda.experience.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.common.PaginationComment;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.experience.model.service.ExperienceService;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

@Controller
public class ExperienceController {
	@Autowired
	private MainService ms;
	
	@Autowired
	private ExperienceService es;
	
	@RequestMapping("experiencePage.ep")
	public String experiencePage(Model model,PageInfo pi) {
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		int listCount = es.selectExperienceListCount();
		
		PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
		
		try {
			ArrayList<Tips> list = es.selectExperienceList(pgif);
			
			model.addAttribute("tipslist", list);
			model.addAttribute("pi", pgif);
			return "experience/experience";
		} catch (ExperienceSelectListException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("experienceDetail.ep")
	public String experienceDetail(String experience_no, Model model, PageInfo pi) {
		Tips tinfo = es.selectExperienceOne(experience_no);
		
		int heartCount = es.selectHeartExperience(experience_no);
		
		
		//댓글
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		int listCount = es.selectCommentListCount(experience_no);
		
		PageInfo pgif = PaginationComment.getPageInfo(currentPage, listCount);
		
		ArrayList<TipsComment> tcomment = es.selectCommentList(experience_no,pgif);
		
		//이전글 | 다음글
		Tips nextBoard = es.selectNextNo(experience_no);
		Tips beforeBoard = es.selectBeforeNo(experience_no);
		
		model.addAttribute("tinfo", tinfo);
		model.addAttribute("pi",pgif);
		model.addAttribute("tcomment", tcomment);
		model.addAttribute("cCount", listCount);
		model.addAttribute("hcount", heartCount);
		model.addAttribute("before", beforeBoard);
		model.addAttribute("next", nextBoard);
		
		return "tips/tipsDetail";
	}
}
