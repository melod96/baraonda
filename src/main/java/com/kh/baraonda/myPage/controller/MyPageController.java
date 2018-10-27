package com.kh.baraonda.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {

	
	
	
	//마이페이지 - 내 정보 수정으로 이동하는 메소드
	@RequestMapping("changeInfo.my")
	public String showChangeInfo() {
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
