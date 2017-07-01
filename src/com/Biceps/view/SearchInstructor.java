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
public class SearchInstructor implements MouseListener, ItemListener{
	private MALINDU n;
	private JFrame SearchFrame;
	private Container SearchCont;
	private JSeparator js;
	private JLabel mainTitle,sign,background,Search, clear, close;
	private JTextField firstNameText, lastNameText, title, sex, userNameText, contacText, chart;
	private JComboBox usernames;
	
public void setFrame(){
        n = new MALINDU();
        SearchFrame = n.getFrame("Member Search",600,750);
		SearchFrame.setLocationRelativeTo(null);
		SearchFrame.setResizable(false);
        	SearchCont = SearchFrame.getContentPane();
        	SearchCont.setLayout(null);
    }  
    public void setTitle(){  
        mainTitle = n.getLabel("Search Profile", 135, 2, 350, 80, 30);
        SearchCont.add(mainTitle);
        
        sign = n.getLabel("", 45, 0, 96, 96, 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/user.png"));
        sign.setIcon(icon);
        SearchCont.add(sign);
        
        js = n.getSeparator(30,96);
        SearchCont.add(js);
    }
	public void setLabels(){
        JLabel firstNameLabel = n.getLabel("First Name", 20, 100);
        SearchCont.add(firstNameLabel);
        
        JLabel lastNameLabel = n.getLabel("Last Name", 20, 150);
        SearchCont.add(lastNameLabel);

	JLabel titleLabel = n.getLabel("Title", 20, 200);
        SearchCont.add(titleLabel);

	JLabel accountTypeLabel = n.getLabel("Sex", 20, 250);
        SearchCont.add(accountTypeLabel);

        JLabel userNameLabel = n.getLabel("User Name", 20, 300);
        SearchCont.add(userNameLabel);

        JLabel contacLabel = n.getLabel("Contact No ", 20, 350);
        SearchCont.add(contacLabel);

	JLabel chartLabel = n.getLabel("Workout Chart", 40, 425,140,30,15);
        SearchCont.add(chartLabel);


    }		
	public void setFields(){
		firstNameText = n.getField(140, 100);
        	SearchCont.add(firstNameText);
        
        	lastNameText = n.getField(140, 150);
        	SearchCont.add(lastNameText);

		title = n.getField(140,200);
		SearchCont.add(title);

		sex = n.getField(140,250);
		SearchCont.add(sex);
		
		userNameText = n.getField(140, 300);
		SearchCont.add(userNameText);

		contacText = n.getField(140, 350);
		SearchCont.add(contacText);

		chart = n.getField(140,400);
		SearchCont.add(chart);
		
		
	}

	void setSearchUserName(){
		
		List<String> getuserNameList = new ArrayList<String>();
		
		GetUserNames un = new GetUserNames();
		
		getuserNameList = un.getInstructorUserNames();
		
		
		String [] idList = new String [getuserNameList.size()];
		
		idList = getuserNameList.toArray(idList);
		
    	
		usernames = n.getComboBox(335,32,180,31,idList);
    	
		usernames.addItemListener(this);
    	
		SearchCont.add(usernames);
    	
    	
		JLabel idLabel = n.getLabel("Select User Name:", 230, 57, 180, 30, 20);
    	
		SearchCont.add(idLabel);
    
}

	void setAddButton(){
	
/*	Search = n.getLabel("",245,560,72,72,0);
	Search.setToolTipText("Click Here to Search Profile");
  
	ImageIcon submitIcon = new ImageIcon(getClass().getResource("/resources/SearchSymbol.png"));
	Search.setIcon(submitIcon);
        Search.addMouseListener(this);
        SearchCont.add(Search);	*/
    } 
    void setClearButton(){ 
/*	clear = n.getLabel("",245,620,72,72,0);
	clear.setToolTipText("Click Here to Clear");
  
	ImageIcon clearIcon = new ImageIcon(getClass().getResource("/resources/clear.png"));
	clear.setIcon(clearIcon);
        clear.addMouseListener(this);
        SearchCont.add(clear);	*/
        
    }	
	void setCloseButton(){  
      	
	close = n.getLabel("",285,560,72,72,0);
	close.setToolTipText("Click Here to close");
  
	ImageIcon closeIcon = new ImageIcon(getClass().getResource("/resources/close.png"));
	close.setIcon(closeIcon);
        close.addMouseListener(this);
        SearchCont.add(close);
        
    }
	public void setBackground(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/InstructorSearchBack.png"));
        background = n.getLabel("",0,0,600,750,0);
        background.setIcon(icon);
        SearchCont.add(background);
        SearchFrame.setVisible(true);
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
		if(event.getSource() == Search){
			
			
			if(selectUser.equals("Select Your UserName"))
				msg.warningMsg("UserName should be selected to Search Profile", SearchFrame);
			else{
			int dialogResult = msg.confirmMsg("Do you want to Search this Profile ", SearchFrame);
				if( dialogResult ==  0 ){
					try{
						db.search(selectUser);
						clearAll();
						msg.informMsg("Profile Successfully Searchd", SearchFrame);	
						SearchFrame.dispose();	
					}
					catch(Exception ex){
						msg.warningMsg(ex.toString(), SearchFrame);
					}				
			}
		}
}
		if(event.getSource() == clear){
			int dialogResult = msg.confirmMsg("Do you want to clear all the fields? ", SearchFrame);
				if(dialogResult ==  0){
					clearAll();
				}
		}
		if(event.getSource() == close){
			int dialogResult = msg.confirmMsg("Do you want to close this Window? ", SearchFrame);
				if(dialogResult ==  0){
					SearchFrame.dispose();

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
