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
public class LoginMenu implements MouseListener{
	private JFrame j2;
	private JLabel background,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	private Container c;
	private JSeparator js;
	private MALINDU n;

void setGui(){
	n=new MALINDU();
	j2=n.getFrame("Biceps Login",620,580);
	j2.setLocationRelativeTo(null);
	j2.setResizable(false);
	c=j2.getContentPane();
	j2.setAlwaysOnTop (false);
	c.setLayout(null);

}
void setLayout(){		   	

	ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/user.png"));
	l1=n.getLabel("",30,100,100,160,0);
	l1.setIcon(icon2);
	l1.setToolTipText("Click Here to Login as admin");
   
      
	c.add(l1);
 
	l4=n.getLabel("Admin Login",140,100,500,160,30);      
	c.add(l4);
	
	
	
	ImageIcon icon3 = new ImageIcon(getClass().getResource("/resources/user.png"));
	l2=n.getLabel("",130,200,100,160,0); 
	l2.setIcon(icon3);
	l2.setToolTipText("Click Here to Login as member");
 
	c.add(l2);
	
	l8=n.getLabel("Member Login",240,200,500,160,30);      
	c.add(l8);

	


	
	ImageIcon icon6 = new ImageIcon(getClass().getResource("/resources/user.png"));
	l9=n.getLabel("",230,300,100,160,0); 
	l9.setIcon(icon6);
	l9.setToolTipText("Click Here to Login as instructor");
 
	c.add(l9);
	
	l5=n.getLabel("Instructor Login",340,300,500,160,30);      
	c.add(l5);
	

	ImageIcon icon5=new ImageIcon(getClass().getResource("/resources/close.png"));
	l3=n.getLabel("",330,400,100,160,0);
	l3.setIcon(icon5);
	l3.setToolTipText("Click Here to exit");
   
    c.add(l3);
 
	l6=n.getLabel("Exit",440,400,500,160,30);      
	c.add(l6);
	
	
	
	l7=n.getLabel("Biceps Login",10,10,400,100,40); 
	l7.setFont(new Font("Segoe Print", Font.PLAIN, 40));
	c.add(l7);
	
	js=n.getSeparator(253,72,220,10);
	c.add(js);

	background=n.getLabel("",0,0,620,580,0);
	ImageIcon icon = new ImageIcon(getClass().getResource("/resources/menu.jpg")); 
	background.setIcon(icon);   
	c.add(background);
	
	l1.addMouseListener(this);
	l2.addMouseListener(this);
	l3.addMouseListener(this);
	l9.addMouseListener(this);
	
	j2.setVisible(true);
}
public void mouseClicked(MouseEvent event){
		if(event.getSource()==l1)
		{
			Login m=new Login();
			m.setGui();
			m.adminLogin();
			j2.dispose();
		}
		else if(event.getSource()==l2)
		{
			Login m=new Login();
			m.setGui();
			m.memberLogin();
			j2.dispose();
		}
		else if(event.getSource()==l9)
		{
			Login m=new Login();
			m.setGui();
			m.instructorLogin();
			j2.dispose();
		}
		else if(event.getSource()==l3)
		{
			System.exit(0);
		}
}
			
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}	
}
