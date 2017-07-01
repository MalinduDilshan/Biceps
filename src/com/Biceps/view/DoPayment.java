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
public class DoPayment implements MouseListener, ItemListener{
	private JFrame j2;
	private JLabel background,mainTitle,submit,clear,close,l1,l2,l3,l4;
	private JTextField userName,payAmt;
	private JComboBox payType;
	private Container c;
	private JSeparator js;
	private MALINDU n;
	
	private String [] type ={"Select","Month","Year"};
	private String uname;
	
void setFrame(){
	n=new MALINDU();
	j2=n.getFrame("Biceps Payment",600,520);
	j2.setResizable(false);
	j2.setLocationRelativeTo(null);
	c=j2.getContentPane();
	j2.setAlwaysOnTop (false);
	c.setLayout(null);

}
void setTitle(String un){  

		uname=un;

        mainTitle = n.getLabel("Payment", 140, 30, 350, 80, 30);
        c.add(mainTitle);
        
        l1 = n.getLabel("", 50, 10, 125, 125, 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/pay.png"));
        l1.setIcon(icon);
        c.add(l1);
        
        js = n.getSeparator(30,118);
        c.add(js);
    }
public void setLabels(){	
		
		JLabel l2 = n.getLabel("User Name", 20, 150);
        c.add(l2);
		
		JLabel l3 = n.getLabel("Payment Type", 20, 200);
        c.add(l3);
		
		JLabel l4 = n.getLabel("Payment Amount", 20, 250);
        c.add(l4);
	
		
	
}
public void setFields(){
		userName = n.getField(140, 150);
        c.add(userName);
		userName.setText(uname);
 
		payType = n.getComboBox(140,200,type);
		c.add(payType);
		payType.addItemListener(this);
		
		payAmt = n.getField(140,250);
		c.add(payAmt);
		
		
		
}
void setAddButton(){
	
	submit = n.getLabel("",100,350,72,72,0);
	submit.setToolTipText("Click Here to Submit");
  
	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/submit.png"));
	submit.setIcon(submitIcon);
        submit.addMouseListener(this);
        c.add(submit);
    } 
    void setClearButton(){ 
	clear = n.getLabel("",245,350,72,72,0);
	clear.setToolTipText("Click Here to Clear");
  
	ImageIcon clearIcon = new ImageIcon(getClass().getResource("/resources/clear.png"));
	clear.setIcon(clearIcon);
        clear.addMouseListener(this);
        c.add(clear);
        
    }	
	void setCloseButton(){  
      	
	close = n.getLabel("",390,350,72,72,0);
	close.setToolTipText("Click Here to close");
  
	ImageIcon closeIcon = new ImageIcon(getClass().getResource("/resources/close.png"));
	close.setIcon(closeIcon);
        close.addMouseListener(this);
        c.add(close);
        
    }
	public void setBackground(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/signup.png"));
        background = n.getLabel("",0,0,600,520,0);
        background.setIcon(icon);
        c.add(background);
        j2.setVisible(true);
    }
public void mouseClicked(MouseEvent event){
		Payment dox=new Payment();
		Message msg = new Message();
		DataBasePayment db = new DataBasePayment();
		
			

	
		if(event.getSource() == submit){
			
			if(String.valueOf(payType.getSelectedItem()).equals("Select")){
			msg.warningMsg("Payment Type should be selected", j2);
			}
			else{
			dox.setUserName(uname);
			dox.setPayType(String.valueOf(payType.getSelectedItem()));
			dox.setPayAmt(String.valueOf(payAmt.getText()));
			
				int dialogResult = msg.confirmMsg("Do you want to do Payment", j2);
				if( dialogResult ==  0 ){
					try{
						db.insert(dox);
						clearAll();
						msg.informMsg("Payment Successfully Done",j2);	
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
		userName.setText("");
		payType.setSelectedItem("Select");
		payAmt.setText("");
		}
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}

public void itemStateChanged(ItemEvent ex){
		String temp=String.valueOf(payType.getSelectedItem());
		if(temp.equals("Month"))
			payAmt.setText("LKR 5000");
		else
			payAmt.setText("LKR 12000");
			
}	
}