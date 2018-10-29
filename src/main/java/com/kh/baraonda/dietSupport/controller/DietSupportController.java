package com.kh.baraonda.dietSupport.controller;

import java.text.DecimalFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.baraonda.dietSupport.model.vo.BMI;
import com.kh.baraonda.dietSupport.model.vo.CaloriePresciption;

@Controller
public class DietSupportController {
	
/*	@Autowired
	private DietSupportService dss;*/
	
	@RequestMapping("BMI.ds")
	public String bmiPage() {
		return "dietSupport/BMI";
	}
	
	@RequestMapping("BMICal.ds")
	public String bmiCal(Model model,BMI b) {
		
		model.addAttribute("b", b);
		double bmibmi = b.getWeight()/((b.getHeight()/100.0)*(b.getHeight()/100.0));
		DecimalFormat df = new DecimalFormat("#.##");
		double bmi = Double.parseDouble(df.format(bmibmi));
		b.setBmi(bmi);
		
		return "dietSupport/BMIDetail";
	}
	
	@RequestMapping("caloriePresciption.ds")
	public String caloriePresciptionPage() {
		return "dietSupport/caloriePresciption";
	}
	
	@RequestMapping("calpre.ds")
	public String calpreCal(Model model, CaloriePresciption cp) {
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
		double f = (bm1 + ae) * 0.1;
		
		cp.setAcienergy((int)ae);
		cp.setEnergy((int)f);
		cp.setNeedenergy((int)ne);
		
		int ex = cp.getNeedenergy()/(cp.getDateweight()*30);
		cp.setExercise(ex);
		
		return "dietSupport/caloriePresciptionDetail";
	}
	
	@RequestMapping("healthCenterList.ds")
	public String healthCenterListPage() {
		return "dietSupport/healthCenterList";
	}
}
