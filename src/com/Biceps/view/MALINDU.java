/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author MaLindu DiLshan
 */
final class MALINDU{

	
	
private JFrame tempFrame;
   
private JLabel tempLabel;
    
private JTextField tempField;
    
private JButton tempButton;
    
private JComboBox <String> tempBox;
	
private JCheckBox tempCheckBox;
	
private JSeparator tempSeparator;
	
private JPasswordField tempPassword;
	

public JFrame getFrame(String name, int width, int height){
		
tempFrame = new JFrame(name);
		
tempFrame.setSize(width, height);
		
tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
return tempFrame;
	
}
    
    

public JLabel getLabel(String name, int xLoc, int yLoc, int width, int height, int font){
        
tempLabel = new JLabel(name);
        
tempLabel.setLocation(xLoc,yLoc);
        
tempLabel.setSize(width,height);
        
tempLabel.setFont(new Font("Segoe UI", Font.PLAIN, font));
        
tempLabel.setForeground(Color.WHITE);
        
return tempLabel;
    
}
    
    

public JLabel getLabel(String name, int xLoc, int yLoc){
        
tempLabel = new JLabel(name);
        
tempLabel.setLocation(xLoc+20,yLoc+25);
        
tempLabel.setSize(120,30);
        
tempLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
tempLabel.setForeground(Color.WHITE);
        
return tempLabel;
    
}

    

public JTextField getField(int xLoc, int yLoc, int width, int height){

tempField = new JTextField();
        
tempField.setLocation(xLoc, yLoc+25);
        
tempField.setSize(width, height);
        
tempField.setFont(new Font("Segoe UI", Font.PLAIN, 15));

return tempField;
    
}
    
    
public JTextField getField(int xLoc, int yLoc){
        
tempField = new JTextField();
        
tempField.setLocation(xLoc+60, yLoc+25);
        
tempField.setSize(295, 30);
        
tempField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
return tempField;
    
}
    
    
public JButton getButton(int xLoc, int yLoc, int width, int height, String message, ImageIcon icon){
        
tempButton = new JButton("", icon);
        
tempButton.setLocation(xLoc,yLoc);
        
tempButton.setSize(width, height);
        
tempButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
tempButton.setToolTipText(message);
        
tempButton.setOpaque(false);
        
tempButton.setContentAreaFilled(false);
        
tempButton.setBorderPainted(false);
        
return tempButton;
    
}
	

public JButton getButtonMain(int xLoc, int yLoc, int width, int height, String message, ImageIcon icon){
        
tempButton = new JButton("", icon);
        
tempButton.setLocation(xLoc,yLoc-15);
        
tempButton.setSize(width, height);
        
tempButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
tempButton.setToolTipText(message);
        
tempButton.setOpaque(false);
        
tempButton.setContentAreaFilled(false);
        
tempButton.setBorderPainted(false);
        
return tempButton;
    
}
    
    
public JComboBox getComboBox(int xLoc, int yLoc, String [] titleList){
        
tempBox = new JComboBox<>(titleList);
        
tempBox.setLocation(xLoc+60, yLoc+25);
        
tempBox.setSize(295, 30);
        
tempBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
return tempBox;
    }
    
    

public JComboBox getComboBox(int xLoc, int yLoc, int width, int height, String [] titleList){
     
tempBox = new JComboBox<>(titleList);
        
tempBox.setLocation(xLoc+60, yLoc+25);
        
tempBox.setSize(width, height);
        
tempBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
return tempBox;
    
}
    
    

public JCheckBox getCheckBox(String name, int xLoc, int yLoc){
    	
tempCheckBox = new JCheckBox(name);
    	
tempCheckBox.setLocation(xLoc+60, yLoc+25);
        
tempCheckBox.setSize(100, 30);
        
tempCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
tempCheckBox.setForeground(Color.WHITE);
		
tempCheckBox.setOpaque(false);
        
return tempCheckBox;
    
}
	

public JCheckBox getCheckBox(String name, int xLoc, int yLoc, int width, int height){
    	
tempCheckBox = new JCheckBox(name);
    	
tempCheckBox.setLocation(xLoc+60, yLoc+25);
        
tempCheckBox.setSize(width, height);
        
tempCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
tempCheckBox.setForeground(Color.WHITE);
		
tempCheckBox.setOpaque(false);
        
return tempCheckBox;
    
}
    
    

public JSeparator getSeparator(int xLoc, int yLoc){
    	
tempSeparator = new JSeparator();
        
tempSeparator.setLocation(xLoc, yLoc);
        
tempSeparator.setSize(500,40);
		
tempSeparator.setForeground(Color.white); 
		
tempSeparator.setBackground(Color.white.brighter());
        
return tempSeparator;
    
}
    
	

public JSeparator getSeparator(int xLoc, int yLoc, int width, int height){
    	
tempSeparator = new JSeparator();
        
tempSeparator.setLocation(xLoc, yLoc);
        
tempSeparator.setSize(width,height);
		
tempSeparator.setForeground(Color.white); 
		
tempSeparator.setBackground(Color.white.brighter());
        
return tempSeparator;
    
}
    
    

public JPasswordField getPasswordField(int xLoc, int yLoc){
    	
tempPassword = new JPasswordField();
        
tempPassword.setLocation(xLoc+60, yLoc+25);
        
tempPassword.setSize(295, 30);
        
tempPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
return tempPassword;
    
}


}
