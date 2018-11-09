package com.kh.baraonda.exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExchangeController {
	
	
	@RequestMapping("exchangePage.ex")
	public String exchangePage(String change_type,Model model) {
		
		model.addAttribute("type", change_type);
		
		return "payment/ExpPayment";
	}
}
