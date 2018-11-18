package com.kh.baraonda.tips.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.baraonda.common.CommonUtils;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.service.TipsService;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsFiles;
import com.kh.baraonda.tips.model.vo.TipsMarking;


@Controller
public class TipsController {
	@Autowired
	private TipsService ts;
	
	@Autowired
	private MainService ms;
	
	/*//게시글 전체 목록 조회
		@RequestMapping("tips.tp")
		public ModelAndView list(ModelAndView mv, int writing_type, PageInfo pi) {
			int currentPage = 1;
			System.out.println(writing_type);

			if(pi.getCurrentPage() > 0) {
				currentPage = pi.getCurrentPage();
			}

			List<HashMap<String, Object>> list;

			try {
				int listCount = ts.selectTipsListCount();

				PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);

				list = ts.selectTipsList(writing_type, pgif);

				mv.setViewName("board/board");
				mv.addObject("list", list);
				mv.addObject("pi", pgif);
				mv.addObject("writing_type", writing_type);
				return mv;

			} catch (TipsSelectListException e) {
				mv.setViewName("board/board");
				mv.addObject("errorMessgae", "리스트 조회 실패");

				return mv;
			}
		}*/
		
	//꿀팁 리스트 출력
		@RequestMapping("tips.tp")
		public String TipsListPage(Model model, PageInfo pi, @RequestParam int writing_type) {
			int currentPage =1;
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
			
			if(pi.getCurrentPage() > 0){
				currentPage = pi.getCurrentPage();
			}
			
			
			try {
				
				if(writing_type == 0){
					int listCount = ts.selectTipsListCount();
					
					PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
					
					ArrayList<Tips> list = ts.selectTipsList(pgif);
					System.out.println("list : " + list.get(0).getWriting_type());
					
					model.addAttribute("tipslist", list);
					model.addAttribute("pi", pgif);
				}else{
					int listCount = ts.selectTypeTipsListCount(writing_type);
				
					PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
					
					ArrayList<Tips> list = ts.selectTypeTipsList(writing_type,pgif);
					System.out.println("list : " + list.get(0).getWriting_type());
					
					model.addAttribute("tipslist", list);
					model.addAttribute("pi", pgif);
				}
				
				model.addAttribute("writing_type", writing_type);
				//model.addAttribute("writing_type", writing_type);
				
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
			
			//이전글 | 다음글
			Tips nextBoard = ts.selectNextNoTips(tips_no);
			Tips beforeBoard = ts.selectBeforeNoTips(tips_no);
			
			model.addAttribute("tinfo", tinfo);
			model.addAttribute("pi",pgif);
			model.addAttribute("tcomment", tcomment);
			model.addAttribute("cCount", listCount);
			model.addAttribute("hcount", heartCount);
			model.addAttribute("before", beforeBoard);
			model.addAttribute("next", nextBoard);
			
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
		public String insertTips(HttpSession session,HttpServletRequest request,
				@RequestParam("photo") MultipartFile photo,
				@SessionAttribute("loginUser") Member m,Tips t, Model model) {
			t.setMember_no(m.getMember_no());
			System.out.println(photo);
			System.out.println(t);
			
			System.out.println("cont t : " + t);
			int insert = ts.insertTips(t);
			System.out.println("EEEE" + insert);
			
			System.out.println("cont writing type : " + t.getWriting_type());
			
			//사진 저장할 경로 지정
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			//파일의 경로는 root 하위의 uploadFiles이다.
			String filePath = root +"\\images\\uploadFiles";
			
			//파일명 변경
			String originFileName = photo.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			
			//CommonUtils에서 랜덤한 글자를 받아옴
			String changeName = CommonUtils.getRandomString();
			
			//업로드된 파일을 지정한 경로에 저장
					try {
						photo.transferTo(new File(filePath + "\\" + changeName + ext));
						TipsFiles file = new TipsFiles();
						
						file.setF_reference_no(insert);
						file.setFiles_title(originFileName);
						file.setFiles_change_title(changeName+ext);
						file.setFiles_type(4);
						file.setFiles_root(filePath + "\\" + changeName + ext);
						System.out.println("???"+file);
						
						ts.insertPhoto(file);
						
						
					} catch (Exception e) {
						//실패시 파일  삭제
						new File(filePath + "\\" + changeName + ext).delete();
						
						model.addAttribute("msg", "사진등록 실패");
						return "common/errorPage";
						
					}
			
				System.out.println("cont t : " + t);

			
			if(insert > 0) {
				model.addAttribute("writing_type",0);
				return "redirect:tips.tp";			
			}else {
				model.addAttribute("msg","다이어트꿀팁 등록 실패");
				return "common/errorPage";
				
			}
			
		}
		
		//공지사항 update
				@RequestMapping("updateTips.tp")
				public String updateTips(HttpSession session,HttpServletRequest request,
				@RequestParam("photo") MultipartFile photo,@SessionAttribute("loginUser")
				Member m,Tips t, Model model, @RequestParam int ref_no) {
					
					//사진 저장할 경로 지정
					String root = request.getSession().getServletContext().getRealPath("resources");
					
					//파일의 경로는 root 하위의 uploadFiles이다.
					String filePath = root +"\\images\\uploadFiles";
					
					String originFileName = photo.getOriginalFilename();
					System.out.println("origin : " + originFileName); 
					String ext = originFileName.substring(originFileName.lastIndexOf("."));
					
					
					//CommonUtils에서 랜덤한 글자를 받아옴
					String changeName = CommonUtils.getRandomString();
					
					
					
					t.setMember_no(m.getMember_no());
					System.out.println(photo);
					System.out.println(t);
					
					System.out.println("cont t : " + t);
					int update = ts.updateTips(t);
					System.out.println("EEEE" + update);
					
					
					
					//업로드된 파일을 지정한 경로에 저장
							try {
								photo.transferTo(new File(filePath + "\\" + changeName + ext));
								
								TipsFiles file = new TipsFiles();
								
								System.out.println("사진 저장경로 : " + filePath + "\\" + changeName + ext);
								
								file.setFiles_title(originFileName);
								file.setFiles_change_title(changeName+ext);
								file.setF_reference_no(ref_no);
								
								System.out.println("change_title : " + file.getFiles_change_title()); 
								System.out.println("cont ref_no : " + ref_no);
								ts.updatePhoto(file);
								System.out.println("update 끝 cont");

								
								
							} catch (Exception e) {
								
								e.printStackTrace();
								model.addAttribute("msg", "사진등록 실패11");
								return "common/errorPage";
								
							}
					
					
					
				//	t.setMember_no(m.getMember_no());
					
				//	int update = ts.updateTips(t);
					model.addAttribute("writing_type", 0);
					return "redirect:tips.tp";
				}
		
		//공지사항 delete
		@RequestMapping("deleteTips.tp")
		public String deleteTips(String tips_no) {
			int delete = ts.deleteTips(tips_no);
			
			return "redirect:tips.tp?writing_type=0";
		}
		
		//공지사항 수정 페이지
		@RequestMapping("tipsUpdatePage.tp")
		public String tipsUpdatePage(String tips_no, Model model) {
			Tips tinfo = ts.selectTipsOne(tips_no);
			
			model.addAttribute("tinfo",tinfo);
			
			return "tips/tipsUpdate";
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
