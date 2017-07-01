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
/**
 *
 * @author MaLindu DiLshan
 */
public class SignupInstructor implements MouseListener{
	private MALINDU n;
	private JFrame signupFrame;
	private Container signinCont;
	private JSeparator js;
	private JLabel mainTitle,sign,background,submit, clear, close;
	private JTextField firstNameText, lastNameText, userNameText, contacText;
	private JPasswordField passwordText,confirmPasswordText;
	private JComboBox sex,chart,title;
	private String [] type ={"Select","MALE","FEMALE"};
	private String [] titles = {"Select a Title", "Mr", "Mrs", "Miss"};
 
	private String [] wchart ={"Select a Chart","Power chart","Bulk chart"};
	
public void setFrame(){
        n = new MALINDU();
        signupFrame = n.getFrame("Instructor Signup",600,750);
		signupFrame.setLocationRelativeTo(null);
		signupFrame.setResizable(false);
        	signinCont = signupFrame.getContentPane();
        	signinCont.setLayout(null);
    }  
    public void setTitle(){  
        mainTitle = n.getLabel("Instructor Signup", 140, 5, 350, 80, 30);
        signinCont.add(mainTitle);
        
        sign = n.getLabel("", 50, 5, 96, 96, 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/user.png"));
        sign.setIcon(icon);
        signinCont.add(sign);
        
        js = n.getSeparator(30,96);
        signinCont.add(js);
    }
	public void setLabels(){
        JLabel firstNameLabel = n.getLabel("First Name", 20, 100);
        signinCont.add(firstNameLabel);
        
        JLabel lastNameLabel = n.getLabel("Last Name", 20, 150);
        signinCont.add(lastNameLabel);

	JLabel titleLabel = n.getLabel("Title", 20, 200);
        signinCont.add(titleLabel);

	JLabel accountTypeLabel = n.getLabel("Sex", 20, 250);
        signinCont.add(accountTypeLabel);

        JLabel userNameLabel = n.getLabel("User Name", 20, 300);
        signinCont.add(userNameLabel);
        
        JLabel passwordLabel = n.getLabel("Password", 20, 350);
        signinCont.add(passwordLabel);

	JLabel confPasswordLabel = n.getLabel("Confirm Password", 20, 400);
        signinCont.add(confPasswordLabel);
		
        JLabel contacLabel = n.getLabel("Contact No ", 20, 450 );
        signinCont.add(contacLabel);

	JLabel chartLabel = n.getLabel("Workout Chart", 20, 500);
        signinCont.add(chartLabel);


    }		
	public void setFields(){
		firstNameText = n.getField(140, 100);
        	signinCont.add(firstNameText);
        
        	lastNameText = n.getField(140, 150);
        	signinCont.add(lastNameText);

		title = n.getComboBox(140,200,titles);
		signinCont.add(title);

		sex = n.getComboBox(140,250,type);
		signinCont.add(sex);
		
		userNameText = n.getField(140, 300);
		signinCont.add(userNameText);
		
		passwordText = n.getPasswordField(140, 350);
		signinCont.add(passwordText);

		confirmPasswordText = n.getPasswordField(140, 400);
		signinCont.add(confirmPasswordText);

		contacText = n.getField(140, 450);
		signinCont.add(contacText);

		chart = n.getComboBox(140,500,wchart);
		signinCont.add(chart);
		
		
	}
	void setAddButton(){
	
	submit = n.getLabel("",100,620,72,72,0);
	submit.setToolTipText("Click Here to Submit");
  
	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/submit.png"));
	submit.setIcon(submitIcon);
        submit.addMouseListener(this);
        signinCont.add(submit);
    } 
    void setClearButton(){ 
	clear = n.getLabel("",245,620,72,72,0);
	clear.setToolTipText("Click Here to Clear");
  
	ImageIcon clearIcon = new ImageIcon(getClass().getResource("/resources/clear.png"));
	clear.setIcon(clearIcon);
        clear.addMouseListener(this);
        signinCont.add(clear);
        
    }	
	void setCloseButton(){  
      	
	close = n.getLabel("",390,620,72,72,0);
	close.setToolTipText("Click Here to close");
  
	ImageIcon closeIcon = new ImageIcon(getClass().getResource("/resources/close.png"));
	close.setIcon(closeIcon);
        close.addMouseListener(this);
        signinCont.add(close);
        
    }
	public void setBackground(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/SignupInstructor.png"));
        background = n.getLabel("",0,0,600,750,0);
        background.setIcon(icon);
        signinCont.add(background);
        signupFrame.setVisible(true);
    }
	public void mouseClicked(MouseEvent event){
		Instructor dox=new Instructor();
		Message msg = new Message();
		DataBaseInstructor dbm = new DataBaseInstructor();
		Validation valid=new Validation();
		if(event.getSource() == submit){
			dox.setFname(firstNameText.getText());
			dox.setLname(lastNameText.getText());
			dox.setTitle(String.valueOf(title.getSelectedItem()));
			dox.setGender(String.valueOf(sex.getSelectedItem()));
			dox.setUsername(userNameText.getText());
			dox.setPassword(passwordText.getText());
			String confirm = confirmPasswordText.getText();
			dox.setContact(contacText.getText());
			dox.setChart(String.valueOf(chart.getSelectedItem()));

			if(dox.getFname().isEmpty()){
				msg.warningMsg("First Name should not be Empty", signupFrame);
			}
			else if(dox.getLname().isEmpty()){
				msg.warningMsg("Last Name should not be Empty", signupFrame);
			}
			else if(dox.getTitle().equals("Select a Title")){
				msg.warningMsg("Title should be selected", signupFrame);
			}
			else if(dox.getGender().equals("Select")){
				msg.warningMsg("Gender Type should be selected", signupFrame);
			}
			else if(dox.getUsername().isEmpty()){
				msg.warningMsg("User Name should not be Empty", signupFrame);
			}
			else if(dox.getUsername().length() < 4){
				msg.warningMsg("User Name should have more than 4 characters", signupFrame);
			}
			else if(dox.getPassword().isEmpty()){
				msg.warningMsg("Password should not be Empty", signupFrame);
			}
			else if(dox.getPassword().length() < 6){
				msg.warningMsg("Password should be at least 6 characters long ", signupFrame);
			}
			else if(confirm.isEmpty()){
				msg.warningMsg("Confirm password should be Empty ", signupFrame);
			}
			else if(!dox.getPassword().equals(confirm)){
				msg.warningMsg("Your confirm password do not match ", signupFrame);
			}
			else if(dox.getContact().isEmpty()){
				msg.warningMsg("Contact No should not be Empty", signupFrame);
			}
			else if(!valid.isNumeric(dox.getContact())){

				msg.warningMsg("Contact Number should be Numeric", signupFrame);
			
			}
		
			else if(dox.getContact().length() != 10){
				
				msg.warningMsg("Contact Number should be 10 Digits", signupFrame);
			
			}

			else if(dox.getChart().equals("Select a Chart")){
				msg.warningMsg("Workout Chart should not be Empty",signupFrame);
			}
			else{
				int dialogResult = msg.confirmMsg("Do you want to create a new Profile ", signupFrame);
				if( dialogResult ==  0 ){
					try{
						dbm.insert(dox);
						clearAll();
						msg.informMsg("Profile Successfully Created", signupFrame);	
						signupFrame.dispose();	
					}
					catch(Exception ex){
						msg.warningMsg(ex.toString(), signupFrame);
					}			
				}	
			}
		}
		if(event.getSource() == clear){
			int dialogResult = msg.confirmMsg("Do you want to clear all the fields? ", signupFrame);
				if(dialogResult ==  0){
					clearAll();
				}
		}
		if(event.getSource() == close){
			int dialogResult = msg.confirmMsg("Do you want to close this Window? ", signupFrame);
				if(dialogResult ==  0){
					signupFrame.dispose();

				}
		}
		
	}
	public void clearAll(){
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
}
