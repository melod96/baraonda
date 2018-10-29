package com.kh.baraonda.myPage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.service.MyPageService;
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
		
		Point point = mps.selectPoint(loginUser);
		System.out.println("point : " + point.getAccrue_point());
		model.addAttribute("point", point);
		
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
