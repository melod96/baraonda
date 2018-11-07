package com.kh.baraonda.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		return "redirect:goMain.me";
	}
	
	
	//회원 가입 폼으로 이동시키는 메소드
	@RequestMapping("memberJoinView.me")
	public String showMemberJoinView() {
		return "member/memberJoin";
	}
		
	//ajax통신
	@RequestMapping("duplicationCheck.me")
	public ModelAndView duplication(String id, ModelAndView mv) {
		System.out.println("UserId : " + id);
		
		Member m = new Member();
		m.setId(id);
		
		mv.addObject("member", m);
		mv.setViewName("jsonView");
		
		
		return mv;
	}
	
	@RequestMapping("goMain.me")
	public String goMain() {
		
		return "main/main";
	}
	
	//회원가입
	@RequestMapping("insert.me")
	public String insertMember(Model model, Member m) {
		//비밀번호 평문으로 출력됨
		System.out.println("Controller insert Member m : " + m);
		
		String encPassword = passwordEncoder.encode(m.getPassword());
		
		m.setPassword(encPassword);
		
		System.out.println("암호화 후 : " + m);
		
		int result = -99;
		
		if(m.getCompany_right() == 1 ) {
			m.setCompany_name(m.getNick_name());
			m.setName(m.getCeo_name());
			System.out.println("기업 가입시 : " + m);
			result = ms.insertCompany(m);
		}else {
			result = ms.insertMember(m);
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
}
