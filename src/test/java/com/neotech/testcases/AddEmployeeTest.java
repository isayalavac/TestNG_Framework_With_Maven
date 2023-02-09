package com.neotech.testcases;

import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods{
	
	@Test
	public static void addEmployee() {
		LoginPageElements login = new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);
		click(login.logInButton);
		
		DashboardPageElements dashboard = new DashboardPageElements(); 
		
	}
	
	

}
