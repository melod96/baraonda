package com.kh.baraonda.myPage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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
	
	//마이페이지 - 내 정보 수정으로 이동하는 메소드
	@RequestMapping("changeInfo.my")
	public String showChangeInfo(HttpSession session) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		Point p = mps.selectPoint(loginUser);
		
		
		
		return "myPage/changeInfo";
	}
	
	//마이페이지 - 내 활동 정보로 이동하는 메소드
	@RequestMapping("footprints.my")
	public String showFootprints() {
		return "myPage/footprints";
	}
	
	//마이페이지 - 병아리 키우기로 이동하는 메소드
	@RequestMapping("growingChicks.my")
	public String showGrowingChicks() {
		return "myPage/growingChicks";
	}
	
}
