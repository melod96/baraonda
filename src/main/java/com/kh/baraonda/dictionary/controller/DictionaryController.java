package com.kh.baraonda.dictionary.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.Pagination;
import com.kh.baraonda.dictionary.model.exception.DictionaryException;
import com.kh.baraonda.dictionary.model.service.DictionaryService;
import com.kh.baraonda.dictionary.model.vo.FoodDictionary;
import com.kh.baraonda.main.model.exception.MainSelectListException;
import com.kh.baraonda.main.model.service.MainService;
import com.kh.baraonda.main.model.vo.Fame;
import com.kh.baraonda.main.model.vo.Ranking;
import com.kh.baraonda.notice.model.vo.Notice;

@Controller
public class DictionaryController {

	@Autowired
	private DictionaryService ds;
	
	@Autowired
	private MainService ms;
	
	@RequestMapping("foodDictionary.dt")
	public String foodDictionaryPage(FoodDictionary fd, Model model, PageInfo pi) {
		
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
			int listCount = ds.selectFoodListCount();
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<FoodDictionary> foodlist = ds.selectFoodList(pgif);
			
			model.addAttribute("foodlist",foodlist);
			model.addAttribute("pi",pgif);
			
			return "dictionary/foodDictionary";
		} catch (DictionaryException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("searchFoodDictionary.dt")
	public String searchFoodDictionary(FoodDictionary fd, Model model, PageInfo pi, String search) {
		
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
			int listCount = ds.selectSearchFoodListCount(search);
			
			PageInfo pgif = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<FoodDictionary> foodlist = ds.selectSearchFoodList(search, pgif);
			
			model.addAttribute("foodlist",foodlist);
			model.addAttribute("pi",pgif);
			model.addAttribute("search", search);
			
			return "dictionary/foodDictionary";
		} catch (DictionaryException e) {
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping("exerciseDictionary.dt")
	public String exerciseDictionaryPage() {
		
		return "dictionary/exerciseDictionary";
	}
	
	@RequestMapping("foodDetail.dt")
	public String foodInfo(String food_no, Model model) {
		FoodDictionary fd = ds.selectFoodInfo(food_no);
		
		model.addAttribute("foodinfo", fd);
		
		return "dictionary/foodDetail";
	}
}
