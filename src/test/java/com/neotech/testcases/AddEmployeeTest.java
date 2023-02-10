package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods{
	
//	Create AddEmployeeTest.java similar to Homework1.java under com/neotech/lesson04 package in TestNG project.
//	Follow Page Object Model design pattern, don't find any elements inside the test method!
//
//	Create a Test Method named addEmployee with the following steps:
//	Login into the application
//	Navigate to PIM and Add Employee
//	Provide First Name and Last Name
//	Create Login Details
//	Provide User Name and Password
//	Save the Employee
//	Verify Employee has been added successfully
//
//	This test method should belong to addEmp group.
//	By using @DataProvider, add 3 different employees using Excel.xlsx file.
//
//	Create an xml file named addEmp.xml similar to smoke.xml file and execute the xml file.
	
	@Test(dataProvider = "excelData", groups = "addEmployees")
	public static void addEmployee(String firstName, String lastname, String  username, String password, String employeeId, String location) {

		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements(); 
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetails = new PersonalDetailsPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);
		click(login.logInButton);
		wait(2);
		
		
		click(dashboard.PIM);
		waitForVisibility(dashboard.addEmployeeBtn);
		click(dashboard.addEmployeeBtn);
		wait(2);
		
		sendText(addEmployee.firstNameBox, firstName);
		sendText(addEmployee.lastNameBox, lastname);
 		sendText(addEmployee.employeeId, employeeId);
 		selectDropDown(addEmployee.locationDD, location);
 		wait(2);
 		click(addEmployee.hasLoginDetails);
		wait(1);
		sendText(addEmployee.username, username);
		sendText(addEmployee.password, password);
		sendText(addEmployee.confirmPassword, password);
 
		click(addEmployee.saveButton);
		
		waitForVisibility(personalDetails.pimPersonalDetailsForm);
		String actualId = personalDetails.peronalDetailId.getAttribute("value");
		Assert.assertEquals(actualId, employeeId, "Employee name DOES NOT match!!!");
		
}
	
	@DataProvider(name = "excelData")
	public Object [][] getExcelData(){
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testdata/Excel.xlsx", "Employee" );
	}

}

