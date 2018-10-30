package com.kh.baraonda.common;

import java.util.UUID;

public class CommonUtils {

	
	public static String getRandomString() {
		
		
		//32비트의 랜덤한 문자를 생성해주는 클래스
		return UUID.randomUUID().toString().replaceAll("-", "");
		//객체로 반환되기 때문에 String으로 변경 한 뒤 "-"를 제거함.
	}

}
