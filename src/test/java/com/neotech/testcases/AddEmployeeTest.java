package com.neotech.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods{
	
	@Test(dataProvider = "excelData", groups = "addEmployees")
	public static void addEmployee(String firstName, String lastname, String location, String employeeId, String loginUsername,
								   String loginPassword, String adminRoleId ) {
		
//		Create AddEmployeeTest.java similar to Homework1.java under com/neotech/lesson04 package in TestNG project.
//		Follow Page Object Model design pattern, don't find any elements inside the test method!
//
//		Create a Test Method named addEmployee with the following steps:
//		Login into the application
//		Navigate to PIM and Add Employee
//		Provide First Name and Last Name
//		Create Login Details
//		Provide User Name and Password
//		Save the Employee
//		Verify Employee has been added successfully
//
//		This test method should belong to addEmp group.
//		By using @DataProvider, add 3 different employees using Excel.xlsx file.
//
//		Create an xml file named addEmp.xml similar to smoke.xml file and execute the xml file.

		LoginPageElements login = new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);
		click(login.logInButton);
		wait(2);
		
		DashboardPageElements dashboard = new DashboardPageElements(); 
		click(dashboard.PIM);
		waitForVisibility(dashboard.addEmployeeBtn);
		click(dashboard.addEmployeeBtn);
		wait(2);
		sendText(dashboard.firstNameBox, firstName);
		sendText(dashboard.lastNameBox, lastname);
		sendText(dashboard.employeeId, employeeId);
		selectDropDown(dashboard.locationDD, location);
		click(dashboard.hasLoginDetails);
		wait(1);
		sendText(dashboard.username, loginUsername);
		sendText(dashboard.password, loginPassword);
		sendText(dashboard.confirmPassword, loginPassword);
		selectDropDown(dashboard.adminRoleId, adminRoleId);
		click(dashboard.saveButton);

		
	}
	
	@DataProvider(name = "excelData")
	public Object [][] getExcelData(){
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testdata/Excel.xlsx", "Employee" );
	}

}
