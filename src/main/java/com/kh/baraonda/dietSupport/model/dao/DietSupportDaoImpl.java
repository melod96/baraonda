package com.kh.baraonda.dietSupport.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dietSupport.model.exception.DietSupportSelectListException;
import com.kh.baraonda.dietSupport.model.vo.HealthCenter;

@Repository
public class DietSupportDaoImpl implements DietSupportDao{

	@Override
	public int selectCenterListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("HealthCenter.selectListCount");
	}

	@Override
	public ArrayList<HealthCenter> selectCenter(SqlSessionTemplate sqlSession, PageInfo pgif) throws DietSupportSelectListException {
		ArrayList<HealthCenter> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
		
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("HealthCenter.selectCenter", null, rowBounds);
		
//		System.out.println(list);
		
		if(list == null){
			sqlSession.close();
			throw new DietSupportSelectListException("게시물 조회 실패");
		}
		
		
		return list;
	}

	@Override
	public int searchCenterListCount(SqlSessionTemplate sqlSession, String state) {
		
		return sqlSession.selectOne("HealthCenter.searchListCount",state);
	}

	@Override
	public ArrayList<HealthCenter> searchCenter(SqlSessionTemplate sqlSession, String state, PageInfo pgif) throws DietSupportSelectListException {
		ArrayList<HealthCenter> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
		
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("HealthCenter.searchCenter", state, rowBounds);
		
//		System.out.println(list);
		
		if(list == null){
			sqlSession.close();
			throw new DietSupportSelectListException("게시물 조회 실패");
		}
		
		
		return list;
	}


	

}
