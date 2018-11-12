package com.kh.baraonda.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.service.AdminService;
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
	
	@RequestMapping(value="goGeneralMemberAdminList.adm")
	public ModelAndView goGeneralMemberAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
												@RequestParam(value="searchContent", required=false)String content, 
												@RequestParam(value="option1", required=false)String option1) {
		Search search = new Search(content, option1);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		try {
			int listCount = as.selectGeneralMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				mv.addObject("list", as.selectGeneralMemberList(info, search));
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
	
	@RequestMapping(value="goGeneralMemberAdminDetail.adm")
	public ModelAndView goGeneralMemberAdminDetail(ModelAndView mv, @RequestParam(value="num", required=true)String num) {
		try {
			mv.addObject("memberInfo", as.selectGeneralMemberInfo(num));
			mv.addObject("membersDeclartionList", as.selectMembersDeclarationList(num));
			mv.addObject("membersOrderList", as.selectMembersOrderList(num));
			mv.setViewName("admin/memberAdmin/generalMemberAdminDetail");
		} catch (AdminException e) {
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "MemberDetail 조회 실패!");
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
		try {
			int listCount = as.selectCompanyMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				mv.addObject("list", as.selectCompanyMemberList(info, search));
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
	
	@RequestMapping(value="goCompanyMemberAdminDetail.adm")
	public ModelAndView goCompanyMemberAdminDetail(ModelAndView mv, @RequestParam(value="num", required=true)String num) {
		try {
			mv.addObject("memberInfo", as.selectCompanyMemberInfo(num));
			mv.setViewName("admin/memberAdmin/companyMemberAdminDetail");
		} catch (AdminException e) {
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "CompanyDetail 조회 실패!");
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
		try {
			int listCount = as.selectBlackMemberCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				mv.addObject("list", as.selectBlackMemberList(info, search));
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
	
	/*@RequestMapping(value="goQnAAdminList.adm")
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
	}*/
	
	@RequestMapping(value="goNoticeAdminList.adm")
	public ModelAndView goNoticeAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
											@RequestParam(value="searchContent", required=false)String content) {
		Search search = new Search(content);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		try {
			int listCount = as.selectNoticeCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				mv.addObject("list", as.selectNoticeList(info, search));
			}
			mv.addObject("pi", info);
			mv.addObject("search", search);
			mv.setViewName("admin/noticeAdmin/noticeAdminList");
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "NoticeList 조회 실패!");
		}
		return mv;
	}
	
	@RequestMapping(value="goNoticeAdminDetail.adm")
	public ModelAndView goNoticeAdminDetail(ModelAndView mv, @RequestParam(value="num", required=true)String num) {
		try {
			mv.addObject("boardInfo", as.selectNoticeInfo(num));
			mv.setViewName("admin/noticeAdmin/noticeAdminDetail");
		} catch (AdminException e) {
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "NoticeDetail 조회 실패!");
		}
		return mv;
	}
	
	@RequestMapping(value="goNoticeAdminWriteForm.adm")
	public ModelAndView goNoticeAdminWriteForm(ModelAndView mv) {
		mv.setViewName("admin/noticeAdmin/noticeAdminWriteForm");
		return mv;
	}
	
	@RequestMapping(value="goDeclarationAdminList.adm")
	public ModelAndView goDeclarationAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
												@RequestParam(value="searchContent", required=false)String content) {
		Search search = new Search(content);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		try {
			int listCount = as.selectDeclarationCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				mv.addObject("list", as.selectDeclarationList(info, search));
			}
			mv.addObject("pi", info);
			mv.addObject("search", search);
			mv.setViewName("admin/declarationAdmin/declarationAdminList");
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "Notice 조회 실패!");
		}
		return mv;
	}
	
	@RequestMapping(value="goOrderAdminList.adm")
	public ModelAndView goOrderAdminList(ModelAndView mv, @ModelAttribute PageInfo pi, 
											@RequestParam(value="searchContent", required=false)String content) {
		Search search = new Search(content);
		int currentPage = 1;
		if(pi.getCurrentPage() > 0) {
			currentPage = pi.getCurrentPage();
		}
		try {
			int listCount = as.selectOrderCount(search);
			PageInfo info = Pagination.getPageInfo(currentPage, listCount);
			if(listCount != 0) {
				mv.addObject("list", as.selectOrderList(info, search));
			}
			mv.addObject("pi", info);
			mv.addObject("search", search);
			mv.setViewName("admin/orderAdmin/orderAdminList");
		} catch (AdminException e){
			mv.setViewName("common/errerPage");
			mv.addObject("errorMessage", "Notice 조회 실패!");
		}
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
