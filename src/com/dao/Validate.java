package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.*;

import javax.sql.DataSource;

import org.hibernate.Session;

public class Validate {

	/////////////////////// Adminlogin//////////////////////////////////
	public static boolean adminlogin(String username, String password) {
		boolean st = false;

		try {

			// loading drivers for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");

			// creating connection with the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			st = rs.next();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return st;
	}

///////////////////////////////////////////List Of Teachers//////////////////////////////////////////////


///////////////////////////////////////List Of Class////////////////////////////////////////////////////	
	
}
