package com.kh.baraonda.dictionary.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dictionary.model.exception.DictionaryException;
import com.kh.baraonda.dictionary.model.vo.FoodDictionary;

@Repository
public class DictionaryDaoImpl implements DictionaryDao{

	@Override
	public int selectFoodListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Dictionary.selectFoodListCount");
	}

	@Override
	public ArrayList<FoodDictionary> selectFoodList(SqlSessionTemplate sqlSession, PageInfo pgif) throws DictionaryException {
		ArrayList<FoodDictionary> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
				
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
				
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Dictionary.selectFoodList", null, rowBounds);
				
		if(list == null){
			sqlSession.close();
			throw new DictionaryException("음식 칼로리 조회 실패");
		}
				
				
		return list;
	}

	@Override
	public int selectSearchFoodListCount(SqlSessionTemplate sqlSession, String search) {
		
		return sqlSession.selectOne("Dictionary.selectSearchFoodListCount",search);
	}

	@Override
	public ArrayList<FoodDictionary> selectSearchFoodList(SqlSessionTemplate sqlSession, String search, PageInfo pgif) throws DictionaryException {
		ArrayList<FoodDictionary> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
				
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
		
		String searchf = "%" + search + "%";
				
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Dictionary.selectSearchFoodList", searchf, rowBounds);
				
		if(list == null){
			sqlSession.close();
			throw new DictionaryException("음식 칼로리 조회 실패");
		}
				
				
		return list;
	}

	@Override
	public FoodDictionary selectFoodInfo(SqlSessionTemplate sqlSession, String food_no) {
		
		return sqlSession.selectOne("Dictionary.selectFoodInfo",food_no);
	}

}
