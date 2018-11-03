package com.kh.baraonda.notice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.service.NoticeService;
import com.kh.baraonda.notice.model.vo.Notice;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	
	@RequestMapping("noticelist.nt")
	public String noticeListPage(Notice n, Model model, PageInfo pi) {
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		
		try {
			int listCount = ns.selectNoticeListCount();
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = ns.selectNoticeList(pgif);
			
			model.addAttribute("noticelist", list);
			System.out.println(list);
			
			return "notice/notice";
		} catch (NoticeException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
		
		
	}
}
