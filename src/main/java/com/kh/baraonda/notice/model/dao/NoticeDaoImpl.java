package com.kh.baraonda.notice.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.notice.model.exception.NoticeException;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Override
	public int selectNoticeListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Notice2.selectNoticeListCount");
	}

	@Override
	public ArrayList<Board> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pgif) throws NoticeException {
		ArrayList<Board> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Notice2.selectNoticeList", null, rowBounds);
						
		if(list == null){
			sqlSession.close();
			throw new NoticeException("공지사항 조회 실패");
		}
		
		return list;
	}

}
