package com.kh.baraonda.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.baraonda.exchange.model.service.ExchangeService;
import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.member.model.vo.Member;

@Controller
public class ExchangeController {
	
	@Autowired
	private ExchangeService ecs;
	
	@RequestMapping("exchangePage.ex")
	public String exchangePage(String change_type,Model model) {
		Product p = ecs.selectProduct(change_type);
		
		model.addAttribute("product",p);
		
		return "payment/ExpPayment";
	}
	
	@RequestMapping("expExchange.ex")
	public String expExchange(Exchange ex, Model model, @SessionAttribute("loginUser") Member m) {
		ex.setMember_no(m.getMember_no());
		
		String address = ex.getAccept_address2() + ex.getAccept_address3();
		
		ex.setAccept_address2(address);
		//insert
		ecs.insertOrder(ex);
		ecs.insertAddress(ex);
		int currval = ecs.orderCurrval();
		int currval2 = ecs.addressCurrval();
		
		Deliver_record dr = new Deliver_record();
		dr.setOrders_no(currval);
		dr.setAddress_no(currval2);
		
		ecs.insertDeliver(dr);
		
		return "redirect:growingChicksView.my";
	}
}
