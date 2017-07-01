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
public class CreateChart implements MouseListener{
	private JFrame j2;
	private JLabel background,mainTitle,chartPic,submit,clear,close,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	private JComboBox charts,day1,day2,day3,day4,day5,day6,day7;
	private JTextField qty;
	private Container c;
	private JSeparator js;
	private MALINDU n;
	
	private String [] type ={"Select","Bulk Chart","Power Chart"};
	private String [] day ={"Select","Chest","Legs","Arms","Cardio","Back","Sholders","Rest"};

void setFrame(){
	n=new MALINDU();
	j2=n.getFrame("Biceps Create Chart",600,750);
	j2.setResizable(false);
	j2.setLocationRelativeTo(null);
	c=j2.getContentPane();
	j2.setAlwaysOnTop (false);
	c.setLayout(null);

}
void setTitle(){  
        mainTitle = n.getLabel("Create Chart", 165, 20, 350, 80, 30);
        c.add(mainTitle);
        
        chartPic = n.getLabel("", 50, 10, 125, 125, 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/chart.png"));
        chartPic.setIcon(icon);
        c.add(chartPic);
        
        js = n.getSeparator(30,118);
        c.add(js);
    }
public void setLabels(){	
		JLabel l1 = n.getLabel("Select Chart type", 20, 100);
        c.add(l1);
		
		JLabel l2 = n.getLabel("Quantity", 20, 150);
        c.add(l2);
		
		JLabel l3 = n.getLabel("Day 1:", 20, 200);
        c.add(l3);
		
		JLabel l4 = n.getLabel("Day 2:", 20, 250);
        c.add(l4);
		
		JLabel l5 = n.getLabel("Day 3:", 20, 300);
        c.add(l5);
		
		JLabel l6 = n.getLabel("Day 4:", 20, 350);
        c.add(l6);
		
		JLabel l7 = n.getLabel("Day 5:", 20, 400);
        c.add(l7);
		
		JLabel l8 = n.getLabel("Day 6:", 20, 450);
        c.add(l8);
		
		JLabel l9 = n.getLabel("Day 7:", 20, 500);
        c.add(l9);

}
public void setFields(){
		qty = n.getField(140, 150);
        c.add(qty);
 
		charts = n.getComboBox(140,100,type);
		c.add(charts);
		
		day1 = n.getComboBox(140,200,day);
		c.add(day1);
		
		day2 = n.getComboBox(140,250,day);
		c.add(day2);
		
		day3 = n.getComboBox(140,300,day);
		c.add(day3);
		
		day4 = n.getComboBox(140,350,day);
		c.add(day4);
		
		day5 = n.getComboBox(140,400,day);
		c.add(day5);
		
		day6 = n.getComboBox(140,450,day);
		c.add(day6);
		
		day7 = n.getComboBox(140,500,day);
		c.add(day7);
}
void setAddButton(){
	
	submit = n.getLabel("",100,600,72,72,0);
	submit.setToolTipText("Click Here to Submit");
  
	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/submit.png"));
	submit.setIcon(submitIcon);
        submit.addMouseListener(this);
        c.add(submit);
    } 
    void setClearButton(){ 
	clear = n.getLabel("",245,600,72,72,0);
	clear.setToolTipText("Click Here to Clear");
  
	ImageIcon clearIcon = new ImageIcon(getClass().getResource("/resources/clear.png"));
	clear.setIcon(clearIcon);
        clear.addMouseListener(this);
        c.add(clear);
        
    }	
	void setCloseButton(){  
      	
	close = n.getLabel("",390,600,72,72,0);
	close.setToolTipText("Click Here to close");
  
	ImageIcon closeIcon = new ImageIcon(getClass().getResource("/resources/close.png"));
	close.setIcon(closeIcon);
        close.addMouseListener(this);
        c.add(close);
        
    }
	public void setBackground(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/signup.png"));
        background = n.getLabel("",0,0,600,750,0);
        background.setIcon(icon);
        c.add(background);
        j2.setVisible(true);
    }
public void mouseClicked(MouseEvent event){
		Chart dox=new Chart();
		Message msg = new Message();
		Validation valid=new Validation();
		DataBaseChart dbm = new DataBaseChart();

		if(event.getSource() == submit){
			dox.setChart(String.valueOf(charts.getSelectedItem()));
			dox.setQty(String.valueOf(qty.getText()));
			dox.setDay1(String.valueOf(day1.getSelectedItem()));
			dox.setDay2(String.valueOf(day2.getSelectedItem()));
			dox.setDay3(String.valueOf(day3.getSelectedItem()));
			dox.setDay4(String.valueOf(day4.getSelectedItem()));
			dox.setDay5(String.valueOf(day5.getSelectedItem()));
			dox.setDay6(String.valueOf(day6.getSelectedItem()));
			dox.setDay7(String.valueOf(day7.getSelectedItem()));

			
			if(dox.getChart().equals("Select")){
				msg.warningMsg("Chart should be selected", j2);
			}
			else if(dox.getQty().isEmpty()){
				msg.warningMsg("Quantity should not be Empty", j2);
			}
			else if(!valid.isNumeric(dox.getQty())){
				msg.warningMsg("Quantity should be Numeric", j2);
			}
			else if(dox.getDay1().equals("Select")){
				msg.warningMsg("Day1 exercise should be selected", j2);
			}
			else if(dox.getDay2().equals("Select")){
				msg.warningMsg("Day2 exercise should be selected", j2);
			}
			else if(dox.getDay3().equals("Select")){
				msg.warningMsg("Day3 exercise should be selected", j2);
			}
			else if(dox.getDay4().equals("Select")){
				msg.warningMsg("Day4 exercise should be selected", j2);
			}
			else if(dox.getDay5().equals("Select")){
				msg.warningMsg("Day5 exercise should be selected", j2);
			}
			else if(dox.getDay6().equals("Select")){
				msg.warningMsg("Day6 exercise should be selected", j2);
			}
			else if(dox.getDay7().equals("Select")){
				msg.warningMsg("Day7 exercise should be selected", j2);
			}
			else{
				int dialogResult = msg.confirmMsg("Do you want to create a new Chart ", j2);
				if( dialogResult ==  0 ){
					try{
						dbm.insert(dox);
						clearAll();
						msg.informMsg("Chart Successfully Created",j2);	
						j2.dispose();	
					}
					catch(Exception ex){
						msg.warningMsg(ex.toString(), j2);
					}			
				}	
			}
		}
		if(event.getSource() == clear){
			int dialogResult = msg.confirmMsg("Do you want to clear all the fields? ", j2);
				if(dialogResult ==  0){
					clearAll();
				}
		}
		if(event.getSource() == close){
			int dialogResult = msg.confirmMsg("Do you want to close this Window? ", j2);
				if(dialogResult ==  0){
					j2.dispose();

				}
		}
}
void clearAll(){
		charts.setSelectedItem("Select");
		qty.setText("");
		day1.setSelectedItem("Select");
		day2.setSelectedItem("Select");
		day3.setSelectedItem("Select");
		day4.setSelectedItem("Select");
		day5.setSelectedItem("Select");
		day6.setSelectedItem("Select");
		day7.setSelectedItem("Select");
		}
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}	
}
