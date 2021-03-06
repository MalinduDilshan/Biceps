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
public class DataBaseMember{

private Connection con;
private PreparedStatement pst;
private Statement st;
private ResultSet rs;


void insert(Member dox){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";
		String query="insert into user (fname, lname, title, gender, username, password, contact, chart, payment)values(?,?,?,?,?,?,?,?,?)";

		con=DriverManager.getConnection(dbpath,"root","");
		pst=con.prepareStatement(query);

		pst.setString(1,dox.getFname());
		pst.setString(2,dox.getLname());
		pst.setString(3,dox.getTitle());
		pst.setString(4,dox.getGender());
		pst.setString(5,dox.getUsername());
		pst.setString(6,dox.getPassword());
		pst.setString(7,dox.getContact());
		pst.setString(8,dox.getChart());
		pst.setString(9,dox.getPayment());
		
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

void update(Member dox,String tempuser){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";

		con=DriverManager.getConnection(dbpath,"root","");
		st=con.createStatement();
		st.executeUpdate("update user set fname='"+dox.getFname()+"', lname='"+dox.getLname()+"', title='"+dox.getTitle()+"', gender='"+dox.getGender()+"',username='"+dox.getUsername()+"',password='"+dox.getPassword()+"', contact='"+dox.getContact()+"', chart='"+dox.getChart()+"', payment='"+dox.getPayment()+"' where username='"+tempuser+"'");
				
		con.close();
	
	    }
catch(ClassNotFoundException e){
		System.out.println("SQL Error class not found in update"+"\t"+e.getMessage());
	    }
catch(SQLException e){
		System.out.println("SQL Error in update method"+"\t"+e.getMessage());
	    }
}
void delete(String tempuser){

	try{
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";

		con=DriverManager.getConnection(dbpath,"root","");
		st=con.createStatement();
		st.executeUpdate("delete from user where username='"+tempuser+"'");
				
		con.close();
	
	    }
catch(ClassNotFoundException e){
		System.out.println("SQL Error class not found in delete"+"\t"+e.getMessage());
	    }
catch(SQLException e){
		System.out.println("SQL Error in delete method"+"\t"+e.getMessage());
	    }
}
Member search(String tempuser){
		

		Member dox=new Member();

	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		String dbpath="jdbc:mysql://localhost/gym";

		con=DriverManager.getConnection(dbpath,"root","");
		st=con.createStatement();
		rs=st.executeQuery("select *from user where username='"+tempuser+"'");

			while(rs.next()){
			dox.setFname(rs.getString(1));
			dox.setLname(rs.getString(2));
			dox.setTitle(rs.getString(3));
			dox.setGender(rs.getString(4));
			dox.setUsername(rs.getString(5));
			dox.setPassword(rs.getString(6));
			dox.setContact(rs.getString(7));
			dox.setChart(rs.getString(8));
			dox.setPayment(rs.getString(9));

			}				
		con.close();

			
	    }
catch(ClassNotFoundException e){
		System.out.println("SQL Error class not found in search"+"\t"+e.getMessage());
	    }
catch(SQLException e){
		System.out.println("SQL Error in search method"+"\t"+e.getMessage());
	    }
	return dox;		
	}

} 
