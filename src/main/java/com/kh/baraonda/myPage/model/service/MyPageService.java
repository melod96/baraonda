package com.kh.baraonda.myPage.model.service;

import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Point;

public interface MyPageService {

	Point selectPoint(Member loginUser);

	int updateMemberInfo(Member m);

	void insertPhoto(Files file);

	Files selectPhoto(Member loginUser);

	Footprints selectFootprints(Member loginUser);


}
