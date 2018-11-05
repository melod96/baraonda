package com.kh.baraonda.tips.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.service.TipsService;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;


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
		public String noticeDetail(String board_no, Model model, PageInfo pi) {
			
			Tips tinfo = ts.selectTipsOne(board_no);
			
			//댓글
			int currentPage =1;
			
			if(pi.getCurrentPage() > 0){
				currentPage = pi.getCurrentPage();
			}
			
			int listCount = ts.selectCommentListCount(board_no);
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<TipsComment> comment = ts.selectComment(board_no,pgif);
			
			model.addAttribute("tinfo", tinfo);
			model.addAttribute("pi",pgif);
			model.addAttribute("comment", comment);
			model.addAttribute("cCount", listCount);
			
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
