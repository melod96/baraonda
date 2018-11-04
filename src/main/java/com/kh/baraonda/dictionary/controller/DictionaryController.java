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

@Controller
public class DictionaryController {

	@Autowired
	private DictionaryService ds;
	
	@RequestMapping("foodDictionary.dt")
	public String foodDictionaryPage(FoodDictionary fd, Model model, PageInfo pi) {
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
