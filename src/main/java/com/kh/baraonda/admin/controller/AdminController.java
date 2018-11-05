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
import com.kh.baraonda.admin.model.vo.AdminBlackMember;
import com.kh.baraonda.admin.model.vo.AdminCompanyMember;
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
		
		Search search = new Search(content, option1);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		ArrayList<AdminGeneralMember> list;
		try {
			int listCount = as.selectGeneralMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				list = as.selectGeneralMemberList(info, search);
				mv.addObject("list", list);
			}
			
			mv.addObject("pi", info);
			mv.addObject("search", search);
			mv.setViewName("admin/memberAdmin/generalMemberAdminList");
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "GeneralMember 조회 실패!");
		}
		return mv;
	}
	
	@RequestMapping(value="goCompanyMemberAdminList.adm")
	public ModelAndView goCompanyMemberAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
										@RequestParam(value="searchContent", required=false)String content) {
		Search search = new Search(content);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		ArrayList<AdminCompanyMember> list;
		try {
			int listCount = as.selectCompanyMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				list = as.selectCompanyMemberList(info, search);
				mv.addObject("list", list);
			}
			
			mv.addObject("pi", info);
			mv.addObject("search", search);
			mv.setViewName("admin/memberAdmin/companyMemberAdminList");
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "CompanyMember 조회 실패!");
		}
		return mv;
	}
	
	@RequestMapping(value="goBlackMemberAdminList.adm")
	public ModelAndView goBlackMemberAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
										@RequestParam(value="searchContent", required=false)String content) {
		Search search = new Search(content);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		ArrayList<AdminBlackMember> list;
		try {
			int listCount = as.selectBlackMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				list = as.selectBlackMemberList(info, search);
				mv.addObject("list", list);
			}
			
			mv.addObject("pi", info);
			mv.addObject("search", search);
			mv.setViewName("admin/memberAdmin/blackMemberAdminList");
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "BlackMember 조회 실패!");
		}
		return mv;
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
