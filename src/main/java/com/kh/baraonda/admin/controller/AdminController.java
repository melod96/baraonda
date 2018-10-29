package com.kh.baraonda.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.baraonda.member.model.service.MemberService;

@SessionAttributes("loginUser") 
@Controller
public class AdminController {

	@Autowired
	private MemberService ms ;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("goAdmin.adm")
	public String goMain() {
		
		return "admin/dashboard/dashboard";
	}
	
}
