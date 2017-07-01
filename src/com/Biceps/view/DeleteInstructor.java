/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;

import java.util.ArrayList;
/**
 *
 * @author MaLindu DiLshan
 */
public class DeleteInstructor implements MouseListener, ItemListener{
	private MALINDU n;
	private JFrame DeleteFrame;
	private Container DeleteCont;
	private JSeparator js;
	private JLabel mainTitle,sign,background,Delete, clear, close;
	private JTextField firstNameText, lastNameText, title, sex, userNameText, contacText, chart;
	private JComboBox usernames;
	
public void setFrame(){
        n = new MALINDU();
        DeleteFrame = n.getFrame("Instructor Delete",600,750);
		DeleteFrame.setLocationRelativeTo(null);
		DeleteFrame.setResizable(false);
        	DeleteCont = DeleteFrame.getContentPane();
        	DeleteCont.setLayout(null);
    }  
    public void setTitle(){  
        mainTitle = n.getLabel("Delete Profile", 135, 2, 350, 80, 30);
        DeleteCont.add(mainTitle);
        
        sign = n.getLabel("", 45, 0, 96, 96, 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/user.png"));
        sign.setIcon(icon);
        DeleteCont.add(sign);
        
        js = n.getSeparator(30,96);
        DeleteCont.add(js);
    }
	public void setLabels(){
        JLabel firstNameLabel = n.getLabel("First Name", 20, 100);
        DeleteCont.add(firstNameLabel);
        
        JLabel lastNameLabel = n.getLabel("Last Name", 20, 150);
        DeleteCont.add(lastNameLabel);

	JLabel titleLabel = n.getLabel("Title", 20, 200);
        DeleteCont.add(titleLabel);

	JLabel accountTypeLabel = n.getLabel("Sex", 20, 250);
        DeleteCont.add(accountTypeLabel);

        JLabel userNameLabel = n.getLabel("User Name", 20, 300);
        DeleteCont.add(userNameLabel);

        JLabel contacLabel = n.getLabel("Contact No ", 20, 350);
        DeleteCont.add(contacLabel);

	JLabel chartLabel = n.getLabel("Workout Chart", 40, 425,140,30,15);
        DeleteCont.add(chartLabel);
    }		
	public void setFields(){
		firstNameText = n.getField(140, 100);
        	DeleteCont.add(firstNameText);
        
        	lastNameText = n.getField(140, 150);
        	DeleteCont.add(lastNameText);

		title = n.getField(140,200);
		DeleteCont.add(title);

		sex = n.getField(140,250);
		DeleteCont.add(sex);
		
		userNameText = n.getField(140, 300);
		DeleteCont.add(userNameText);

		contacText = n.getField(140, 350);
		DeleteCont.add(contacText);

		chart = n.getField(140,400);
		DeleteCont.add(chart);
		
		
	}

	void setSearchUserName(){
		
		List<String> getuserNameList = new ArrayList<String>();
		
		GetUserNames un = new GetUserNames();
		
		getuserNameList = un.getInstructorUserNames();
		
		
		String [] idList = new String [getuserNameList.size()];
		
		idList = getuserNameList.toArray(idList);
		
    	
		usernames = n.getComboBox(335,32,180,31,idList);
    	
		usernames.addItemListener(this);
    	
		DeleteCont.add(usernames);
    	
    	
		JLabel idLabel = n.getLabel("Select User Name:", 230, 57, 180, 30, 20);
    	
		DeleteCont.add(idLabel);
    
}

	void setAddButton(){
	
	Delete = n.getLabel("",245,560,72,72,0);
	Delete.setToolTipText("Click Here to Delete Profile");
  
	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/DeleteSymbol.png"));
	Delete.setIcon(submitIcon);
        Delete.addMouseListener(this);
        DeleteCont.add(Delete);
    } 
    void setClearButton(){ 
/*	clear = n.getLabel("",245,620,72,72,0);
	clear.setToolTipText("Click Here to Clear");
  
	ImageIcon clearIcon = new ImageIcon(getClass().getResource("/resources/clear.png"));
	clear.setIcon(clearIcon);
        clear.addMouseListener(this);
        DeleteCont.add(clear);	*/
        
    }	
	void setCloseButton(){  
      	
	close = n.getLabel("",415,560,72,72,0);
	close.setToolTipText("Click Here to close");
  
	ImageIcon closeIcon = new ImageIcon(getClass().getResource("/resources/close.png"));
	close.setIcon(closeIcon);
        close.addMouseListener(this);
        DeleteCont.add(close);
        
    }
	public void setBackground(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/InstructorDeleteBack.png"));
        background = n.getLabel("",0,0,600,750,0);
        background.setIcon(icon);
        DeleteCont.add(background);
        DeleteFrame.setVisible(true);
    }


public void itemStateChanged(ItemEvent ex){

			String selectUser = String.valueOf(usernames.getSelectedItem());
			
			DataBaseInstructor dbtemp = new DataBaseInstructor();
			Instructor dox=new Instructor();
			dox=dbtemp.search(selectUser);
		
			firstNameText.setText(dox.getFname());
			lastNameText.setText(dox.getLname());
			title.setText(dox.getTitle());
			sex.setText(dox.getGender());
			userNameText.setText(dox.getUsername());
			contacText.setText(dox.getContact());
			chart.setText(dox.getChart());


}

public void mouseClicked(MouseEvent event){
		
		DataBaseInstructor db = new DataBaseInstructor();
		Message msg = new Message();
		Validation valid=new Validation();
		String selectUser = String.valueOf(usernames.getSelectedItem());
		if(event.getSource() == Delete){
			
			
			if(selectUser.equals("Select Your UserName"))
				msg.warningMsg("UserName should be selected to Delete Profile", DeleteFrame);
			else{
			int dialogResult = msg.confirmMsg("Do you want to Delete this Profile ", DeleteFrame);
				if( dialogResult ==  0 ){
					try{
						db.delete(selectUser);
						clearAll();
						msg.informMsg("Profile Successfully Deleted", DeleteFrame);	
						DeleteFrame.dispose();	
					}
					catch(Exception ex){
						msg.warningMsg(ex.toString(), DeleteFrame);
					}				
			}
		}
}
		if(event.getSource() == clear){
			int dialogResult = msg.confirmMsg("Do you want to clear all the fields? ", DeleteFrame);
				if(dialogResult ==  0){
					clearAll();
				}
		}
		if(event.getSource() == close){
			int dialogResult = msg.confirmMsg("Do you want to close this Window? ", DeleteFrame);
				if(dialogResult ==  0){
					DeleteFrame.dispose();

				}
		}
		
	}
	public void clearAll(){
		usernames.setSelectedItem("Select Your UserName");
		firstNameText.setText("");
		lastNameText.setText("");
		title.setText("");
		sex.setText("");
		userNameText.setText("");
		contacText.setText("");
		chart.setText("");
		
	}
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}

}