/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.Connection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.design.JasperDesign;
/**
 *
 * @author MaLindu DiLshan
 */

public class AdminMenu implements MouseListener{
	private JFrame j2;
	private JLabel background,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27;
	private Container c;
	private JSeparator js,js1,js2;
	private MALINDU n;

void setGui(){
	n=new MALINDU();
	j2=n.getFrame("Biceps Admin Menu",1080,710);
	j2.setResizable(false);
	j2.setLocationRelativeTo(null);
	c=j2.getContentPane();
	j2.setAlwaysOnTop (false);
	c.setLayout(null);

}
void setLayout(){   	

	ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/member.png"));
	l1=n.getLabel("",20,100,140,160,0);
	l1.setIcon(icon2);
	l1.setToolTipText("Click Here to Signup member");
   
      
	c.add(l1);
 

	l5=n.getLabel("Signup Member",160,90,500,160,20);      
	c.add(l5);
	
	ImageIcon icon3 = new ImageIcon(getClass().getResource("/resources/delete.png"));
	l2=n.getLabel("",20,250,140,160,0); 
	l2.setIcon(icon3);
	l2.setToolTipText("Click Here to delete member");
 
	c.add(l2);



	l6=n.getLabel("Delete Member",160,240,500,160,20);      
	c.add(l6);

	ImageIcon icon5=new ImageIcon(getClass().getResource("/resources/update.png"));
	l3=n.getLabel("",20,400,140,160,0);
	l3.setIcon(icon5);
	l3.setToolTipText("Click Here to update member");
   
      
	c.add(l3);
 

	l7=n.getLabel("Update Member",160,390,500,160,20);      
	c.add(l7);
	
	ImageIcon icon6=new ImageIcon(getClass().getResource("/resources/search.png"));
	l4=n.getLabel("",20,550,140,160,0);
	l4.setIcon(icon6);
	l4.setToolTipText("Click Here to Search member");
   
      
	c.add(l4);
	
	l8=n.getLabel("Search Member",160,540,500,160,20);      
	c.add(l8);





	ImageIcon icon7=new ImageIcon(getClass().getResource("/resources/member.png"));
	l9=n.getLabel("",350,100,140,160,0);
	l9.setIcon(icon7);
	l9.setToolTipText("Click Here to Signup instructor");
   
      
	c.add(l9);
 

	l13=n.getLabel("Signup Instructor",480,90,500,160,20);      
	c.add(l13);
	
	ImageIcon icon8 = new ImageIcon(getClass().getResource("/resources/delete.png"));
	l10=n.getLabel("",350,250,140,160,0); 
	l10.setIcon(icon8);
	l10.setToolTipText("Click Here to delete instructor");
 
	c.add(l10);



	l14=n.getLabel("Delete Instructor",480,240,500,160,20);      
	c.add(l14);

	ImageIcon icon9=new ImageIcon(getClass().getResource("/resources/update.png"));
	l11=n.getLabel("",350,400,140,160,0);
	l11.setIcon(icon9);
	l11.setToolTipText("Click Here to update instructor");
   
      
	c.add(l11);
 

	l15=n.getLabel("Update Instructor",480,390,500,160,20);      
	c.add(l15);

	ImageIcon icon10=new ImageIcon(getClass().getResource("/resources/search.png"));
	l12=n.getLabel("",350,550,140,160,0);
	l12.setIcon(icon10);
	l12.setToolTipText("Click Here to Search instructor");
   
      
	c.add(l12);
	
	l16=n.getLabel("Search Instructor",480,540,500,160,20);      
	c.add(l16);








	ImageIcon icon11=new ImageIcon(getClass().getResource("/resources/payment_d.png"));
	l17=n.getLabel("",730,100,140,160,0);
	l17.setIcon(icon11);
	l17.setToolTipText("Click Here to view Payement Details");
   
      
	c.add(l17);
 

	l20=n.getLabel("Payement Details",860,90,500,160,20);      
	c.add(l20);
	
	ImageIcon icon12 = new ImageIcon(getClass().getResource("/resources/member_d.png"));
	l18=n.getLabel("",730,250,140,160,0); 
	l18.setIcon(icon12);
	l18.setToolTipText("Click Here to view Member Details");
 
	c.add(l18);



	l21=n.getLabel("Member Details",860,240,500,160,20);      
	c.add(l21);

	ImageIcon icon13=new ImageIcon(getClass().getResource("/resources/instructor_d.png"));
	l19=n.getLabel("",730,400,140,160,0);
	l19.setIcon(icon13);
	l19.setToolTipText("Click Here to view Instructor Details");
   
      
	c.add(l19);
 

	l22=n.getLabel("Instructor Details",860,390,500,160,20);      
	c.add(l22);
	
	ImageIcon icon14=new ImageIcon(getClass().getResource("/resources/Logout.png"));
	l26=n.getLabel("",731,550,140,160,0);
	l26.setIcon(icon14);
	l26.setToolTipText("Click Here to Exit");
   
      
	c.add(l26);
	
	l27=n.getLabel("Logout",860,540,500,160,20);      
	c.add(l27);






	l23=n.getLabel("Member",20,1,400,100,30);        
	c.add(l23);


	l24=n.getLabel("Reports",750,1,400,100,30);        
	c.add(l24);


	l25=n.getLabel("Instructor",380,1,400,100,30);        
	c.add(l25);

	js=n.getSeparator(127,62,200,300);
	c.add(js);

	js1=n.getSeparator(850,62,180,300);
	c.add(js1);

	js2=n.getSeparator(500,62,180,300);
	c.add(js2);

	background=n.getLabel("",0,0,1080,710,0);
	ImageIcon icon = new ImageIcon(getClass().getResource("/resources/mainmenu.jpg")); 
	background.setIcon(icon);   
	c.add(background);

	l1.addMouseListener(this);
	l2.addMouseListener(this);
	l3.addMouseListener(this);
	l4.addMouseListener(this);
	l9.addMouseListener(this);
	l10.addMouseListener(this);
	l11.addMouseListener(this);
	l12.addMouseListener(this);
	l17.addMouseListener(this);
	l18.addMouseListener(this);
	l19.addMouseListener(this);
	l26.addMouseListener(this);
	
	j2.setVisible(true);
}
public void mouseClicked(MouseEvent event){
		if(event.getSource()==l1)
		{
	Signup m=new Signup();
	m.setFrame();
	m.setTitle();
	m.setLabels();
	m.setFields();
	m.setAddButton();
	m.setClearButton();
	m.setCloseButton();
	m.setBackground();	
		}
		else if(event.getSource()==l2)
		{
	Delete d=new Delete();
	d.setFrame();
	d.setTitle();
	d.setLabels();
	d.setFields();
	d.setSearchUserName();
	d.setAddButton();
	d.setClearButton();
	d.setCloseButton();
	d.setBackground();	
		}
		else if(event.getSource()==l3)
		{
	Update u=new Update();
	u.setFrame();
	u.setTitle();
	u.setLabels();
	u.setFields();
	u.setSearchUserName();
	u.setAddButton();
	u.setClearButton();
	u.setCloseButton();
	u.setBackground();	
		}
		else if(event.getSource()==l4)
		{
	Search s=new Search();
	s.setFrame();
	s.setTitle();
	s.setLabels();
	s.setFields();
	s.setSearchUserName();
	s.setAddButton();
	s.setClearButton();
	s.setCloseButton();
	s.setBackground();
		}
		else if(event.getSource()==l9)
		{
	SignupInstructor i=new SignupInstructor();
	i.setFrame();
	i.setTitle();
	i.setLabels();
	i.setFields();
	i.setAddButton();
	i.setClearButton();
	i.setCloseButton();
	i.setBackground();	
		}
		else if(event.getSource()==l10)
		{
	DeleteInstructor di=new DeleteInstructor();
	di.setFrame();
	di.setTitle();
	di.setLabels();
	di.setFields();
	di.setSearchUserName();
	di.setAddButton();
	di.setClearButton();
	di.setCloseButton();
	di.setBackground();	
		}
		else if(event.getSource()==l11)
		{
	UpdateInstructor ui=new UpdateInstructor();
	ui.setFrame();
	ui.setTitle();
	ui.setLabels();
	ui.setFields();
	ui.setSearchUserName();
	ui.setAddButton();
	ui.setClearButton();
	ui.setCloseButton();
	ui.setBackground();		
		}
		else if(event.getSource()==l12)
		{
	SearchInstructor si=new SearchInstructor();
	si.setFrame();
	si.setTitle();
	si.setLabels();
	si.setFields();
	si.setSearchUserName();
	si.setAddButton();
	si.setClearButton();
	si.setCloseButton();
	si.setBackground();	
		}
		else if(event.getSource()==l17)
		{
			try{
				String myquery = "select * from payment";
					Class.forName("com.mysql.jdbc.Driver");
					String a = "jdbc:mysql://localhost/gym";
					Connection con = DriverManager.getConnection(a, "root", "");
					JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("reportPayment.jrxml"));
					JRDesignQuery newQuery = new JRDesignQuery();
					newQuery.setText(myquery);
					jd.setQuery(newQuery);
					JasperReport jr = JasperCompileManager.compileReport(jd);
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);	
			}
			catch(Exception e){
				System.out.println(e);
			}	
		}
		else if(event.getSource()==l18)
		{
			try{
				String myquery = "select * from user";
					Class.forName("com.mysql.jdbc.Driver");
					String a = "jdbc:mysql://localhost/gym";
					Connection con = DriverManager.getConnection(a, "root", "");
					JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("reportMember.jrxml"));
					JRDesignQuery newQuery = new JRDesignQuery();
					newQuery.setText(myquery);
					jd.setQuery(newQuery);
					JasperReport jr = JasperCompileManager.compileReport(jd);
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);	
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else if(event.getSource()==l19)
		{
			try{
				String myquery = "select * from Instructor";
					Class.forName("com.mysql.jdbc.Driver");
					String a = "jdbc:mysql://localhost/gym";
					Connection con = DriverManager.getConnection(a, "root", "");
					JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("reportIns.jrxml"));
					JRDesignQuery newQuery = new JRDesignQuery();
					newQuery.setText(myquery);
					jd.setQuery(newQuery);
					JasperReport jr = JasperCompileManager.compileReport(jd);
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);	
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else if(event.getSource()==l26)
		{
	LoginMenu n=new LoginMenu();
	n.setGui();
	n.setLayout();	
	j2.dispose();
		}
}
			
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}	
}
