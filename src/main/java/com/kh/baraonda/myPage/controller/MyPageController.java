package com.kh.baraonda.myPage.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.CommonUtils;
import com.kh.baraonda.common.GmailSend;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.common.TempKey;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.member.model.exception.LoginException;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.service.MyPageService;
import com.kh.baraonda.myPage.model.vo.Comments;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Marking;
import com.kh.baraonda.myPage.model.vo.Message;
import com.kh.baraonda.myPage.model.vo.Orders;
import com.kh.baraonda.myPage.model.vo.Point;
import com.kh.baraonda.myPage.model.vo.PointRecord;

@Controller
public class MyPageController {

	@Autowired
	private MyPageService mps;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
//[마이페이지 : 내 정보 변경]
	//마이페이지 - 내 정보 변경으로 이동하는 메소드
	@RequestMapping("changeInfoView.my")
	public String ChangeInfoView(HttpSession session, Model model) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(loginUser != null) {
			
			//포인트 불러오기
			Point point = mps.selectPoint(loginUser);
			//request.setAttribute("point", point);
			model.addAttribute("point", point);
			
			//프로필사진 불러오기
			Files file = mps.selectPhoto(loginUser);
			model.addAttribute("file", file);
			//request.setAttribute("file", file);
			
			return "myPage/changeInfo";
		}else {
			return "redirect:goMain.me";
		}
	}
	
	//마이페이지 - 내 정보 변경 메소드
	@RequestMapping("changeInfo.my")
	public String ChangeInfO(Member m, Model model) {
		
		String encPassword = passwordEncoder.encode(m.getPassword());
		
		System.out.println("encPassword : " + encPassword);
		m.setPassword(encPassword);
		
		int result = mps.updateMemberInfo(m);
		
		if(result > 0) {
			return "redirect:logout.me";
		}else {
			model.addAttribute("msg", "개인정보 변경 실패");
			return "common/errorPage";
		}
		
	}
	
	//사진 업로드 메소드
	@RequestMapping("uploadPhoto.my")
	public String uploadPhoto(HttpSession session,HttpServletRequest request,
								@RequestParam(name="photo", required=false) MultipartFile photo
								,Model model) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		mps.updateDelPhoto(loginUser.getMember_no());
		
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
					photo.transferTo(new File(filePath + "/" + changeName + ext));
					Files file = new Files();
					
					file.setF_reference_no(loginUser.getMember_no());
					file.setFiles_title(originFileName);
					file.setFiles_change_title(changeName+ext);
					file.setFiles_type(1);
					file.setFiles_root("/resources/images/uploadFiles/");
					
					mps.insertPhoto(file);
					
					
				} catch (Exception e) {
					//실패시 파일  삭제
					new File(filePath + "/" + changeName + ext).delete();
					
					model.addAttribute("msg", "사진등록 실패");
					return "common/errorPage";
					
				}
		
		
		
		
		return "redirect:changeInfoView.my";
	}
	

	
