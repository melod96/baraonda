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
		
		String date ="" + new Date();
		//시간을 제외한 년, 월, 일만 담아서 출력
		String date1 = date.split("\\s")[0] + date.split("\\s")[1] + date.split("\\s")[2];
		
		if(returnObj instanceof Member) {
			Member m = (Member)returnObj;
			logger.info("$"+ date1 +"^"+ m.getMember_no()+"^"+ m.getId() + "$");
		}
		
	}
	
	
}



















