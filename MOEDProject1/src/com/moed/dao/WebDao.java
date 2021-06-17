package com.moed.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WebDao {

	String sql = "select * from userdata where uname=? and pass=?";
	String url = "jdbc:mysql://localhost:3306/neon";
	String username = "root";
	String password = "rdmsql09";
	
	public boolean check(String uname, String pass) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {return true;}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}
	
	
	
	

	
}
