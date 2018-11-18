package com.kh.baraonda.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	@RequestMapping("createCannel.ch")
	public String create() {
		
		return "chat/createCannel";
	}
	
	@RequestMapping("connectCannel.ch")
	public String connect() {
		
		return "chat/connectCannel";
	}
}
