package com.kh.baraonda.dietSupport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.dietSupport.model.vo.BMI;

@Controller
public class DietSupportController {
	
/*	@Autowired
	private DietSupportService dss;*/
	
	@RequestMapping("BMI.ds")
	public String bmiCheck() {
		return "dietSupport/BMI";
	}
	
	@RequestMapping("BMICal.ds")
	public String bmiCal(Model model,BMI b) {
		
		model.addAttribute("b", b);
		double h=(b.getHeight()/100.0);
		System.out.println(h);
		double bmibmi = b.getWeight()/((b.getHeight()/100.0)*(b.getHeight()/100.0));
		double bmi = Math.round(bmibmi*10)/10F;
		System.out.println(b.getWeight());
		System.out.println(b.getHeight());
		System.out.println(bmi);
		b.setBmi(bmi);
		
		return "dietSupport/BMIDetail";
	}
}
