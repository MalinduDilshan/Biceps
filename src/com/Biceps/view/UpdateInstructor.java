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
public class UpdateInstructor implements MouseListener, ItemListener{
	private MALINDU n;
	private JFrame updateFrame;
	private Container updateCont;
	private JSeparator js;
	private JLabel mainTitle,sign,background,update, clear, close;
	private JTextField firstNameText, lastNameText, userNameText, contacText;
	private JPasswordField passwordText,confirmPasswordText;
	private JComboBox sex,chart,title,usernames;
	private String [] type ={"Select","MALE","FEMALE"};
	private String [] titles = {"Select a Title", "Mr", "Mrs", "Miss"};
 
	private String [] wchart ={"Select a Chart","Power chart","Bulk chart"};
	
public void setFrame(){
        n = new MALINDU();
        updateFrame = n.getFrame("Instructor update",600,750);
		updateFrame.setLocationRelativeTo(null);
		updateFrame.setResizable(false);
        	updateCont = updateFrame.getContentPane();
        	updateCont.setLayout(null);
    }  
    public void setTitle(){  
        mainTitle = n.getLabel("Update Profile", 135, 2, 350, 80, 30);
        updateCont.add(mainTitle);
        
        sign = n.getLabel("", 45, 0, 96, 96, 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/user.png"));
        sign.setIcon(icon);
        updateCont.add(sign);
        
        js = n.getSeparator(30,96);
        updateCont.add(js);
    }
	public void setLabels(){
        JLabel firstNameLabel = n.getLabel("New First Name", 20, 100);
        updateCont.add(firstNameLabel);
        
        JLabel lastNameLabel = n.getLabel("New Last Name", 20, 150);
        updateCont.add(lastNameLabel);

	JLabel titleLabel = n.getLabel("Title", 20, 200);
        updateCont.add(titleLabel);

	JLabel accountTypeLabel = n.getLabel("Sex", 20, 250);
        updateCont.add(accountTypeLabel);

        JLabel userNameLabel = n.getLabel("New User Name", 20, 300);
        updateCont.add(userNameLabel);
        
        JLabel passwordLabel = n.getLabel("New Password", 20, 350);
        updateCont.add(passwordLabel);

	JLabel confPasswordLabel = n.getLabel("Confirm Password", 20, 400);
        updateCont.add(confPasswordLabel);
		
        JLabel contacLabel = n.getLabel("New Contact No ", 20, 450);
        updateCont.add(contacLabel);

	JLabel chartLabel = n.getLabel("New Workout Chart", 40, 525,140,30,15);
        updateCont.add(chartLabel);

    }		
	public void setFields(){
		firstNameText = n.getField(140, 100);
        	updateCont.add(firstNameText);
        
        	lastNameText = n.getField(140, 150);
        	updateCont.add(lastNameText);

		title = n.getComboBox(140,200,titles);
		updateCont.add(title);

		sex = n.getComboBox(140,250,type);
		updateCont.add(sex);
		
		userNameText = n.getField(140, 300);
		updateCont.add(userNameText);
		
		passwordText = n.getPasswordField(140, 350);
		updateCont.add(passwordText);

		confirmPasswordText = n.getPasswordField(140, 400);
		updateCont.add(confirmPasswordText);

		contacText = n.getField(140, 450);
		updateCont.add(contacText);

		chart = n.getComboBox(140,500,wchart);
		updateCont.add(chart);
		
	}

	void setSearchUserName(){
		
		List<String> getuserNameList = new ArrayList<String>();
		
		GetUserNames un = new GetUserNames();
		
		getuserNameList = un.getInstructorUserNames();
		
		
		String [] idList = new String [getuserNameList.size()];
		
		idList = getuserNameList.toArray(idList);
		
    	
		usernames = n.getComboBox(335,32,180,31,idList);
    	
		usernames.addItemListener(this);
    	
		updateCont.add(usernames);
    	
    	
		JLabel idLabel = n.getLabel("Select User Name:", 230, 57, 180, 30, 20);
    	
		updateCont.add(idLabel);
    
}
    
   

	void setAddButton(){
	
	update = n.getLabel("",100,620,72,72,0);
	update.setToolTipText("Click Here to Update Profile");
  
	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/updateSymbol.png"));
	update.setIcon(submitIcon);
        update.addMouseListener(this);
        updateCont.add(update);
    } 
    void setClearButton(){ 
	clear = n.getLabel("",245,620,72,72,0);
	clear.setToolTipText("Click Here to Clear");
  
	ImageIcon clearIcon = new ImageIcon(getClass().getResource("/resources/clear.png"));
	clear.setIcon(clearIcon);
        clear.addMouseListener(this);
        updateCont.add(clear);
        
    }	
	void setCloseButton(){  
      	
	close = n.getLabel("",390,620,72,72,0);
	close.setToolTipText("Click Here to close");
  
	ImageIcon closeIcon = new ImageIcon(getClass().getResource("/resources/close.png"));
	close.setIcon(closeIcon);
        close.addMouseListener(this);
        updateCont.add(close);
        
    }
	public void setBackground(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/InstructorUpdateBack.png"));
        background = n.getLabel("",0,0,600,750,0);
        background.setIcon(icon);
        updateCont.add(background);
        updateFrame.setVisible(true);
    }
	public void mouseClicked(MouseEvent event){
		Instructor dox=new Instructor();
		Message msg = new Message();
		DataBaseInstructor db = new DataBaseInstructor();
		Validation valid=new Validation();
		if(event.getSource() == update){

			String selectUser = String.valueOf(usernames.getSelectedItem());


			dox.setFname(firstNameText.getText());
			dox.setLname(lastNameText.getText());
			dox.setTitle(String.valueOf(title.getSelectedItem()));
			dox.setGender(String.valueOf(sex.getSelectedItem()));
			dox.setUsername(userNameText.getText());
			dox.setPassword(passwordText.getText());
			String confirm = confirmPasswordText.getText();
			dox.setContact(contacText.getText());
			dox.setChart(String.valueOf(chart.getSelectedItem()));
			
			if(selectUser.equals("Select Your UserName")){
				msg.warningMsg("UserName should be selected to Update Profile", updateFrame);
			}
			else if(dox.getFname().isEmpty()){
				msg.warningMsg("First Name should not be Empty", updateFrame);
			}
			else if(dox.getLname().isEmpty()){
				msg.warningMsg("Last Name should not be Empty", updateFrame);
			}
			else if(dox.getTitle().equals("Select a Title")){
				msg.warningMsg("Title should be selected", updateFrame);
			}
			else if(dox.getGender().equals("Select")){
				msg.warningMsg("Gender Type should be selected", updateFrame);
			}
			else if(dox.getUsername().isEmpty()){
				msg.warningMsg("User Name should not be Empty", updateFrame);
			}
			else if(dox.getUsername().length() < 4){
				msg.warningMsg("User Name should have more than 4 characters", updateFrame);
			}
			else if(dox.getPassword().isEmpty()){
				msg.warningMsg("Password should not be Empty", updateFrame);
			}
			else if(dox.getPassword().length() < 6){
				msg.warningMsg("Password should be at least 6 characters long ", updateFrame);
			}
			else if(confirm.isEmpty()){
				msg.warningMsg("Confirm password should be Empty ", updateFrame);
			}
			else if(!dox.getPassword().equals(confirm)){
				msg.warningMsg("Your confirm password do not match ", updateFrame);
			}
			else if(dox.getContact().isEmpty()){
				msg.warningMsg("Contact No should not be Empty", updateFrame);
			}
			else if(dox.getContact().length() != 10){
				
				msg.warningMsg("Contact Number should be 10 Digits", updateFrame);

			}
			else if(!valid.isNumeric(dox.getContact())){

				msg.warningMsg("Contact Number should be Numeric", updateFrame);
			
			}
		
			else if(dox.getChart().equals("Select a Chart")){
				msg.warningMsg("Workout Chart should not be Empty",updateFrame);
			}
			else{
			int dialogResult = msg.confirmMsg("Do you want to Update your Profile ", updateFrame);
				if( dialogResult ==  0 ){
					try{
						db.update(dox,selectUser);
						clearAll();
						msg.informMsg("Profile Successfully Updated", updateFrame);	
						updateFrame.dispose();	
					}
					catch(Exception ex){
						msg.warningMsg(ex.toString(), updateFrame);
					}			
				}	
			}
		}
		if(event.getSource() == clear){
			int dialogResult = msg.confirmMsg("Do you want to clear all the fields? ", updateFrame);
				if(dialogResult ==  0){
					clearAll();
				}
		}
		if(event.getSource() == close){
			int dialogResult = msg.confirmMsg("Do you want to close this Window? ", updateFrame);
				if(dialogResult ==  0){
					updateFrame.dispose();

				}
		}
		
	}
	public void clearAll(){
		usernames.setSelectedItem("Select Your UserName");
		firstNameText.setText("");
		lastNameText.setText("");
		title.setSelectedItem("Select a Title");
		sex.setSelectedItem("Select");
		userNameText.setText("");
		confirmPasswordText.setText("");
		passwordText.setText("");
		contacText.setText("");
		chart.setSelectedItem("Select a Chart");
	}
public void mouseExited(MouseEvent event){}
			
public void mouseEntered(MouseEvent event){}
			
public void mouseReleased(MouseEvent event){}
			
public void mousePressed(MouseEvent event){}
public void itemStateChanged(ItemEvent event){} 
}
