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
public class InstructorMenu implements MouseListener{
	private JFrame j2;
	private JLabel background,welcomeLabel,l1,l2,l3,l5,l6,l7,l8,l9;
	private Container c;
	private MALINDU n;

void setGui(){
	n=new MALINDU();
	j2=n.getFrame("Biceps Instructor Menu",660,710);
	j2.setResizable(false);
	j2.setLocationRelativeTo(null);
	c=j2.getContentPane();
	j2.setAlwaysOnTop (false);
	c.setLayout(null);

}
void setLayout(String un){ 

	ImageIcon icon1=new ImageIcon(getClass().getResource("/resources/hello.jpg"));
	l3=n.getLabel("",20,50,200,200,0);
	l3.setIcon(icon1);
	c.add(l3);
	
	welcomeLabel = n.getLabel(un, 200,80,600,100,40);
	welcomeLabel.setFont(new Font("Segoe Print", Font.PLAIN, 60));
	c.add(welcomeLabel);  	

	ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/member.png"));
	l1=n.getLabel("",20,260,140,140,0);
	l1.setIcon(icon2);
	l1.setToolTipText("Click Here to view Bulk Chart member");
   
      
	c.add(l1);
 

	l5=n.getLabel("Bulk Chart Members",135,245,500,160,25);      
	c.add(l5);
	
	ImageIcon icon3 = new ImageIcon(getClass().getResource("/resources/member.png"));
	l2=n.getLabel("",110,350,140,140,0); 
	l2.setIcon(icon3);
	l2.setToolTipText("Click Here to view power Chart member");
 
	c.add(l2);



	l6=n.getLabel("Power Chart Members",220,334,500,160,25);      
	c.add(l6);

	ImageIcon icon5=new ImageIcon(getClass().getResource("/resources/chart.png"));
	l3=n.getLabel("",200,440,140,140,0);
	l3.setIcon(icon5);
	l3.setToolTipText("Click Here to create Charts");
   
      
	c.add(l3);
 

	l7=n.getLabel("Create Charts",315,425,500,160,25);      
	c.add(l7);
	
	ImageIcon icon4=new ImageIcon(getClass().getResource("/resources/logout.png"));
	l8=n.getLabel("",260,547,140,140,0);
	l8.setIcon(icon4);
	l8.setToolTipText("Click Here to exit");
   
    c.add(l8);
 
	l9=n.getLabel("Logout",388,525,500,160,25);      
	c.add(l9);
	



	background=n.getLabel("",0,0,660,710,0);
	ImageIcon icon = new ImageIcon(getClass().getResource("/resources/menuIns.jpg")); 
	background.setIcon(icon);   
	c.add(background);

	l1.addMouseListener(this);
	l2.addMouseListener(this);
	l3.addMouseListener(this);
	l8.addMouseListener(this);
	
	j2.setVisible(true);
}
public void mouseClicked(MouseEvent event){
		if(event.getSource()==l1)
		{
			try{
				String myquery = "select * from user where chart= 'Bulk Chart'";
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
		else if(event.getSource()==l2)
		{
			try{
				String myquery = "select * from user where chart= 'Power Chart'";
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
		else if(event.getSource()==l3)
		{
	CreateChart m=new CreateChart();
	m.setFrame();
	m.setTitle();
	m.setLabels();
	m.setFields();
	m.setAddButton();
	m.setClearButton();
	m.setCloseButton();
	m.setBackground();
		}
		else if(event.getSource()==l8)
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