package com.kh.baraonda.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.baraonda.admin.model.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService as;

	@RequestMapping(value="goDashboard.adm")
	public String goDashboard() {		
		return "admin/dashboard/dashboard";
	}
	
	@RequestMapping(value="goGeneralMemberAdminList.adm")
	public String goGeneralMemberAdminList() {
		return "admin/memberAdmin/generalMemberAdminList";
	}
	
	@RequestMapping(value="goCompanyMemberAdminList.adm")
	public String goCompanyMemberAdminList() {
		return "admin/memberAdmin/companyMemberAdminList";
	}
	
	@RequestMapping(value="goBlackMemberAdminList.adm")
	public String goBlackMemberAdminList() {
		return "admin/memberAdmin/blackMemberAdminList";
	}
	
	@RequestMapping(value="goQnAAdminList.adm")
	public String goQnAAdminList() {
		return "admin/QnAAdmin/QnAAdminList";
	}
	
	@RequestMapping(value="goAdvertisingAdminList.adm")
	public String goAdvertisingAdminList() {
		return "admin/advertisingAdmin/advertisingAdminList";
	}
	
	@RequestMapping(value="goExperienceAdminList.adm")
	public String goExperienceAdminList() {
		return "admin/experienceAdmin/experienceAdminList";
	}
	
	@RequestMapping(value="goDeclarationAdminList.adm")
	public String goDeclarationAdminList() {
		return "admin/declarationAdmin/declarationAdminList";
	}
	
	@RequestMapping(value="goOrderAdminList.adm")
	public String goOrderAdminList() {
		return "admin/orderAdmin/orderAdminList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
