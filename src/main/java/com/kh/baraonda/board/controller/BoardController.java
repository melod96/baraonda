package com.kh.baraonda.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.service.BoardService;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.board.model.vo.HomeFiles;
import com.kh.baraonda.board.model.vo.Report;
import com.kh.baraonda.board.model.vo.boardMarking;
import com.kh.baraonda.common.CommonUtils;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.common.PaginationComment;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;

	@Autowired
	private MainService ms;
	
	//게시글 전체 목록 조회
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mv, int writing_type, PageInfo pi) {
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			mv.addObject("flist", flist);
			nlist = ms.selectNotice();
			mv.addObject("nlist", nlist);
			rlist = ms.selectRanking();
			mv.addObject("rlist", rlist);
		} catch (MainSelectListException e1) {
			mv.addObject("msg", e1.getMessage());
		}
		
		
		int currentPage = 1;

		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}

		List<HashMap<String, Object>> list;

		try {
			int listCount = boardService.selectBoardListCount(writing_type);

			PageInfo info = Pagination.getPageInfo(currentPage, listCount);

			list = boardService.listAll(writing_type, info);

			mv.setViewName("board/board");
			mv.addObject("list", list);
			mv.addObject("pi", info);
			mv.addObject("writing_type", writing_type);
			return mv;

		} catch (BoardException e) {
			mv.setViewName("board/board");
			mv.addObject("errorMessgae", "리스트 조회 실패");

			return mv;
		}
	}
	
	//게시글 상세보기(댓글 포함), 조회수 증가 처리
	@RequestMapping(value="view.do")
	public ModelAndView view(int board_no, HttpSession session, PageInfo pi) {
		ModelAndView mv = new ModelAndView();
		//게시글 상세보기(제목, 내용, 작성자, 날짜, 댓글수, 조회수) 
		HashMap<String, Object> detail;
		//댓글 조회(작성자, 내용, 날짜)
		List<HashMap<String, Object>> commentList;
		
		try {
			//조회수 증가처리
			boardService.increaseViewCnt(board_no, session);
			
			//좋아요 수
			int likeCount = boardService.selectLike(board_no);
			
			//댓글 페이징
			int currentPage = 1;
			
			if(pi.getCurrentPage() > 0) {
				currentPage = pi.getCurrentPage();
			}
			
			int listCount = boardService.commentListCount(board_no);
			
			PageInfo info = PaginationComment.getPageInfo(currentPage, listCount);
			
			Member m = (Member) session.getAttribute("loginUser");
			
			if(m != null) {
				boardMarking bm = new boardMarking();
				bm.setBoard_no(board_no);
				bm.setMember_no(m.getMember_no());
				
				int check1 = - 99;
				int check2 = - 99;
				
				check1 = boardService.checkBookMark(bm);
				check2 = boardService.checkLike(bm);
				
				mv.addObject("check1", check1);
				mv.addObject("check2", check2);
				
			}
			
			//상세보기 board_no값 넘겨줌
			detail = boardService.detail(board_no);
			commentList = boardService.commentList(board_no, info);
			//뷰 이름
			mv.setViewName("board/boardPage");
			//뷰에 전달할 데이터
			mv.addObject("detail", detail);
			mv.addObject("commentList", commentList);
			mv.addObject("likeCount", likeCount);
			mv.addObject("listCount", listCount);
			mv.addObject("pi", info);
			
			return mv;
			
		} catch (BoardException e) {
			mv.setViewName("board/boardPage");
			mv.addObject("errorMessgae", "상세보기 조회 실패");
			
			return mv;
		}
	}
	//게시판 검색
	@RequestMapping("searchBoard.do")
	public ModelAndView searchBoard(String searchType, String search, PageInfo pi, ModelAndView mv) throws BoardException {
		SearchCondition sc = new SearchCondition();
		List<HashMap<String, Object>> list;
		
		if(searchType.equals("title")) {
			sc.setTitle(search);
		}
		if(searchType.equals("content")) {
			sc.setContent(search);
		}
		if(searchType.equals("writer")){
			sc.setWriter(search);
		}
		
		int currentPage = 1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		//게시글 검색 개수 
		int listCount = boardService.searchBoardCount(sc);
		
		PageInfo info = Pagination.getPageInfo(currentPage, listCount);

		list = boardService.searchList(info, sc);
		
		mv.setViewName("board/board");
		mv.addObject("list", list);
		mv.addObject("pi", info);
		mv.addObject("search", search);
		
		return mv;

	}
	

	//게시글 작성 페이지로 이동
	//@RequestMapping("board/write.do")
	//value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/boardWrite";
	}
	
	//게시글 작성처리
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(HttpSession session,
			@ModelAttribute Board b, HttpServletRequest request, int writing_type) {
		try {
			boardService.create(b);

			return "redirect:list.do?writing_type=" + writing_type;
		} catch (Exception e) {

			return "common/errorPage";
		}
	}
	
	//게시물 update
	@RequestMapping(value="updateBoardPage.do")
	public ModelAndView updateBoardPage(int board_no) {
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> detail;
		try {
			detail = boardService.detail(board_no);
			//뷰 이름
			mv.setViewName("board/boardUpdate");
			//뷰에 전달할 데이터
			mv.addObject("detail", detail);

			return mv;

		} catch (BoardException e) {
			mv.setViewName("board/boardUpdate");
			mv.addObject("errorMessgae", "게시물 수정 실패");

			return mv;
		}
	}
	
	//게시물 수정 페이지
	@RequestMapping(value="updateBoard.do")
	public String updateBoard(@SessionAttribute("loginUser") Member m, @ModelAttribute Board b, int writing_type) {

		try {
			b.setMember_no(m.getMember_no());

			boardService.updateBoard(b);

			return "redirect:list.do?writing_type=" + writing_type;
		} catch (Exception e) {

			return "common/errorPage";
		}
	}
	//게시물 delete
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(int board_no) {
		try {
			boardService.deleteBoard(board_no);
			
			return "redirect:list.do?writing_type=11";
			
		} catch (BoardException e) {
			return "common/errorPage";
		}
		
	}
	//댓글 insert
	@RequestMapping("insertComment.do")
	public String insertComment(@SessionAttribute("loginUser") Member m, Comments c, Model model) {
		c.setMEMBER_NO(m.getMember_no());
		
		int insert = boardService.insertComment(c);
		
		return "redirect:view.do?board_no="+c.getBOARD_NO();
	}
	//댓글 delete
	@RequestMapping("deleteComment.do")
	public String deleteComment(int board_no, int comments_no) {
		
		int delete = boardService.deleteComment(comments_no);
		
		return "redirect:view.do?board_no="+board_no;
	}
	
	//좋아요 등록/삭제
	@RequestMapping("like.do")
	public String like(@SessionAttribute("loginUser") Member m, int board_no) {
		boardMarking bm = new boardMarking();
		bm.setBoard_no(board_no);
		bm.setMember_no(m.getMember_no());
		
		int check = -99;
		
		check = boardService.checkLike(bm);
		
		if(check == 0) {
			int insert = boardService.insertLike(bm);
		}else {
			int delete = boardService.deleteLike(bm);
		}
	
		return "redirect:view.do?board_no=" + board_no;
	}
	
	//북마크
	@RequestMapping("bookMark.do")
	public String bookMark(@SessionAttribute("loginUser") Member m, int board_no) {
		boardMarking bm = new boardMarking();
		bm.setBoard_no(board_no);
		bm.setMember_no(m.getMember_no());
		
		int check = -99;
		
		check = boardService.checkBookMark(bm);
		
		if(check == 0) {
			int insert = boardService.insertBookMark(bm);
		}else {
			int delete = boardService.deleteBookMark(bm);
		}
		
		return "redirect:view.do?board_no=" + board_no;
	}
	
	//홈트레이닝 게시판 리스트
	@RequestMapping("home.do")
	public String homeTrainingList(Model model, PageInfo pi, int writing_type) {
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
		
		int currentPage = 1;
		
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		
		try {
			int listCount = boardService.selectBoardListCount(writing_type);
			
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = boardService.selectHomeList(info, writing_type);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", info);
			model.addAttribute("writing_type", writing_type);
			
			return "board/homeTraining";
			
		} catch (BoardException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
	}
	//홈트레이닝 게시글 작성 페이지
	@RequestMapping("homeWrite.do")
	public String homeWrite() {
		return "board/homeWrite";
	}
	
	//홈트레이닝 게시글 작성
	@RequestMapping("insertHome.do")
	public String insertHome(HttpSession session, HttpServletRequest request,
			@RequestParam("photo") MultipartFile photo,
			@SessionAttribute("loginUser") Member m, Board b, Model model, int writing_type) {
		b.setMember_no(m.getMember_no());
		
		int insert = boardService.insertHome(b);
		
		//사진 저장할 경로 지정
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		//파일의 경로는 root 하위의 uploadFiles이다.
		String filePath = root +"\\images\\uploadFiles";
		
		//파일명 변경
		String originFileName = photo.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		
		//CommonUtils에서 랜덤한 글자를 받아옴
		String changeName = CommonUtils.getRandomString();
		
		try {
			photo.transferTo(new File(filePath + "\\" + changeName + ext));
			HomeFiles file = new HomeFiles();
			
			file.setF_reference_no(insert);
			file.setFiles_title(originFileName);
			file.setFiles_change_title(changeName+ext);
			file.setFiles_type(4);
			file.setFiles_root(filePath + "\\" + changeName + ext);
			System.out.println("파일 : " + file);
			
			boardService.insertPhoto(file);
			
		} catch (Exception e) {

			//실패시 파일  삭제
			new File(filePath + "\\" + changeName + ext).delete();
			
			model.addAttribute("msg", "사진등록 실패");
			return "common/errorPage";
		}
		
		if(insert > 0) {
			return "redirect:home.do?writing_type=" + writing_type;
		}else{
			model.addAttribute("msg", "작성 실패");
			return "common/errorPage";
		}	
	}
	@RequestMapping("adminDelete.do")
	public void adminDelete(@RequestParam(value = "valueArrTest[]") List<String> valueArr) {
		System.out.println("value : " + valueArr);
		
		boardService.adminDelete(valueArr);

		return;
	}
	
	//게시글 신고
	@RequestMapping("report.do")
	public String report(@SessionAttribute("loginUser") Member m, Report r, Model model) {
		r.setReport_give_no(m.getMember_no());
		
		boardService.report(r);
		
		return "redirect:view.do?board_no=" + r.getBoard_no();
	}

	//자주하는 질문 페이지
	@RequestMapping("question.do")
	public String question() {
		return "board/Question";
	}
	
	
}































