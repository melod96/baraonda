package com.kh.baraonda.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.baraonda.member.model.exception.LoginException;
import com.kh.baraonda.member.model.service.MemberService;
import com.kh.baraonda.member.model.vo.Member;

@SessionAttributes("loginUser") 
@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms ;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//암호화 로그인2 - 솔트를 고려한 방법
		@RequestMapping("login.me")
		public String loginCheck(Member m , Model model) {
			
			try {
				//이렇게 ServiceImpl에 전달해 준뒤 거기에서 암호 처리를 해줘야한다.
				Member loginUser = ms.loginMember(m);
				
				model.addAttribute("loginUser", loginUser);
				System.out.println("loginUser : " + loginUser);
				return "redirect:goMain.me";
				
			} catch (LoginException e) {
				
				model.addAttribute("msg", e.getMessage());
				
				return "common/errorPage";
				
			}
			
		}
	
	//로그아웃
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		status.setComplete();
		
		return "redirect:main.m";
	}
	
	
	//회원 가입 폼으로 이동시키는 메소드
	@RequestMapping("joinCompany.me")
	public String showMemberJoinView() {
		return "member/joinCompany";
	}
		
	
	@RequestMapping("goMain.me")
	public String goMain() {
		
		return "redirect:main.m";
	}
	
	//회원가입
	@RequestMapping("insert.me")
	public String insertMember(Model model, Member m, HttpServletRequest request) {
		//비밀번호 평문으로 출력됨
		System.out.println("Controller insert Member m : " + m);
		String encPassword = "";
		
		int result = -99;
		
		if(m.getPassword() != null && m.getPassword() != "") {
			System.out.println("일반회원가입시" + m.getPassword());
			
			encPassword = passwordEncoder.encode(m.getPassword());
			
			m.setPassword(encPassword);
			
			System.out.println("암호화 후 : " + m);
			
			
		
			result = ms.insertMember(m);
		}else if(request.getAttribute("id1") != null || request.getAttribute("id1")!= "") {
			System.out.println("기업회원가입시");
			encPassword = passwordEncoder.encode(request.getParameter("password1"));
			
			
			
			m.setId(request.getParameter("id1"));
			m.setPassword(encPassword);
			m.setCompany_name(request.getParameter("nick_name1"));
			m.setName(m.getCeo_name());
			m.setNick_name("#기업");
			
			System.out.println("기업 가입시 : " + m);
			
			result = ms.insertCompany(m);
		}
		
		Member member = ms.selectOne(m);
		
		if(result > 0) {
			int result2 =ms.insertPoint(member);
			
			if(result2 > 0) {
				return "redirect:goMain.me";
			}else {
				model.addAttribute("msg", "포인트 생성 실패");
				return "common/errorPage";
			}
		}else {
			model.addAttribute("msg", "기업회원가입실패");
			return "common/errorPage";
		}
	}
	
	
	
	@SuppressWarnings("null")
	@RequestMapping("checkId.me")
	public @ResponseBody int duplicationCheck(@RequestParam String id){
		
		Member m = new Member();
		m.setId(id);
		
		System.out.println("cont id : " + id);
		
		int result =  ms.selectIdCheck(m);
		
		return result;
	}
	
	
	@SuppressWarnings("null")
	@RequestMapping("checkBizID.me")
	public @ResponseBody int checkBizID(@RequestParam String bizID){
		
		Member m = new Member();
		m.setCompany_no(bizID);
		
		System.out.println("cont bizID : " + bizID);
		
		int result =  ms.selectBizIDCheck(m);
		
		return result;
	}
	
	@SuppressWarnings("null")
	@RequestMapping("checkNick.me")
	public @ResponseBody int checkNick(@RequestParam String nick_name){
		
		Member m = new Member();
		m.setNick_name(nick_name);
		
		System.out.println("cont nick_name : " + nick_name);
		
		int result =  ms.selectNickCheck(m);
		
		return result;
	}
	
	
	
	
	@RequestMapping("findId.me")
	public String findId() {
	
		return "common/findId";
	}
	
	@RequestMapping("selectIds.me")
	public String selectIds(@RequestParam String email, @RequestParam String name, Model model) {
		
		System.out.println("cont email : " + email);
		System.out.println("cont name : " + name);
		
		Member m = new Member();
		m.setName(name);
		m.setEmail(email);
		
		ArrayList<Member> findIdList = ms.selectIds(m);
		System.out.println("findIdList : " + findIdList);
	
		model.addAttribute("findIdList", findIdList );
	
		return "common/findIdResult";
	}
	
	
	@RequestMapping("changePwd.me")
	public String changePwd() {
	
		return "common/changePwd";
	}
	
	@RequestMapping("changePwdResult.me")
	public String changePwdResult(@RequestParam String idd, Model model) {
	
		model.addAttribute("idd",idd);
		return "common/changePwdResult";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
