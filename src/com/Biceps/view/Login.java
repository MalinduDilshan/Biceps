/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author MaLindu DiLshan
 */
public class Login implements MouseListener{
	private JFrame j;
	private JLabel l1,l2,l3,l4,l6,l7,l8;
	private JTextField t1;
	private JPasswordField pf;
	private JSeparator js;
	private Container c;
	private MALINDU n;	
	private String un,pw;
	
	
void setGui(){
	n=new MALINDU();
	j=n.getFrame("Login",640,360);
	j.setResizable(false);
	j.setLocationRelativeTo(null);
	c=j.getContentPane();
	j.setAlwaysOnTop (false);
	c.setLayout(null);

	l1=n.getLabel("Login",20,40,180,100,50);
	c.add(l1);
	
	js=n.getSeparator(135,110);
	c.add(js);
	
	l3=n.getLabel("Password",180,180,100,50,18);
	c.add(l3); 
			
	t1=n.getField(300,120,295,30);
	c.add(t1);

	pf=n.getPasswordField(240,170);
	c.add(pf);

}
void adminLogin(){
	


	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/log.png"));
	l6=n.getLabel("",390,230,120,90,0);

	l6.setIcon(submitIcon);
	l6.setToolTipText("Click Here to Login");
	c.add(l6);



	l2=n.getLabel("Admin Name",180,130,120,50,18);
	c.add(l2);

	ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/admin.jpg"));
	l4=n.getLabel("",0,0,640,360,0);     
	l4.setIcon(icon2);
        
	c.add(l4);


	l6.addMouseListener(this);
	
	j.setVisible(true);

}
void instructorLogin(){



	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/log.png"));
	l7=n.getLabel("",390,230,120,90,0);

	l7.setIcon(submitIcon);
	l7.setToolTipText("Click Here to Login");
	c.add(l7);



	l2=n.getLabel("User Name",180,130,120,50,18);
	c.add(l2);
		
	ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/inst.png"));
	l4=n.getLabel("",0,0,640,360,0);     
	l4.setIcon(icon2);
        
	c.add(l4);


	l7.addMouseListener(this);


	j.setVisible(true);

}
void memberLogin(){

	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/log.png"));
	l8=n.getLabel("",390,230,120,90,0);

	l8.setIcon(submitIcon);
	l8.setToolTipText("Click Here to Login");
	c.add(l8);



	l2=n.getLabel("User Name",180,130,120,50,18);
	c.add(l2);
		
	ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/admin.jpg"));
	l4=n.getLabel("",0,0,640,360,0);     
	l4.setIcon(icon2);
        
	c.add(l4);


	l8.addMouseListener(this);


	j.setVisible(true);



}
public void mouseClicked(MouseEvent event){
	un=String.valueOf(t1.getText());
	pw=String.valueOf(pf.getText());
	
	Message msg = new Message();
	
		if(event.getSource()==l6)
		{
			
			if(un.equals("Admin")&&pw.equals("admin")){
	AdminMenu m=new AdminMenu();
	m.setGui();
	m.setLayout();
	j.dispose();
			}
			else 
		msg.warningMsg("Username or Password is Wrong!", j);
		}
		
		
		
		
		
		else if(event.getSource()==l7)
		{
		Instructor ins=new Instructor();
		DataBaseInstructor dbi = new DataBaseInstructor();
		ins=dbi.search(un);
		
			if(un.equals(ins.getUsername())&&pw.equals(ins.getPassword())){
	InstructorMenu m=new InstructorMenu();
	m.setGui();
	m.setLayout(ins.getFname());
	j.dispose();
		}
		else 
		msg.warningMsg("Username or Password is Wrong!", j);
		}
		
		
		
		
		
		
		
	else if(event.getSource()==l8)
		{
		Member dox=new Member();
		DataBaseMember dbm = new DataBaseMember();
		dox=dbm.search(un);
	
		if(un.equals(dox.getUsername())&&pw.equals(dox.getPassword())){
	MemberMenu m=new MemberMenu();
	m.setGui();
	m.setLayout(dox.getFname(),un);
	j.dispose();
				}
			else 
		msg.warningMsg("Username or Password is Wrong!", j);
		}
}
			
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}	
}	
			
		

			


