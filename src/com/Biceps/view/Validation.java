/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Biceps.view;

/**
 *
 * @author MaLindu DiLshan
 */
public class Validation{

boolean isNumeric(String temp){
	try{
		int value=Integer.parseInt(temp.trim());
		return true;
	   }
	catch(Exception ex){
		return false;
	}
	}
}
