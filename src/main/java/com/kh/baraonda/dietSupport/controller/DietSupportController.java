package com.kh.baraonda.dietSupport.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.dietSupport.model.exception.DietSupportSelectListException;
import com.kh.baraonda.dietSupport.model.service.DietSupportService;
import com.kh.baraonda.dietSupport.model.vo.BMI;
import com.kh.baraonda.dietSupport.model.vo.CaloriePresciption;
import com.kh.baraonda.dietSupport.model.vo.HealthCenter;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;

@Controller
public class DietSupportController {
	
	@Autowired
	private DietSupportService dss;
	
	@Autowired
	private MainService ms;
	
	@RequestMapping("BMI.ds")
	public String bmiPage(Model model) {
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		return "dietSupport/BMI";
	}
	
	@RequestMapping("BMICal.ds")
	public String bmiCal(Model model,BMI b) {
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		model.addAttribute("b", b);
		double bmibmi = b.getWeight()/((b.getHeight()/100.0)*(b.getHeight()/100.0));
		DecimalFormat df = new DecimalFormat("#.##");
		double bmi = Double.parseDouble(df.format(bmibmi));
		b.setBmi(bmi);
		
		return "dietSupport/BMIDetail";
	}
	
	@RequestMapping("caloriePresciption.ds")
	public String caloriePresciptionPage(Model model) {
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		return "dietSupport/caloriePresciption";
	}
	
	@RequestMapping("calpre.ds")
	public String calpreCal(Model model, CaloriePresciption cp) {
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		model.addAttribute("cp",cp);
		
		double avgweight = 0;
		double bm = 0;
		if(cp.getGender()=="M") {
			avgweight = (cp.getHeight()-100) * 0.9;
			bm = cp.getWeight()*24*1;
		}else {
			avgweight = (cp.getHeight()-100) * 0.85;
			bm = cp.getWeight()*24*0.9;
		}
		DecimalFormat df = new DecimalFormat("#.#");
		int bm1 = (int)(bm);		//기초 대사량
		double avgweight1 = Double.parseDouble(df.format(avgweight));
		cp.setAvgweight(avgweight1);
		cp.setBasal(bm1);
		
		double ae = 0;				//활동 대사량
		double ne = 0;				//필요 열량
		
		if(cp.getGender() == "M") {
			if(cp.getActivity().equals("No")) {
				ae = 0.4 * 6 * cp.getWeight();
				ne = avgweight1 * 20;
			}else if(cp.getActivity().equals("Little")) {
				ae = 1.3 * 6 * cp.getWeight();
				ne = avgweight1 * 25;
			}else if(cp.getActivity().equals("Nomal")) {
				ae = 2.6 * 6 * cp.getWeight();
				ne = avgweight1 * 30;
			}else if(cp.getActivity().equals("Many")) {
				ae = 3.1 * 6 * cp.getWeight();
				ne = avgweight1 * 35;
			}else {
				ae = 3.9 * 6 * cp.getWeight();
				ne = avgweight1 * 40;
			}
		}else {
			if(cp.getActivity().equals("No")) {
				ae = 0.4 * 6 * cp.getWeight();
				ne = avgweight1 * 20;
			}else if(cp.getActivity().equals("Little")) {
				ae = 1.2 * 6 * cp.getWeight();
				ne = avgweight1 * 25;
			}else if(cp.getActivity().equals("Nomal")) {
				ae = 2.3 * 6 * cp.getWeight();
				ne = avgweight1 * 30;
			}else if(cp.getActivity().equals("Many")) {
				ae = 2.7 * 6 * cp.getWeight();
				ne = avgweight1 * 35;
			}else {
				ae = 3.5 * 6 * cp.getWeight();
				ne = avgweight1 * 40;
			}
		}
		double f = (bm1 + ae) * 0.1;
		
		cp.setAcienergy((int)ae);
		cp.setEnergy((int)f);
		cp.setNeedenergy((int)ne);
		
		int ex = cp.getNeedenergy()/(cp.getDateweight()*30);
		cp.setExercise(ex);
		
		return "dietSupport/caloriePresciptionDetail";
	}
	
	@RequestMapping("healthCenterList.ds")
	public String healthCenterListPage(Model model, PageInfo pi){
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		try {
			int listCount = dss.selectCenterListCount();
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<HealthCenter> centerlist = dss.selectCenter(pgif);
			
			model.addAttribute("clistcount", listCount);
			model.addAttribute("centerlist",centerlist);
			model.addAttribute("pi",pgif);
			
			return "dietSupport/healthCenterList";
			
		} catch (DietSupportSelectListException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping("searchHealthCenter.ds")
	public String searchHealthCenter(String state,Model model, PageInfo pi) {
		
		//명예의전당
		ArrayList<Fame> flist;
		//공지사항
		ArrayList<Notice> nlist;
		//다이어터랭킹
		ArrayList<Ranking> rlist;
		try {
			flist = ms.selectFame();
			model.addAttribute("flist", flist);
			nlist = ms.selectNotice();
			model.addAttribute("nlist", nlist);
			rlist = ms.selectRanking();
			model.addAttribute("rlist", rlist);
		} catch (MainSelectListException e1) {
			model.addAttribute("msg", e1.getMessage());
		}
		
		
		int currentPage =1;
		
		if(pi.getCurrentPage() > 0){
			currentPage = pi.getCurrentPage();
		}
		
		try {
			int listCount = dss.searchCenterListCount(state);
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<HealthCenter> centerlist = dss.searchCenter(state, pgif);

			model.addAttribute("clistcount",listCount);
			model.addAttribute("centerlist",centerlist);
			model.addAttribute("pi",pgif);
			model.addAttribute("search",state);
			
			return "dietSupport/healthCenterList";
		} catch (DietSupportSelectListException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
		
		
		
	}
	
}
