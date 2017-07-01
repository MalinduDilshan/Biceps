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
public class DataBasePayment{

private Connection con;
private PreparedStatement pst;
private ResultSet rs;


void insert(Payment dox){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";
		String query="insert into payment (username,type,amt)values(?,?,?)";

		con=DriverManager.getConnection(dbpath,"root","");
		pst=con.prepareStatement(query);

		pst.setString(1,dox.getUserName());
		pst.setString(2,dox.getPayType());
		pst.setString(3,dox.getPayAmt());
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
}
