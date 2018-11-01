package com.kh.baraonda.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.baraonda.admin.model.service.AdminService;

@SessionAttributes("loginUser") 
@Controller
public class AdminController {

	@Autowired
	private AdminService as;

	@RequestMapping("goDashboard.adm")
	public String goMain() {		
		return "admin/dashboard/dashboard";
	}
	
	
	
}
