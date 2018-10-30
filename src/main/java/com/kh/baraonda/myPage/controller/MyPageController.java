package com.kh.baraonda.myPage.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.baraonda.common.CommonUtils;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.service.MyPageService;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Point;

@Controller
public class MyPageController {

	@Autowired
	private MyPageService mps;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	//마이페이지 - 내 정보 변경으로 이동하는 메소드
	@RequestMapping("changeInfoView.my")
	public String ChangeInfoView(HttpSession session, Model model) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		//포인트 불러오기
		Point point = mps.selectPoint(loginUser);
		model.addAttribute("point", point);
		
		//프로필사진 불러오기
		Files file = mps.selectPhoto(loginUser);
		model.addAttribute("file", file);
		
		System.out.println(file.getChange_files_title());
		
		return "myPage/changeInfo";
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
					Files file = new Files();
					
					file.setF_reference_no(loginUser.getMember_no());
					file.setFiles_title(originFileName);
					file.setChange_files_title(ext);
					file.setFiles_type(1);
					file.setFiles_root(filePath + "\\" + changeName + ext);
					
					mps.insertPhoto(file);
					
					
				} catch (Exception e) {
					//실패시 파일  삭제
					new File(filePath + "\\" + changeName + ext).delete();
					
					model.addAttribute("msg", "사진등록 실패");
					return "common/errorPage";
					
				}
		
		
		
		
		return "redirect:changeInfoView.my";
	}
	
	
	
	//마이페이지 - 내 활동 정보로 이동하는 메소드
	@RequestMapping("footprintsView.my")
	public String showFootprintsView() {
		return "myPage/footprints";
	}
	
	//마이페이지 - 병아리 키우기로 이동하는 메소드
	@RequestMapping("growingChicksView.my")
	public String showGrowingChicksView() {
		return "myPage/growingChicks";
	}
	
}
