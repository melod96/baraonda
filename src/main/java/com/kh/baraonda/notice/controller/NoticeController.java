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
import com.kh.baraonda.notice.model.vo.NoticeMarking;

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
		
		int heartCount = ns.selectHeart(notice_no);
		
		//댓글
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		int listCount = ns.selectCommentListCount(notice_no);
		
		PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<NoticeComment> comment = ns.selectComment(notice_no,pgif);
		
		//이전글 | 다음글
		Notice nextBoard = ns.selectNextBoard(notice_no);
		Notice beforeBoard = ns.selectBeforeBoard(notice_no);
		
		model.addAttribute("ninfo", ninfo);
		model.addAttribute("pi",pgif);
		model.addAttribute("comment", comment);
		model.addAttribute("cCount", listCount);
		model.addAttribute("hcount", heartCount);
		model.addAttribute("before", beforeBoard);
		model.addAttribute("next", nextBoard);
		
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
	public String insertNotice(@SessionAttribute("loginUser") Member m,Notice n, Model model) {
		
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
	
	//공지사항 수정 페이지
	@RequestMapping("noticeUpdatePage.nt")
	public String noticeUpdatePage(String notice_no, Model model) {
		Notice ninfo = ns.selectNoticeOne(notice_no);
		
		model.addAttribute("ninfo",ninfo);
		
		return "notice/noticeUpdate";
	}
	
	//공지사항 update
	@RequestMapping("updateNotice.nt")
	public String updateNotice(@SessionAttribute("loginUser") Member m,Notice n, Model model) {
		n.setMember_no(m.getMember_no());
		
		int update = ns.updateNotice(n);
		
		return "redirect:noticelist.nt";
	}
	
	//댓글 insert
	@RequestMapping("insertComment.nt")
	public String insertComment(@SessionAttribute("loginUser") Member m,NoticeComment c, Model model) {
		c.setMember_no(m.getMember_no());
		
		int insert = ns.insertComment(c);
		return "redirect:noticeDetail.nt?notice_no="+c.getBoard_no();
	}
	
	//댓글 delete
	@RequestMapping("deleteComment.nt")
	public String deleteComment(String notice_no, String comment_no) {
		
		int delete = ns.deleteComment(comment_no);
		
		return "redirect:noticeDetail.nt?notice_no="+notice_no;
	}
	
	//북마크
	@RequestMapping("bookmark.nt")
	public String bookmark(@SessionAttribute("loginUser") Member m, String notice_no) {
		NoticeMarking nm = new NoticeMarking();
		nm.setBoard_no(Integer.parseInt(notice_no));
		nm.setMember_no(m.getMember_no());
		
		int check = -99;
		
		check = ns.checkBookmark(nm);
		
		if(check==0) {
			int insert = ns.insertBookmark(nm);
		}else {
			int delete = ns.deleteBookmark(nm);
		}
		
		return "redirect:noticeDetail.nt?notice_no="+notice_no;
	}
	
	//좋아요
	@RequestMapping("heart.nt")
	public String heart(@SessionAttribute("loginUser") Member m, String notice_no) {
		NoticeMarking nm = new NoticeMarking();
		nm.setBoard_no(Integer.parseInt(notice_no));
		nm.setMember_no(m.getMember_no());
		
		int check = -99;
		
		check = ns.checkHeart(nm);
		if(check==0) {
			int insert = ns.insertHeart(nm);
		}else {
			int delete = ns.deleteHeart(nm);
		}
		
		return "redirect:noticeDetail.nt?notice_no="+notice_no;
	}
}