//[마이페이지 : 내 활동 정보]
	//마이페이지 - 내 활동 정보로 이동하는 메소드
	@RequestMapping("footprintsView.my")
	public String showFootprintsView(HttpSession session, Model model) {
		
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser != null) {
			HashSet<String> set = new HashSet<String>();
			
			
			
			//파일 리스트 읽기
			List<String> list = new ArrayList<String>();
	
			File[] files = new File("C://sts//log").listFiles();
			
			for (File file : files) {
			    if (file.isFile()) {
			        list.add(file.getName());
			    }
			}
			    
				for(String l : list) {
				//파일 읽기
//					System.out.println("List : " + l);
				File file = new File("C://sts//log//"+l);
				
				FileReader filereader;
				try {
					filereader = new FileReader(file);
					
					BufferedReader bufReader = new BufferedReader(filereader);
					
					String line = "";
					
					
					while((line = bufReader.readLine()) != null) {
						if(line.indexOf('$')>0) {
							System.out.println(line.substring(line.indexOf('$')+1,line.lastIndexOf('$')));
							System.out.println("test2 : "+line.substring(line.indexOf("^")+1,line.lastIndexOf("^")));
							System.out.println("loginUser_member_no : " + loginUser.getMember_no());
							
							if(Integer.parseInt(line.substring(line.indexOf("^")+1,line.lastIndexOf("^"))) == loginUser.getMember_no()) {
								
								set.add(line.substring(line.indexOf('$')+1,line.lastIndexOf('$')));
								System.out.println("set.size() : " + set.size());
							}
						}
					}
					
					bufReader.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//6개중 5개 카운트 불러오기
			Footprints footprints = mps.selectFootprints(loginUser);
			
			footprints.setCheck_count(set.size());
			
			model.addAttribute("footprints", footprints);
			
			return "myPage/footprints";
		}else {
			return "redirect:goMain.me";
		}
	}
	
	
	
	//활동내역 출력 ajax
	@SuppressWarnings("null")
	@RequestMapping(value="footList.my")
	public @ResponseBody HashMap<String, Object> duplicationCheck(@RequestParam int member_no,
			@RequestParam String name, @RequestParam int currentPage, HttpServletResponse response){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		switch(name) {
		
		case "WriteBoard" : 
			System.out.println("WriteBoard");
			
			int listCount = mps.selectListCount(member_no);
			
			System.out.println("listCount : " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = mps.selectBoardList(pi,member_no);
			ArrayList<Marking> mList = mps.selectLikeCount(member_no);
			
			String date[] = new String[10];
			
			for(int i = 0 ; i < list.size(); i++) {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				date[i] = transFormat.format(list.get(i).getBoard_date());
			}
			
			hmap.put("list", list);
			hmap.put("date",date);
			hmap.put("pi",pi);
			hmap.put("mList",mList);
			
			break;
			
		
		case "WriteComments" : 
			
			int commentsListCount = mps.selectCommentsListCount(member_no);
			PageInfo cPi = Pagination.getPageInfo(currentPage, commentsListCount);
			
			ArrayList<Comments> cList = mps.selectCommentList(cPi,member_no);
			
			String cDate[] = new String[10];
			
			for(int i = 0 ; i < cList.size(); i++) {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				cDate[i] = transFormat.format(cList.get(i).getComments_date());
			}
			
			hmap.put("cList", cList);
			hmap.put("cDate",cDate);
			hmap.put("pi",cPi);
			
			break;
			
		case "BookMark" :
			int bookMarkListCount = mps.selectBookMarkListCount(member_no);
			PageInfo bPi = Pagination.getPageInfo(currentPage, bookMarkListCount);
			
			ArrayList<Marking> bList = mps.selectBookMarkList(bPi,member_no);
			
			String bDate[] = new String[10];
			
			for(int i = 0 ; i < bList.size(); i++) {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				bDate[i] = transFormat.format(bList.get(i).getMarking_date());
			}
			
			hmap.put("bList", bList);
			hmap.put("bDate",bDate);
			hmap.put("pi",bPi);
			
			break;
			
		case "Point" : 
			int pointListCount = mps.selectPointListCount(member_no);
			PageInfo pPi = Pagination.getPageInfo(currentPage, pointListCount);
			
			ArrayList<PointRecord> pList = mps.selectPointList(pPi,member_no);
			
			String pDate[] = new String[10];
			
			for(int i = 0 ; i < pList.size(); i++) {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				pDate[i] = transFormat.format(pList.get(i).getPoint_record_date());
			}
			
			hmap.put("pList", pList);
			hmap.put("pDate",pDate);
			hmap.put("pi",pPi);
			
			break;
			
		case "ChangeGoods" : 
			int changeGoodsCount = mps.selectChangeGoodsListCount(member_no);
			PageInfo gPi = Pagination.getPageInfo(currentPage, changeGoodsCount);
			
			ArrayList<Orders> gList = mps.selectChangeGoodsList(gPi,member_no);
			
			String gDate[] = new String[10];
			
			for(int i = 0 ; i < gList.size(); i++) {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				gDate[i] = transFormat.format(gList.get(i).getOrders_date());
			}
			
			hmap.put("gList", gList);
			hmap.put("gDate",gDate);
			hmap.put("pi",gPi);
			
			break;
		
		}
		
		return hmap;
		
	}
	
	
	
	
	
	//마이페이지 - 병아리 키우기로 이동하는 메소드
	@RequestMapping("growingChicksView.my")
      
	public String showGrowingChicksView(Model model,HttpSession session) {

		Member loginUser = (Member)session.getAttribute("loginUser");

		if(loginUser != null) {

			Point point = mps.selectPoint(loginUser);
			ArrayList<Product> p = mps.selectProductList();

			model.addAttribute("point", point);
			model.addAttribute("product",p);

			return "myPage/growingChicks";

		}else {
			return "redirect:goMain.me";
		}
	}
	
	//마이페이지 - 기업 화면으로 이동하는 메소드
		@RequestMapping("companyView.my")
	public String showCompanyPage(HttpSession session) {
			
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(loginUser != null) {
			return "myPage/company";
		}else {
			return "redirect:goMain.me";
		}
	}
		
	//마이페이지 - 다른사람이 보는 개인정보 화면으로 이동하는 메소드
			@RequestMapping("othersView.my")
		public String showOthersView(@RequestParam int member_no, Model model) {
				
				
//				System.out.println("othersView.my 실행 : " + member_no);
				
				//정보 불러오기
				Member viewUser = mps.selectMemberView(member_no);
				
				Files file = mps.selectPhoto(viewUser);
				
				model.addAttribute("viewUser", viewUser);
				model.addAttribute("file", file);
				
				
				return "myPage/othersView";
		}
			
			
	
	//이메일 인증 ajax
	@SuppressWarnings("null")
	@RequestMapping(value="emailCheck.my")
	public @ResponseBody String emailCheck(@RequestParam String email){	
		
		System.out.println(email);
		
		GmailSend mail = new GmailSend();
		String key = new TempKey().getKey(10, false); // 인증키 생성
		System.out.println(key);
		mail.GmailSet(email, "[Baraonda 이메일 인증입니다]","다음 인증 번호를 인증번호 기입란에 입력해주세요. [ "+key+" ]" );
		
		System.out.println("이메일 전송 완료");
		
		return key;
	}
	//마이페이지 - 이메일 insert
		@RequestMapping("updateEmail.my")
		public String insertEmail(@RequestParam int member_no,@RequestParam String email,HttpSession session) {
				System.out.println("cont insertEmail : " + email);
				
				Member m = new Member();
				m.setMember_no(member_no);
				m.setEmail(email);
				
				mps.updateEmail(m);
				System.out.println("이메일 등록 완료");
				
				Member loginUser = (Member) session.getAttribute("loginUser");
				
				loginUser.setEmail(email);
				
				return "redirect:changeInfoView.my";
		}
		
		
		//패스워드 확인 페이지로 이동
		@RequestMapping("checkPwd.my")
		public String checkPwd(Model model, @RequestParam String type) {
			
			
			System.out.println("type : " + type);
			model.addAttribute("type",type);
			
			return "myPage/checkPwd";
		}
		
		
		
		//패스워드 확인
		@RequestMapping("selectPwd.my")
		public String selectPwd(HttpSession session, Model model, @RequestParam String type, @RequestParam String pwd) {
			Member loginUser = (Member) session.getAttribute("loginUser");
			
			System.out.println("메소드 실행");
			System.out.println("member_no : " + loginUser.getMember_no());
			System.out.println("pwd : " + pwd);
			System.out.println("type : " + type);
			
			
			String encPassword = passwordEncoder.encode(pwd);
			System.out.println("encPassword : " + encPassword);
			if(!passwordEncoder.matches(pwd, loginUser.getPassword())) {
				
				model.addAttribute("msg" ,"비밀번호가 일치하지 않습니다.");
				model.addAttribute("type",type);
				return "myPage/falsePage";
			}else {
				model.addAttribute("type",type);
				System.out.println(type + "실행1");
				switch(type) {
				case "changeNick" : 
					return "myPage/changeNickPageView";
				case "changePwd" : 
					return "myPage/changePwdPageView";
				case "changeEmail" : 
					return "myPage/changeEmailPageView";
				case "changeStatus" : 
					System.out.println(type + "실행2");
					mps.updateStatus(loginUser.getMember_no());
					return "redirect:logout.me";
					
				default : return "redirect:changeInfoView.my";
				}
			}
			
		}
				
		
		
		@RequestMapping("updateNick.my")
		public String updateNick(HttpSession session, Model model, @RequestParam String nick) {
			Member loginUser = (Member) session.getAttribute("loginUser");
			loginUser.setNick_name(nick);
			System.out.println("updateNick cont실행");
			mps.updateNick(loginUser);
			
			return "redirect:logout.me";
		}
		
		@RequestMapping("updatePwd.my")
		public String updatePwd(HttpSession session, Model model, @RequestParam String pwd) {
			Member loginUser = (Member) session.getAttribute("loginUser");
			
			String encPassword = passwordEncoder.encode(pwd);
			loginUser.setPassword(encPassword);
			mps.updatePwd(loginUser);
			
			return "redirect:logout.me";
		}
		
		
		//이메일 인증 ajax - id 찾기
		@SuppressWarnings("null")
		@RequestMapping(value="findId.my")
		public @ResponseBody String findId(@RequestParam String email,@RequestParam String namee){	
			
			System.out.println(namee);
			System.out.println(email);
			
			Member m = new Member();
			
			m.setName(namee);
			m.setEmail(email);
			
			int result = mps.selectId(m);
			
			System.out.println(result);
			if(result > 0){
			
				GmailSend mail = new GmailSend();
				String key = new TempKey().getKey(10, false); // 인증키 생성
				System.out.println(key);
				mail.GmailSet(email, "[Baraonda 이메일 인증입니다]","다음 인증 번호를 인증번호 기입란에 입력해주세요. [ "+key+" ]" );
			
				System.out.println("이메일 전송 완료");
			
				return key;
			}else{
				return "";
			}
		}
		
		//이메일 인증 ajax- password
				@SuppressWarnings("null")
				@RequestMapping(value="findPwd.my")
				public @ResponseBody String findPwd(@RequestParam String email,@RequestParam String namee, @RequestParam String idd){	
					
					System.out.println(namee);
					System.out.println(email);
					System.out.println(idd);
					
					Member m = new Member();
					
					m.setId(idd);
					m.setName(namee);
					m.setEmail(email);
					
					int result = mps.selectPwd(m);
					
					System.out.println(result);
					if(result > 0){
					
						GmailSend mail = new GmailSend();
						String key = new TempKey().getKey(10, false); // 인증키 생성
						System.out.println(key);
						mail.GmailSet(email, "[Baraonda 이메일 인증입니다]","다음 인증 번호를 인증번호 기입란에 입력해주세요. [ "+key+" ]" );
					
						System.out.println("이메일 전송 완료");
					
						return key;
					}else{
						return "";
					}
				}
		
			@RequestMapping("updatePwd2.my")
			public String updatePwd(@RequestParam String pwd, @RequestParam String idd) {
				Member m = new Member();
			
				m.setId(idd);
				
				String encPassword = passwordEncoder.encode(pwd);
				m.setPassword(encPassword);
				mps.updatePwd2(m);
			
				return "redirect:logout.me";
			}
		
			
			@RequestMapping("updateDelPhoto.my")
			public String updateDelPhoto(@RequestParam int member_no) {
				
				mps.updateDelPhoto(member_no);
				
				return "redirect:changeInfoView.my";
			}
		
		
		
		
		
		//message list ajax
	@SuppressWarnings("null")
	@RequestMapping(value="messageList.my")
	public @ResponseBody HashMap<String, Object> duplicationCheck(@RequestParam int member_no,
			 @RequestParam int currentPage, HttpServletResponse response){
		
			HashMap<String, Object> hmap = new HashMap<String, Object>();
	
			int messageCount = mps.selectMessageListCount(member_no);
			
			System.out.println("messageCount : " + messageCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, messageCount);
			
			ArrayList<Message> msgList = mps.selectMessageList(pi,member_no);
			
			System.out.println("msgList : " + msgList);
			
			hmap.put("msgList", msgList);
			hmap.put("pi",pi);
			
	
		
		return hmap;
		
	}
}
