package toyProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import toyProject.JDBCUtil;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String MEMBER_INSERT = "insert into MEMBER(MEMBER_ID, NAME, PHONE_NUMBER) values(?, ?, ?)";
	private final String MEMBER_UPDATE = "update MEMBER set PHONE_NUMBER = ? where MEMBER_ID = ? ";
	private String MEMBER_DELETE = "delete MEMBER where MEMBER_ID = ?";
	private final String MEMBER_LIST = "select * from MEMBER";
	private final String MEMBER_SELECT = "select * from MEMBER where MEMBER_ID = ?";
	
	//회원 등록
	public void insertMember(String MEMBER_ID, String NAME, String PHONE_NUMBER) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_INSERT);
			stmt.setString(1, MEMBER_ID);
			stmt.setString(2, NAME);
			stmt.setString(3, PHONE_NUMBER);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 수정
	public void updateMember(String MEMBER_ID, String PHONE_NUMBER) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, PHONE_NUMBER);
			stmt.setString(2, MEMBER_ID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 삭제
	public void deleteMember(String MEMBER_ID) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setString(1, MEMBER_ID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 목록 검색
	public void getMemberList() {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
					
			if(rs.next()) {
				System.out.println("\t\t" + "### MemberList ###");
				do {
					System.out.print("\t" + "[" + rs.getString("MEMBER_ID") + " : ");
					System.out.print(rs.getString("NAME") + " : ");
					System.out.print(rs.getString("PHONE_NUMBER") + "]" + "\n");	
					}
				while(rs.next());
			}else {
				System.out.println("\t\t" + "!! THERE IS NO MEMBER !!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	
	// 회원 상세 조회
	public boolean selectMember(String MEMBER_ID) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_SELECT);
			stmt.setString(1, MEMBER_ID);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			} 
			else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
			
		}
		return false;
	}
}
