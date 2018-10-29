package com.kh.baraonda.myPage.model.service;

import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Point;

public interface MyPageService {

	Point selectPoint(Member loginUser);

}
