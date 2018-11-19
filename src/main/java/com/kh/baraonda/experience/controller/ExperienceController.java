package com.kh.baraonda.experience.controller;

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
import com.kh.baraonda.common.PaginationComment;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.experience.model.service.ExperienceService;
import com.kh.baraonda.experience.model.vo.Experience;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.service.MyPageService;
import com.kh.baraonda.myPage.model.vo.Point;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsFiles;

@Controller
public class ExperienceController {
	@Autowired
	private MainService ms;

	@Autowired
	private ExperienceService es;

	@Autowired
	private MyPageService mps;

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
	public String experienceDetail(String experience_no, Model model, PageInfo pi,HttpSession session) {

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
		
		Member m = (Member) session.getAttribute("loginUser");
		
		if(m != null) {
			NoticeMarking nm = new NoticeMarking();
			nm.setBoard_no(Integer.parseInt(experience_no));
			nm.setMember_no(m.getMember_no());
			
			int check = -99;
			
			check = es.checkBookmark(nm);
			
			model.addAttribute("checking", check);
			
			int check2 = -99;
			
			check2 = es.checkHeart(nm);
			
			model.addAttribute("checking2", check2);
		}

		model.addAttribute("tinfo", tinfo);
		model.addAttribute("pi",pgif);
		model.addAttribute("tcomment", tcomment);
		model.addAttribute("cCount", listCount);
		model.addAttribute("hcount", heartCount);
		model.addAttribute("before", beforeBoard);
		model.addAttribute("next", nextBoard);

		return "experience/experienceDetail";
	}

	@RequestMapping("searchExperience.ep")
	public String searchNotice(String searchtype, String search, Model model, PageInfo pi) {
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

		int listCount = es.searchExperienceCount(sc);

		PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<Tips> list = es.searchExperienceList(sc,pgif);

		model.addAttribute("tipslist", list);
		model.addAttribute("pi", pgif);
		model.addAttribute("search", search);
		model.addAttribute("searchtype", searchtype);

		return "experience/experience";
	}

	@RequestMapping("deleteExperience.ep")
	public String deleteExperience(String board_no) {
		es.deleteExperience(board_no);

		return "redirect:experiencePage.ep";
	}

	//북마크
	@RequestMapping("bookmarkexperience.ep")
	public String bookmark(@SessionAttribute("loginUser") Member m, String board_no) {
		NoticeMarking nm = new NoticeMarking();
		nm.setBoard_no(Integer.parseInt(board_no));
		nm.setMember_no(m.getMember_no());

		int check = -99;

		check = es.checkBookmark(nm);

		if(check==0) {
			es.insertBookmark(nm);
		}else {
			es.deleteBookmark(nm);
		}

		return "redirect:experienceDetail.ep?experience_no="+board_no;
	}

	//좋아요
	@RequestMapping("heartexperience.ep")
	public String heart(@SessionAttribute("loginUser") Member m, String board_no) {
		NoticeMarking nm = new NoticeMarking();
		nm.setBoard_no(Integer.parseInt(board_no));
		nm.setMember_no(m.getMember_no());

		int check = -99;

		check = es.checkHeart(nm);
		if(check==0) {
			es.insertHeart(nm);
		}else {
			es.deleteHeart(nm);
		}

		return "redirect:experienceDetail.ep?experience_no="+board_no;
	}

	@RequestMapping("insertComment.ep")
	public String insertComment(@SessionAttribute("loginUser") Member m,NoticeComment c, Model model) {
		c.setMember_no(m.getMember_no());

		es.insertComment(c);

		Point point = mps.selectPoint(m);

		Point_Record pr = new Point_Record();
		pr.setMember_no(m.getMember_no());
		pr.setBefore_point(point.getAccrue_point());
		pr.setAfter_point(point.getAccrue_point() + 5);
		es.updatePoint(pr);
		return "redirect:experienceDetail.ep?experience_no="+c.getBoard_no();
	}

	@RequestMapping("deleteCommentexperience.ep")
	public String deleteCommentexperience(String board_no, String comment_no) {

		es.deleteComment(comment_no);

		return "redirect:experienceDetail.ep?experience_no="+board_no;
	}
	@RequestMapping("experienceWrite.ep")
	public String experienceWrite() {
		return "experience/experienceWrite";
	}
	
	@RequestMapping("insertExperience.ep")
	public String insertExperience(HttpSession session,HttpServletRequest request,
			@RequestParam("photo") MultipartFile photo,
			@SessionAttribute("loginUser") Member m,Tips t, Model model) {
		t.setMember_no(m.getMember_no());
		
		int insert = es.insertExperience(t);
		
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
					System.out.println(file);
					
					Experience e = new Experience();
					e.setBoard_no(insert);
					e.setCompany_no(m.getMember_no());
					es.insertPhoto(file,e);
					
					
				} catch (Exception e) {
					//실패시 파일  삭제
					new File(filePath + "\\" + changeName + ext).delete();
					
					model.addAttribute("msg", "사진등록 실패");
					return "common/errorPage";
					
				}
		

		
		if(insert > 0) {
			return "redirect:experiencePage.ep";			
		}else {
			model.addAttribute("msg","체험단 신청 실패");
			return "common/errorPage";
			
		}
		
	}
}
