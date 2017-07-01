/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import java.sql.*;
/**
 *
 * @author MaLindu DiLshan
 */
public class DataBaseChart{

private Connection con;
private PreparedStatement pst;
private Statement st;
private ResultSet rs;


void insert(Chart dox){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";
		String query="insert into chart (chart_type, qty, day1, day2, day3, day4, day5, day6, day7)values(?,?,?,?,?,?,?,?,?)";

		con=DriverManager.getConnection(dbpath,"root","");
		pst=con.prepareStatement(query);

		pst.setString(1,dox.getChart());
		pst.setString(2,dox.getQty());
		pst.setString(3,dox.getDay1());
		pst.setString(4,dox.getDay2());
		pst.setString(5,dox.getDay3());
		pst.setString(6,dox.getDay4());
		pst.setString(7,dox.getDay5());
		pst.setString(8,dox.getDay6());
		pst.setString(9,dox.getDay7());
		pst.executeUpdate();				
		con.close();
	
	    }
catch(ClassNotFoundException e){
		System.out.println("My SQL Error class not found in insert"+"\t"+e.getMessage());
	    }
catch(SQLException e){
		System.out.println("My SQL Error in insert method"+"\t"+e.getMessage());
	    }
}
void delete(String tempchart){

	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";

		con=DriverManager.getConnection(dbpath,"root","");
		st=con.createStatement();
		st.executeUpdate("delete from chart where chart_type='"+tempchart+"'");
				
		con.close();
	
	    }
catch(ClassNotFoundException e){
		System.out.println("SQL Error class not found in delete"+"\t"+e.getMessage());
	    }
catch(SQLException e){
		System.out.println("SQL Error in delete method"+"\t"+e.getMessage());
	    }
}

} 
