package com.kh.baraonda.tips.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TipsController {
	
		//다이어트꿀팁으로 이동하는 페이지
		@RequestMapping("tips.tp")
		public String selectTips() {
			return "tips/tips";
		}
		
		//다이어트꿀팁 작성으로 이동하는 페이지
		@RequestMapping("tipsWrite.tp")
		public String selectTipsWrite() {
			return "tips/tipsWrite";
		}
		
		//다이어트꿀팁 디테일로 이동하는 페이지
		@RequestMapping("tipsDetail.tp")
		public String selectTipsDetail() {
			return "tips/tipsDetail";
		}
		
		//다이어트꿀팁 업데이트로 이동하는 페이지
		@RequestMapping("tipsUpdate.tp")
		public String selectTipsUpdate() {
			return "tips/tipsUpdate";
		}

}
