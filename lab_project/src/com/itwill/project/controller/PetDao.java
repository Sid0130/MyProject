package com.itwill.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public enum PetDao {
	INSTANCE;
	
	
	PetDao() {
		
		try {
			DriverManager.registerDriver(new OracleDriver()); // 오라클에 드라이버 등록
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close(); 
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}

	
}
