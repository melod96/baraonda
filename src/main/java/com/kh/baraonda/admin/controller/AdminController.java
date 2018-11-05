package com.kh.baraonda.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.service.AdminService;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;

@Controller
public class AdminController {

	@Autowired
	private AdminService as;

	@RequestMapping(value="goDashboard.adm")
	public String goDashboard() {		
		return "admin/dashboard/dashboard";
	}
	
	//Member>General 목록 조회용
	@RequestMapping(value="goGeneralMemberAdminList.adm")
	public ModelAndView goGeneralMemberAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
												@RequestParam(value="searchContent", required=false)String content, 
												@RequestParam(value="option1", required=false)String option1) {
		
		Search search = new Search();
		search.setContent(content);
		search.setOption1(option1);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		ArrayList<AdminGeneralMember> list;
		try {
			int listCount = as.selectGeneralMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			list = as.selectGeneralMemberList(info, search);
			
			mv.setViewName("admin/memberAdmin/generalMemberAdminList");
			mv.addObject("list", list);
			mv.addObject("pi", info);
			mv.addObject("search", search);
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "GeneralMember 조회 실패!");
		}
		return mv;
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
