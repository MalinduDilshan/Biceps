/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import java.sql.*;
import java.util.*;
/**
 *
 * @author MaLindu DiLshan
 */
public class GetUserNames{

private List <String> userNameList;
	
	

public List getUserNames(){
		

userNameList = new ArrayList<String>();
		
userNameList.add("Select Your UserName");
		
try{
				
Class.forName("com.mysql.jdbc.Driver");
				
String a = "jdbc:mysql://localhost/gym";
				
Connection con = DriverManager.getConnection(a, "root", "");			
				
Statement st = con.createStatement();
				
ResultSet rs = st.executeQuery("select username from user");
				

while(rs.next()){
														
userNameList.add(rs.getString(1));
				
}
				
con.close();
		
}
		

catch(Exception e){
				
e.printStackTrace();
		
}
		
return userNameList;
	
}

public List getInstructorUserNames(){
		

userNameList = new ArrayList<String>();
		
userNameList.add("Select Your UserName");
		
try{
				
Class.forName("com.mysql.jdbc.Driver");
				
String a = "jdbc:mysql://localhost/gym";
				
Connection con = DriverManager.getConnection(a, "root", "");			
				
Statement st = con.createStatement();
				
ResultSet rs = st.executeQuery("select username from instructor");
				

while(rs.next()){
														
userNameList.add(rs.getString(1));
				
}
				
con.close();
		
}
		

catch(Exception e){
				
e.printStackTrace();
		
}
		
return userNameList;
	
}


}
