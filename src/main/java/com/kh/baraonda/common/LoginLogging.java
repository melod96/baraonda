package com.kh.baraonda.common;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import com.kh.baraonda.member.model.vo.Member;



@Component
@Aspect
public class LoginLogging {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginLogging.class);
	
	@Pointcut("execution(* com.kh.baraonda..*ServiceImpl.login*(..))")
	public void loginPointcut() {}
	
	@AfterReturning(pointcut="loginPointcut()", returning="returnObj")
	public void loginLog(JoinPoint jp, Object returnObj) {
		System.out.println("login ReturnObject : " + returnObj);
		
		String date = "" + new Date();
		
		if(returnObj instanceof Member) {
			Member m = (Member)returnObj;
			logger.info("$"  + m.getMember_no()+ m.getId() + "$");
		}
		
	}
	
	
}



















