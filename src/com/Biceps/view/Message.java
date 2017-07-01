/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

import javax.swing.*;
/**
 *
 * @author MaLindu DiLshan
 */
public class Message{
	

	
public void warningMsg(String value, JFrame frame){
		
JOptionPane.showMessageDialog(frame, value , "Warning", JOptionPane.WARNING_MESSAGE);
	
}

	
	
public int confirmMsg(String value, JFrame frame){	
		
int result = JOptionPane.showConfirmDialog(frame, value , "Confirmation" ,JOptionPane.YES_NO_OPTION);
		return result;
	}

	
	
public void informMsg(String value, JFrame frame){
		
JOptionPane.showMessageDialog(frame, value, "Message", JOptionPane.INFORMATION_MESSAGE);
	
}

}
	