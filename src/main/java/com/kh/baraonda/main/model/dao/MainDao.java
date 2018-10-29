package com.kh.baraonda.main.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.baraonda.main.model.exception.NoticeSelectListException;
import com.kh.baraonda.main.model.vo.PageInfo;
import com.kh.baraonda.notice.model.vo.Notice;

public class MainDao {
	
		//게시글 목록 조회용 메소드
		public ArrayList<Notice> selectNotice(SqlSession session) throws NoticeSelectListException {
			ArrayList<Notice> list = null;
			
			list = (ArrayList)session.selectList("Main.selectNotice", null);
			
			System.out.println("Dao list : " + list);
			
			if(list == null){
				session.close();
				throw new NoticeSelectListException("게시뮬 조회 실패!");
			}
			
			return list;
		}
		
		
		
		/*PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> noticeList = null;
		
		String query = prop.getProperty("searchNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			noticeList = new ArrayList<Notice>();
			
			while(rset.next()){
				Notice n = new Notice();
				n.setRownum(rset.getInt(1));
				n.setnNo(rset.getInt("BOARD_NO"));
				n.setnType(rset.getInt("BOARD_TYPE"));
				n.setnTitle(rset.getString("BOARD_TITLE"));
				n.setnContent(rset.getString("BOARD_CONTENT"));
				n.setnDate(rset.getDate("BOARD_DATE"));
				n.setModifyDate(rset.getDate("MODIFY_DATE"));
				n.setnStatus(rset.getInt("BOARD_STATUS"));
				n.setnCount(rset.getInt("BOARD_COUNT"));
				
				noticeList.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return noticeList;
	}
*/

}
