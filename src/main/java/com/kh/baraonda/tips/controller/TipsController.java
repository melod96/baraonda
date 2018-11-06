package com.kh.baraonda.tips.controller;

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
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.service.TipsService;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsMarking;


@Controller
public class TipsController {
	@Autowired
	private TipsService ts;
	
	
	//꿀팁 리스트 출력
		@RequestMapping("tips.tp")
		public String TipsListPage(Model model, PageInfo pi) {
			int currentPage =1;
			
			if(pi.getCurrentPage() > 0){
				currentPage = pi.getCurrentPage();
			}
			
			
			try {
				int listCount = ts.selectTipsListCount();
				
				PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
				
				ArrayList<Tips> list = ts.selectTipsList(pgif);
				
				model.addAttribute("tipslist", list);
				model.addAttribute("pi", pgif);
				
				return "tips/tips";
			} catch (TipsSelectListException e) {
				model.addAttribute("msg",e.getMessage());
				return "common/errorPage";
			}
			
			
		}
		
		
		
		//공지사항 상세보기
		@RequestMapping("tipsDetail.tp")
		public String tipsDetail(String tips_no, Model model, PageInfo pi) {
			
			Tips tinfo = ts.selectTipsOne(tips_no);
			
			int heartCount = ts.selectHeartTips(tips_no);
			
			//댓글
			int currentPage =1;
			
			if(pi.getCurrentPage() > 0){
				currentPage = pi.getCurrentPage();
			}
			
			int listCount = ts.selectCommentListCountTips(tips_no);
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<TipsComment> tcomment = ts.selectCommentTips(tips_no,pgif);
			
			/*//이전글 | 다음글
			Tips nextBoard = ts.selectNextNoTips(tips_no);
			Tips beforeBoard = ts.selectBeforeNoTips(tips_no);*/
			
			model.addAttribute("tinfo", tinfo);
			model.addAttribute("pi",pgif);
			model.addAttribute("tcomment", tcomment);
			model.addAttribute("cCount", listCount);
			model.addAttribute("hcount", heartCount);
	/*		model.addAttribute("before", beforeBoard);
			model.addAttribute("next", nextBoard);*/
			
			return "tips/tipsDetail";
		}
		
		//공지사항 검색
		@RequestMapping("searchTips.tp")
		public String searchTips(String searchtype, String search, Model model, PageInfo pi) {
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
			
			int listCount = ts.searchTipsCount(sc);
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Tips> list = ts.searchTipsList(sc,pgif);
			
			model.addAttribute("tipslist", list);
			model.addAttribute("pi", pgif);
			model.addAttribute("search", search);
			
			return "tips/tips";
		}
		
		
		
		
		//공지사항 작성 페이지
		@RequestMapping("tipsWrite.tp")
		public String tipsWrite() {
			return "tips/tipsWrite";
		}
		
		//공지사항 insert
		@RequestMapping("insertTips.tp")
		public String insertTips(@SessionAttribute("loginUser") Member m,Tips t, Model model) {
			
			int insert = ts.insertTips(t);
			
			if(insert > 0) {
				return "redirect:tipslist.tp";			
			}else {
				model.addAttribute("msg","다이어트꿀팁 등록 실패");
				return "common/errorPage";
				
			}
			
		}
		
		//공지사항 delete
		@RequestMapping("deleteTips.tp")
		public String deleteTips(String tips_no) {
			int delete = ts.deleteTips(tips_no);
			
			return "redirect:tipslist.tp";
		}
		
		//공지사항 수정 페이지
		@RequestMapping("tipsUpdatePage.tp")
		public String tipsUpdatePage(String tips_no, Model model) {
			Tips tinfo = ts.selectTipsOne(tips_no);
			
			model.addAttribute("tinfo",tinfo);
			
			return "tips/tipsUpdate";
		}
		
		//공지사항 update
		@RequestMapping("updateTips.tp")
		public String updateTips(@SessionAttribute("loginUser") Member m,Tips t, Model model) {
			t.setMember_no(m.getMember_no());
			
			int update = ts.updateTips(t);
			
			return "redirect:tipslist.tp";
		}
		
		//댓글 insert
		@RequestMapping("insertCommentTips.tp")
		public String insertCommentTips(@SessionAttribute("loginUser") Member m,TipsComment tc, Model model) {
			tc.setMember_no(m.getMember_no());
			
			int insert = ts.insertCommentTips(tc);
			return "redirect:tipsDetail.tp?tips_no="+tc.getBoard_no();
		}
		
		//댓글 delete
		@RequestMapping("deleteCommentTips.tp")
		public String deleteCommentTips(String tips_no, String tcomment_no) {
			
			int delete = ts.deleteCommentTips(tcomment_no);
			
			return "redirect:tipsDetail.tp?tips_no="+tips_no;
		}
		
		//북마크
		@RequestMapping("bookmarkTips.tp")
		public String bookmarkTips(@SessionAttribute("loginUser") Member m, String tips_no) {
			TipsMarking tm = new TipsMarking();
			tm.setBoard_no(Integer.parseInt(tips_no));
			tm.setMember_no(m.getMember_no());
			
			int check = -99;
			
			check = ts.checkBookmarkTips(tm);
			
			if(check==0) {
				int insert = ts.insertBookmarkTips(tm);
			}else {
				int delete = ts.deleteBookmarkTips(tm);
			}
			
			return "redirect:tipsDetail.tp?tips_no="+tips_no;
		}
		
		//좋아요
		@RequestMapping("heartTips.tp")
		public String heartTips(@SessionAttribute("loginUser") Member m, String tips_no) {
			TipsMarking tm = new TipsMarking();
			tm.setBoard_no(Integer.parseInt(tips_no));
			tm.setMember_no(m.getMember_no());
			
			int check = -99;
			
			check = ts.checkHeartTips(tm);
			if(check==0) {
				int insert = ts.insertHeartTips(tm);
			}else {
				int delete = ts.deleteHeartTips(tm);
			}
			
			return "redirect:tipsDetail.tp?tips_no="+tips_no;
		}
		
		
		
		
		
		
		/*//다이어트꿀팁으로 이동하는 페이지
		@RequestMapping("tips.tp")
		public String selectTips() {
			return "tips/tips";
		}
		
		//다이어트꿀팁 작성으로 이동하는 페이지
		@RequestMapping("tipsWrite.tp")
		public String selectTipsWrite() {
			return "tips/tipsWrite";
		}
		
		//다이어트꿀팁 디테일로 이동하는 페이지
		@RequestMapping("tipsDetail.tp")
		public String selectTipsDetail() {
			return "tips/tipsDetail";
		}
		
		//다이어트꿀팁 업데이트로 이동하는 페이지
		@RequestMapping("tipsUpdate.tp")
		public String selectTipsUpdate() {
			return "tips/tipsUpdate";
		}*/

}
