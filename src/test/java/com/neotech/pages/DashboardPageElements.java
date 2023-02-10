package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	
	@FindBy(xpath="//li[@id='menu_pim_viewPimModule']/a/span[2]")
	public WebElement PIM;
	
	@FindBy(linkText="Add Employee")
	public WebElement addEmployeeBtn;
		
	@FindBy(id="account-name")
	public WebElement accountName;
	

	
	
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
}
