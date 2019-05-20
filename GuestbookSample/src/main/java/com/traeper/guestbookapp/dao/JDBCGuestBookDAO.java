package com.traeper.guestbookapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.traeper.guestbookapp.vo.GuestBookVO;

public class JDBCGuestBookDAO implements GuestBookDAO {

	private PreparedStatement getPreparedStatement(final String sql)  {
		try {
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
		} catch (ClassNotFoundException e1) {
		}
		Connection conn;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection ("jdbc:cubrid:localhost:30000:GuestBookDB:::?charset=UTF-8", "dba", "1234");
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	@Override
	public String create(GuestBookVO guestBookVO) {
		PreparedStatement ps = getPreparedStatement(
				"INSERT INTO guestbook ( title, content, register_date, password ) "
				+ "VALUES ( ?, ?, now(), ? )");
		if(ps == null) {
			return null;
		}
		
		try {
			ps.setString(1, guestBookVO.getTitle());
			ps.setString(2, guestBookVO.getContent());
			ps.setString(3, guestBookVO.getPassword());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<GuestBookVO> retrieve() {
		List<GuestBookVO> list = new ArrayList<GuestBookVO>();
		
		PreparedStatement ps = getPreparedStatement("SELECT * FROM guestbook");
		if(ps == null) {
			return null;
		}
		
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new GuestBookVO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
			}
			try {
				rs.close();
			} catch (SQLException e) {
			}
			
		}
		
		return list;
	}

	@Override
	public void update(GuestBookVO guestBookVO) {
		PreparedStatement ps = getPreparedStatement(
				" UPDATE guestbook SET "
				+ "title = ?,"
				+ "content = ?, "
				+ "password  = ? "
				+ "WHERE guestbook_id = ?" 
				);
		if(ps == null) {
			return;
		}
		
		try {
			ps.setString(1, guestBookVO.getTitle());
			ps.setString(2, guestBookVO.getContent());
			ps.setString(3, guestBookVO.getPassword());
			ps.setString(4, guestBookVO.getGuestbookId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String guestBookId) {
		PreparedStatement ps = getPreparedStatement(
				"DELETE FROM guestbook WHERE guestbook_id = ? ");
		if(ps == null) {
			return;
		}
		
		try {
			ps.setString(1, ""+guestBookId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public GuestBookVO getGuestbook(String guestbookId) {
		throw new UnsupportedOperationException();
	}

}
