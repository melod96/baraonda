package com.kh.baraonda.notice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.service.NoticeService;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	//공지사항 리스트 출력
	@RequestMapping("noticelist.nt")
	public String noticeListPage(Model model, PageInfo pi) {
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		
		try {
			int listCount = ns.selectNoticeListCount();
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Notice> list = ns.selectNoticeList(pgif);
			
			model.addAttribute("noticelist", list);
			model.addAttribute("pi", pgif);
			
			return "notice/notice";
		} catch (NoticeException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
		
		
	}
	
	//공지사항 상세보기
	@RequestMapping("noticeDetail.nt")
	public String noticeDetail(String notice_no, Model model, PageInfo pi) {
		
		Notice ninfo = ns.selectNoticeOne(notice_no);
		
		//댓글
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		int listCount = ns.selectCommentListCount(notice_no);
		
		PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<NoticeComment> comment = ns.selectComment(notice_no,pgif);
		
		model.addAttribute("ninfo", ninfo);
		model.addAttribute("pi",pgif);
		model.addAttribute("comment", comment);
		model.addAttribute("cCount", listCount);
		
		return "notice/noticeDetail";
	}
	
	//공지사항 검색
	@RequestMapping("searchNotice.nt")
	public String searchNotice(String searchtype, String search, Model model, PageInfo pi) {
		SearchCondition sc = new SearchCondition();
		
		if(searchtype.equals("title")) {
			sc.setTitle(search);
		}
		if(searchtype.equals("content")) {
			sc.setContent(search);
		}
		if(searchtype.equals("writer")){
			sc.setWriter(search);
		}
		
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		int listCount = ns.searchNoticeCount(sc);
		
		PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Notice> list = ns.searchNoticeList(sc,pgif);
		
		model.addAttribute("noticelist", list);
		model.addAttribute("pi", pgif);
		model.addAttribute("search", search);
		
		return "notice/notice";
	}
	
	//공지사항 작성 페이지
	@RequestMapping("noticeWrite.nt")
	public String noticeWrite() {
		return "notice/noticeWrite";
	}
	
	//공지사항 insert
	@RequestMapping("insertNotice.nt")
	public String insertNotice(@SessionAttribute("loginUser") Member m,String title, String content, Model model) {
		Notice n = new Notice();
		
		if(title != null && content != null && m != null) {
			n.setBoard_title(title);
			n.setBoard_content(content);
			n.setMember_no(m.getMember_no());
		}
		
		int insert = ns.insertNotice(n);
		
		if(insert > 0) {
			return "redirect:noticelist.nt";			
		}else {
			model.addAttribute("msg","공지사항 등록 실패");
			return "common/errorPage";
			
		}
		
	}
	
	//공지사항 delete
	@RequestMapping("deleteNotice.nt")
	public String deleteNotice(String notice_no) {
		int delete = ns.deleteNotice(notice_no);
		
		return "redirect:noticelist.nt";
	}
	
}
