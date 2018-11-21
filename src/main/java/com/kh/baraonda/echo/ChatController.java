package com.kh.baraonda.echo;

import static com.kh.baraonda.echo.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.baraonda.admin.model.vo.AdminBoard;
import com.kh.baraonda.admin.model.vo.Member;

public class ChatController {

	public Member doEcho(AdminBoard adminBoard) {
		Connection con = getConnection();
		
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = "SELECT M.MEMBER_NO, M.NICK_NAME, F.FILES_ROOT, F.FILES_CHANGE_TITLE " + 
						"FROM MEMBER M " + 
						"JOIN FILES F ON(M.MEMBER_NO = F.F_REFERENCE_NO) " + 
						"WHERE 1 = 1 " + 
						"AND MEMBER_NO = ? " + 
						"AND FILES_SECESSION = 0" + 
						"AND FILES_TYPE = 1";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminBoard.getBoard_no());

			rset = pstmt.executeQuery();
			
			if(rset.next()){
				member = new Member();
				
				member.setMember_no(rset.getInt("member_no"));
				member.setNick_name(rset.getString("nick_name"));
				member.setFiles_root(rset.getString("files_root"));
				member.setFiles_change_title(rset.getString("files_change_title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		query = "INSERT INTO CHAT VALUES(SEQ_CHAT_NO.NEXTVAL, ?, ?, SYSDATE)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminBoard.getBoard_no());
			pstmt.setString(2, adminBoard.getContent());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
				
		return member;
	}
	
}
